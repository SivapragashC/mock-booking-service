package net.apmoller.crb.telikos.microservices.activityplanworkflow.model;

import lombok.Data;

@Data
public class ActivityPlanEvent {
    String productName;
    String domainName;
    String orderId;
    String bookingId;
    String eventName;
    String userId;
    String userName;
    String activityDateTime;
    String status;

}
