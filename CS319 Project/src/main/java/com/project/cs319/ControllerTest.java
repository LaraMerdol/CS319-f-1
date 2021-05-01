package com.project.cs319;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerTest {

    @GetMapping("/m1")
    public String m1() {
        return "asfgmnasıpghnasnbgpsanbgğosagasgsagas";
    }
}

