package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import guru.qa.utils.RandomUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationFormTest {
    String fname = RandomUtils.getRandomStringName(),
            lname = RandomUtils.getRandomStringName(),
            email = RandomUtils.getRandomEmail(),
            fullName = format("%s %s", fname, lname),
            phoneNumber = RandomUtils.getRandomPhoneNumbers();

    @BeforeAll
    public static void settings() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1800x1200";
    }

    @Test
    void fillFormTest() {


        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        Selenide.zoom(0.75);
        $("#firstName").setValue(fname);
        $("#lastName").setValue(lname);
        $("#userEmail").setValue(email);
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--015:not(react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("Lenina street 11");
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        // Проверки корректности внесённых данных
        $(".table-responsive").shouldHave(text("Student Name	" + fullName),
                text("Mobile " + phoneNumber), text("Picture	1.PNG"), text("Student Email " + email),
                text("Gender Female"), text("Date of Birth 15 January,1995"), text("Subjects English"),
                text("Hobbies Music"), text("Address Lenina street 11"), text("State and City Haryana Panipat"));



        $("#closeLargeModal").click();
    }
}
