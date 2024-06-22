package org.gfg.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class NotificationService {

    // field based dependency injection
    @Autowired
    private SMSGatewayService smsGatewayService;

    // constructor based dependency injection
//    public NotificationService(SMSGatewayService smsGatewayService) {
//        this.smsGatewayService = smsGatewayService;
//    }


    // setter based dependency injection
   // @Autowired
    public void setSmsGatewayService(SMSGatewayService smsGatewayService) {
        System.out.println("Executing setter");
        this.smsGatewayService = smsGatewayService;
    }

    public void sendNotification(String msg){
        smsGatewayService.sendSMS(msg);
    }
}
