package io.github.userrrrr.langString.test;

import io.github.userrrrr.langString.LangString;
import io.github.userrrrr.langString.LangStrings;
import org.junit.jupiter.api.Test;

import io.github.userrrrr.langString.Lang;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class LangTest {

    @Test
    public void getLanguage(){
        Lang lang = Lang.CN_zh.getLanguage();
        assertEquals(lang.getRegionCode(),"");
        assertEquals(lang.getRegion(),Lang.root);
        assertEquals(lang.getLanguageCode(),Lang._zh.getLanguageCode());
    }
    @Test
    public void getLanguageCode(){
        Lang CN_zh = Lang.CN_zh;
        Lang _zh = Lang._zh;
        Lang RU_ru = new Lang("ru","RU");

        assertEquals("zh", _zh.getLanguageCode());
        assertEquals("zh", CN_zh.getLanguageCode());
        assertEquals("ru", RU_ru.getLanguageCode());
    }
    @Test
    public void getRegionCode(){
        Lang SG_en = new Lang("en","SG");
        Lang _ru = new Lang("ru");


        assertEquals("CN",Lang.CN_zh.getRegionCode());
        assertEquals("TW",Lang.TW_zh.getRegionCode());
        assertEquals(Lang._zh.getRegionCode(),"");
        assertEquals("SG",SG_en.getRegionCode());
        assertEquals(_ru.getRegionCode(),"");


        LangStrings langStrings = new LangStrings("hello");
        langStrings.set(new LangString(Lang._zh,"ÄãºÃ"));
        langStrings.set(new LangString(Lang._fr,"Bonjour"));

        System.out.println(langStrings.get(new Lang(Locale.getDefault())));
    }
    @Test
    public void getCode(){
        Lang CN_zh = Lang.CN_zh;
        Lang _zh = Lang._zh;
        Lang RU_ru = new Lang("ru","RU");

        assertEquals("zh", _zh.getCode());
        assertEquals("ru_RU", RU_ru.getCode());
        assertEquals("zh_CN", CN_zh.getCode());
    }
    @Test
    public void isRegion(){
        assertFalse(Lang._zh.isRegion());
        assertTrue(Lang.CN_zh.isRegion());
    }
}
