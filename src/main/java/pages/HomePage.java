package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    private WebDriver driver;

    private By loginButton = By.cssSelector("button[data-qa='btn_header_signInOrUp']");
    private By loginModal = By.cssSelector("div[data-qa='div_loginModal']");
    private By signupButton = By.cssSelector("h3[data-qa='btn_signUpButton']");
    private By emailInput = By.cssSelector("input[id='emailInput']");
    private By passwordInput = By.cssSelector("input[id='passwordInput']");
    private By firstnameInput = By.cssSelector("input[id='firstNameInput']");
    private By lastnameInput = By.cssSelector("input[id='lastNameInput']");
    private By signupSubmit = By.cssSelector("button[data-qa='btn_Create an account']");
    private By accountMenu = By.cssSelector("button[class='trigger']");
    private By profileButton = By.cssSelector("button>img[alt='Profile']");
    private By loginSubmit = By.cssSelector("button[data-qa='btn_Sign In']");
    private By logout = By.cssSelector("button[data-qa='btn_user_logOut']");
    private By closeLogin = By.cssSelector("div[data-qa='div_loginModal']>div>button>img[alt='close-modal']");
    private By headerCreateAccount = By.cssSelector("div>h2[data-qa='lbl_modalTitle_Create an account']");



    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public void openSignupForm() {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginModal));
        driver.switchTo().activeElement();
        driver.findElement(signupButton).click();
    }

    public void fillSignupForm(String email, String password, String firstname, String lastname) {
        driver.switchTo().activeElement();
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerCreateAccount));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));

        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(firstnameInput).sendKeys(firstname);
        driver.findElement(lastnameInput).sendKeys(lastname);
        driver.findElement(signupSubmit).click();
    }

    public ProfilePage openProfilePage () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginModal));
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountMenu));
        driver.findElement(accountMenu).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        driver.findElement(profileButton).click();
        return new ProfilePage(driver);
    }

    public void fillLoginForm(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginModal));
        driver.switchTo().activeElement();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginSubmit).click();
    }

    public void logOut(){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginModal));
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountMenu));
        driver.findElement(accountMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
        wait.until(ExpectedConditions. elementToBeClickable(logout));

        driver.findElement(logout).click();
    }

    public void closeLoginModal(){
        driver.findElement(closeLogin).click();
    }


}


