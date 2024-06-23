package io.github.createduser.langString;

import java.util.Objects;

public class LangString {
    Lang lang;
    String string;

    /**
     * 通过Lang定义，使用此构造函数时string不会被初始化
     * @param lang 语言
     */
    public LangString(Lang lang){
        this.lang = lang;
    }


    /**
     * 通过Lang和String定义，使用此构造函数时string会被赋值
     * @param lang 语言
     * @param string 字符串值
     */
    public LangString(Lang lang,String string){
        this(lang);
        this.string = string;
    }

    public Lang getLang() {
        return lang;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LangString)) return false;
        LangString that = (LangString) o;
        return Objects.equals(getLang(), that.getLang()) && Objects.equals(getString(), that.getString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLang(), getString());
    }

    @Override
    public String toString() {
        return this.getString();
    }
}
