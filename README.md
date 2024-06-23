# LanguageString4j
**This page uses Google Translate.**

[繁體中文](README_zh.md) [简体中文](README_zh_cn.md) [English](README.md)
## Introduction
<p>This is a code library created to make it easier to operate strings in multi-language scenarios</p>
In the past, we needed to store multiple languages, and we may need to do this

```java
String str = "hello";
String str_zh = "Hello";
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
The above code has not even adapted to the problem of returning different Locales in different regions of the same language, and it will appear so bloated.

But when you use LanguageString4j, just do this
```java
LangStrings langStrings = new LangStrings("hello");
langStrings.set(new LangString(Lang._zh,"你好"));
langStrings.set(new LangString(Lang._fr,"Bonjour"));

System.out.println(langStrings.get(new Lang(Locale.getDefault())));
```
You can even initialize `LangStrings` directly from the resource bundle. However, this method will only get the languages ​​supported by the system, that is, the Locale returned by `Locale.getAvailableLocales()`.
```java
LangStrings langStrings = new LangStrings("resource bundle name", "key");
System.out.println(langStrings.get(new Lang(Locale.getDefault())));
```
## Robustness
### LangStrings
When calling the `LangStrings.get` method, it will first try to obtain a string that exactly matches the language and region. If it cannot be obtained, it will obtain a string in that language.
, if it still cannot be obtained, it will return the `rootStr` passed in the `LangStrings` constructor.

### Lang

We considered the usage scenario of creating `Lang` in large quantities. If it is just to apply for space in the memory every time it is created to put down a large number of repeated `Lang`
, which will inevitably cause a huge burden on the memory. So we choose to use the same processing method as `String`

In `Lang`, there is a static constant `ArrayList` member called `baseLangs`. BaseLang is stored inside. When creating `Lang`, a BaseLang will first be created
, and then try to find whether there is this `BaseLang` in `baseLangs`. If there is
, then the value of `baseLangIndex` in `Lang` is the subscript of that member in `baseLangs`.

That is to say, when you repeatedly create an existing `Lang`, you actually only create an object containing only one `int` variable.

**Please view the source code for more**

## How to add it to your project
**The version number may not be the latest, please refer to the Maven central repository**

**Groovy Gradle:**
```groovy
implementation 'io.github.createduser:LangaugeString4j:0.9.3'
```

**Kotlin Gradle:**
```kotlin
implementation("io.github.createduser:LangaugeString4j:0.9.3")
```
## document
The `docs` folder contains pages that can be displayed in the browser and are provided in Simplified Chinese. Documents in Simplified Chinese are also included in the uploaded artifacts.

[Jump to documentation](docs/index.html)
[Jump to Maven central repository page](https://central.sonatype.com/artifact/io.github.createduser/LangaugeString4j/overview)
[Jump to blog](https://userrrrr.cn/)