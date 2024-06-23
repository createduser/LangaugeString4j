package io.github.createduser.langString;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class LangStrings {
    /**
     * LangString的列表
     */
    ArrayList<LangString> strings = new ArrayList<>();

    /**
     * 只定义默认字符串的构造函数
     * @param rootString 默认字符串，当匹配不到适合的语言时会返回这个值
     */
    public LangStrings(String rootString){
        LangString root = new LangString(Lang.root);
        root.setString(rootString);
        this.strings.add(root);
    }

    /**
     * 通过资源包进行获得各语言的字符串，仅会获得其中系统中已支持的语言
     * @param baseName 资源包路径及名字
     * @param key 键
     */
    public LangStrings(String baseName,String key){
        HashSet<Lang> langsInSystem = new HashSet<>();//在系统里支持的所有语言
        HashSet<Lang> langsInResource = new HashSet<>();//在资源包内包含的语言
        HashMap<Lang,URL> resourceURLs = new HashMap<>();//资源URL

        resourceURLs.put(Lang.root,ClassLoader.getSystemResource(baseName + ".properties"));
        langsInResource.add(Lang.root);

        for (Locale locale : Locale.getAvailableLocales()){
            langsInSystem.add(new Lang(locale));
        }

        for (Lang lang : langsInSystem){
            URL resourceURL = ClassLoader.getSystemResource(baseName + "_" + lang.getCode() + ".properties");
            if (resourceURL != null) {
                resourceURLs.put(lang,resourceURL);
                langsInResource.add(lang);
            }
        }

        for (Lang lang : langsInResource){
            Properties properties = new Properties();
            try {
                properties.load(new InputStreamReader(resourceURLs.get(lang).openStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            this.set(new LangString(lang, (String) properties.get(key)));
        }
    }

    /**
     * 拷贝构造函数，会拷贝形参的所有LangString
     * @param langStrings 被拷贝的LangStrings
     */
    public LangStrings(@org.jetbrains.annotations.NotNull LangStrings langStrings){
        this.strings = new ArrayList<>(langStrings.getAll());
    }

    /**
     * 获得Lang对应的LangString在列表中的索引
     * @param lang 语言
     * @return 对应在列表中的索引
     */
    private int getIndex(Lang lang){
        for (LangString langString : this.getAll()){
             Lang lang1 = langString.getLang();
            if(lang1.equals(lang)) {
                return this.getAll().indexOf(langString);
            }
        }
        return -1;
    }

    /**
     * 获得Lang对应的字符串，会先尝试获取该地区下该语言的字符串，如果获取不到就会获取该语言在全球范围内的字符串，还是获取不到就会返回默认值
     * @param lang 语言
     * @return 对应的字符串
     */
    public String get(Lang lang){
        int index = this.getIndex(lang);
        if (index > -1)
            return this.getAll().get(index).getString();

        index = this.getIndex(lang.getLanguage());
        if (index > -1)
            return this.getAll().get(index).getString();

        index = this.getIndex(Lang.root);
        return this.getAll().get(index).getString();
    }

    /**
     * @return 所有LangString列表
     */
    public ArrayList<LangString> getAll() {
        return strings;
    }

    /**
     * 设置LangString，会先尝试寻找在列表中已经包含的LangString然后进行设置，否则直接添加
     */
    public void set(@NotNull LangString langString){
        int index = this.getIndex(langString.getLang());
        if(index == -1) {
            this.strings.add(langString);
            return;
        }
        this.strings.set(index,langString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LangStrings)) return false;
        LangStrings that = (LangStrings) o;
        return Objects.equals(strings, that.strings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strings);
    }
}
