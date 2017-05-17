package fuzitao.diswy.learn_comprehensive_demo.mvp.view;

import fuzitao.diswy.learn_comprehensive_demo.mvp.bean.User;

/**
 * Created by Diswy on 2017/5/17.
 */

public interface InterfaceLoginView {
    String getUserName();
    String getPassword();
    void clearUserName();
    void clearPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
}
