package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class JavaApplication {

    @RequestMapping("/")
    public String Java() {
        return "Hello World";
    }

    @RequestMapping(path = "/sort", method = RequestMethod.POST, consumes = {"text/plain"})
    public String sort(@RequestBody String body) {
        if(!StringUtils.hasText(body)) {
            return body;
        }
        return Arrays.stream(body.split(","))
                .mapToInt(x -> Integer.parseInt(x.trim()))
                .sorted().boxed().collect(Collectors.<Integer>toList()).toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }

}
