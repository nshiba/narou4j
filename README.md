# narou4j
小説家になろうAPIのJavaラッパーライブラリです。  
本家様はこちら [http://dev.syosetu.com/man/api/](http://dev.syosetu.com/man/api/)

「小説家になろう」は株式会社ヒナプロジェクトの登録商標です．
また，本プログラムは株式会社ヒナプロジェクトが提供するものではありません．

# Download
[Download Jar](http://search.maven.org/remotecontent?filepath=net/nashihara/narou4j/1.2.0/narou4j-1.2.0.jar)

or Gradle  
```gradle
compile 'net.nashihara:narou4j:1.2.0'
```

or Maven  
```xml
<dependency>
    <groupId>net.nashihara</groupId>
    <artifactId>narou4j</artifactId>
    <version>1.2.0</version>
</dependency>
```

# Dependencies
* [Okhttp 3.2.0](https://github.com/square/okhttp)
* [Jackson 2.7.0](https://github.com/FasterXML/jackson)

# License
```
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

# Usage
## 小説20件を新着順で取得  
```Java
Narou narou = new Narou();
List<Novel> novels = narou.getNovels();
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
