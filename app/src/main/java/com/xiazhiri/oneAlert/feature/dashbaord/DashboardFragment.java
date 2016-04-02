package com.xiazhiri.oneAlert.feature.dashbaord;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.db.chart.model.LineSet;
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
    private final String[] mLabels = {"Jan", "Fev", "Mar", "Apr", "Jun", "May", "Jul", "Aug", "Sep"};
    private final float[][] mValues = {{3.5f, 4.7f, 4.3f, 8f, 6.5f, 9.9f, 7f, 8.3f, 7.0f},
            {4.5f, 2.5f, 2.5f, 9f, 4.5f, 9.5f, 5f, 8.3f, 1.8f}};
    @Bind(R.id.lineChartView)
    LineChartView lineChartView;
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
        LineSet lineSetCount = new LineSet();
        LineSet lineSetMttr = new LineSet();
        LineSet lineSetMtta = new LineSet();

        //LineSet dataset = new LineSet(mLabels, mValues[0]);
        //dataset.setColor(Color.parseColor("#758cbb"))
        //        .setFill(Color.parseColor("#2d374c"))
        //        .setDotsColor(Color.parseColor("#758cbb"))
        //        .setThickness(4)
        //        .setDashed(new float[]{10f,10f})
        //        .beginAt(5);
        //lineChartView.addData(dataset);
        //
        //lineChartView.setBorderSpacing(15)
        //        .setAxisBorderValues(0, 20)
        //        .setYLabels(AxisController.LabelPosition.NONE)
        //        .setLabelsColor(Color.parseColor("#6a84c3"))
        //        .setXAxis(false)
        //        .setYAxis(false);


        for (int i = 0; i < chartData.getData().getDate().size(); i++) {
            String date = chartData.getData().getDate().get(i);
            String count = chartData.getData().getCount().get(i);
            lineSetCount.addPoint(date, Float.parseFloat(count));
            lineSetCount.setFill(Color.RED);
        }
        lineChartView.addData(lineSetCount);

        lineChartView.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
