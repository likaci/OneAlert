package com.xiazhiri.oneAlert.model;

import java.util.List;

/**
 * Created by liuwencai on 16/4/2.
 */
public class AlertCompress {

    /**
     * result : success
     * message : null
     * data : {"ratio":["0","0","50.0%","66.7%"],"event":["0","0","2","12"],"alert":["0","0","1","8"],"date":["2016-03-30","2016-03-31","2016-04-01","2016-04-02"]}
     * totalCount : 0
     * code : 200
     */

    private String result;
    private Object message;
    private DataEntity data;
    private int totalCount;
    private String code;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class DataEntity {
        private List<String> ratio;
        private List<Long> event;
        private List<Long> alert;
        private List<String> date;

        public List<String> getRatio() {
            return ratio;
        }

        public void setRatio(List<String> ratio) {
            this.ratio = ratio;
        }

        public List<Long> getEvent() {
            return event;
        }

        public void setEvent(List<Long> event) {
            this.event = event;
        }

        public List<Long> getAlert() {
            return alert;
        }

        public void setAlert(List<Long> alert) {
            this.alert = alert;
        }

        public List<String> getDate() {
            return date;
        }

        public void setDate(List<String> date) {
            this.date = date;
        }
    }
}
