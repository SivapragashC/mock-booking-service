package net.apmoller.crb.telikos.microservices.activityplanworkflow.service;


import lombok.extern.slf4j.Slf4j;
import net.apmoller.crb.telikos.microservices.activityplanworkflow.model.ActivityPlanModel;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {

    @Autowired
    private KafkaProducer<String, Object> kafkaProducer;

    public void kafkaSendMessage(String topicName, ActivityPlanModel emailRequest) {

        if (null != emailRequest) {

            ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(topicName, emailRequest.getBookingId(), emailRequest);
            kafkaProducer.send(producerRecord, (recordMetadata, exception) -> {
                if (exception == null) {
                    log.info("message published successfully " +
                            "Topic: " + recordMetadata.topic() + ", Partition: " + recordMetadata.partition() + ", " +
                            "Offset: " + recordMetadata.offset() + " @ Timestamp: " + recordMetadata.timestamp());
                } else {
                    log.error("error occurred while publishing kafka msg ...", exception);
                }
            });
        }
    }
}
