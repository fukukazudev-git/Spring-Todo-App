package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.MessageService;
import com.example.demo.service.CasualHelloService;

@Configuration
public class AppConfig {

    @Bean
    public MessageService messageService(){
        return new CasualHelloService();
    }

}

/*
これまでのServiceは@Service、@Component、
@Repository等のアノテーションによって自動的にBean化されていた。
しかし、実務では以下のようなケースが多い。
・外部ライブラリのクラスをBeanとして使用したい
・コンストラクタに複雑な設定が必要
・実装を動的に切り替えたい
・設定値を使用してインスタンスを生成したい
→このようなケースで@Beanを使用する

@Configrationは設定クラスであることを指す
@Beanはメソッドの戻り値をSpringのBeanとして登録することを意味する
戻り値の型(MessageService)がDIコンテナに登録される

ControllerはMessageServiceの実装を知らない
SpringがAppConfigの@BeanをみてHelloServiceを注入する

@Beanの本質
Springが自動で作らないクラスをBeanにできる
    外部ライブラリのクラス等に最適
コンストラクタに複雑な設定を渡せる
実装を動的に切り替えられる
    設定ファイルや環境変数を使用して切り替えることも可能
@Primaryや@Qualifierと併用可能

@Componentと@Beanの使い分け
@ComponentもクラスをSpringのコンテナにBeanとして登録するためのアノテーション
基本的には単純なクラスをSpringに管理させるときは@Component、複雑な初期化処理が必要なBeanや、
同じクラスで複数のBeanを管理する必要がある場合は@Beanを使用するとよい
@Component→Spring Bootがいい感じに依存関係を調節する
@Bean→より柔軟な定義が可能
 */
