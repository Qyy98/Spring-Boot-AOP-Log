package com.example.springbootaoplog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @Description
 * @Author QianYiyu
 */
@RestController
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("test")
    public void test() throws Exception {
        testService.method1();
        testService.method2();
        testService.method3();
    }
}
