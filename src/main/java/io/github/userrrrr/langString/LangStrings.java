package io.github.userrrrr.langString;

import java.util.ArrayList;
import java.util.Objects;

public class LangStrings {
    /**
     * LangString���б�
     */
    ArrayList<LangString> strings = new ArrayList<>();

    /**
     * ֻ����Ĭ���ַ����Ĺ��캯��
     * @param rootString Ĭ���ַ�������ƥ�䲻���ʺϵ�����ʱ�᷵�����ֵ
     */
    public LangStrings(String rootString){
        LangString root = new LangString(Lang.root);
        root.setString(rootString);
        this.strings.add(root);
    }

    /**
     * �������캯�����´���βε�����LangString
     * @param langStrings ��������LangStrings
     */
    public LangStrings(LangStrings langStrings){
        this.strings = new ArrayList<>(langStrings.getAll());
    }

    /**
     * ���Lang��Ӧ��LangString���б��е�����
     * @param lang ����
     * @return ��Ӧ���б��е�����
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
     * ���Lang��Ӧ���ַ��������ȳ��Ի�ȡ�õ����¸����Ե��ַ����������ȡ�����ͻ��ȡ��������ȫ��Χ�ڵ��ַ��������ǻ�ȡ�����ͻ᷵��Ĭ��ֵ
     * @param lang ����
     * @return ��Ӧ���ַ���
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
     * @return ����LangString�б�
     */
    public ArrayList<LangString> getAll() {
        return strings;
    }

    /**
     * ����LangString�����ȳ���Ѱ�����б����Ѿ�������LangStringȻ��������ã�����ֱ�����
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
