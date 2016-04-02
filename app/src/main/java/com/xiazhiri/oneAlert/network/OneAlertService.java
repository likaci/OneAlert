package com.xiazhiri.oneAlert.network;

import com.xiazhiri.oneAlert.model.Alarm;
import com.xiazhiri.oneAlert.model.ChartData;

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

    public static Observable<ChartData> getChartData() {
        return SingletonHolder.SERVICE.getChartData();
    }

    public interface OneAlertServiceApi {
        @GET("alert/api/alert/assigned?status=ACK&page=1&rows=20&time=week&UPYOO_TOKEN=8cde4c8d-0ef8-41bc-87cd-aa0744306275")
        Observable<Alarm> getAlarm();

        //http://c.110monitor.com/console//CrossDomainProxy?1=1&_workId=1459526259772-49412&UPYOO_TOKEN=98ba632b-7c6a-4894-96cc-19bf8db1721a&_url=http://c.110monitor.com/analyse/api/alertAnalyse?startTime=1459267059768&endTime=1459526259768&_=1459526206604
        @GET("http://c.110monitor.com/console//CrossDomainProxy?1=1&_workId=1459526259772-49412&UPYOO_TOKEN=98ba632b-7c6a-4894-96cc-19bf8db1721a&_url=http://c.110monitor.com/analyse/api/alertAnalyse?startTime=1459267059768&endTime=1459526259768&_=1459526206604")
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
