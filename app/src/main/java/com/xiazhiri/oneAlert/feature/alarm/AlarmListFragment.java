package com.xiazhiri.oneAlert.feature.alarm;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.xiazhiri.oneAlert.R;
import com.xiazhiri.oneAlert.feature.base.BaseFragment;
import com.xiazhiri.oneAlert.model.Alarm;
import com.xiazhiri.oneAlert.network.OneAlertService;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class AlarmListFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private String mParam1;
    private String mParam2;
    private int processRadioId = R.id.processAll;
    private int assignRadioId = R.id.assignAll;

    public AlarmListFragment() {
    }

    public static AlarmListFragment newInstance(String param1, String param2) {
        AlarmListFragment fragment = new AlarmListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alarm_list, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {

        String assign;
        if (assignRadioId == R.id.assignMine) {
            assign = "alert/assigned";
        } else {
            assign = "alert";
        }

        String processState;
        switch (processRadioId) {
            case R.id.processAll:
                processState = null;
                break;
            case R.id.processNot:
                processState = "ACTIVE";
                break;
            case R.id.processDoing:
                processState = "ACK";
                break;
            case R.id.processDone:
                processState = "CLOSED";
                break;
            default:
                processState = null;
                break;
        }

        HashMap<String, String> queryMap = new HashMap<>();
        queryMap.put("UPYOO_TOKEN", "f05fce9a-0b64-402d-8d7b-283cb04bb31f");
        if (processState != null) {
            queryMap.put("status", processState);
        }
        OneAlertService.getAlarm(assign, queryMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Alarm>() {
                    @Override
                    public void call(Alarm alarm) {
                        initView(alarm);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }

    private void initView(final Alarm alarm) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new AlarmListAdapter(getActivity(), alarm));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick(R.id.fab)
    public void onFabClick() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_alarm_filter, null);
        final RadioGroup process = (RadioGroup) view.findViewById(R.id.process);
        process.check(processRadioId);
        final RadioGroup assign = (RadioGroup) view.findViewById(R.id.assign);
        assign.check(assignRadioId);

        new AlertDialog.Builder(getActivity())
                .setTitle("过滤条件")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlarmListFragment.this.processRadioId = process.getCheckedRadioButtonId();
                        AlarmListFragment.this.assignRadioId = assign.getCheckedRadioButtonId();
                        initData();
                    }
                })
                .setNegativeButton("取消", null)
                .setView(view)
                .create()
                .show();
    }

}
