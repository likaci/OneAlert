package com.xiazhiri.oneAlert.feature.main;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiazhiri.oneAlert.R;
import com.xiazhiri.oneAlert.feature.base.BaseFragment;
import com.xiazhiri.oneAlert.model.Alarm;
import com.xiazhiri.oneAlert.network.OneAlertService;

import butterknife.Bind;
import butterknife.ButterKnife;
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
        OneAlertService.getAlarm()
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
        recyclerView.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_alarm_detail, parent, false);
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                Alarm.DataEntity data = alarm.getData().get(position);
                holder.serverName.setText(data.getAppService().getDescription());
                holder.message.setText(data.getAlarmName());
                holder.time.setText(data.getCreationTime());

                int tintColor;
                switch (data.getPriority()) {
                    case 3:
                        tintColor = Color.parseColor("#FF3837");
                        break;
                    case 2:
                        tintColor = Color.parseColor("#EF773E");
                        break;
                    case 1:
                        tintColor = Color.parseColor("#48A6F1");
                        break;
                    default:
                        tintColor  = Color.parseColor("#48A6F1");
                        break;
                }
                holder.alarmLevelTint.setBackgroundColor(tintColor);
            }

            @Override
            public int getItemCount() {
                return alarm.getData().size();
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.alarmLevelTint)
        View alarmLevelTint;
        @Bind(R.id.serverName)
        TextView serverName;
        @Bind(R.id.time)
        TextView time;
        @Bind(R.id.message)
        TextView message;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
