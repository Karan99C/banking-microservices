package com.notification.util;

public class MessageFormatter {

    public static String formatRewardMessage(String customerId, double rewardPoints){
        return "Hi " + customerId + ", you've earned " + rewardPoints + " reward points!";
    }
}
