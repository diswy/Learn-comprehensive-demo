package fuzitao.diswy.learn_comprehensive_demo.mvp.biz;

import fuzitao.diswy.learn_comprehensive_demo.mvp.bean.User;

/**
 * Created by Diswy on 2017/5/17.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
