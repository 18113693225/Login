package com.lj.apps.login.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.lj.apps.login.R;
import com.lj.apps.login.api.ApiService;
import com.lj.apps.login.api.service.Api;
import com.lj.apps.login.model.LoginResponse;
import com.lj.apps.login.model.RegisterResponse;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import butterknife.ButterKnife;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
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
        add();
    }

    private void add() {
        api = ApiService.createApiService();
        api.login("0d3d25324fe168ce5b72957ff240d6c3", "CZ3869")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse loginResponse) throws Exception {

                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<LoginResponse, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(LoginResponse loginResponse) throws Exception {
                        if (loginResponse.resultcode == 200) {
                            return api.registe("0d3d25324fe168ce5b72957ff240d6c3", "CZ3869");
                        }
                        return api.registe("0d3d25324fe168ce5b72957ff240d6c3", "CZ3869");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {

                    @Override
                    public void accept(Object o) throws Exception {

                    }
                });

    }

}
