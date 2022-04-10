package guru.qa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();

    //locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderInput = $("#genterWrapper");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement resultTableForm = $(".table-responsive");
    SelenideElement calendarInput = $("#dateOfBirthInput");
    SelenideElement subjectInput = $("#subjectsInput");
    SelenideElement hobbiesChekBox = $("#hobbiesWrapper");
    SelenideElement uploadPictureInput = $("#uploadPicture");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement stateInput = $("#state");
    SelenideElement closeResultTable =  $("#closeLargeModal");
    SelenideElement cityInput1 = $("#react-select-4-option-0");
    SelenideElement cityInput2 = $("#react-select-4-option-1");
    SelenideElement cityInput3 = $("#react-select-4-option-2");
    SelenideElement stateInput1 = $("#react-select-3-option-0");
    SelenideElement stateInput2 = $("#react-select-3-option-1");
    SelenideElement stateInput3 = $("#react-select-3-option-2");
    SelenideElement stateInput4 = $("#react-select-3-option-3");
    SelenideElement clickSubmit = $("#submit");


    //actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        Selenide.zoom(0.75);
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setNumberPhone(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDay(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbiesChekBox.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setMyState(String value) {
        stateInput.click();
        if (value == "NCR") {
            stateInput1.click();
        } else if (value == "Uttar Pradesh") {
            stateInput2.click();
        } else if (value == "Haryana") {
            stateInput3.click();
        } else if (value == "Rajasthan") {
            stateInput4.click();
        }

        return this;
    }

    public RegistrationFormPage setMyCity(String state, String city) {
        $("#city").click();
        if (state == "NCR") {
            if (city == "Delhi") {
                cityInput1.click();
        } else if (city == "Gurgaon") {
                cityInput2.click();
        } else if (city == "Noida") {
                cityInput3.click();
        } } else if (state == "Uttar Pradesh") {
            if (city == "Agra") {
                cityInput1.click();
            } else if (city == "Lucknow") {
                cityInput2.click();
            } else if (city == "Merrut") {
                cityInput3.click();
            }
        } else if (state == "Haryana") {
            if (city == "Karnal") {
                cityInput1.click();
            } else if (city == "Panipat") {
                cityInput2.click();
            } } else if (state == "Rajasthan") {
            if (city == "Jaipur") {
                cityInput1.click();
            } else if (city == "Jaiselmer") {
                cityInput2.click();
        }}
        return this;
    }

    public RegistrationFormPage clickSubmit() {
        clickSubmit.click();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultTableForm.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationFormPage closeTable() {
        closeResultTable.click();

        return this;
    }




}
