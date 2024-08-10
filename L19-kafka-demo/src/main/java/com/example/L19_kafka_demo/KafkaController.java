package com.example.L19_kafka_demo;

import jakarta.websocket.SendResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/push")
    ResponseEntity<String> pushDataToTopic(@RequestParam String topic, @RequestParam String data) throws ExecutionException, InterruptedException {
        Future future = kafkaTemplate.send(topic,data,data);
        LOGGER.info("Payload pushed to kafka: {}",future.get());
        return ResponseEntity.ok("Data Pushed");
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
 //       simpleMailMessage.setFrom("sk.email.service@gmail.com");
        simpleMailMessage.setFrom("jbdl.ewallet@gmail.com");
        simpleMailMessage.setSubject(emailRequest.getSubject());
        simpleMailMessage.setText(emailRequest.getBody());
        simpleMailMessage.setCc(emailRequest.getCc());
        simpleMailMessage.setTo(emailRequest.getToEmail());
        javaMailSender.send(simpleMailMessage);
        return ResponseEntity.ok("Data Pushed");
    }


    @PostMapping("/sendEmailAsync")
    public ResponseEntity<String> sendEmailAsync(@RequestBody EmailRequest emailRequest) throws ExecutionException, InterruptedException {
        Future future = kafkaTemplate.send("emailTopic",emailRequest.getToEmail(),emailRequest);
        LOGGER.info("Payload pushed to kafka: {}",future.get());
        return ResponseEntity.accepted().build();
    }

}
