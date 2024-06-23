# LanguageString4j
[繁體中文](README_zh.md) [简体中文](README_zh_cn.md) [English](README.md)
## 简介
<p>这是一个为了在多语言场景下为更方便操作字符串所诞生的代码库</p>
在以往，我们需要存储多个语言，可能需要这么做

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
以上代码甚至还未适配同语言不同地区所返回Locale不同的问题，都会显得如此臃肿

但当您使用LanguageString4j后，只需要这样做
```java
LangStrings langStrings = new LangStrings("hello");
langStrings.set(new LangString(Lang._zh,"你好"));
langStrings.set(new LangString(Lang._fr,"Bonjour"));

System.out.println(langStrings.get(new Lang(Locale.getDefault())));
```

您甚至可以直接通过资源包来初始化`LangStrings`。但是这种方式只会获得系统支持的语言，也就是
`Locale.getAvailableLocales()`所返回的Locale。
```java
LangStrings langStrings = new LangStrings("资源包名称","键");
System.out.println(langStrings.get(new Lang(Locale.getDefault())));
```
## 健壮性
### LangStrings
在调用`LangStrings.get`方法时会先尝试获得完全匹配语言和地区的字符串，如果无法获得就会去获得该语言的字符串
，如果还是无法获得就会返回`LangStrings`构造函数所传进去的`rootStr`。

### Lang

我们考虑到了大批量创建`Lang`的使用场景。如果仅仅只是普通地每次创建时都在内存中申请空间来放下大量重复的`Lang`
，必然会给内存造成很大的负担。所以我们选择用像`String`一样的处理方法

在`Lang`中，有一个静态常量`ArrayList`成员叫做`baseLangs`。里面存放着BaseLang。在创建`Lang`时，会首先创建一个BaseLang
，然后尝试着在`baseLangs`中查找是否有这个`BaseLang`。如果有
，那么`Lang`中的`baseLangIndex`的值就是那个成员在`baseLangs`里的下标。

也就是说当您重复创建一个已经存在的`Lang`的话，实际上只是创建了一个只含有一个`int`变量的对象。

**更多请查看源代码**

## 如何加入到您的项目中
**版本号可能不是最新的，请以Maven中央仓库为准**

**Groovy Gradle:**
```groovy
implementation 'io.github.createduser:LangaugeString4j:0.9.3'
```

**Kotlin Gradle:**
```kotlin
implementation("io.github.createduser:LangaugeString4j:0.9.3")
```
## 文档
于`docs`文件夹中含有可在浏览器显示的页面，以简体中文形式提供。在上传的工件中也已含有简体中文形式的文档

[跳转至文档](docs/index.html)
[跳转至Maven中央仓库页面](https://central.sonatype.com/artifact/io.github.createduser/LangaugeString4j/overview)
[跳转至博客](https://userrrrr.cn/)