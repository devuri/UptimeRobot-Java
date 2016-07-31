package com.madyoda.uptimerobot.methods;

import com.madyoda.uptimerobot.UptimeRobot;
import com.madyoda.uptimerobot.exceptions.ApiException;
import com.madyoda.uptimerobot.objects.AccountDetails;
import com.madyoda.uptimerobot.objects.Monitors;
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

    public static GetMonitorsRequestBuilder builder() {
        return new GetMonitorsRequestBuilder();
    }


    public static class GetMonitorsRequestBuilder {

        private UptimeRobot uptimeRobot;
        private String monitors = "";
        private String types = "";
        private String statuses = "";
        private String customUptimeRatio = "";
        private Boolean logs = false;
        private String logsLimit = "";
        private Boolean responseTimes = false;
        private String responseTimesLimit = "";
        private Integer responseTimesAverage = 0;
        private String responseTimesStartDate = "";
        private String responseTimesEndDate = "";
        private Boolean alertContacts = false;
        private Boolean showMonitorAlertContacts = false;
        private Boolean showTimezone = false;
        private String search = "";

        // API Object
        public GetMonitorsRequestBuilder setUptimeRobot(UptimeRobot uptimeRobot) {
            this.uptimeRobot = uptimeRobot;
            return this;
        }

        public GetMonitorsRequestBuilder setMonitors(String monitors) {
            this.monitors = monitors;
            return this;
        }

        public GetMonitorsRequestBuilder setTypes(String types) {
            this.types = types;
            return this;
        }

        public GetMonitorsRequestBuilder setStatuses(String statuses) {
            this.statuses = statuses;
            return this;
        }

        public GetMonitorsRequestBuilder setCustomUptimeRatio(String customUptimeRatio) {
            this.customUptimeRatio = customUptimeRatio;
            return this;
        }

        public GetMonitorsRequestBuilder setLogs(Boolean logs) {
            this.logs = logs;
            return this;
        }

        public GetMonitorsRequestBuilder setLogsLimit(String logsLimit) {
            this.logsLimit = logsLimit;
            return this;
        }

        public GetMonitorsRequestBuilder setResponseTimes(Boolean responseTimes) {
            this.responseTimes = responseTimes;
            return this;
        }

        public GetMonitorsRequestBuilder setResponseTimesLimit(String responseTimesLimit) {
            this.responseTimesLimit = responseTimesLimit;
            return this;
        }

        public GetMonitorsRequestBuilder setResponseTimesAverage(Integer responseTimesAverage) {
            this.responseTimesAverage = responseTimesAverage;
            return this;
        }

        public GetMonitorsRequestBuilder setResponseTimesStartDate(String responseTimesStartDate) {
            this.responseTimesStartDate = responseTimesStartDate;
            return this;
        }

        public GetMonitorsRequestBuilder setResponseTimesEndDate(String responseTimesEndDate) {
            this.responseTimesEndDate = responseTimesEndDate;
            return this;
        }

        public GetMonitorsRequestBuilder setAlertContacts(Boolean alertContacts) {
            this.alertContacts = alertContacts;
            return this;
        }

        public GetMonitorsRequestBuilder setShowMonitorAlertContacts(Boolean showMonitorAlertContacts) {
            this.showMonitorAlertContacts = showMonitorAlertContacts;
            return this;
        }

        public GetMonitorsRequestBuilder setShowTimezone(Boolean showTimezone) {
            this.showTimezone = showTimezone;
            return this;
        }

        public GetMonitorsRequestBuilder setSearch(String search) {
            this.search = search;
            return this;
        }

        public Monitors get() throws ApiException, UnirestException {
            HttpResponse<JsonNode> accountDetailsJson = Unirest.post(API_URL + "getMonitors")
                    /*
                    This is based off the fact Unirest treats an empty string ("") as nothing and doesn't put it as a query.
                     */
                    .queryString("apiKey", uptimeRobot.getAPI_KEY())
                    .queryString("format", "json")
                    .queryString("noJsonCallback", 1)
                    .queryString("monitors", monitors)
                    .queryString("types", types)
                    .queryString("statuses", statuses)
                    .queryString("customUptimeRatio", customUptimeRatio)
                    .queryString("logs", logs ? "1" : "0")
                    .queryString("logsLimit", logsLimit)
                    .queryString("responseTimes", responseTimes ? "1" : "0")
                    .queryString("responseTimesLimit", responseTimesLimit)
                    .queryString("responseTimesAverage", responseTimesAverage)
                    .queryString("responseTimesStartDate", responseTimesStartDate)
                    .queryString("responseTimesEndDate", responseTimesEndDate)
                    .queryString("alertContacts", alertContacts ? "1" : "0")
                    .queryString("showMonitorAlertContacts", showMonitorAlertContacts ? "1" : "0")
                    .queryString("showTimezone", showTimezone ? "1" : "0")
                    .queryString("search", search)
                    .asJson();
            JSONObject jsonObject = accountDetailsJson.getBody().getObject();
            if (accountDetailsJson.getBody().getObject().getString("stat").equalsIgnoreCase("ok")) {
                return GSON.fromJson(jsonObject.getJSONObject("monitors").toString(), Monitors.class);
            } else {
                throw new ApiException("API returned fail, id " + jsonObject.getString("id") + ", message " + jsonObject.getString("message"));
            }
        }
    }
}
