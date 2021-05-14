package cn.liuhao.web_market.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubController {

    @RequestMapping("login")
    public Object login(){

        return "hell world";
    }

}
