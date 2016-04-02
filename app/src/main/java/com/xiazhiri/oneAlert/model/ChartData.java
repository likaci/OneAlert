package com.xiazhiri.oneAlert.model;

import java.util.List;

/**
 * Created by liuwencai on 16/4/1.
 */
public class ChartData {


    /**
     * result : success
     * message : null
     * data : {"count":["0","0","0","1"],"date":["2016-03-29","2016-03-30","2016-03-31","2016-04-01"],"mttr":["0","0","0","453.0"],"mtta":["0","0","0","49.0"]}
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
        private List<String> count;
        private List<String> date;
        private List<String> mttr;
        private List<String> mtta;

        public List<String> getCount() {
            return count;
        }

        public void setCount(List<String> count) {
            this.count = count;
        }

        public List<String> getDate() {
            return date;
        }

        public void setDate(List<String> date) {
            this.date = date;
        }

        public List<String> getMttr() {
            return mttr;
        }

        public void setMttr(List<String> mttr) {
            this.mttr = mttr;
        }

        public List<String> getMtta() {
            return mtta;
        }

        public void setMtta(List<String> mtta) {
            this.mtta = mtta;
        }
    }
}
