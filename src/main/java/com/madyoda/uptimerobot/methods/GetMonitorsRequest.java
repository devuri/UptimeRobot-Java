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
        private String customUptimeRanges = "";
        private Boolean allTimeUptimeRatio = false;
        private Boolean allTimeUptimeDurations = false;
        private Boolean logs = false;
        private String logsStartDate = "";
        private String logsEndDate = "";
        private String logsLimit = "";
        private Boolean responseTimes = false;
        private String responseTimesLimit = "";
        private Integer responseTimesAverage = 0;
        private String responseTimesStartDate = "";
        private String responseTimesEndDate = "";
        private Boolean alertContacts = false;
        private String maintenanceWindows = "";
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

        public GetMonitorsRequestBuilder setCustomUptimeRanges(String customUptimeRanges) {
            this.customUptimeRanges = customUptimeRanges;
            return this;
        }

        public GetMonitorsRequestBuilder setAllTimeUptimeRatio(Boolean allTimeUptimeRatio) {
            this.allTimeUptimeRatio = allTimeUptimeRatio;
            return this;
        }

        public GetMonitorsRequestBuilder setAllTimeUptimeDurations(Boolean allTimeUptimeDurations) {
            this.allTimeUptimeDurations = allTimeUptimeDurations;
            return this;
        }

        public GetMonitorsRequestBuilder setLogs(Boolean logs) {
            this.logs = logs;
            return this;
        }

        public GetMonitorsRequestBuilder setLogsStartDate(String logsStartDate) {
            this.logsStartDate = logsStartDate;
            return this;
        }

        public GetMonitorsRequestBuilder setLogsEndDate(String logsEndDate) {
            this.logsEndDate = logsEndDate;
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

        public GetMonitorsRequestBuilder setMaintenanceWindows(String maintenanceWindows) {
            this.maintenanceWindows = maintenanceWindows;
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
            HttpResponse<JsonNode> accountMonitorsJson = Unirest.post(API_URL + "getMonitors")
                    /*
                    This is based off the fact Unirest treats an empty string ("") as nothing and doesn't put it as a query.
                     */
                    .queryString("format", "json")
                    .queryString("noJsonCallback", 1)
                    .queryString("monitors", monitors)
                    .queryString("types", types)
                    .queryString("statuses", statuses)
                    .queryString("custom_uptime_ratios", customUptimeRatio)
                    .queryString("custom_uptime_ranges", customUptimeRanges)
                    .queryString("all_time_uptime_ratio", allTimeUptimeRatio ? "1" : "0")
                    .queryString("all_time_uptime_durations", allTimeUptimeDurations ? "1" : "0")
                    .queryString("logs", logs ? "1" : "0")
                    .queryString("logs_start_date", logsStartDate)
                    .queryString("logs_end_date", logsEndDate)
                    .queryString("logs_limit", logsLimit)
                    .queryString("response_times", responseTimes ? "1" : "0")
                    .queryString("response_times_limit", responseTimesLimit)
                    .queryString("response_times_average", responseTimesAverage)
                    .queryString("response_times_start_date", responseTimesStartDate)
                    .queryString("response_times_end_date", responseTimesEndDate)
                    .queryString("alert_contacts", alertContacts ? "1" : "0")
                    .queryString("mwindows", maintenanceWindows)
                    .queryString("showTimezone", showTimezone ? "1" : "0")
                    .queryString("search", search)
                    .field("api_key", uptimeRobot.getAPI_KEY())
                    .asJson();
            JSONObject jsonObject = accountMonitorsJson.getBody().getObject();
            if (accountMonitorsJson.getBody().getObject().getString("stat").equalsIgnoreCase("ok")) {
                System.out.println(jsonObject.toString());
                return GSON.fromJson(jsonObject.toString(), Monitors.class);
            } else {
                throw new ApiException("API returned fail, id " + jsonObject.getString("id") + ", message " + jsonObject.getString("message"));
            }
        }
    }
}
