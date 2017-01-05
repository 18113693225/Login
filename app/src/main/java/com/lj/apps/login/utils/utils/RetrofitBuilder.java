package com.lj.apps.login.utils.utils;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.lj.apps.login.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private Retrofit mRetrofit;
    private OkHttpClient client;


    private RetrofitBuilder() {
    }

    // Make this class a thread safe singleton
    private static class SingletonHolder {
        private static final RetrofitBuilder INSTANCE = new RetrofitBuilder();
    }

    public static synchronized RetrofitBuilder get() {
        return SingletonHolder.INSTANCE;
    }


    public Retrofit retrofit(String baseUrl) {
        if (null == mRetrofit) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    public static class Builder {
        private OkHttpClient mClient;

        public RetrofitBuilder build() {
            ensureSaneDefaults();
            RetrofitBuilder retrofitBuilder = get();
            retrofitBuilder.client = mClient;
            return retrofitBuilder;
        }

        private void ensureSaneDefaults() {
            if (mClient == null) {
                mClient = defaultClient();
            }
        }

        private OkHttpClient defaultClient() {
            // default interceptors
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
            builder.connectTimeout(10000L, TimeUnit.MILLISECONDS);    //设置连接超时
            builder.readTimeout(10000L, TimeUnit.MILLISECONDS);  //设置读取超时
            builder.writeTimeout(10000L, TimeUnit.MILLISECONDS);//设置写入超时
            return builder.build();
        }


    }
}
