package com.example.springbootaoplog;

import org.springframework.stereotype.Service;

/**
 * TestImpl
 *
 * @Description
 * @Author QianYiyu
 */
@Service
public class TestImpl implements TestService{
    @Override
    public void method1() {
        System.out.println("Method1 Body");
    }

    @Override
    public void method2() {
        System.out.println("Method2 Body");
    }

    @Override
    public void method3() throws Exception {
        throw new Exception("Some Exception");
    }
}
