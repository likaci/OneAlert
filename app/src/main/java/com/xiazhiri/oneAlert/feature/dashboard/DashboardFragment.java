package com.xiazhiri.oneAlert.feature.dashboard;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.db.chart.model.BarSet;
import com.db.chart.model.LineSet;
import com.db.chart.view.BarChartView;
import com.db.chart.view.LineChartView;
import com.xiazhiri.oneAlert.R;
import com.xiazhiri.oneAlert.feature.base.BaseFragment;
import com.xiazhiri.oneAlert.model.ChartData;
import com.xiazhiri.oneAlert.network.OneAlertService;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class DashboardFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.lineChartView)
    LineChartView lineChartView;
    @Bind(R.id.barChartView)
    BarChartView barChartView;
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
    }

    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        OneAlertService.getChartData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ChartData>() {
                    @Override
                    public void call(ChartData chartData) {
                        initView(chartData);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }

    private void initView(ChartData chartData) {
        BarSet barSetAlarmCount = new BarSet();
        LineSet lineSetMttr = new LineSet();
        LineSet lineSetMtta = new LineSet();

        for (int i = 0; i < chartData.getData().getDate().size(); i++) {
            String date = chartData.getData().getDate().get(i);

            String count = chartData.getData().getCount().get(i);
            String mtta = chartData.getData().getMtta().get(i);
            String mttr = chartData.getData().getMttr().get(i);

            barSetAlarmCount.addBar(date, Float.parseFloat(count));
            lineSetMtta.addPoint(date, Float.parseFloat(mtta));
            lineSetMttr.addPoint(date, Float.parseFloat(mttr));
        }

        lineSetMtta.setColor(Color.parseColor("#32CD32"))
                .setDotsColor(Color.parseColor("#32CD32"))
                .setDotsRadius(12);

        lineSetMttr.setColor(Color.parseColor("#6495ED"))
                .setDotsColor(Color.parseColor("#6495ED"))
                .setDotsRadius(12);

        barSetAlarmCount.setColor(Color.parseColor("#C687CEFA"));

        barChartView.addData(barSetAlarmCount);

        lineChartView.setLabelsColor(Color.TRANSPARENT).setYAxis(false).setXAxis(false);

        lineChartView.addData(lineSetMtta);
        lineChartView.addData(lineSetMttr);

        barChartView.show();
        lineChartView.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
