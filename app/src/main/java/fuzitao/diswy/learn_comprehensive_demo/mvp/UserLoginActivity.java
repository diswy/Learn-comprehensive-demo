package fuzitao.diswy.learn_comprehensive_demo.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fuzitao.diswy.learn_comprehensive_demo.R;
import fuzitao.diswy.learn_comprehensive_demo.mvp.bean.User;
import fuzitao.diswy.learn_comprehensive_demo.mvp.presenter.UserLoginPresenter;
import fuzitao.diswy.learn_comprehensive_demo.mvp.view.InterfaceLoginView;
import fuzitao.diswy.learn_comprehensive_demo.ui.BaseActivity;

public class UserLoginActivity extends BaseActivity implements InterfaceLoginView {

    @Bind(R.id.et_psd)
    EditText etPsd;
    @Bind(R.id.et_name)
    EditText etName;

    private UserLoginPresenter presenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                presenter.login();
                break;
            case R.id.btn_clear:
                presenter.clear();
                break;
        }
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void clearPassword() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {

    }

    @Override
    public void showFailedError() {

    }
}
