package com.zto.sxy.design.factorya;

/**
 * Created by spilledyear on 2017/9/5.
 */
public class MailSendFactory implements Factory{
    @Override
    public ISend produce() {
        return new MailSend();
    }
}
