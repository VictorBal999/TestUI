import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TestHtmlForm {

@DataProvider(parallel = true)


public static Object[][] data() {
    return new Object[][]{
            {"Виктор", "//input[@name='name']" },
            {"123@mail.ru", "//input[@name='email']"},
            {"123qwe", "//input[@name='password']"},
            {"123qwe", "//input[@name='password_retry']"},

    };
}

    @Test(dataProvider = "data")
    public void testMyHtml(String data1, String data2) throws InterruptedException {
        Selenide.open("file://C:\\Users\\Nikita\\IdeaProjects\\testUi\\src\\main\\resources\\index.html");

        $x(data2).sendKeys(data1);
        $(By.name("sex")).selectRadio("male");
        $("select").selectOption(1);
        $x("//*[@type='submit']").click();

        $("#head")
               .shouldBe(text(data1));
    }

    // TODO сделать тест параметризованным
   /* @Test
    public void testGoogle() {
        Selenide.open("http://google.com");
        $x("//input[@name='name']").sendKeys("10 * 10", Keys.ENTER);
        // TODO реализовать проверку результата в гугл

    }*/

}
