package hello.controller;

import hello.model.Greeting;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// annotation shorthand for @Controller and @ResponseBody
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // This annotation can accept method=GET otherwise all requests are routed
    // The response is marshalled into JSON by Jackson 2 (MappingJackson2HttpMessageConverter)
    // CORS is also enabled for this request https://spring.io/guides/gs/rest-service-cors/
    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),
                String.format(template,name));
    }
}
