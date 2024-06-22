package org.gfg.annotations;

import org.springframework.stereotype.Component;

@Component
public class SMSGatewayService {


    public void sendSMS(String msg){
        System.out.println("Sending sms:"+msg);
    }
}
