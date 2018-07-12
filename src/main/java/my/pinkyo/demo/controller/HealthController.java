package my.pinkyo.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    private static final String SUCCESS_STRING = "Success";

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String health() {
        return SUCCESS_STRING;
    }
}
