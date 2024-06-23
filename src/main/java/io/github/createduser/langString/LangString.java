package io.github.createduser.langString;

import java.util.Objects;

public class LangString {
    Lang lang;
    String string;

    /**
     * ͨ��Lang���壬ʹ�ô˹��캯��ʱstring���ᱻ��ʼ��
     * @param lang ����
     */
    public LangString(Lang lang){
        this.lang = lang;
    }


    /**
     * ͨ��Lang��String���壬ʹ�ô˹��캯��ʱstring�ᱻ��ֵ
     * @param lang ����
     * @param string �ַ���ֵ
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
