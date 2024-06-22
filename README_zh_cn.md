# LanguageString4j
[���w����](README_zh.md) [��������](README_zh_cn.md) [English](README.md)
## ���
<p>����һ��Ϊ���ڶ����Գ�����Ϊ����������ַ����������Ĵ����</p>
��������������Ҫ�洢������ԣ�������Ҫ��ô��

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
���ϴ���������δ����ͬ���Բ�ͬ����������Locale��ͬ�����⣬�����Ե����ӷ��

������ʹ��LanguageString4j��ֻ��Ҫ������
```java
LangStrings langStrings = new LangStrings("hello");
langStrings.set(new LangString(Lang._zh,"���"));
langStrings.set(new LangString(Lang._fr,"Bonjour"));

System.out.println(langStrings.get(new Lang(Locale.getDefault())));
```
## ��׳��
### LangStrings
�ڵ���`LangStrings.get`����ʱ���ȳ��Ի����ȫƥ�����Ժ͵������ַ���������޷���þͻ�ȥ��ø����Ե��ַ���
����������޷���þͻ᷵��`LangStrings`���캯��������ȥ��`rootStr`��

### Lang

���ǿ��ǵ��˴���������`Lang`��ʹ�ó������������ֻ����ͨ��ÿ�δ���ʱ�����ڴ�������ռ������´����ظ���`Lang`
����Ȼ����ڴ���ɺܴ�ĸ�������������ѡ������`String`һ���Ĵ�����

��`Lang`�У���һ����̬����`ArrayList`��Ա����`baseLangs`����������BaseLang���ڴ���`Lang`ʱ�������ȴ���һ��BaseLang
��Ȼ��������`baseLangs`�в����Ƿ������`BaseLang`�������
����ô`Lang`�е�`baseLangIndex`��ֵ�����Ǹ���Ա��`baseLangs`����±ꡣ

Ҳ����˵�����ظ�����һ���Ѿ����ڵ�`Lang`�Ļ���ʵ����ֻ�Ǵ�����һ��ֻ����һ��`int`�����Ķ���

**������鿴Դ����**

## ��μ��뵽������Ŀ��
**�汾�ſ��ܲ������µģ�����Maven����ֿ�Ϊ׼**

**Groovy Gradle:**
```groovy
implementation 'io.github.createduser:LangaugeString4j:0.9.1'
```

**Kotlin Gradle:**
```kotlin
implementation("io.github.createduser:LangaugeString4j:0.9.1")
```
## �ĵ�
��`docs`�ļ����к��п����������ʾ��ҳ�棬�Լ���������ʽ�ṩ�����ϴ��Ĺ�����Ҳ�Ѻ��м���������ʽ���ĵ�

[��ת���ĵ�](docs/index.html)
[��ת��Maven����ֿ�ҳ��](https://central.sonatype.com/artifact/io.github.createduser/LangaugeString4j/overview)
[��ת������](https://userrrrr.cn/)