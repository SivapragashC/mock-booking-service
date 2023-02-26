package net.apmoller.crb.telikos.microservices.activityplanworkflow.controller;//package net.apmoller.crb.ohm.microservices.reactivekafkaonionarc.controller;


import lombok.RequiredArgsConstructor;
import net.apmoller.crb.telikos.microservices.activityplanworkflow.model.ActivityPlanModel;
import net.apmoller.crb.telikos.microservices.activityplanworkflow.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    @Autowired
    private KafkaProducerService KafkaProducerService;

    @PostMapping("/publish")
    public void pushReactiveEasy(@RequestBody final ActivityPlanModel message) {
        KafkaProducerService.kafkaSendMessage("booking-topic",message);
    }

    @PostMapping("/publish/email")
    public void pushReactiveEmail(@RequestBody final ActivityPlanModel message) {
        KafkaProducerService.kafkaSendMessage("email-response-topic",message);
    }

}
