package io.github.createduser.langString;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

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
     * ͨ����Դ�����л�ø����Ե��ַ���������������ϵͳ����֧�ֵ�����
     * @param baseName ��Դ��·��������
     * @param key ��
     */
    public LangStrings(String baseName,String key){
        HashSet<Lang> langsInSystem = new HashSet<>();//��ϵͳ��֧�ֵ���������
        HashSet<Lang> langsInResource = new HashSet<>();//����Դ���ڰ���������
        HashMap<Lang,URL> resourceURLs = new HashMap<>();//��ԴURL

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
     * �������캯�����´���βε�����LangString
     * @param langStrings ��������LangStrings
     */
    public LangStrings(@org.jetbrains.annotations.NotNull LangStrings langStrings){
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
