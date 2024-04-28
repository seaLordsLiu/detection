package org.sealord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import java.util.Map;

/**
 * @author liu xw
 * @date 2024 04-09
 */
@SpringBootApplication
public class DetectionDemoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DetectionDemoSpringApplication.class, args);
    }

}
