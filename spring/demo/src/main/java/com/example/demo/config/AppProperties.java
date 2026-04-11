package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private String message;
    private String version;
    private String author;

    // getter / setter
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getVersion(){
        return version;
    }
    public void setVersion(String version){
        this.version = version;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    
}
/*@ConfigurationPropertiesは設定値をまとめて1つのクラスに注入する仕組み
＠Valueの上位互換であり、実務ではこちらが主流
Step1: application.propertiesに設定値をまとめる
Step2: 設定値を受け取るクラスを作る(POJO)
　　　  @ConfigurationProperties(prefix="app")⇒app.*の設定値をまとめて注入
　　　　@Component→Springの管理対象(Bean)にする
　　　　フィールド名と設定キーの後半が一致すれば自動でマッピングされる
Step3: ControllerでAppPropertiesを使う

 */