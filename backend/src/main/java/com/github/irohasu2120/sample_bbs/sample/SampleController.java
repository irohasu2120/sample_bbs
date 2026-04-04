package com.github.irohasu2120.sample_bbs.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String sampleGet() {
        return "Hello World2!";
    }
}
