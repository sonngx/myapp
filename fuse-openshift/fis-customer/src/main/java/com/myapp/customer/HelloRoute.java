package com.myapp.customer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * A spring-boot application that includes a Camel route builder to setup the Camel routes
 */
@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
public class HelloRoute extends RouteBuilder {

    // must have a main method spring-boot can run
    public static void main(String[] args) {
        SpringApplication.run(HelloRoute.class, args);
    }

    @Override
    public void configure() throws Exception {
        from("timer://foo222?period=15000")
            .setBody().constant("Hello World foo222")
            .log(">>> ${body}");
    }
}


