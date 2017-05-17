package fuzitao.diswy.learn_comprehensive_demo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.autolayout.config.AutoLayoutConifg;


public class MyApplication extends Application{


    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

        // 默认使用的高度是设备的可用高度，也就是不包括状态栏和底部的操作栏的，如果你希望拿设备的物理高度进行百分比化
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}
