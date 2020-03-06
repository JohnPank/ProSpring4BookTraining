package com.johnpank.prospring4.chapter13.monitoring;

import com.johnpank.prospring4.chapter13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class AppStatisticImpl implements AppStatistic {

    @Autowired
    UserService userService;

    @Override
    public int getUserCount() {
        return userService.findAll().size();
    }
}
