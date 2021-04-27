package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private WebDriver driver;

    private By addressButton = By.cssSelector("li[id='addresses']");
    private By addAddressButton = By.cssSelector("div[data-qa='btn_add-new-address']");
    private By AddressBox = By.cssSelector("input[data-qa='tf_searchFieldMaps']");
    private By AddressOption = By.cssSelector("div[data-qa='suggestions_Maps']>div:nth-of-type(1)");
    private By AddressConfirm = By.xpath("//button/span[text()='Confirm Location']");
    private By AddressDetails = By.cssSelector("div[data-qa='tf_Additional Address Details']>div>input[type='text']");
    private By numberOption = By.cssSelector("div[role='button'][aria-haspopup='listbox']");
    private By numberCode = By.cssSelector("li[id='dd_areaCode10']");
    private By number = By.cssSelector("div[data-qa='tf_Mobile Number']>div>input[class='MuiInputBase-input MuiInput-input']");
    private By firstName = By.cssSelector("div[data-qa='tf_First Name']>div>input[class='MuiInputBase-input MuiInput-input']");
    private By lastName = By.cssSelector("div[data-qa='tf_Last Name']>div>input[class='MuiInputBase-input MuiInput-input']");
    private By saveButton = By.xpath("//button/span[text()='Save Address']");
    private By logoutButton = By.xpath("//div[@id='__next']/div[1]/section/div/div[1]/div/button[text()='Sign Out']");
    private By Address = By.cssSelector("div[class='gm-style-iw gm-style-iw-c']");
    private By AddressForm = By.cssSelector("div[id='FormOuterContainer']");
    private By codeList = By.cssSelector("ul[role='listbox'][tabindex='-1']");
    private By successMessage = By.cssSelector("div[id='notistack-snackbar']");


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addAddress() {
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.urlContains("https://account.noon.com/egypt-en/profile"));
        driver.findElement(addressButton).click();

        wait.until(ExpectedConditions.urlContains("https://account.noon.com/egypt-en/addresses"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addAddressButton));
        driver.findElement(addAddressButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AddressBox));
        driver.findElement(AddressBox).sendKeys("ElBaron Mansoura");

        wait.until(ExpectedConditions.visibilityOfElementLocated(AddressOption));
        driver.findElement(AddressOption).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(Address));
        wait.until(ExpectedConditions.elementToBeClickable(AddressConfirm));
        driver.findElement(AddressConfirm).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AddressForm));
        driver.findElement(AddressDetails).sendKeys("ElBaron");
        driver.findElement(numberOption).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(codeList));
        driver.findElement(numberCode).click();

        driver.findElement(number).sendKeys("34572398");
        driver.findElement(firstName).sendKeys("Eman");
        driver.findElement(lastName).sendKeys("Diab");

        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        driver.findElement(saveButton).click();
    }

     public boolean isSuccessMegPresent(){
         WebDriverWait wait = new WebDriverWait(driver, 150);
         wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
         return driver.findElement(successMessage).isDisplayed();
    }

    public HomePage signOut(){
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(successMessage));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
        wait.until(ExpectedConditions.urlToBe("https://www.noon.com/egypt-en/"));
        return new HomePage(driver);
    }

}
