package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import base.BasePage;

public class AdminPage extends BasePage {

    public AdminPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    By adminMenu = By.xpath("//span[text()='Admin']");
    By addBtn = By.xpath("//button[normalize-space()='Add']");

    By roleDropdown = By.xpath("(//div[contains(@class,'oxd-select-text')])[1]");
    By statusDropdown = By.xpath("(//div[contains(@class,'oxd-select-text')])[2]");
    By options = By.xpath("//div[@role='listbox']//span");

    By empName = By.xpath("//input[@placeholder='Type for hints...']");
    By suggestions = By.xpath("//div[@role='option']");

    By usernameInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By passwordInput = By.xpath("(//input[@type='password'])[1]");
    By confirmPassword = By.xpath("(//input[@type='password'])[2]");

    By saveBtn = By.xpath("//button[@type='submit']");

    By searchUser = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By searchBtn = By.xpath("//button[@type='submit']");
    By rows = By.xpath("//div[@class='oxd-table-card']");
    By deleteBtn = By.xpath(".//button[1]");
    By confirmDelete = By.xpath("//button[text()='Yes, Delete']");

    public void goToAdmin() {
        click(adminMenu);
    }

    public void clickAdd() {
        click(addBtn);
    }

    // 🔥 Dropdown handler
    private void selectDropdown(By dropdown, String value) {

        WebElement drop = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        drop.click();

        List<WebElement> list = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(options)
        );

        for (WebElement e : list) {
            if (e.getText().trim().equalsIgnoreCase(value)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
                break;
            }
        }
    }

    public void selectRole(String role) {
        selectDropdown(roleDropdown, role);
    }

    public void selectStatus(String status) {
        selectDropdown(statusDropdown, status);
    }

    // 🔥 Employee always valid
    public void enterEmployeeName(String name) {
        sendKeys(empName, name);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(suggestions, 0));

        driver.findElements(suggestions).get(0).click();
    }

    public void enterCredentials(String user, String pass, String confirm) {
        sendKeys(usernameInput, user);
        sendKeys(passwordInput, pass);
        sendKeys(confirmPassword, confirm);
    }

    public void clickSave() {
        click(saveBtn);
    }

    public void searchUser(String user) {
        sendKeys(searchUser, user);
        click(searchBtn);

        wait.until(driver ->
                driver.findElements(rows).size() > 0 ||
                driver.getPageSource().contains("No Records Found")
        );
    }

    public boolean isUserPresent() {
        return driver.findElements(rows).size() > 0;
    }

    public void deleteUser() {
        WebElement row = driver.findElements(rows).get(0);
        row.findElement(deleteBtn).click();
        click(confirmDelete);
    }
}