package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
        firstNameInput = $("[placeholder='First Name']"),
        lastNameInput = $("[placeholder='Last Name']"),
        emailInput = $("#userEmail"),
        genderChoice = $("#genterWrapper"),
        phoneInput = $("#userNumber"),
        birthDateInput = $("#dateOfBirthInput"),
        subjectInput = $("#subjectsInput"),
        hobbiesChoice = $("#hobbiesWrapper"),
        pictureUpload = $("#uploadPicture"),
        addressInput = $("#currentAddress"),
        stateList = $("#state"),
        cityList = $("#city"),
        submitButton = $("#submit"),
        closeButton = $("#closeLargeModal");

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        //$(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderChoice.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesChoice.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setAvatar(String location) {
        pictureUpload.uploadFile(new File(location));

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }


    public RegistrationPage setState(String state) {
        stateList.click();
        stateList.$(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        cityList.click();
        cityList.$(byText(city)).click();

        return this;
    }

    public void submitUserInfo() {
        submitButton.click();
    }

    public RegistrationPage verifyResultModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key,value);

        return this;
    }

    public void closeWindow () {
        closeButton.click();
    }
}
