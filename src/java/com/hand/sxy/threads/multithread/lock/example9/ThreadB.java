package com.hand.sxy.threads.multithread.lock.example9;

/**
 * Created by Brian on 2016/4/15.
 */
public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.notifyMethod();
    }
}
