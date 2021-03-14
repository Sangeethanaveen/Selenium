package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class HomePage {

    WebDriver driver;
    @FindBy(linkText = "Login")
    WebElement login;

    @FindBy(xpath = "//li[@id='home-link']/a")
    WebElement home;

    @FindBy(id = "keywords")
    WebElement searchKeyword;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchButton;

    @FindBy(linkText = "Bags")
    WebElement bagLink;

    @FindBy(xpath = "//input[@id='Price_Range_$15.00_-_$18.00']")
    WebElement priceFilter;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement searchFilter;

    @FindBy(xpath = "//span[@itemprop='price']")
    WebElement priceProperty;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Ruby')]")
    public List<WebElement> searchNameRuby;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Apache')]")
    public List<WebElement> searchNameApache;

    @FindBy(how = How.XPATH, using = "//span[@itemprop='price']")
    public List<WebElement> priceValue;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //utilization
    public void navigateToLogin() {
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Login")));
        login.click();
    }

    public void navigateToHome() {
        home.click();
    }

    public void searchKeyword(String name) {
        searchKeyword.sendKeys(name);
        searchButton.click();
        searchKeyword.clear();
        //searchButton.click();
    }

    public boolean verifySearchByRuby() {
        int size = searchNameRuby.size();
        String title = "";
        for (int i = 0; i < size; i++)
            title = searchNameRuby.get(i).getText();
        boolean check = title.contains("Ruby");
        return check;
    }

    public boolean verifySearchByApache() {
        int size = searchNameApache.size();
        String title = "";
        for (int i = 0; i < size; i++)
            title = searchNameApache.get(i).getText();
        boolean check = title.contains("Apache");
        return check;

    }

    public void searchByFilters()  {

        bagLink.click();
        priceFilter.click();
        searchFilter.click();

    }

    public boolean verifySearchByFilters() {
        Boolean checkbox = priceFilter.isSelected();
        Boolean checkPrice = null;
        Assert.assertTrue(checkbox);
        for (int i = 0; i < priceValue.size(); i++) {
            String price = priceValue.get(i).getText();
            String value = price.substring(1);
            double priceText = Double.parseDouble(value);
            if((priceText > 15.00) && (priceText < 18.00));
               checkPrice=true;
        }
        return checkPrice;
    }

}
