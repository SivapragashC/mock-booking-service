package net.apmoller.crb.telikos.microservices.activityplanworkflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The application class for the activityplanworkflow spring boot service.
 */
@SpringBootApplication(scanBasePackages = {"com.*", "com.maersk.*", "net.apmoller.crb.telikos.microservices.activityplanworkflow.*"})
public class ActivityplanworkflowApplication {

    /**
     * Standalone spring boot starter.
     *
     * @param args arguments for the spring boot app run.
     */
    public static void main(String... args) {

        SpringApplication.run(ActivityplanworkflowApplication.class, args);
    }
}
