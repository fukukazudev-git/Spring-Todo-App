package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class TimeService{
    
    public String getCurrentTime(){
        return "Current time: " + LocalDateTime.now();
        
    }
/*どちらも@ServiceをつけることでSpringの管理対象(Bean)にする
Springが自動でインスタンス化してDIコンテナに登録する
→次にControllerに複数のServiceを注入する
 */
}