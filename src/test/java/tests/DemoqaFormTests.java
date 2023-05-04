package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DemoqaFormTests {
    @BeforeAll
    static void beforeAll() {Configuration.browserSize = "3020x2048";
    }

    @Test
    void formFulfillmentTest() {

        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[placeholder='First Name']").setValue("Michael");


        $("[placeholder='Last Name']").setValue("Jackson");

        $("#userEmail").setValue("michael@jackson.com");

        $("#gender-radio-1").sendKeys(" ");

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1958");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();


        $("#subjectsInput").setValue("Computer science").pressEnter();

        $("#hobbies-checkbox-3").sendKeys(" ");

        $("#uploadPicture").uploadFile(new File("src/test/resources/pictures/michael.jpg"));

        $("#currentAddress").setValue("Los-Angeles, CA");

        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        $(byText("Select State")).click();
        $(byText("NCR")).click();

        $(byText("Select City")).click();
        $(byText("Delhi")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Michael Jackson"));
        $("tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text("michael@jackson.com"));
        $("tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $("tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text("1234567890"));
        $("tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text("29 August,1958"));
        $("tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Music"));
        $("tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("michael.jpg"));
        $("tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text("Los-Angeles, CA"));
        $("tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").exists();

    }
}
