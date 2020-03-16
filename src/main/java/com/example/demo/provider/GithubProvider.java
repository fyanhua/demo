package com.example.demo.provider;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.AccessTokenDAO;
import com.example.demo.dao.userDAO;
import okhttp3.*;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDAO accessTokenDAO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

            RequestBody body = FormBody.create(JSON.toJSONString(accessTokenDAO),mediaType);
            Request request = new Request.Builder()
                     .url("https://github.com/login/oauth/access_token")
                     .post(body)
                     .addHeader("Accept","application/json")
                     .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                System.out.println(string);
                return string;
            } catch (IOException e) {
            }return null;
    }
    @SuppressWarnings("UnnecessaryLocalVariable")
    public userDAO getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user")
                    .header("Authorization","token "+accessToken)
                    .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            userDAO user = JSON.parseObject(string,userDAO.class);
            return user;
        } catch (IOException e) {
        }
        return null;
    }
}

