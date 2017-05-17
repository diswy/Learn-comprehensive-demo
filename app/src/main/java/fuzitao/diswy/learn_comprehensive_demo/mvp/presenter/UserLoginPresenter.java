package fuzitao.diswy.learn_comprehensive_demo.mvp.presenter;

import android.os.Handler;

import fuzitao.diswy.learn_comprehensive_demo.mvp.bean.User;
import fuzitao.diswy.learn_comprehensive_demo.mvp.biz.InterfaceUserBiz;
import fuzitao.diswy.learn_comprehensive_demo.mvp.biz.OnLoginListener;
import fuzitao.diswy.learn_comprehensive_demo.mvp.biz.UserBiz;
import fuzitao.diswy.learn_comprehensive_demo.mvp.view.InterfaceLoginView;

/**
 * Created by Diswy on 2017/5/17.
 */

public class UserLoginPresenter {
    private InterfaceUserBiz userBiz;
    private InterfaceLoginView loginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(InterfaceLoginView loginView) {
        this.loginView = loginView;
        userBiz = new UserBiz();
    }

    public void login() {
        loginView.showLoading();
        userBiz.login(loginView.getUserName(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                // 需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMainActivity(user);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailedError();
                        loginView.hideLoading();
                    }
                });
            }
        });
    }


    public void clear() {
        loginView.clearUserName();
        loginView.clearPassword();
    }
}
