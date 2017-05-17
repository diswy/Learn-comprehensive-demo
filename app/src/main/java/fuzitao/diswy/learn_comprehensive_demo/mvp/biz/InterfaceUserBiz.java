package fuzitao.diswy.learn_comprehensive_demo.mvp.biz;

/**
 * Created by Diswy on 2017/5/17.
 */

public interface InterfaceUserBiz {
    void login(String name, String password,OnLoginListener listener);
}
