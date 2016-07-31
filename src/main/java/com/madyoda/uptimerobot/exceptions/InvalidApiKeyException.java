package com.madyoda.uptimerobot.exceptions;

/**
 * Copyright (C) madyoda // madyoda.com
 * Created by tom on 7/31/2016.
 */
public class InvalidApiKeyException extends Exception {

    public InvalidApiKeyException() {
        super("API Key is invalid");
    }

}
