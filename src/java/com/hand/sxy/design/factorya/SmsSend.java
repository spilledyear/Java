package com.hand.sxy.design.factorya;

/**
 * Created by spilledyear on 2017/9/5.
 */
public class SmsSend implements ISend {
    @Override
    public void send(String message) {
        System.out.println("发送短信" + message);
    }
}
