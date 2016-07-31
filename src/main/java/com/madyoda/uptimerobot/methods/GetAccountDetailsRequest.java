package com.madyoda.uptimerobot.methods;

import com.madyoda.uptimerobot.UptimeRobot;
import com.madyoda.uptimerobot.exceptions.ApiException;
import com.madyoda.uptimerobot.objects.AccountDetails;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.Getter;
import org.json.JSONObject;

import static com.madyoda.uptimerobot.UptimeRobot.API_URL;
import static com.madyoda.uptimerobot.UptimeRobot.GSON;

/**
 * Copyright (C) madyoda // madyoda.com
 * Created by tom on 7/31/2016.
 */
public class GetAccountDetailsRequest {

    public static GetAccountDetailsRequestBuilder builder() {
        return new GetAccountDetailsRequestBuilder();
    }


    public static class GetAccountDetailsRequestBuilder {

        private UptimeRobot uptimeRobot;

        public GetAccountDetailsRequestBuilder setUptimeRobot(UptimeRobot uptimeRobot) {
            this.uptimeRobot = uptimeRobot;
            return this;
        }

        public AccountDetails build() throws ApiException, UnirestException {
            HttpResponse<JsonNode> accountDetailsJson = Unirest.post(API_URL + "getAccountDetails").queryString("apiKey", uptimeRobot.getAPI_KEY()).queryString("format", "json").queryString("noJsonCallback", 1).asJson();
            JSONObject jsonObject = accountDetailsJson.getBody().getObject();
            if (accountDetailsJson.getBody().getObject().getString("stat").equalsIgnoreCase("ok")) {
                return GSON.fromJson(jsonObject.getJSONObject("account").toString(), AccountDetails.class);
            } else {
                throw new ApiException("API returned fail, id " + jsonObject.getString("id") + ", message " + jsonObject.getString("message"));
            }
        }
    }

}
