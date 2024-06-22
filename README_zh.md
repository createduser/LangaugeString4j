# LanguageString4j
**�@�����ʹ�ùȸ跭�g���^��ɫ**

[���w����](README_zh.md) [��������](README_zh_cn.md) [English](README.md)
## ����
<p>�@��һ�������ڶ��Z�Ԉ��������������ִ����Q���ĳ�ʽ�a��</p>
���������҂���Ҫ��������Z�ԣ�������Ҫ�@�N��

```java
String str = "hello";
String str_zh = "���";
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
���ϴ��a����߀δ�m��ͬ�Z�Բ�ͬ�؅^������Locale��ͬ�Ć��}�������@�����ӷ�[

������ʹ��LanguageString4j�ᣬֻ��Ҫ�@����
```java
LangStrings langStrings = new LangStrings("hello");
langStrings.set(new LangString(Lang._zh,"���"));
langStrings.set(new LangString(Lang._fr,"Bonjour"));

System.out.println(langStrings.get(new Lang(Locale.getDefault())));
```
## ������
### LangStrings
�ں���`LangStrings.get`�����r���ȇLԇȡ����ȫ�����Z�Ժ͵؅^���ִ�������o��ȡ�þ͕�ȥ�@��ԓ�Z�Ե��ִ�
�����߀�ǟo��ȡ�þ͕��؂�`LangStrings`�����������Mȥ��`rootStr`��

### Lang

�҂����]���˴���������`Lang`��ʹ�È���������H�Hֻ����ͨ��ÿ�΄����r���ڃȴ�����Ո���g����´������}��`Lang`
����Ȼ����ӛ���w��ɺܴ��ؓ���������҂��x������`String`һ�ӵ�̎����

��`Lang`�У���һ���o�B����`ArrayList`�ɆT����`baseLangs`���e������BaseLang���ڽ���`Lang`�r�����Ƚ���һ��BaseLang
��Ȼ��Lԇ��`baseLangs`�Ќ����Ƿ����@��`B??aseLang`�������
�����N`Lang`�е�`baseLangIndex`��ֵ�����ǂ��ɆT��`baseLangs`�e���ˡ�

Ҳ�����f�������}����һ���ѽ����ڵ�`Lang`��Ԓ�����H��ֻ�ǽ�����һ��ֻ����һ��`int`׃���������

**����Ո�鿴ԭʼ�a**

## ��μ������Č�����
**�汾̖�a���ܲ������µģ�Ո��Maven����}����**

**Groovy Gradle:**
```groovy
implementation 'io.github.createduser:LangaugeString4j:0.9.1'
```

**Kotlin Gradle:**
```kotlin
implementation("io.github.createduser:LangaugeString4j:0.9.1")
```
## �ļ�
�`docs`�Y�ϊA�к��п��ڞg�[���@ʾ����棬�Ժ��w������ʽ�ṩ�����ς��Ĺ�����Ҳ�Ѻ��к��w������ʽ���ęn

[���D���ęn](docs/index.html)
[���D��Maven����}�����](https://central.sonatype.com/artifact/io.github.createduser/LangaugeString4j/overview)
[���D�������](https://userrrrr.cn/)