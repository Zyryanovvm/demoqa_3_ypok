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
        String name = "Vladimir";                                        // Задаю переменную name
        open("/automation-practice-form");               // Перехожу по ссылку
        $("#firstName").setValue(name);                         // Ввожу значени переменной Name
        $("#lastName").setValue("Zyryanov");                    // Ввожу данные
        $("#userEmail").setValue("Zyryanovvm@rambler.ru");      // Ввожу данные
        $(byText("Female")).click();                           // Нахожу слово Female и кликаю по нему (Не совсем правильно так делать!)
        $("#userNumber").setValue("89821459787");               // Ввожу данные
        $("#dateOfBirthInput").click();                         // вызываю календарь
            $(".react-datepicker__month-select").selectOption("January");                  // В пиклисте выбираю Месяц
            $(".react-datepicker__year-select").selectOption("1995");                      // В пиклисте выбираю год
                    $(byText("15")).click();                         // Нахожу на страницу цифру 15 кликаю по нему!!!
        $("#subjectsInput").setValue("E").pressEnter();               // Нажимаю на первое слово по букве E
        $(byText("Music")).click();                                  // Нахожу слово Female и кликаю по нему!!!
        $("#uploadPicture").uploadFromClasspath("1.png");   // Загружаю файл 1.png из папки Ресурсы
        $("#currentAddress").setValue("Lenina street 11");           // Ввожу данные
        $("#state").click();                                         // Кликаю на пиклист
            $(byText("NCR")).click();                               // Ищу текст NCR и кликаю по нему!!!
        $("#city").click();                                          // Кликаю на пиклист
            $(byText("Delhi")).click();                             // Ищу текст Delfi и кликаю по нему!!!
        $("[id=submit]").click();                                    // Кликаю на Submit

        // Проверки корректности внесённых данных
        $(".table-responsive").shouldHave(text("Student Name	" + name + " Zyryanov"),
                text("Mobile 8982145978"), text("Picture	1.PNG"), text("Student Email Zyryanovvm@rambler.ru"),
                text("Gender Female"), text("Date of Birth 15 January,1995"), text("Subjects English"),
                text("Hobbies Music"), text("Address Lenina street 11"), text("State and City NCR Delhi"));

        $("#closeLargeModal").click();                                //Закрываю таблицу как знак успешного теста
    }
    }