package com.xiazhiri.oneAlert.feature.customView;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by liuwencai on 16/4/2.
 */
public class MyCoordinatorLayout extends CoordinatorLayout {

    public MyCoordinatorLayout(Context context) {
        super(context);
    }

    public MyCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        getParentCoordinatorLayout().onStartNestedScroll(child, target, nestedScrollAxes);
        return super.onStartNestedScroll(child, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
        getParentCoordinatorLayout().onNestedScrollAccepted(child, target, nestedScrollAxes);
        super.onNestedScrollAccepted(child, target, nestedScrollAxes);
    }

    @Override
    public void onStopNestedScroll(View target) {
        getParentCoordinatorLayout().onStopNestedScroll(target);
        super.onStopNestedScroll(target);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        getParentCoordinatorLayout().onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        getParentCoordinatorLayout().onNestedPreScroll(target, dx, dy, consumed);
        super.onNestedPreScroll(target, dx, dy, consumed);
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        getParentCoordinatorLayout().onNestedFling(target, velocityX, velocityY, consumed);
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        getParentCoordinatorLayout().onNestedPreFling(target, velocityX, velocityY);
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    CoordinatorLayout getParentCoordinatorLayout() {
        return (CoordinatorLayout) getParent().getParent();
    }

}
