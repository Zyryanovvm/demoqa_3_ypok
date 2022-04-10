package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationFormPage;
import guru.qa.utils.RandomUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static java.lang.String.format;

public class RegistrationFormTest<IdeaProjects, QA, resources> {

    Faker fakerRu = new Faker(new Locale("ru"));

    // My Details
    String firstName = RandomUtils.getRandomStringName(),
            lastName = fakerRu.name().lastName(),
            email = RandomUtils.getRandomEmail(),
            phoneNumber = RandomUtils.getRandomPhoneNumbers(),
            currentAddress = fakerRu.address().fullAddress(),
            myGender = "Other",
            bithDay = "15",
            bithMonth = "January",
            bithYear = "1995",
            mySubject = "English",
            myHobbies = "Music",
            myState = "Haryana",
            myCity = "Panipat",
            file = "1.PNG";

    // My verification details
    String fullName = format("%s %s", firstName, lastName),
            fullBithDate = format("%s %s,%s", bithDay, bithMonth, bithYear),
            myStateAndCity = format("%s %s", myState, myCity);


    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    public static void settings() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1800x1200";
    }

    @Test
    void fillFormTest() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        // Data input
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(myGender)
                .setNumberPhone(phoneNumber)
                .setBirthDay(bithDay, bithMonth, bithYear)
                .setSubject(mySubject)
                .setHobbies(myHobbies)
                .setUploadPicture(file)
                .setCurrentAddress(currentAddress)
                .setMyState(myState)
                .setMyCity(myState, myCity)
                .clickSubmit();


        // Data asserst
        registrationFormPage.checkResult("Student Name", fullName)
                .checkResult("Student Email", email )
                .checkResult("Gender", myGender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", fullBithDate)
                .checkResult("Subjects", mySubject)
                .checkResult("Hobbies", myHobbies)
                .checkResult("Picture", file)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", myStateAndCity)
                .closeTable();

    }
}
