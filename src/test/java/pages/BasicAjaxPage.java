package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicAjaxPage {
    WebDriver driver;

    @FindBy(id="combo1")
    private WebElement category;

    @FindBy(id="combo2")
    private WebElement language;

    @FindBy(name="submitbutton")
    private WebElement submitButton;

    @FindBy(id="_valueid")
    private WebElement idElement;

    @FindBy(id="_valuelanguage_id")
    private WebElement languageIdElement;

    public BasicAjaxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCategory(String categoryName) {
        Select categorySelect = new Select(category);
        categorySelect.selectByVisibleText(categoryName);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxBusy")));
    }

    public void selectLanguage(String languageName) {
        Select languageSelect = new Select(language);
        languageSelect.selectByVisibleText(languageName);
    }

    public void submitForm() {
        submitButton.click();
    }

    public String getIdElement() {
        return idElement.getText();
    }

    public String getLanguageIdElement() {
        return languageIdElement.getText();
    }
}
