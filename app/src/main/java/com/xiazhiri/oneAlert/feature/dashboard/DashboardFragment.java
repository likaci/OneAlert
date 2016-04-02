package com.xiazhiri.oneAlert.feature.dashboard;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.db.chart.model.BarSet;
import com.db.chart.model.LineSet;
import com.db.chart.view.AxisController;
import com.db.chart.view.BarChartView;
import com.db.chart.view.LineChartView;
import com.xiazhiri.oneAlert.R;
import com.xiazhiri.oneAlert.feature.base.BaseFragment;
import com.xiazhiri.oneAlert.model.AlertCompress;
import com.xiazhiri.oneAlert.model.AlertTop;
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
    @Bind(R.id.alertOverviewHolder)
    LinearLayout alertOverviewHolder;
    @Bind(R.id.alertCompressChart)
    LineChartView alertCompressChart;
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

        OneAlertService.getAlertContentTop()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<AlertTop>() {
                    @Override
                    public void call(AlertTop alertTop) {
                        initView(alertTop);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });


        OneAlertService.getAlertCompress()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<AlertCompress>() {
                    @Override
                    public void call(AlertCompress alertCompress) {
                        initView(alertCompress);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });


    }

    private void initView(AlertCompress alertCompress) {
        if (alertCompress != null && alertCompress.getData() != null && alertCompress.getData().getDate() != null && alertCompress.getData().getDate().size() > 0) {
            AlertCompress.DataEntity data = alertCompress.getData();
            LineSet alertSet = new LineSet();
            LineSet eventSet = new LineSet();
            for (int i = 0; i < data.getDate().size(); i++) {
                String date = data.getDate().get(i);
                Long alert = data.getAlert().get(i);
                Long event = data.getEvent().get(i);
                alertSet.addPoint(date, alert);
                eventSet.addPoint(date, event);
            }


            alertSet.setColor(Color.parseColor("#4CAF50"))
                    .setThickness(10)
                    .setDotsColor(Color.parseColor("#388E3C"))
                    .setFill(Color.parseColor("#85388E3C"));

            eventSet.setColor(Color.parseColor("#2196F3"))
                    .setThickness(10)
                    .setDotsColor(Color.parseColor("#1976D2"))
                    .setFill(Color.parseColor("#851976D2"));

            alertCompressChart.addData(alertSet);
            alertCompressChart.addData(eventSet);

            alertCompressChart.setStep(5);

            alertCompressChart.show();
        }
    }

    private void initView(AlertTop alertTop) {
        if (alertTop != null && alertTop.getData() != null && alertTop.getData().size() > 0) {
            for (AlertTop.DataEntity data : alertTop.getData()) {
                TextView textView = new TextView(getActivity());
                textView.setText(data.getContent() + " " + data.getCount());
                alertOverviewHolder.addView(textView);
            }
        }
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

        //barChartView
        //        .setYAxis(false)
        //        .setXAxis(false)
        //        .setYLabels(AxisController.LabelPosition.NONE)
        //        .setXLabels(AxisController.LabelPosition.NONE);
        barChartView.setBarSpacing(900);

        lineChartView
                .setYAxis(false)
                .setXAxis(false)
                .setYLabels(AxisController.LabelPosition.NONE)
                .setXLabels(AxisController.LabelPosition.NONE);

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
