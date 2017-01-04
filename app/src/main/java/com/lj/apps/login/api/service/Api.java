package com.lj.apps.login.api.service;


import com.lj.apps.login.model.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("/plan/snew")
    Observable<LoginResponse> login(@Query("key") String key,
                                    @Query("name") String name);

}
