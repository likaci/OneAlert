package com.xiazhiri.oneAlert.feature.alarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xiazhiri.oneAlert.R;
import com.xiazhiri.oneAlert.model.Alarm;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AlarmDetailActivity extends AppCompatActivity {

    @Bind(R.id.server)
    TextView server;
    @Bind(R.id.name)
    TextView name;
    @Bind(R.id.id)
    TextView id;
    @Bind(R.id.content)
    TextView content;
    @Bind(R.id.startTime)
    TextView startTime;
    @Bind(R.id.endTime)
    TextView endTime;
    @Bind(R.id.comment)
    TextView comment;

    Alarm.DataEntity data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_detail);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        data = getIntent().getParcelableExtra("data");
        initView();
    }

    private void initView() {
        name.setText(data.getAlarmName());
        id.setText(data.getAlarmId() + "");
        try {
            server.setText(data.getAppService().getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
        content.setText(data.getAlarmContent());
        startTime.setText(data.getCreationTime());
        endTime.setText(data.getModifiedTime());
        try {
            comment.setText(data.getCloseComments().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
