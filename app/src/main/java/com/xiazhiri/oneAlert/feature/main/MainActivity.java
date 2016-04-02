package com.xiazhiri.oneAlert.feature.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.xiazhiri.oneAlert.R;
import com.xiazhiri.oneAlert.feature.alarm.AlarmListFragment;
import com.xiazhiri.oneAlert.feature.base.BaseActivity;
import com.xiazhiri.oneAlert.feature.dashbaord.DashboardFragment;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements AHBottomNavigation.OnTabSelectedListener {

    @Bind(R.id.bottomNavigation)
    AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomNavigation.addItem(new AHBottomNavigationItem("Alarm", R.drawable.ic_notification));
        bottomNavigation.addItem(new AHBottomNavigationItem("Dashboard", R.drawable.ic_dashboard));
        bottomNavigation.addItem(new AHBottomNavigationItem("Team", R.drawable.ic_team));

        bottomNavigation.setOnTabSelectedListener(this);

    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        Fragment fragment = AlarmListFragment.newInstance(null, null);
        if (position == 1) {
            fragment = DashboardFragment.newInstance(null, null);
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

}
