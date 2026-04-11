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
設定ファイルの本質
1. 設定値をコードから切り離せる
→コードを変更せずに動作を変えられる
→本番環境と開発環境で設定を変えられる

2. Beanに設定値を渡せる
→APIキー
→URL
→タイムアウト値
→バージョン情報 など、実務で必須

3.application.ymlにも書ける

丁寧に仕組みを整理すると
Spring Bootは起動時に
1. applicaton.propertiesを読み込む
2. 全てのキーと値を「環境変数(Environment)」に登録する
3. ＠Value("${キー}")を見つけると
4. Environmentから値を取り出して
5. フィールドに代入する

キー名にドットが使用されているが、
これは一般的な命名規則で階層構造を表現するためにドットを使用している
*/