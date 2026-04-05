package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("casual")
public class CasualHelloService implements MessageService{
    
    @Override
    public String getMessage(){
        return "Hey! What's up?";
    }
/*DIの真骨頂
Controllerのコードを1文字も変更することなく、実装だけ差し替えて動作が変わる
これが疎結合であり、テストしやすさ、拡張しやすさにつながる。
 */

}
