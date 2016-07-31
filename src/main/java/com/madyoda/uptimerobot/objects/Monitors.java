package com.madyoda.uptimerobot.objects;

import lombok.Getter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C) madyoda // madyoda.com
 * Created by tom on 7/31/2016.
 */
public class Monitors {

    private List<Monitor> monitor;

    public List<Monitor> getMonitors() {
        return monitor;
    }


    public class Monitor {
        private String id;
        private String friendlyname;
        private String url;
        private String type;
        private String subtype;
        private String keywordtype;
        private String keyboardvalue;
        private String httpusername;
        private String httppassword;
        private String port;
        private String interval;
        private String status;
        private String alltimeuptimeratio;
        private String customtimeuptimeratio;
        private List<AlertContact> alertcontact;
        private List<Log> log;
        private List<ResponseTime> responsetime;

        public String getId() {
            return id;
        }

        public String getFriendlyName() {
            return friendlyname;
        }

        public String getUrl() {
            return url;
        }

        public String getType() {
            return type;
        }

        public String getSubtype() {
            return subtype;
        }

        public String getKeywordType() {
            return keywordtype;
        }

        public String getKeyboardValue() {
            return keyboardvalue;
        }

        public String getHttpUsername() {
            return httpusername;
        }

        public String getHttpPassword() {
            return httppassword;
        }

        public String getPort() {
            return port;
        }

        public String getInterval() {
            return interval;
        }

        public String getStatus() {
            return status;
        }

        public String getAllTimeUptimeRatio() {
            return alltimeuptimeratio;
        }

        public String getCustomTimeUptimeRatio() {
            return customtimeuptimeratio;
        }

        public List<AlertContact> getAlertContacts() {
            return alertcontact;
        }

        public List<Log> getLogs() {
            return log;
        }

        public List<ResponseTime> getResponseTimes() {
            return responsetime;
        }
    }

    public class AlertContact {
        private String id;
        private String type;
        private String value;
        private String threshold;
        private String recurrence;

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public String getValue() {
            return value;
        }

        public String getThreshold() {
            return threshold;
        }

        public String getRecurrence() {
            return recurrence;
        }
    }

    public class Log {
        private String type;
        private String datetime;
        private List<AlertContact> alertcontact;

        public String getType() {
            return type;
        }

        public Date getDatetime() {
            try {
                return new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(datetime);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        public String getDatetimeString(){
            return datetime;
        }
    }

    public class ResponseTime {
        private String datetime;
        private String value;

        public Date getDatetime() {
            try {
                return new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(datetime);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        public String getDatetimeString(){
            return datetime;
        }

        public String getValue() {
            return value;
        }
    }

}
