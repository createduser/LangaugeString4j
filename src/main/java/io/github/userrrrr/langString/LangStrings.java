package io.github.userrrrr.langString;

import java.util.ArrayList;
import java.util.Objects;

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
     * 拷贝构造函数，会拷贝形参的所有LangString
     * @param langStrings 被拷贝的LangStrings
     */
    public LangStrings(LangStrings langStrings){
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
    public void set(LangString langString){
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
