package com.example.services;

import java.util.concurrent.Future;

public interface AsyncNotificationsService {

    Future<Void> sendNotification(String type, String content);
}
