package com.xiazhiri.oneAlert.network;

import com.xiazhiri.oneAlert.model.Alarm;
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

    public static Observable<Alarm> getAlarm(String assign, Map<String,String> queryMap) {
        return SingletonHolder.SERVICE.getAlarm(assign, queryMap);
    }

    public static Observable<ChartData> getChartData() {
        return SingletonHolder.SERVICE.getChartData();
    }

    public interface OneAlertServiceApi {
        @GET("http://c.110monitor.com/alert/api/{assign}")
        Observable<Alarm> getAlarm(@Path(value = "assign", encoded = true) String assign, @QueryMap Map<String, String> queryMap);

        //http://c.110monitor.com/console//CrossDomainProxy?1=1&_workId=1459526259772-49412&UPYOO_TOKEN=98ba632b-7c6a-4894-96cc-19bf8db1721a&_url=http://c.110monitor.com/analyse/api/alertAnalyse?startTime=1459267059768&endTime=1459526259768&_=1459526206604
        @GET("http://c.110monitor.com/console//CrossDomainProxy?1=1&_workId=1459566479531-64875&UPYOO_TOKEN=98ba632b-7c6a-4894-96cc-19bf8db1721a&_url=http://c.110monitor.com/analyse/api/alertAnalyse?startTime=1459307279525&endTime=1459566479525&_=1459564554785")
        Observable<ChartData> getChartData();
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
