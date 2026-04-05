package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;
@Service
@Qualifier("hello")
public class HelloService implements MessageService{
    
    @Override
    public String getMessage(){
        return "Hello from HelloService!";
    }

}
/*優先する実装の場合、@Primaryを指定する
@Qualifierを使用した実務的なパターンについて
用途によって使い分けたい場合、@Qualifierを使用する。
Step1:実装クラスに名前を付ける
    つけた名前が識別子(ID)になる。
    Springはこの名前でBeanを区別可能になる。
Step2:Controllerで使用したい実装を指定する
Qualifierパッケージをインポートする(忘れない)
import org.springframework.beans.factory.annotation.Qualifier

@Qualifierを使用する実務的メリット
1.画面や機能ごとに実装を切り替えることが可能
    通常の画面 → HelloService
    カジュアルな画面 → CasualHelloService
    管理画面 → AdminHelloService
など、用途によって柔軟に切り替え可能。

2.実装を追加してもControllerは壊れない
新しい実装を追加しても：
    Controllerのコードは変えない
    @Qualifierの指定を変えればよい
→拡張性が高い

3.テストでモックを注入しやすい
テスト時に：
    @Qualifier("mock")
のようにモック実装を注入できる。

4.実務では @Primary と @Qualifier を併用する。
    デフォルトでは@Primary
    特定の箇所で@Qualifier で切り替える
というパターンが非常に多い。

*/