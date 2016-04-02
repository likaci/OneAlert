package com.xiazhiri.oneAlert.model;

import java.util.List;

/**
 * Created by liuwencai on 16/4/2.
 */
public class AlertTop {

    /**
     * result : success
     * message : null
     * data : [{"content":"{\"ping time\":\"1500ms\",\"load avg\":0.75}","duration":2037.8568,"count":2,"mttr":1018.9284,"mtta":269.71704},{"content":"磁盘空间仅剩5%","duration":792.19714,"count":2,"mttr":396.09857,"mtta":349.6467},{"content":"提醒内容","duration":451.3984,"count":2,"mttr":225.6992,"mtta":225.6992},{"content":"CPU占用过高","duration":475.53635,"count":1,"mttr":475.53635,"mtta":475.53635},{"content":"磁盘空间仅剩1%","duration":223.86876,"count":1,"mttr":223.86876,"mtta":223.86876},{"content":"告警内容","duration":226.31644,"count":1,"mttr":226.31644,"mtta":226.31644}]
     * totalCount : 0
     * code : 200
     */

    private String result;
    private Object message;
    private int totalCount;
    private String code;
    /**
     * content : {"ping time":"1500ms","load avg":0.75}
     * duration : 2037.8568
     * count : 2
     * mttr : 1018.9284
     * mtta : 269.71704
     */

    private List<DataEntity> data;

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

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private String content;
        private double duration;
        private int count;
        private double mttr;
        private double mtta;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public double getDuration() {
            return duration;
        }

        public void setDuration(double duration) {
            this.duration = duration;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public double getMttr() {
            return mttr;
        }

        public void setMttr(double mttr) {
            this.mttr = mttr;
        }

        public double getMtta() {
            return mtta;
        }

        public void setMtta(double mtta) {
            this.mtta = mtta;
        }
    }
}
