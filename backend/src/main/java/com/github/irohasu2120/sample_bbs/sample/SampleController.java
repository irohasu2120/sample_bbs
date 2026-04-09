package com.github.irohasu2120.sample_bbs.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * サンプル Controller
 */
@RestController
@RequiredArgsConstructor
public class SampleController {
    private final SampleService sampleService;

    /**
     * サンプル Getリクエスト
     * @return 実行結果
     */
    @GetMapping("/hello")
    public String sampleGet() {
        return sampleService.mainRoutine();
//        return "Hello World2!";
    }
}
