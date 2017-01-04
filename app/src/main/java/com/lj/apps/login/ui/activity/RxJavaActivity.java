package com.lj.apps.login.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.lj.apps.login.R;
import com.lj.apps.login.api.ApiService;
import com.lj.apps.login.api.service.Api;
import com.lj.apps.login.model.LoginResponse;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import butterknife.ButterKnife;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;


public class RxJavaActivity extends BaseActivity {

    Subscription sub;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        ButterKnife.bind(this);
        //   rxLearn();
        add();
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

    private void add() {
        api = ApiService.createApiService();
        api.login("0d3d25324fe168ce5b72957ff240d6c3", "CZ3869")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("TAG", "onSubscribe");
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        Log.d("TAG", "onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "失败");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TAG", "成功");
                    }
                });
    }

}
