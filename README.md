# Spring-Todo-App
===概要===
Spring Bootを使用したシンプルなTodo管理アプリケーションです。タスクの登録・更新・削除・検索ができ、REST APIとして提供しています。

===主な機能===
タスクの新規作成
タスク一覧取得
タスクの更新
タスクの削除
タスクの検索(キーワード/ステータス)

===使用技術===
Java17
Spring Boot3.x
Spring Web
Spring Data JPA
H2 Database / MySQL
Maven
Lombok

===API仕様===
GET/api/tasks
タスク一覧を取得します。

POST/api/tasks
新規タスクを登録します。

===セットアップ方法===
1.リポジトリをclone
  git clone https://github.com/username/spring-todo-app.git

2.プロジェクトを起動
  mvn spring-boot:run

3.ブラウザで確認
  http://localhost:8080

===ディレクトリ構成===
src/
 └ main/
    ├ java/com/example/todo
    │   ├ controller
    │   ├ service
    │   ├ repository
    │   └ entity
    └ resources/
        ├ application.properties
        └ data.sql

===今後の改善活動===
認証機能の追加
Docker化
フロントエンドとの連携(React/Vue)

===作者===
一城
Backend Engineer(Aspiring)
GitHub:
