package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
/* SpringApplication.run()がやっていること
SpringApplication.run(DemoApplication.class,args);
実際に行われていることとしては：
SpringのDIコンテナ(IoCコンテナ)を起動
@Component/@Service/@Controller(Bean定義されている
インスタンス)をスキャン
それらのクラスのインスタンスを自動生成
依存関係(コンストラクタ引数)を解決して注入
Tomcatを起動してWebサーバとして待ち受け開始

 */


}
