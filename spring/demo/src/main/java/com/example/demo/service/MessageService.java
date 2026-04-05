package com.example.demo.service;

public interface MessageService {
    String getMessage();
} 

/*Controllerがインターフェースを渡すことに関連した
Springの設計思想の核心について

メリットは大きく分けて3つ
1.実装を自由に差し替えられる(疎結合)
    Controllerが実装クラスを直接newしていたら：
    HelloService service  = new HelloService();
    こういった実装になるが、この場合だと：
    ・HelloServiceの変更がControllerに影響する
    ・別の実装に差し替えたいときにControllerを書き換える必要がある
    ・テスト時にモックに差し替えられない
    →結合が密

    インターフェースを使用すると
    public HelloController(MessageService service)
    ControllerはMessageServiceという契約のみ知っていればよい
    実装が：
    ・HelloService
    ・CasualHelloService
    ・SpecialHelloService
    どれでも動く。Controllerは一切変更不要。

    2.テストが圧倒的に楽になる
    実務ではControllerのテストをするとき、本物のServiceを使用したくないことが多い
    理由：
    ・DBにアクセスしてしまう
    ・外部APIを叩いてしまう
    ・時間がかかる
    ・テストが不安定になる
    そこで、モック(偽物の実装)を使用する。
    インターフェースがあれば：
    MessageService mock = () -> "test message";
    HelloController controller = new HelloController(mock);
    これでControllerのテストが完了する。実装クラスをnewしているとこれができない。

3.実務での拡張が圧倒的に楽になる
    案件例：
    ・平日はHelloService
    ・休日はHolodayHelloService
    ・VIPユーザにはSpecialHelloService
    →インターフェースがあれば、実装を増やすことで対応できる。
    (Controllerは一切変更不要)

→インターフェースの本質は「実装を強制する」ではなく、「依存を逆転させる」
　それが、依存性逆転の法則
・上位レイヤー(Controller)は下位レイヤー(Serviceの実装)に依存してはいけない
・両者は抽象(インターフェース)に依存すべき
これにより：
・変更に強い
・テストしやすい
・拡張しやすい
・大規模開発でも破綻しない
というメリットが生まれる。
 */