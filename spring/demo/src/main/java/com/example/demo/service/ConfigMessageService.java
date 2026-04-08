package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigMessageService {

    @Value("${app.message}")
    private String message;

    @Value("${app.version}")
    private String version;

    public String getConfigMessage() {
        return message + " (version: " + version + ")";
    }
}
/* @Value("${キー名}")で設定値を注入‘Springがapprication.propertiesを読み込んで設定値を渡す
DIと同じく「自分でnewしない」仕組み
*/