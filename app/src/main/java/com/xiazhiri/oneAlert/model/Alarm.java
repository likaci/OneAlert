package com.xiazhiri.oneAlert.model;

import java.util.List;

/**
 * Created by liuwencai on 16/4/1.
 */
public class Alarm {

    /**
     * result : success
     * message : null
     * data : [{"alarmId":1482997,"alarmType":"event","alarmName":"FAILURE for production/HTTP on machine 192.168.0.253","entityName":"host-192.168.0.253","hostIp":null,"status":"ACK","priority":1,"alarmContent":"{\"ping time\":\"1500ms\",\"load avg\":0.75}","count":2,"creationTime":"04-01 16:25","creationTimeL":1459499108958,"modifiedTime":"04-01 16:25","modifiedTimeL":1459499113561,"lastTimeTxt":"5小时","timeDuring":"5小时56分","closeTime":null,"closeTimeL":null,"entityId":"host-192.168.0.253","alarmDefId":null,"app":"35c9f7bf-cf7f-8e4d-2f36-424bab4f5133","appService":{"id":"f782591b-9803-aad8-727e-b2b1059f577e","escalationId":"system","entityId":"35c9f7bf-cf7f-8e4d-2f36-424bab4f5133","description":"MyOwn","integrateType":"api","autoResolve":1800000,"ackTimeout":0,"user":"335779879","escalation":"system","email":null,"password":"1b9402","status":null,"isnow":null,"compress":0,"mnsAccesskeyId":null,"mnsAccesskeySecret":null,"mnsAccountEndpoint":null},"assignments":["242386811"],"contactNames":["likaci"],"ackTime":"04-01 17:14","ackTimeL":1459502041638,"ackUser":"242386811","ackUserContactName":"likaci","closeUser":null,"closeUserContactName":null,"closeComments":null,"user":"335779879","ext":1,"activeCount":0,"activeAlarm":null,"host":"","service":"","tag":"","metric":"","version":0,"parentAlarmId":null}]
     * totalCount : 1
     * code : 200
     */

    private String result;
    private Object message;
    private int totalCount;
    private String code;
    /**
     * alarmId : 1482997
     * alarmType : event
     * alarmName : FAILURE for production/HTTP on machine 192.168.0.253
     * entityName : host-192.168.0.253
     * hostIp : null
     * status : ACK
     * priority : 1
     * alarmContent : {"ping time":"1500ms","load avg":0.75}
     * count : 2
     * creationTime : 04-01 16:25
     * creationTimeL : 1459499108958
     * modifiedTime : 04-01 16:25
     * modifiedTimeL : 1459499113561
     * lastTimeTxt : 5小时
     * timeDuring : 5小时56分
     * closeTime : null
     * closeTimeL : null
     * entityId : host-192.168.0.253
     * alarmDefId : null
     * app : 35c9f7bf-cf7f-8e4d-2f36-424bab4f5133
     * appService : {"id":"f782591b-9803-aad8-727e-b2b1059f577e","escalationId":"system","entityId":"35c9f7bf-cf7f-8e4d-2f36-424bab4f5133","description":"MyOwn","integrateType":"api","autoResolve":1800000,"ackTimeout":0,"user":"335779879","escalation":"system","email":null,"password":"1b9402","status":null,"isnow":null,"compress":0,"mnsAccesskeyId":null,"mnsAccesskeySecret":null,"mnsAccountEndpoint":null}
     * assignments : ["242386811"]
     * contactNames : ["likaci"]
     * ackTime : 04-01 17:14
     * ackTimeL : 1459502041638
     * ackUser : 242386811
     * ackUserContactName : likaci
     * closeUser : null
     * closeUserContactName : null
     * closeComments : null
     * user : 335779879
     * ext : 1
     * activeCount : 0
     * activeAlarm : null
     * host :
     * service :
     * tag :
     * metric :
     * version : 0
     * parentAlarmId : null
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
        private int alarmId;
        private String alarmType;
        private String alarmName;
        private String entityName;
        private Object hostIp;
        private String status;
        private int priority;
        private String alarmContent;
        private int count;
        private String creationTime;
        private long creationTimeL;
        private String modifiedTime;
        private long modifiedTimeL;
        private String lastTimeTxt;
        private String timeDuring;
        private Object closeTime;
        private Object closeTimeL;
        private String entityId;
        private Object alarmDefId;
        private String app;
        /**
         * id : f782591b-9803-aad8-727e-b2b1059f577e
         * escalationId : system
         * entityId : 35c9f7bf-cf7f-8e4d-2f36-424bab4f5133
         * description : MyOwn
         * integrateType : api
         * autoResolve : 1800000
         * ackTimeout : 0
         * user : 335779879
         * escalation : system
         * email : null
         * password : 1b9402
         * status : null
         * isnow : null
         * compress : 0
         * mnsAccesskeyId : null
         * mnsAccesskeySecret : null
         * mnsAccountEndpoint : null
         */

