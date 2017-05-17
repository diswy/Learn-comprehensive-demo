package fuzitao.diswy.learn_comprehensive_demo.mvp.biz;

import fuzitao.diswy.learn_comprehensive_demo.mvp.bean.User;

/**
 * Created by Diswy on 2017/5/17.
 */

public class UserBiz implements InterfaceUserBiz {
    @Override
    public void login(final String name, final String password, final OnLoginListener listener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 模拟登录成功
                if ("".equals(name) && "".equals(password)) {
                    User user = new User();
                    user.setUsername(name);
                    user.setPassword(password);
                    listener.loginSuccess(user);
                } else {
                    listener.loginFailed();
                }
            }
        }.start();
    }
}
