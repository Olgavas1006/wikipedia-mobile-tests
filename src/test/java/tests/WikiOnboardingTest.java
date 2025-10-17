package tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.FirstOnboardingScreen;
import screens.FourthOnboardingScreen;
import screens.SecondOnboardingScreen;
import screens.ThirdOnboardingScreen;

import static io.qameta.allure.Allure.step;

@Owner("Olgavas1006")
@Feature("Стартовые экраны приложения")
public class WikiOnboardingTest extends TestBase {

    FirstOnboardingScreen firstScreen = new FirstOnboardingScreen();
    SecondOnboardingScreen secondScreen = new SecondOnboardingScreen();
    ThirdOnboardingScreen thirdScreen = new ThirdOnboardingScreen();
    FourthOnboardingScreen fourthScreen = new FourthOnboardingScreen();

    @Test
    @Tag("android")
    @Story("Стартовые экраны приложения")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка экранов онбординга")
    void verifyGettingStartedScreensTest() {
        step("Проверить первый экран", () -> {
            firstScreen.verifyFirstScreen();
            firstScreen.goToNextScreen();
        });

        step("Проверить второй экран", () -> {
            secondScreen.verifySecondScreen();
            secondScreen.goToNextScreen();
        });

        step("Проверить третий экран", () -> {
            thirdScreen.verifyThirdScreen();
            thirdScreen.goToNextScreen();
        });

        step("Проверить четвертый экран", () -> {
            fourthScreen.verifyFourthScreen();
        });
    }
}
