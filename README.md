# narou4j
小説家になろうAPIのJavaラッパーライブラリです。  
本家様はこちら [http://dev.syosetu.com/man/api/](http://dev.syosetu.com/man/api/)

「小説家になろう」は株式会社ヒナプロジェクトの登録商標です．
また，本プログラムは株式会社ヒナプロジェクトが提供するものではありません．

# Download
[Download Jar](http://search.maven.org/remotecontent?filepath=net/nashihara/narou4j/1.2.4/narou4j-1.2.4.jar)

or Gradle  
```gradle
compile 'net.nashihara:narou6j:1.2.4'
```

or Maven  
```xml
<dependency>
    <groupId>net.nashihara</groupId>
    <artifactId>narou4j</artifactId>
    <version>1.2.4</version>
</dependency>
```

# Dependencies
* [Okhttp 3.2.0](https://github.com/square/okhttp)
* [Jackson 2.7.0](https://github.com/FasterXML/jackson)
* [jsoup 1.9.1](https://jsoup.org/)

# Usage
## 小説20件を新着順で取得  
```Java
Narou narou = new Narou();
List<Novel> novels = narou.getNovels();
```

## 総合評価の高い順で小説を300件取得
```java
Narou narou = new Narou();
narou.setOrder(OutputOrder.TOTAL_POINT);
narou.setLim(300);
List<Novel> novels = narou.getNovels();
```

## Nコードを指定して小説を取得
```java
Novel novel = narou.getNovel("ncode");
```

## 取得小説数を指定
```java
narou.setLim(300);
```

## 出力項目を指定

```java
// 小説名、作者名、あらすじのみ取得する場合。
narou.set(new OfParam[]{OfParam.TITLE, OfParam.WRITE, OfParam.STORY});
```

## 単語検索
```java
// 「なろう」という単語で検索
narou.setSearchWord("なろう");

// 「なろう」という単語が含まれていないものを検索
narou.setNotWord("なろう");
```

また、検索対象をタイトル、あらすじ、タグ、作者名の4つの中から選択が可能です。
なにも指定しない場合は全てから検索します。
例えば、作者名を指定して検索したい場合は以下のような感じになります。

```java
narou.setSearchWord("なろう");
narou.setSearchTarget(SearchWordTarget.WRITER);
```

## ジャンル指定
```java
// ファンタジーを取得
narou.setGenre(NovelGenre.FANTASY);

// ファンタジーとSFを取得
narou.setGenre(new NovelGenre[]{NovelGenre.FANTASY, NovelGenre.SF});
```

## ランキングを取得
```Java
Ranking ranking = new Ranking();

List<NovelRank> ranks = ranking.getRanking(RankingType.DAILY);
// 週間ランキングを取得
List<NovelRank> ranks = ranking.getRanking(RankingType.WEEKLY);
// 月間ランキングを取得
List<NovelRank> ranks = ranking.getRanking(RankingType.MONTHLY);
// 四半期ランキングを取得
List<NovelRank> ranks = ranking.getRanking(RankingType.QUARTET);
```

累計ランキングはNarouオブジェクトで総合評価順に指定すると累計ランキングの順番になります．

## ランクイン情報を取得
```java
Ranking ranking = new Ranking();

// 指定された小説コードの過去のランクイン情報を取得
ranking.getRankinDetail(String ncode);
```

## 小説の目次、本文を取得
```java
Narou narou = new Narou();

// 小説の目次を取得
narou.getNovelTable(String ncode);

// 指定したページの本文を取得
narou.getNovelBody(String ncode, int page);

// 小説の目次と本文を取得（順番は目次順）
narou.getNovelBodyAll(String ncode);

// 小説の情報、目次、本文の全てを取得
narou.getNovelAll(String ncode);

// 指定した条件に当てはまる小説の情報、目次、本文の全てを取得（前回記事参照）
narou.getNovelsAll();
```

# License
```
Copyright 2016 Naoya Shibahara

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
