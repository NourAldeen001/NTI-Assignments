package com.example.notify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationManager {

    private List<Notifier> notifiers;

    @Autowired
    public NotificationManager(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void notify(String message) {
        for(Notifier notifier : notifiers) {
            notifier.send(message);
        }
    }

}
