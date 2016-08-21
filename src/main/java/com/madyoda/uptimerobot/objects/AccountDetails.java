package com.madyoda.uptimerobot.objects;

import lombok.Getter;

/**
 * Copyright (C) madyoda // madyoda.com
 * Created by tom on 7/31/2016.
 */
public class AccountDetails {

    private Integer id;
    private String email;
    private String monitor_limit;
    private String monitor_interval;
    private String up_monitors;
    private String down_monitors;
    private String paused_monitors;

    public String getEmail() {
        return email;
    }

    public String getMonitorLimit() {
        return monitor_limit;
    }

    public String getMonitorInterval() {
        return monitor_interval;
    }

    public String getUpMonitors() {
        return up_monitors;
    }

    public String getDownMonitors() {
        return down_monitors;
    }

    public String getPausedMonitors() {
        return paused_monitors;
    }
}

