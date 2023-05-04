package tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void formFulfillmentTest() {
        String userFirstName = "Michael";
        String userLastName = "Jackson";
        String userEmail = "michael@jackson.com";
        String userGender = "Male";
        String userPhone = "1234567890";
        String userBirthDay = "29";
        String userBirthMonth = "August";
        String userBirthYear = "1958";
        String userSubjects = "Computer science";
        String userHobbies = "Music";
        String userAvatar = "src/test/resources/pictures/michael.jpg";
        String userAddress = "Los-Angeles, CA";
        String userState = "NCR";
        String userCity = "Delhi";

        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(userSubjects)
                .setHobbies(userHobbies)
                .setAvatar(userAvatar)
                .setAddress(userAddress);

        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");

        registrationPage.setState(userState)
                .setCity(userCity)
                .submitUserInfo();

        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .verifyResult("Subjects", "Computer science")
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);

    }
}
