package com.madyoda.uptimerobot;

import com.google.gson.Gson;
import com.madyoda.uptimerobot.exceptions.ApiException;
import com.madyoda.uptimerobot.objects.AccountDetails;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.Getter;
import org.json.JSONObject;

/**
 * Copyright (C) madyoda // madyoda.com
 * Created by tom on 7/31/2016.
 */
public class UptimeRobot {

    public static final String API_URL = "https://api.uptimerobot.com/v2/";
    public static final Gson GSON = new Gson();
    @Getter
    public String API_KEY;

    public UptimeRobot(String apiKey) {
        API_KEY = apiKey;
    }

}
