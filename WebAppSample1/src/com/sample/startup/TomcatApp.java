
/*
  Emmbeded Tomcat Main
 */

package com.sample.startup;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class TomcatApp {
    // arg0 : ポート番号
    // arg1 : ホスト
    // arg2 : マッピング
    // arg3 : サーブレットクラス名
    public static void main(String argv[]) throws Exception {
        Tomcat tomcat = new Tomcat();

        // 待ち受けポートとホスト名の指定
        tomcat.setPort(Integer.parseInt(argv[0]));
        tomcat.setHostname(argv[1]);

        // public Connector getConnector()
        // Get the default HTTP connector that is used by the embedded Tomcat. It is
        // first configured connector in the service. If there's no connector defined,
        // it will create and add a default connector using the port and address
        // specified in this Tomcat instance, and return it for further customization.
        tomcat.getConnector();

        // public Context addContext（String contextPath、 String docBase）
        // contextPath The context mapping to use, "" for root context.
        // コンテキストの追加-プログラムモード、デフォルトのweb.xmlは使用されません。
        // これは、プログラムインターフェイスで明示的に有効にしない限り、JSPサポート（JSPサーブレット）、デフォルトサーブレット、
        // およびWebソケットのサポートがないことを意味します。
        // ServletContainerInitializer処理も注釈処理もありません 。ServletContainerInitializerプログラムで
        // を追加しても、HandlesTypes一致のスキャンは行われません 。
        Context ctx = tomcat.addContext("", null);

        // public Wrapper addServlet（String contextPath、 String servletName、 String
        // servletClass）
        // public static Wrapper addServlet（Context ctx、 String servletClass）
        // addServlt(String, String, String) の静的バージョン
        // <servlet> <servlet-name> <servlet-class>と同等です。
        // 一般に、サーブレットをパラメーターとして使用するメソッドを使用する方が良い/高速です。
        // これは、サーブレットが一般的に使用されておらず、すべての依存関係のロードを避けたい場合に使用できます。
        Tomcat.addServlet(ctx, "default", argv[3]);
        ctx.addServletMappingDecoded(argv[2], "default");

        // public void setBaseDir（String basedir）
        // TODO: disable work dir if not needed ( no jsp, etc ).
        // 上記のように無効化できそうな感じのコメントがあったが、以下の8.5.xソースをみるとディレクトリは作るようだ
        // https://github.com/apache/tomcat/blob/dd7019b4932f2135a55b538b6dd63b7d10180526/java/org/apache/catalina/startup/Tomcat.java#L783
        // tomcat.setBaseDir();

        // public Context addWebapp（String contextPath、 String docBase）
        // 指定されたWARファイルをホストのappBase addWebapp(String, String)にコピーし、新しくコピーされたWARで呼び出します 。
        // Tomcatインスタンスが停止しても、WARはホストのappBaseから削除されません。
        // ExpandWar必要に応じて、WARや展開されたディレクトリを削除するために使用できるユーティリティメソッドを提供します。

        // コンテナ起動
        tomcat.start();
        tomcat.getServer().await();
    }
}
