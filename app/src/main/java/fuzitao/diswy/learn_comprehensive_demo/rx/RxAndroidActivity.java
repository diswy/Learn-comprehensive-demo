package fuzitao.diswy.learn_comprehensive_demo.rx;

import android.os.Bundle;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fuzitao.diswy.learn_comprehensive_demo.R;
import fuzitao.diswy.learn_comprehensive_demo.ui.BaseActivity;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

public class RxAndroidActivity extends BaseActivity {

    @Bind(R.id.rx_btn)
    Button rxBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rx_android);
    }

    @OnClick(R.id.rx_btn)
    public void onClick() {

        initObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        rxBtn.setText(s);
                    }
                });
    }


    private Observable<String> initObservable(){
        return Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return Observable.just("one","two","three","four","five");
            }
        });
    }
}
