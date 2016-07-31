package com.madyoda.uptimerobot.methods;

import com.madyoda.uptimerobot.UptimeRobot;
import com.madyoda.uptimerobot.exceptions.ApiException;
import com.madyoda.uptimerobot.objects.AccountDetails;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import static com.madyoda.uptimerobot.UptimeRobot.API_URL;
import static com.madyoda.uptimerobot.UptimeRobot.GSON;

/**
 * Copyright (C) madyoda // madyoda.com
 * Created by tom on 7/31/2016.
 */
public class GetMonitorsRequest {

    public static GetMonitorsBuilder builder() {
        return new GetMonitorsBuilder();
    }


    public static class GetMonitorsBuilder {

        private UptimeRobot uptimeRobot;
        private String monitors;
        private String types;
        private String statuses;
        private String customUptimeRatio;
        private Boolean logs;
        private Integer logsLimit;


        public GetMonitorsBuilder setUptimeRobot(UptimeRobot uptimeRobot) {
            this.uptimeRobot = uptimeRobot;
            return this;
        }

        public AccountDetails get() throws ApiException, UnirestException {
            HttpResponse<JsonNode> accountDetailsJson = Unirest.post(API_URL + "getMonitors").queryString("apiKey", uptimeRobot.getAPI_KEY()).queryString("format", "json").queryString("noJsonCallback", 1).asJson();
            JSONObject jsonObject = accountDetailsJson.getBody().getObject();
            if (accountDetailsJson.getBody().getObject().getString("stat").equalsIgnoreCase("ok")) {
                return GSON.fromJson(jsonObject.getJSONObject("account").toString(), AccountDetails.class);
            } else {
                throw new ApiException("API returned fail, id " + jsonObject.getString("id") + ", message " + jsonObject.getString("message"));
            }
        }
    }

}