        private AppServiceEntity appService;
        private String ackTime;
        private long ackTimeL;
        private String ackUser;
        private String ackUserContactName;
        private Object closeUser;
        private Object closeUserContactName;
        private Object closeComments;
        private String user;
        private int ext;
        private int activeCount;
        private Object activeAlarm;
        private String host;
        private String service;
        private String tag;
        private String metric;
        private int version;
        private Object parentAlarmId;
        private List<String> assignments;
        private List<String> contactNames;

        public int getAlarmId() {
            return alarmId;
        }

        public void setAlarmId(int alarmId) {
            this.alarmId = alarmId;
        }

        public String getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(String alarmType) {
            this.alarmType = alarmType;
        }

        public String getAlarmName() {
            return alarmName;
        }

        public void setAlarmName(String alarmName) {
            this.alarmName = alarmName;
        }

        public String getEntityName() {
            return entityName;
        }

        public void setEntityName(String entityName) {
            this.entityName = entityName;
        }

        public Object getHostIp() {
            return hostIp;
        }

        public void setHostIp(Object hostIp) {
            this.hostIp = hostIp;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getAlarmContent() {
            return alarmContent;
        }

        public void setAlarmContent(String alarmContent) {
            this.alarmContent = alarmContent;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(String creationTime) {
            this.creationTime = creationTime;
        }

        public long getCreationTimeL() {
            return creationTimeL;
        }

        public void setCreationTimeL(long creationTimeL) {
            this.creationTimeL = creationTimeL;
        }

        public String getModifiedTime() {
            return modifiedTime;
        }

        public void setModifiedTime(String modifiedTime) {
            this.modifiedTime = modifiedTime;
        }

        public long getModifiedTimeL() {
            return modifiedTimeL;
        }

        public void setModifiedTimeL(long modifiedTimeL) {
            this.modifiedTimeL = modifiedTimeL;
        }

        public String getLastTimeTxt() {
            return lastTimeTxt;
        }

        public void setLastTimeTxt(String lastTimeTxt) {
            this.lastTimeTxt = lastTimeTxt;
        }

        public String getTimeDuring() {
            return timeDuring;
        }

        public void setTimeDuring(String timeDuring) {
            this.timeDuring = timeDuring;
        }

        public Object getCloseTime() {
            return closeTime;
        }

        public void setCloseTime(Object closeTime) {
            this.closeTime = closeTime;
        }

        public Object getCloseTimeL() {
            return closeTimeL;
        }

        public void setCloseTimeL(Object closeTimeL) {
            this.closeTimeL = closeTimeL;
        }

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }

        public Object getAlarmDefId() {
            return alarmDefId;
        }

        public void setAlarmDefId(Object alarmDefId) {
            this.alarmDefId = alarmDefId;
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public AppServiceEntity getAppService() {
            return appService;
        }

        public void setAppService(AppServiceEntity appService) {
            this.appService = appService;
        }

        public String getAckTime() {
            return ackTime;
        }

        public void setAckTime(String ackTime) {
            this.ackTime = ackTime;
        }

        public long getAckTimeL() {
            return ackTimeL;
        }

        public void setAckTimeL(long ackTimeL) {
            this.ackTimeL = ackTimeL;
        }

        public String getAckUser() {
            return ackUser;
        }

        public void setAckUser(String ackUser) {
            this.ackUser = ackUser;
        }

        public String getAckUserContactName() {
            return ackUserContactName;
        }

        public void setAckUserContactName(String ackUserContactName) {
            this.ackUserContactName = ackUserContactName;
        }

        public Object getCloseUser() {
            return closeUser;
        }

        public void setCloseUser(Object closeUser) {
            this.closeUser = closeUser;
        }

        public Object getCloseUserContactName() {
            return closeUserContactName;
        }

        public void setCloseUserContactName(Object closeUserContactName) {
            this.closeUserContactName = closeUserContactName;
        }

        public Object getCloseComments() {
            return closeComments;
        }

        public void setCloseComments(Object closeComments) {
            this.closeComments = closeComments;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public int getExt() {
            return ext;
        }

        public void setExt(int ext) {
            this.ext = ext;
        }

        public int getActiveCount() {
            return activeCount;
        }

        public void setActiveCount(int activeCount) {
            this.activeCount = activeCount;
        }

        public Object getActiveAlarm() {
            return activeAlarm;
        }

        public void setActiveAlarm(Object activeAlarm) {
            this.activeAlarm = activeAlarm;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getMetric() {
            return metric;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public Object getParentAlarmId() {
            return parentAlarmId;
        }

        public void setParentAlarmId(Object parentAlarmId) {
            this.parentAlarmId = parentAlarmId;
        }

        public List<String> getAssignments() {
            return assignments;
        }

        public void setAssignments(List<String> assignments) {
            this.assignments = assignments;
        }

        public List<String> getContactNames() {
            return contactNames;
        }

        public void setContactNames(List<String> contactNames) {
            this.contactNames = contactNames;
        }

        public static class AppServiceEntity {
            private String id;
            private String escalationId;
            private String entityId;
            private String description;
            private String integrateType;
            private int autoResolve;
            private int ackTimeout;
            private String user;
            private String escalation;
            private Object email;
            private String password;
            private Object status;
            private Object isnow;
            private int compress;
            private Object mnsAccesskeyId;
            private Object mnsAccesskeySecret;
            private Object mnsAccountEndpoint;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getEscalationId() {
                return escalationId;
            }

            public void setEscalationId(String escalationId) {
                this.escalationId = escalationId;
            }

            public String getEntityId() {
                return entityId;
            }

            public void setEntityId(String entityId) {
                this.entityId = entityId;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIntegrateType() {
                return integrateType;
            }

            public void setIntegrateType(String integrateType) {
                this.integrateType = integrateType;
            }

            public int getAutoResolve() {
                return autoResolve;
            }

            public void setAutoResolve(int autoResolve) {
                this.autoResolve = autoResolve;
            }

            public int getAckTimeout() {
                return ackTimeout;
            }

            public void setAckTimeout(int ackTimeout) {
                this.ackTimeout = ackTimeout;
            }

            public String getUser() {
                return user;
            }

            public void setUser(String user) {
                this.user = user;
            }

            public String getEscalation() {
                return escalation;
            }

            public void setEscalation(String escalation) {
                this.escalation = escalation;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getIsnow() {
                return isnow;
            }

            public void setIsnow(Object isnow) {
                this.isnow = isnow;
            }

            public int getCompress() {
                return compress;
            }

            public void setCompress(int compress) {
                this.compress = compress;
            }

            public Object getMnsAccesskeyId() {
                return mnsAccesskeyId;
            }

            public void setMnsAccesskeyId(Object mnsAccesskeyId) {
                this.mnsAccesskeyId = mnsAccesskeyId;
            }

            public Object getMnsAccesskeySecret() {
                return mnsAccesskeySecret;
            }

            public void setMnsAccesskeySecret(Object mnsAccesskeySecret) {
                this.mnsAccesskeySecret = mnsAccesskeySecret;
            }

            public Object getMnsAccountEndpoint() {
                return mnsAccountEndpoint;
            }

            public void setMnsAccountEndpoint(Object mnsAccountEndpoint) {
                this.mnsAccountEndpoint = mnsAccountEndpoint;
            }
        }
    }
}
