package com.pieceofquality;

import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

/**
 * Created by piece on 21.06.2016.
 */
public class GoogleSearchTest {

    @Test
    public void googleSearch(){

        open("http://google.com/ncr");

        $(By.name("q")).setValue("Selenium automates browsers").pressEnter();
        googleSearchResults.shouldHaveSize(10);
        googleSearchResults.get(0).shouldHave(text("Selenium automates browsers")).$(".r>a").click();
        $("#header>h1>a").shouldHave(exactText("Browser Automation"));
        assertEquals("http://www.seleniumhq.org/", url());
    }

    ElementsCollection googleSearchResults = $$(".srg>.g");

}
