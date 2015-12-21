package com.example.services;

import java.util.concurrent.Future;

public interface NotificationsService {

    Future<Void> sendNotification(String type, String content);
}
