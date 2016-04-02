package com.xiazhiri.oneAlert.network;

import com.xiazhiri.oneAlert.model.Alarm;
import com.xiazhiri.oneAlert.model.AlertCompress;
import com.xiazhiri.oneAlert.model.AlertTop;
import com.xiazhiri.oneAlert.model.ChartData;

import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by liuwencai on 16/4/1.
 */
public class OneAlertService {

    public static final String BASE_URL = "http://c.110monitor.com/";

    public static Observable<Alarm> getAlarm(String assign, Map<String, String> queryMap) {
        return SingletonHolder.SERVICE.getAlarm(assign, queryMap);
    }

    public static Observable<ChartData> getChartData() {
        return SingletonHolder.SERVICE.getChartData();
    }

    public static Observable<AlertTop> getAlertContentTop() {
        return SingletonHolder.SERVICE.getAlertContentTop();
    }

    public static Observable<AlertCompress> getAlertCompress() {
        return SingletonHolder.SERVICE.getAlertCompress();
    }

    public interface OneAlertServiceApi {
        @GET("http://c.110monitor.com/alert/api/{assign}")
        Observable<Alarm> getAlarm(@Path(value = "assign", encoded = true) String assign, @QueryMap Map<String, String> queryMap);

        @GET("http://c.110monitor.com/console//CrossDomainProxy?1=1&_workId=1459566479531-64875&UPYOO_TOKEN=98ba632b-7c6a-4894-96cc-19bf8db1721a&_url=http://c.110monitor.com/analyse/api/alertAnalyse?startTime=1459307279525&endTime=1459566479525&_=1459564554785")
        Observable<ChartData> getChartData();

        @GET("http://c.110monitor.com/console//CrossDomainProxy?1=1&_workId=1459591658328-26967&UPYOO_TOKEN=98ba632b-7c6a-4894-96cc-19bf8db1721a&_url=http://c.110monitor.com/analyse/api/alertContentTop?startTime=1459332458305&endTime=1459591658305&_=1459591172372")
        Observable<AlertTop> getAlertContentTop();

        @GET("http://c.110monitor.com/console//CrossDomainProxy?1=1&_workId=1459591658338-52519&UPYOO_TOKEN=98ba632b-7c6a-4894-96cc-19bf8db1721a&_url=http://c.110monitor.com/analyse/api/alertCompress?startTime=1459332458305&endTime=1459591658305&_=1459591172375 ")
        Observable<AlertCompress> getAlertCompress();
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
