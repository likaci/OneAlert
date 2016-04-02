package com.xiazhiri.oneAlert.feature.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "设置");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

}
