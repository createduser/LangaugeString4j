package io.github.userrrrr.langString;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/**
 * 这是用于存储BaseLang的索引和操作BaseLine的类
 */
public class Lang {

    /**
     * 此Lang对应的BaseLang的索引
     */
    private final int baseLangIndex;
    /**
     * 全局BaseLang列表
     */
    public static final ArrayList<BaseLang> baseLangs = new ArrayList<>();
    /**
     * 全球范围内英语的Lang定义
     */
    public static final Lang _en = new Lang(Locale.ENGLISH);
    /**
     * 全球范围内法语的Lang定义
     */
    public static final Lang _fr = new Lang(Locale.FRENCH);
    /**
     * 全球范围内德语的Lang定义
     */
    public static final Lang _de = new Lang(Locale.GERMAN);
    /**
     * 全球范围内意大利语的Lang定义
     */
    public static final Lang _it = new Lang(Locale.ITALIAN);
    /**
     * 全球范围内日语的Lang定义
     */
    public static final Lang _ja = new Lang(Locale.JAPANESE);
    /**
     * 全球范围内韩语的Lang定义
     */
    public static final Lang _ko = new Lang(Locale.KOREAN);
    /**
     * 全球范围内中文的Lang定义
     */
    public static final Lang _zh = new Lang(Locale.CHINESE);
    /**
     * 中国内地范围中文内的Lang定义
     */
    public static final Lang CN_zh = new Lang(Locale.CHINA);
    /**
     * 中国台湾省范围内中文的Lang定义
     */
    public static final Lang TW_zh = new Lang(Locale.TAIWAN);
    /**
     * 中国香港特别行政区范围内中文的Lang定义
     */
    public static final Lang HKSAR_zh = new Lang("zh","HK");
    /**
     * 中国澳门特别行政区范围内中文的Lang定义
     */
    public static final Lang MOSAR_zh = new Lang("zh","MO");
    /**
     * 新加坡范围内中文的Lang定义
     */
    public static final Lang SG_zh = new Lang("zh","SG");
    /**
     * 法国范围内法语的Lang定义
     */
    public static final Lang FR_fr = new Lang("fr", "FR");
    /**
     * 德语范围内德语的Lang定义
     */
    public static final Lang DE_de = new Lang("de", "DE");
    /**
     * 意大利范围内意大利语的Lang定义
     */
    public static final Lang IT_it = new Lang("it", "IT");

    /**
     * 日本范围内日语的Lang定义
     */
    public static final Lang JP_ja = new Lang("ja", "JP");

    /**
     * 韩国范围内韩语的Lang定义
     */
    public static final Lang KR_ko = new Lang("ko", "KR");
    /**
     * 英国范围内英文的Lang定义
     */
    public static final Lang GB_en = new Lang("en", "GB");
    /**
     * 美国范围内英文的Lang定义
     */
    public static final Lang US_en = new Lang("en", "US");
    /**
     * 加拿大范围内英文的Lang定义
     */
    public static final Lang CA_en = new Lang("en", "CA");
    /**
     * 加拿大范围内法语的Lang定义
     */
    public static final Lang CA_fr = new Lang("fr", "CA");
    /**
     * 全球范围内所有语言的Lang定义，即Lang的默认值
     */
    public static final Lang root = new Lang("", "");

    /**
     * 获得此Lang在baseLangs（全局BaseLang列表）的索引
     * @return 此Lang在baseLangs（全局BaseLang列表）的索引
     */
    public int getBaseLangIndex() {
        return baseLangIndex;
    }

    /**
     * 通过字符串进行定义
     * @param lang 语言
     * @param region 适用的地区
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
     * 通过字符串进行定义，适用于全球地区
     * @param lang 语言
     */
    public Lang(String lang) {
        this(lang,"");
    }

    /**
     * 通过Locale中的语言和地区定义，一般不建议使用
     * @param locale 语言环境
     */
    @Deprecated
    public Lang(Locale locale) {
        this(locale.getLanguage(), locale.getCountry());
    }

    /**
     * 真正存储语言和地区信息的类
     */
    static class BaseLang{
        /**
        * 通过字符串进行定义
        * @param lang 语言
        * @param region 适用的地区
        */
        public BaseLang(final String lang, final String region){

            this.lang = lang;
            this.region = region;
        }

        /**
         * 通过字符串进行定义，适用于全球地区
         * @param lang 语言
         */
        public BaseLang(final String lang){

            this.lang = lang;
            this.region = null;
        }

        /**
         * 语言代码字符串
         */
        final String lang;
        /**
         * 地区代码字符串
         */
        String region;

        /**
         * 获得语言代码
         * @return 语言代码
         */
        public String getLanguageCode() {
            return lang;
        }

        /**
         * 获得地区代码
         * @return 地区代码
         */
        public String getRegionCode() {
            return region;
        }

        /**
         * 获得完整的语言和地区代码
         * @return 语言和地区代码
         */
        public String getCode(){
            if (region == null || region.equals(""))
                return lang;
            return region + "_" + lang;
        }

        /**
         * 检测此BaseLang的语言翻译是否适用于全球范围
         * @return 是否适用于全球范围
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
     * 获得此语言代码对应的Lang
     * @return 语言代码对应的Lang
     */
    public Lang getLanguage() {
        return new Lang(this.getLanguageCode());
    }

    /**
     * 获得此地区代码对应的Lang，说实话感觉没用
     * @return 地区代码对应的Lang
     */
    public Lang getRegion() {
        String regionCode = this.getRegionCode();
        if (this.getRegionCode() == null || regionCode.equals(""))
            return Lang.root;
        return new Lang("",this.getRegionCode());
    }

    /**
     * 获得语言代码
     * @return 语言代码
     */
    public String getLanguageCode() {
        return Lang.baseLangs.get(this.baseLangIndex).getLanguageCode();
    }
    /**
     * 获得地区代码
     * @return 地区代码
     */
    public String getRegionCode() {
        return Lang.baseLangs.get(this.baseLangIndex).getRegionCode();
    }
    /**
     * 获得完整的语言和地区代码
     * @return 语言和地区代码
     */
    public String getCode(){
        return Lang.baseLangs.get(this.baseLangIndex).getCode();
    }
    /**
     * 检测此BaseLang的语言翻译是否适用于全球范围
     * @return 是否适用于全球范围
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
