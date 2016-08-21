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

    private List<Monitor> monitors;

    public List<Monitor> getMonitors() {
        return monitors;
    }


    public class Monitor {
        private String id;
        private String friendly_name;
        private String url;
        private Integer type;
        private String sub_type;
        private String keyword_type;
        private String keyword_value;
        private String http_username;
        private String http_password;
        private String port;
        private Integer interval;
        private Integer status;
        private Integer create_datetime;
        private String alltime_uptime_ratio; // TODO: Check name (undocumented)
        private String customtime_uptime_ratio; // TODO: Check name (undocumented)
        private List<Log> logs;

        public String getId() {
            return id;
        }

        public String getFriendlyName() {
            return friendly_name;
        }

        public String getUrl() {
            return url;
        }

        public Integer getType() {
            return type;
        }

        public String getSubType() {
            return sub_type;
        }

        public String getKeywordType() {
            return keyword_type;
        }

        public String getKeywordValue() {
            return keyword_value;
        }

        public String getHttpUsername() {
            return http_username;
        }

        public String getHttpPassword() {
            return http_password;
        }

        public String getPort() {
            return port;
        }

        public Integer getInterval() {
            return interval;
        }

        public Integer getStatus() {
            return status;
        }

        public Integer getCreateDateTime() {
            return create_datetime;
        }

        public String getAllTimeUptimeRatio() {
            return alltime_uptime_ratio;
        }

        public String getCustomTimeUptimeRatio() {
            return customtime_uptime_ratio;
        }

        public List<Log> getLogs() {
            return logs;
        }

    }

    public class AlertContact {
        // TODO: Do we need?
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
        private Integer type;
        private Integer datetime;
        private Integer duration;

        public Integer getType() {
            return type;
        }

        public Integer getDateTime() {
            return datetime;
        }

        public Integer getDuration() {
            return duration;
        }
    }

}
