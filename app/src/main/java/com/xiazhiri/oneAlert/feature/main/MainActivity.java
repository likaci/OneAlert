package com.xiazhiri.oneAlert.feature.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.xiazhiri.oneAlert.R;
import com.xiazhiri.oneAlert.feature.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements AHBottomNavigation.OnTabSelectedListener {

    @Bind(R.id.bottomNavigation)
    AHBottomNavigation bottomNavigation;
    @Bind(R.id.fragmentContainer)
    FrameLayout fragmentContainer;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomNavigation.addItem(new AHBottomNavigationItem("Alert", R.mipmap.ic_launcher));
        bottomNavigation.addItem(new AHBottomNavigationItem("Team", R.mipmap.ic_launcher));
        bottomNavigation.addItem(new AHBottomNavigationItem("Dashboard", R.mipmap.ic_launcher));

        bottomNavigation.setOnTabSelectedListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter<MyViewHolder>() {

            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                TextView tv = new TextView(MainActivity.this);
                tv.setText("hello");
                return new MyViewHolder(tv);
            }

            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
            }

            @Override
            public int getItemCount() {
                return 200;
            }
        });

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {

    }


}
