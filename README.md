# narou4j
小説家になろうAPIのJavaラッパーライブラリです。  
本家はこちら [http://dev.syosetu.com/man/api/](http://dev.syosetu.com/man/api/)

# Download
[Download Jar](http://search.maven.org/remotecontent?filepath=net/nashihara/narou4j/1.0/narou4j-1.0.jar)

or Gradle  
```
compile 'net.nashihara:narou4j:1.0'
```

or Maven  
```
<dependency>
    <groupId>net.nashihara</groupId>
    <artifactId>narou4j</artifactId>
    <version>1.0</version>
</dependency>
```

# Dependencies
* [Okhttp](https://github.com/square/okhttp)
* [Jackson](https://github.com/FasterXML/jackson)

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
小説20件を新着順で取得  
```Java
Narou narou = new Narou();
List<Novel> novels = narou.getNovels();
```
