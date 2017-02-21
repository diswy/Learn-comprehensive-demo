package fuzitao.diswy.learn_comprehensive_demo.coordinator;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import fuzitao.diswy.learn_comprehensive_demo.view.DragView;

/**
 * 组件协调控制的绑定
 * Created by Fu.Zi.Tao on 2017/2/21 0021.
 */

public class MyBehavior extends CoordinatorLayout.Behavior<TextView> {

    private int width;

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        width = display.widthPixels;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        //如果dependency是TempView的实例，说明它就是我们所需要的Dependency
        return dependency instanceof DragView;
    }

    //每次dependency位置发生变化，都会执行onDependentViewChanged方法
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView tv, View dependency) {

        //根据dependency的位置，设置TextView的位置
        int top = dependency.getTop();
        int left = dependency.getLeft();

        int x = width - left - tv.getWidth();
        int y = top;

        setPosition(tv, x, y);
        return true;
    }

    private void setPosition(TextView tv, int x, int y) {
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) tv.getLayoutParams();
        layoutParams.leftMargin = x;
        layoutParams.topMargin = y;
        tv.setLayoutParams(layoutParams);
    }


}
