package com.example.mode4.Utils;

import com.google.gson.Gson;

import org.greenrobot.greendao.test.DbTest;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements InetWorklnteface{
    private static volatile RetrofitUtils retrofitUtils;
    ApiService apiService;
    private RetrofitUtils() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.base)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
         apiService = retrofit.create(ApiService.class);
    }

    public static RetrofitUtils getRetrofitUtils() {
        if(retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if(retrofitUtils==null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    @Override
    public <I> void get(String url, INetCallBack callBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type y = actualTypeArguments[0];
                            I o = new Gson().fromJson(string, y);
                            callBack.onSuccess(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                    callBack.eroor(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
