import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class googleSearchTest {
    @Test
    public void shouldSearch() {
        open("https://google.com/ncr");

        element(byName("q")).setValue("selenide").pressEnter();

        ElementsCollection result = elements("#search .g");
        result.shouldHave(sizeGreaterThanOrEqual(6));
        result.first().shouldHave(text("Selenide: concise UI tests in Java"));

        SelenideElement firstLink = $x("//div[@id='search']//a[@href]");
        firstLink.click();

        Wait().until(titleIs("Selenide: concise UI tests in Java"));

//        element(byName("q")).setValue("selenide").pressEnter();
//        elements("#search .g").shouldHave(sizeGreaterThanOrEqual(6))
//                .first().shouldHave(text("Selenide: concise UI tests in Java"))
//                .find(".r>a").click();
//
//        Wait().until(titleIs("Selenide: concise UI tests in Java"));

    }
}
