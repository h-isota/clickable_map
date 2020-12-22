# クリッカブルマップ生成 Java ライブラリ

クリッカブルマップを生成する Java のライブラリです。

# デモ

[この](test/HTMLFileTest_save.html) ようなクリッカブルマップを
Java で生成します。
 
# 特徴
 
・シンプルなコード
・機能追加、拡張、変更が容易
 
# 動作環境

* mvn

その他は、mvn が自動で取ってきます。
 
# ライブラリ作成
 
```bash
mvn package
```

以下のファイルができます。

target/clickable_map-0.0.1-SNAPSHOT.jar

# 使い方

以下のソースを見ていただければ分かるかと思います。

[HTMLFileTest.java](src/test/java/isota/test/HTMLFileTest.java)
 
# メモ
 
API ドキュメントが見たい場合。
```bash
mvn javadoc:javadoc
```

# 開発者
 
* isota
* 38205899+h-isota@users.noreply.github.com
 
# ライセンス

[MIT license](LICENSE).
