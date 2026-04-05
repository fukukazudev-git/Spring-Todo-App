package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MessageService;

@RestController
public class HelloController {

    private final MessageService messageService;

    // コンストラクタインジェクション(推奨)
    public HelloController (MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/hello")
    public String hello() {
        return messageService.getMessage();
    }
  
/*
helloService.getMessage()を呼ぶことで
→Controller→Serviceの流れが完成

ここでのコンストラクタインジェクションが機能する理由
→SpringがHelloControllerをnewしている
そのとき、必要なHelloServiceをDIコンテナから取り出して
渡している(Springが引数を解決して渡している→依存性注入)

Springは管理対象(Bean)をDIコンテナに登録し、必要な時に取り出してコンストラクタに注入する
つまり：
@Service→Beanとして登録
@RestController→Beanとして登録
ControllerのコンストラクタにServiceが必要
SpringがDIコンテナからServiceを取り出して渡す
という流れになる。

実装差し替え時(インターフェース編)
ControllerはMessageService(インターフェース)だけを受け取る
実装がHelloServiceかCasualHelloServiceかは知らない。
Springがどちらかを注入する
→実装が複数ある場合、Springは迷うため@Primaryを使用して優先する実装を指定する。
*/
}
