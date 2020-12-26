# クリッカブルマップ生成 Java ライブラリ

クリッカブルマップを生成する Java のライブラリです。

# デモ

[この](test/HTMLFileTest_save.html) ようなクリッカブルマップを
Java で生成します。
 
# 特徴
 
・シンプルなコード
・機能追加、拡張、変更が容易
 
# 動作環境

* jdk15

# ライブラリ作成
 
```bash
./gradlew jar
```

以下のファイルができます。

build/libs/clickable_map.jar

# 使い方

以下のソースを見ていただければ分かるかと思います。

[HTMLFileTest.java](src/test/java/isota/test/HTMLFileTest.java)

テスト実行

```bash
./gradlew test
```


# メモ

- クラス図は [こちら](doc/001clickable_map.png)

- API ドキュメントが見たい場合
```bash
./gradlew javadoc
```

# 開発者
 
* isota
* 38205899+h-isota@users.noreply.github.com
 
# ライセンス

[MIT license](LICENSE).
