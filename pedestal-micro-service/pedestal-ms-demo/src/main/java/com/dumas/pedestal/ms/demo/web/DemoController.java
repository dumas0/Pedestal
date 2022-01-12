package com.dumas.pedestal.ms.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dumas
 * @date 2022/01/12 11:01 AM
 */
@RestController
@RequestMapping
public class DemoController {

    @RequestMapping("/hello")
    public String index(){
        return "Hello World!";
    }
}
