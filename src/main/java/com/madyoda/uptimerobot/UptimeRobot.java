package com.madyoda.uptimerobot;

import com.google.gson.Gson;
import com.madyoda.uptimerobot.exceptions.ApiException;
import com.madyoda.uptimerobot.objects.AccountDetails;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

/**
 * Copyright (C) madyoda // madyoda.com
 * Created by tom on 7/31/2016.
 */
public class UptimeRobot {

    public static final String API_URL = "https://api.uptimerobot.com/";
    public static final Gson GSON = new Gson();
    private static String API_KEY;

    public UptimeRobot(String apiKey) {
        API_KEY = apiKey;
    }

    public AccountDetails getAccountDetails() throws UnirestException, ApiException {
        HttpResponse<JsonNode> accountDetailsJson = Unirest.post(API_URL + "getAccountDetails").queryString("apiKey", API_KEY).queryString("format", "json").queryString("noJsonCallback", 1).asJson();
        JSONObject jsonObject = accountDetailsJson.getBody().getObject();
        if (accountDetailsJson.getBody().getObject().getString("stat").equalsIgnoreCase("ok")) {
            return GSON.fromJson(jsonObject.toString(), AccountDetails.class);
        } else {
            throw new ApiException("API returned fail, id " + jsonObject.getString("id") + ", message " + jsonObject.getString("message"));
        }
    }


}
