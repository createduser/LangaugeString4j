package io.github.userrrrr.langString;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/**
 * �������ڴ洢BaseLang�������Ͳ���BaseLine����
 */
public class Lang {

    /**
     * ��Lang��Ӧ��BaseLang������
     */
    private final int baseLangIndex;
    /**
     * ȫ��BaseLang�б�
     */
    public static final ArrayList<BaseLang> baseLangs = new ArrayList<>();
    /**
     * ȫ��Χ��Ӣ���Lang����
     */
    public static final Lang _en = new Lang(Locale.ENGLISH);
    /**
     * ȫ��Χ�ڷ����Lang����
     */
    public static final Lang _fr = new Lang(Locale.FRENCH);
    /**
     * ȫ��Χ�ڵ����Lang����
     */
    public static final Lang _de = new Lang(Locale.GERMAN);
    /**
     * ȫ��Χ����������Lang����
     */
    public static final Lang _it = new Lang(Locale.ITALIAN);
    /**
     * ȫ��Χ�������Lang����
     */
    public static final Lang _ja = new Lang(Locale.JAPANESE);
    /**
     * ȫ��Χ�ں����Lang����
     */
    public static final Lang _ko = new Lang(Locale.KOREAN);
    /**
     * ȫ��Χ�����ĵ�Lang����
     */
    public static final Lang _zh = new Lang(Locale.CHINESE);
    /**
     * �й��ڵط�Χ�����ڵ�Lang����
     */
    public static final Lang CN_zh = new Lang(Locale.CHINA);
    /**
     * �й�̨��ʡ��Χ�����ĵ�Lang����
     */
    public static final Lang TW_zh = new Lang(Locale.TAIWAN);
    /**
     * �й�����ر���������Χ�����ĵ�Lang����
     */
    public static final Lang HKSAR_zh = new Lang("zh","HK");
    /**
     * �й������ر���������Χ�����ĵ�Lang����
     */
    public static final Lang MOSAR_zh = new Lang("zh","MO");
    /**
     * �¼��·�Χ�����ĵ�Lang����
     */
    public static final Lang SG_zh = new Lang("zh","SG");
    /**
     * ������Χ�ڷ����Lang����
     */
    public static final Lang FR_fr = new Lang("fr", "FR");
    /**
     * ���ﷶΧ�ڵ����Lang����
     */
    public static final Lang DE_de = new Lang("de", "DE");
    /**
     * �������Χ����������Lang����
     */
    public static final Lang IT_it = new Lang("it", "IT");

    /**
     * �ձ���Χ�������Lang����
     */
    public static final Lang JP_ja = new Lang("ja", "JP");

    /**
     * ������Χ�ں����Lang����
     */
    public static final Lang KR_ko = new Lang("ko", "KR");
    /**
     * Ӣ����Χ��Ӣ�ĵ�Lang����
     */
    public static final Lang GB_en = new Lang("en", "GB");
    /**
     * ������Χ��Ӣ�ĵ�Lang����
     */
    public static final Lang US_en = new Lang("en", "US");
    /**
     * ���ô�Χ��Ӣ�ĵ�Lang����
     */
    public static final Lang CA_en = new Lang("en", "CA");
    /**
     * ���ô�Χ�ڷ����Lang����
     */
    public static final Lang CA_fr = new Lang("fr", "CA");
    /**
     * ȫ��Χ���������Ե�Lang���壬��Lang��Ĭ��ֵ
     */
    public static final Lang root = new Lang("", "");

    /**
     * ��ô�Lang��baseLangs��ȫ��BaseLang�б�������
     * @return ��Lang��baseLangs��ȫ��BaseLang�б�������
     */
    public int getBaseLangIndex() {
        return baseLangIndex;
    }

