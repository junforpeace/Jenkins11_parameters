package test.properties;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import pages.RegistrationFormPage;

import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

@Tag("owner")
public class JenkinsFormParams extends TestBase {
    Faker faker = new Faker();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        // parameters
    String name = faker.name().firstName(),
            lastname = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            address = faker.address().fullAddress(),
            phone = faker.phoneNumber().subscriberNumber(10),
            FullName = format("%s %s", name, lastname),
            subject = "Civics",
            image ="Areyouabeer.jpg",
            day = "16",
            month = "July",
            year = "2005",
            fullDate = format("%s %s,%s", day, month, year),
            hobby = "Music",
            state = "Rajasthan",
            city = "Jaipur",
            stateAndcity = format ("%s %s", state, city),
            formTitle = "Thanks for submitting the form";


    @DisplayName("Заполнение формы регистрации студента")
    @Test
    void FormInput() {

        step("Open Registration page", ()-> {
            registrationFormPage.openPage();
        });

        step("Fill the Form", () ->{
            registrationFormPage.setFirstName(name)
                    .setLastName(lastname)
                    .setEmail(userEmail)
                    .setGender(gender)
                    .setPhone(phone)
                    .setCurrentAddress(address)
                    .setBirthday(day, month, year)
                    .setSubjects(subject)
                    .setHobby(hobby)
                    .uploadImage(image)
                    .setState(state, city);
        });

        step("Submit Form", ()->{
            registrationFormPage.submitForm();
        });

        step("Check submitted Form", () -> {
            registrationFormPage.checkTitle(formTitle)
                    .checkResult("Student Name", FullName)
                    .checkResult("Student Email", userEmail)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phone)
                    .checkResult("Date of Birth", fullDate)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobby)
                    .checkResult("Picture", image)
                    .checkResult("Address", address)
                    .checkResult("State and City", stateAndcity);
        });

    }
}

