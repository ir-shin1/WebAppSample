# tomcat-embed を使用したWebアプリケーションサンプル

組み込みTomcatの org.apache.catalina.startup.Tomcat を使用してWebアプリケーションを作成

* apache-tomcat-8.5.47-embed.tar.gz

 org.apache.catalina.startup.Tomcat を使用したmainクラス

* src/com/sample/startup/TomcatApp.java

 com｡sample.startup.TomcatApp を使用して起動するサーブレット(doGetのみを実装)

* src/com/sample/webapp1/ServletApp.java
* src/com/sample/webapp2/ServletApp.java

## 構成

Webサーバ 1個、Webアプリケーション 2個の計3個のdockerコテンナを利用してサンプルを作成

## 環境

### ベースとしたdockerコンテナ

* httpd:2.4.41-alpine
* adoptopenjdk/openjdk8:x86_64-alpine-jre8u232-b09

### 実行環境

* docker host : docker desktop community for mac 2.1.0.5(40693)

## コンパイル方法

### dockerイメージ作成まで

以下のコマンドで、javaのソースファイルからclassファイルを作成し、必要なファイル配置してdockerのイメージファイルを作成する。

```
$ ant mkimage
```

### docker実行

```
$ docker-compose up
```

### 実行確認

他のターミナルから curlコマンドでWebアプリケーションにアクセスする。

```
$ curl 'http://localhost/WebApp1/'
$ curl 'http://localhost/WebApp2/'
```

### docker停止

```
$ docker-compose down
```