    /**
     * ͨ���ַ������ж���
     * @param lang ����
     * @param region ���õĵ���
     */
    public Lang(String lang, String region) {
        BaseLang baseLang = new BaseLang(lang,region);
        int baseLangIndex = baseLangs.indexOf(baseLang);
        if (baseLangIndex != -1) {
            this.baseLangIndex = baseLangIndex;
            return;
        }
        Lang.baseLangs.add(baseLang);
        this.baseLangIndex = Lang.baseLangs.size() -1;
    }

    /**
     * ͨ���ַ������ж��壬������ȫ�����
     * @param lang ����
     */
    public Lang(String lang) {
        this(lang,"");
    }

    /**
     * ͨ��Locale�е����Ժ͵������壬һ�㲻����ʹ��
     * @param locale ���Ի���
     */
    @Deprecated
    public Lang(Locale locale) {
        this(locale.getLanguage(), locale.getCountry());
    }

    /**
     * �����洢���Ժ͵�����Ϣ����
     */
    static class BaseLang{
        /**
        * ͨ���ַ������ж���
        * @param lang ����
        * @param region ���õĵ���
        */
        public BaseLang(final String lang, final String region){

            this.lang = lang;
            this.region = region;
        }

        /**
         * ͨ���ַ������ж��壬������ȫ�����
         * @param lang ����
         */
        public BaseLang(final String lang){

            this.lang = lang;
            this.region = null;
        }

        /**
         * ���Դ����ַ���
         */
        final String lang;
        /**
         * ���������ַ���
         */
        String region;

        /**
         * ������Դ���
         * @return ���Դ���
         */
        public String getLanguageCode() {
            return lang;
        }

        /**
         * ��õ�������
         * @return ��������
         */
        public String getRegionCode() {
            return region;
        }

        /**
         * ������������Ժ͵�������
         * @return ���Ժ͵�������
         */
        public String getCode(){
            if (region == null || region.equals(""))
                return lang;
            return region + "_" + lang;
        }

        /**
         * ����BaseLang�����Է����Ƿ�������ȫ��Χ
         * @return �Ƿ�������ȫ��Χ
         */
        public boolean isRegion(){
            try {
                return region != null || region.equals("");
            }catch (NullPointerException e){
                return false;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BaseLang)) return false;
            BaseLang baseLang = (BaseLang) o;
            return Objects.equals(lang, baseLang.lang) && Objects.equals(region, baseLang.region);
        }

        @Override
        public int hashCode() {
            return Objects.hash(lang, isRegion());
        }
    }

    /**
     * ��ô����Դ����Ӧ��Lang
     * @return ���Դ����Ӧ��Lang
     */
    public Lang getLanguage() {
        return new Lang(this.getLanguageCode());
    }

    /**
     * ��ô˵��������Ӧ��Lang��˵ʵ���о�û��
     * @return ���������Ӧ��Lang
     */
    public Lang getRegion() {
        String regionCode = this.getRegionCode();
        if (this.getRegionCode() == null || regionCode.equals(""))
            return Lang.root;
        return new Lang("",this.getRegionCode());
    }

    /**
     * ������Դ���
     * @return ���Դ���
     */
    public String getLanguageCode() {
        return Lang.baseLangs.get(this.baseLangIndex).getLanguageCode();
    }
    /**
     * ��õ�������
     * @return ��������
     */
    public String getRegionCode() {
        return Lang.baseLangs.get(this.baseLangIndex).getRegionCode();
    }
    /**
     * ������������Ժ͵�������
     * @return ���Ժ͵�������
     */
    public String getCode(){
        return Lang.baseLangs.get(this.baseLangIndex).getCode();
    }
    /**
     * ����BaseLang�����Է����Ƿ�������ȫ��Χ
     * @return �Ƿ�������ȫ��Χ
     */
    public boolean isRegion(){
        String region = this.getRegionCode();

        try {
            return !(region == null || region.equals(""));
        }catch (NullPointerException e){
            return false;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lang)) return false;
        Lang lang = (Lang) o;
        return baseLangIndex == lang.baseLangIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseLangIndex);
    }
}
