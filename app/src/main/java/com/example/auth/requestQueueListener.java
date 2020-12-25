package com.example.auth;

public interface requestQueueListener {
    void onError(String response);
    void onSuccess(String response);
}
