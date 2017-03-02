package fuzitao.diswy.learn_comprehensive_demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.OnClick;
import fuzitao.diswy.learn_comprehensive_demo.R;

public class MainActivity extends BaseActivity {

    @Bind(R.id.main_btn_coordinator_layout)
    Button mainBtnCoordinatorLayout;
    @Bind(R.id.main_btn_toolbar_animation)
    Button mainBtnToolbarAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @OnClick({R.id.main_btn_coordinator_layout, R.id.main_btn_toolbar_animation, R.id.main_btn_refresh_layout
            , R.id.main_btn_learn_json})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn_coordinator_layout:// 联动控件
                startActivity(new Intent(MainActivity.this, CoordinatorDemo.class));
                break;
            case R.id.main_btn_toolbar_animation:// 玩转AppbarLayout
                break;
            case R.id.main_btn_refresh_layout:// 上拉、下拉刷新
                startActivity(new Intent(MainActivity.this, RefreshLayout.class));
                break;
            case R.id.main_btn_learn_json:// Gson学习
                startActivity(new Intent(MainActivity.this, LearnGson.class));
                break;
        }
    }
}
