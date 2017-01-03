package com.lj.apps.login.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.lj.apps.login.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import butterknife.ButterKnife;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;


public class RxJavaActivity extends BaseActivity {

    Subscription sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        ButterKnife.bind(this);
        rxLearn();
    }

    private void rxLearn() {

        Flowable.range(0, 5).subscribe(new Subscriber<Integer>() {

            @Override
            public void onSubscribe(Subscription s) {
                Log.d("TAG", "开始");
                sub = s;
                sub.request(1);
                Log.d("TAG", "结束");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d("TAG", "持续中" + integer);
                sub.request(1);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d("TAG", "完成");
            }
        });
    }


}
