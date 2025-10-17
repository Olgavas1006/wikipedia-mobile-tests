package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import screens.MainScreen;
import screens.SkipOnboardingScreen;
import screens.SearchScreen;
import static io.qameta.allure.Allure.step;

@Owner("Olgavas1006")
@Feature("Открытие статьи в мобильном приложении Wikipedia")
public class SearchGithubTest extends TestBase{

    MainScreen mainScreen = new MainScreen();
    SearchScreen searchScreen = new SearchScreen();
    SkipOnboardingScreen onboardingScreen = new SkipOnboardingScreen();

    @Test
    @Tag("jenkins")
    @Story("Открытие статьи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка открытия статьи")
    void openArticleTest() {
        step("Пропустить онбординг если отображается", () -> {
            onboardingScreen.skipOnboardingIfVisible();
        });

        step("Открыть поиск и ввести Github", () -> {
            mainScreen.clickSearchWikipediaIcon();
            searchScreen.searchPageSetValue("Github");
        });

        step("Открыть первую статью из результатов", () -> {
            searchScreen.clickTheFirstResult();
        });

        step("Закрыть всплывающее окно если отображается", () -> {
                Thread.sleep(1000);
                 onboardingScreen.closeOnboardingIfNeeded();
        });

        step("Проверить найденный контент", () -> {
            searchScreen.verifyContent();
        });

        step("Проверить заголовок статьи", () -> {
            searchScreen.verifyArticleTitle("GitHub");
        });
    }

}
