package com.lj.apps.login.api;

import com.lj.apps.login.BuildConfig;
import com.lj.apps.login.api.service.Api;
import com.lj.apps.login.utils.utils.RetrofitBuilder;

import retrofit2.Retrofit;


public class ApiService {

    public static Api createApiService() {
        return retrofit().create(Api.class);
    }

    private static Retrofit retrofit() {
        return RetrofitBuilder.get().retrofit(BuildConfig.API_ENDPOINT);
    }
}