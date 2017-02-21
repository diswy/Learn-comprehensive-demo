package fuzitao.diswy.learn_comprehensive_demo.ui;

import android.content.Intent;
import android.os.Bundle;
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


    @OnClick({R.id.main_btn_coordinator_layout, R.id.main_btn_toolbar_animation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn_coordinator_layout:
                startActivity(new Intent(MainActivity.this, CoordinatorLayout.class));
                break;
            case R.id.main_btn_toolbar_animation:
                break;
        }
    }
}
