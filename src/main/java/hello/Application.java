package hello;

import hello.configuration.SpringJDBCConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

//@SpringBootApplication is a convenience annotation that adds all of the following:
//
//@Configuration tags the class as a source of bean definitions for the application context.
//@EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
//        Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
//@ComponentScan tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers

@SpringBootApplication
public class Application {
    // Add in some logging
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws SQLException {
        // setup database access
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
//                SpringJDBCConfiguration.class);

        SpringApplication.run(Application.class, args);

//        applicationContext.close();
    }
}
