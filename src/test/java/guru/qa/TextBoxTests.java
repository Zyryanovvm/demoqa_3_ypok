package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    public static void settings() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1800x1200";
    }

    @Test
    void fillFormTest() {
        String name = "Vladimir";
        open("/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue("Zyryanov");
        $("#userEmail").setValue("Zyryanovvm@rambler.ru");
        $(byText("Female")).click();
        $("#userNumber").setValue("89821459787");
        $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("January");
            $(".react-datepicker__year-select").selectOption("1995");
                    $(byText("15")).click();
        $("#subjectsInput").setValue("E").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("Lenina street 11");
        $("#state").click();
            $(byText("NCR")).click();
        $("#city").click();
            $(byText("Delhi")).click();
        $("[id=submit]").click();

        $(".table-responsive").shouldHave(text("Student Name	" + name + " Zyryanov"), text("Mobile 8982145978"),
                text("Picture	1.PNG"), text("Student Email Zyryanovvm@rambler.ru"), text("Gender Female"),
                text("Date of Birth 15 January,1995"), text("Subjects English"), text("Hobbies Music"),
                text("Address Lenina street 11"), text("State and City NCR Delhi"));
        $("#closeLargeModal").click();
    }
    }