package fuzitao.diswy.learn_comprehensive_demo.ui;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 根据需求封装基础Activity
 * Created by Fu.Zi.Tao on 2017/2/21 0021.
 */

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 使用频率高 一般用于Activity初始化界面
     * 例如 onCreate()里。初始化布局就用到setContentView(R.layout.xxx) 就是初始化页面布局
     */
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        // Butter Knife初始化
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Butter Knife解绑
        ButterKnife.unbind(this);
    }
}
