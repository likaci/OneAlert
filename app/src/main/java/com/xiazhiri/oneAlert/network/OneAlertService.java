package com.xiazhiri.oneAlert.network;

import com.xiazhiri.oneAlert.model.Alarm;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by liuwencai on 16/4/1.
 */
public class OneAlertService {

    public static final String BASE_URL = "http://c.110monitor.com/";

    public static Observable<Alarm> getAlarm() {
        return SingletonHolder.SERVICE.getAlarm();
    }

    public interface OneAlertServiceApi {
        @GET("alert/api/alert/assigned?status=ACK&page=1&rows=20&time=week&UPYOO_TOKEN=8cde4c8d-0ef8-41bc-87cd-aa0744306275")
        Observable<Alarm> getAlarm();
    }

    private static class SingletonHolder {
        private static final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        private static final OneAlertServiceApi SERVICE = retrofit.create(OneAlertServiceApi.class);
    }

}
