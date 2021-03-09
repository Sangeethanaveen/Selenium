package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import pages.HomePage;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SpreeTestCase extends SpreeBaseClass {
    @Test(dataProvider = "userDetail")
    public void loginAndLogout(String email, String password) {
        HomePage homePg = new HomePage(driver);
        LoginPage loginPg = new LoginPage(driver);
        homePg.navigateToLogin();
        loginPg.logInSpree(email, password);
        boolean verifyLogin = loginPg.verifyLogInSpree();
        Assert.assertTrue(verifyLogin);
        loginPg.logOutSpree();
        boolean verifyLogOut = loginPg.verifyLogout();
        Assert.assertTrue(verifyLogOut);
    }

    @DataProvider
    public Object[][] userDetail() {
        return new Object[][]{
                {"sangeethaNaveen@gmail.com", "123456"}
        };
    }

    @Test(dataProvider = "searchName")
    public void searchProductByName(String sName) {
        HomePage homePg = new HomePage(driver);
        homePg.navigateToHome();
        homePg.searchKeyword(sName);
        Boolean checkSearchRuby = homePg.verifySearchByRuby();
        Assert.assertTrue(checkSearchRuby);
        homePg.navigateToHome();
    }
    @DataProvider
    public Object[][] searchName() {
        return new Object[][]{
                {"Ruby"}
        };
    }
    @Test(dataProvider ="searchKey")
    public void searchProductByKeyword(String keyword) {
        HomePage homePg = new HomePage(driver);
        homePg.navigateToHome();
        homePg.searchKeyword(keyword);
        Boolean checkSearchApache = homePg.verifySearchByApache();
        Assert.assertTrue(checkSearchApache);
    }
    @DataProvider
    public Object[][] searchKey() {
        return new Object[][]{
                {"Apache"}
        };
    }

    @Test
    public void searchByFilter() throws InterruptedException {
        HomePage homePg = new HomePage(driver);
        homePg.navigateToHome();
        homePg.searchByFilters();
        boolean checkSearchByFilter = homePg.verifySearchByFilters();
        Assert.assertTrue(checkSearchByFilter);
    }

    @Test(dataProvider = "userDetail")
    public void addToCartAndEmptyTheCart(String email,String password) throws InterruptedException {
        HomePage homePg = new HomePage(driver);
        LoginPage loginPg = new LoginPage(driver);
        homePg.navigateToLogin();
        loginPg.logInSpree(email,password);
        homePg.searchKeyword("Ruby on Rails Mug");
        loginPg.addToCart();
        boolean verifyItemIncart =loginPg.verifyAddToCart();
        loginPg.deleteProductInCart();
        loginPg.logOutSpree();
    }
}