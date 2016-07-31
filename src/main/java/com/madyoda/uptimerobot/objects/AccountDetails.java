package com.madyoda.uptimerobot.objects;

import lombok.Getter;

/**
 * Copyright (C) madyoda // madyoda.com
 * Created by tom on 7/31/2016.
 */
public class AccountDetails {


    @Getter
    private String monitorLimit;
    @Getter
    private String monitorInterval;
    @Getter
    private String upMonitors;
    @Getter
    private String downMonitors;
    @Getter
    private String pausedMonitors;

}

