package com.example.demo.controller;

import com.example.demo.dao.AccessTokenDAO;
import com.example.demo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class oAuthController {
    //接收github参数
    @Autowired
    private  GithubProvider githubProvider;



    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state")String state){
        AccessTokenDAO accessTokenDAO = new AccessTokenDAO();
        accessTokenDAO.setCode(code);
        accessTokenDAO.setRedirect_uri("https://github.com/login/oauth/access_token");
        accessTokenDAO.setClient_id("1cfeafe90df37ff82edf");
        accessTokenDAO.setClient_secret("aa4917bf1f08065ce49bab50406394e1ddc4c2c4");
        githubProvider.getAccessToken(accessTokenDAO);
        accessTokenDAO.setState(state);
        return "index";

    }
}
