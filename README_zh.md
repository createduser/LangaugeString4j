# LanguageString4j
**這個頁面使用谷歌翻譯后經過潤色**

[繁體中文](README_zh.md) [简体中文](README_zh_cn.md) [English](README.md)
## 簡介
<p>這是一個為了在多語言場景下為更方便操作字串所誕生的程式碼庫</p>
在以往，我們需要儲存多個語言，可能需要這麼做

```java
String str = "hello";
String str_zh = "你好";
String str_fr = "Bonjour";

if (Locale.getDefault().equals(Locale.ENGLISH)){
 System.out.println(str);
}
if (Locale.getDefault().equals(Locale.CHINESE)){
 System.out.println(str_zh);
}
if (Locale.getDefault().equals(Locale.FRENCH)){
 System.out.println(str_fr);
}
```
以上代碼甚至還未適配同語言不同地區所返回Locale不同的問題，都會顯得如此臃腫

但當您使用LanguageString4j後，只需要這樣做
```java
LangStrings langStrings = new LangStrings("hello");
langStrings.set(new LangString(Lang._zh,"你好"));
langStrings.set(new LangString(Lang._fr,"Bonjour"));

System.out.println(langStrings.get(new Lang(Locale.getDefault())));
```
## 健壯性
### LangStrings
在呼叫`LangStrings.get`方法時會先嘗試取得完全符合語言和地區的字串，如果無法取得就會去獲得該語言的字串
，如果還是無法取得就會回傳`LangStrings`建構子所傳進去的`rootStr`。

### Lang

我們考慮到了大批量創建`Lang`的使用場景。如果僅僅只是普通地每次創建時都在內存中申請空間來放下大量重複的`Lang`
，必然會對記憶體造成很大的負擔。所以我們選擇用像`String`一樣的處理方法

在`Lang`中，有一個靜態常數`ArrayList`成員叫做`baseLangs`。裡面存放著BaseLang。在建立`Lang`時，會先建立一個BaseLang
，然後嘗試在`baseLangs`中尋找是否有這個`B??aseLang`。如果有
，那麼`Lang`中的`baseLangIndex`的值就是那個成員在`baseLangs`裡的下標。

也就是說當您重複建立一個已經存在的`Lang`的話，實際上只是建立了一個只含有一個`int`變數的物件。

**更多請查看原始碼**

## 如何加入您的專案中
**版本號碼可能不是最新的，請以Maven中央倉庫為準**

**Groovy Gradle:**
```groovy
implementation 'io.github.createduser:LangaugeString4j:0.9.1'
```

**Kotlin Gradle:**
```kotlin
implementation("io.github.createduser:LangaugeString4j:0.9.1")
```
## 文件
於`docs`資料夾中含有可在瀏覽器顯示的頁面，以簡體中文形式提供。在上傳的工件中也已含有簡體中文形式的文檔

[跳轉至文檔](docs/index.html)
[跳轉至Maven中央倉庫頁面](https://central.sonatype.com/artifact/io.github.createduser/LangaugeString4j/overview)
[跳轉至部落格](https://userrrrr.cn/)