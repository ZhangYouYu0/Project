package com.example.mode4.Utils;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    String base = "http://www.qubaobei.com/ios/cf/";

    @GET
    Observable<ResponseBody> get(@Url String url);
}
