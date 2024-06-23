package io.github.userrrrr.langString.test;

import org.junit.jupiter.api.Test;
import io.github.userrrrr.langString.Lang;
import io.github.userrrrr.langString.LangString;
import io.github.userrrrr.langString.LangStrings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

public class LangStringsTest {
    public LangStrings getTestLangStrings(){
        LangStrings langStrings = new LangStrings("root");
        langStrings.set(new LangString(Lang.CN_zh,"CN_zh"));
        langStrings.set(new LangString(Lang._zh,"_zh"));

        return langStrings;
    }

    @Test
    public void get(){

        LangStrings langStrings = new LangStrings(this.getTestLangStrings());

        assertEquals("root",langStrings.get(Lang.root));
        assertEquals("root",langStrings.get(Lang.CA_en));
        assertEquals("CN_zh",langStrings.get(Lang.CN_zh));
        assertEquals("_zh",langStrings.get(Lang._zh));

        langStrings.set(new LangString(Lang._zh,"ÄãºÃ"));
        langStrings.set(new LangString(Lang._fr,"Bonjour"));
    }
    @Test
    public void getAll(){
        LangStrings langStrings = new LangStrings("root");
        langStrings.set(new LangString(Lang.CN_zh,"CN_zh"));
        langStrings.set(new LangString(Lang._zh,"_zh"));

        ArrayList<LangString> langStringsList = new ArrayList<>();
        langStringsList.add(new LangString(Lang.root,"root"));
        langStringsList.add(new LangString(Lang.CN_zh,"CN_zh"));
        langStringsList.add(new LangString(Lang._zh,"_zh"));

        assertEquals(langStringsList,langStrings.getAll());
    }
    @Test
    public void LangStrings() throws IOException {
        LangStrings langStrings = new LangStrings("testString","test");
        System.out.println(langStrings.get(new Lang(Locale.getDefault())));
    }
}
