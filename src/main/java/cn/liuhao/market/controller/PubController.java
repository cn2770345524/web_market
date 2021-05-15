package cn.liuhao.market.controller;

import cn.liuhao.market.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pub")
public class PubController {

    @RequestMapping("login")
    public Object login(String username,String password){

        return "hell world";
    }

    @RequestMapping("register")
    public Object register(String username,String password){

        return null;
    }

}
