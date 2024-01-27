package allovercommerce.tests.US07_akif;

import allovercommerce.pages.akif.*;
import allovercommerce.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 {

    AllovCommerceDefaultPage allovCommerceDefaultPage = new AllovCommerceDefaultPage();
    AllovCommerceSignInPage allovCommerceSignInPage = new AllovCommerceSignInPage();
    AllovCommerceHomePage allovCommerceHomePage = new AllovCommerceHomePage();
    AllovCommerceMyAccountPage allovCommerceMyAccountPage = new AllovCommerceMyAccountPage();
    AllovCommerceShippingAddressPage allovCommerceShippingAddressPage = new AllovCommerceShippingAddressPage();
    AllovCommerceItemPage allovCommerceItemPage = new AllovCommerceItemPage();
    AllovCommerceComparePage allovCommerceComparePage = new AllovCommerceComparePage();

    //User should be able to add and compare items on the Compare Page
    //And user should be able to remove items by clicking cross
    //Then user should be able to verify that items are no longer displayed on the page
    // (No products added to the compare message should be displayed on the page)
    @Test
    public void US07_TC07(){

        LoggerUtils.info("Test case begins...");

        ExtentReportUtils.createTestReport("US07_TC07 Test Report", "Compare Products Page Test");
        ExtentReportUtils.pass("Starting the compare products page test...");

        Driver.getDriver().get("https://allovercommerce.com/");

        ExtentReportUtils.pass("User in on the default page...");

        allovCommerceDefaultPage.searchBox.sendKeys(ConfigReader.getProperty("akif_US07_item1") + Keys.ENTER);

        ExtentReportUtils.passAndCaptureScreenshot("Item name entered and searched successfully...");

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("chess"));

        ExtentReportUtils.passAndCaptureScreenshot("Navigate to the item page successfully...");

        JSUtils.JSclickWithTimeout(allovCommerceItemPage.compareButton);

        Assert.assertTrue(allovCommerceItemPage.compareConsole.isDisplayed());

        Assert.assertTrue(allovCommerceItemPage.imageItem1.isDisplayed());

        ExtentReportUtils.passAndCaptureScreenshot("Compare Console is opened and item(s) displayed...");

        allovCommerceDefaultPage.searchBox.sendKeys(ConfigReader.getProperty("akif_US07_item2") + Keys.ENTER);

        ExtentReportUtils.passAndCaptureScreenshot("Item name entered and searched successfully...");

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("pants"));

        ExtentReportUtils.passAndCaptureScreenshot("Navigate to the item page successfully...");

        JSUtils.JSclickWithTimeout(allovCommerceItemPage.compareButton);

        Assert.assertTrue(allovCommerceItemPage.compareConsole.isDisplayed());

        Assert.assertTrue(allovCommerceItemPage.imageItem2.isDisplayed());

        ExtentReportUtils.passAndCaptureScreenshot("Compare Console is opened and item(s) displayed...");

        JSUtils.JSclickWithTimeout(allovCommerceItemPage.startCompareButton);

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("compare"));

        ExtentReportUtils.passAndCaptureScreenshot("Navigate to the Compare Products Page successfully...");

        /*
        allovCommerceComparePage.removeItem1.click();
        WaitUtils.waitFor(2);
        allovCommerceComparePage.removeItem1.click();
        */

        allovCommerceComparePage.removeItem2.click();
        WaitUtils.waitFor(2);

        ExtentReportUtils.passAndCaptureScreenshot("Item removed successfully...");

        allovCommerceComparePage.removeItem1.click();
        WaitUtils.waitFor(2);

        ExtentReportUtils.passAndCaptureScreenshot("Item removed successfully...");

        Assert.assertTrue(allovCommerceComparePage.noProductsMessage.isDisplayed());

        ExtentReportUtils.passAndCaptureScreenshot("No products added to the compare message displayed on the page...");

        Driver.closeDriver();

        ExtentReportUtils.pass("Driver is closed...Test case passed successfully...");

        ExtentReportUtils.flush();

        LoggerUtils.info("Test completed...");


    }

}
