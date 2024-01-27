package allovercommerce.tests.US14_sibel;

import allovercommerce.pages.sibel.*;
import allovercommerce.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

    public class TC09_NegAddSameCatgNamesMultipleTimes {

        MyAccount2LoginPage myAccount2DefaultPage = new MyAccount2LoginPage();
        StoreManagerHomePage storeManagerHomePage = new StoreManagerHomePage();
        AllProductsPage allProductsPage = new AllProductsPage();
        NewProductsPage newProductsPage = new NewProductsPage();
        MyAccountHomePage myAccountHomePage = new MyAccountHomePage();

        // 1.navigate to https://allovercommerce.com/store-manager/products-manage/
        @BeforeTest
        public void signInToVendorAcc() {

            ExtentReportUtils.createTestReport("SignIntoVendorAccount", "User need to signed in to Vendor account");
            Driver.getDriver().get("https://allovercommerce.com/my-account-2/");
            ExtentReportUtils.pass("User on the Sign In to My Account Page");

            myAccount2DefaultPage.username.sendKeys("sibeltechpro@gmail.com");
            WaitUtils.waitFor(1);
            ExtentReportUtils.info("Using e-mail address:sibeltechpro@gmail.com and Password:vendortest1");

            myAccount2DefaultPage.password.sendKeys("vendortest1");
            WaitUtils.waitFor(1);
            JSUtils.JSclickWithTimeout(myAccount2DefaultPage.signInButton);
            ExtentReportUtils.pass("User signed in successfully");
            JSUtils.JSclickWithTimeout(myAccountHomePage.toStoreManagerPage);
            ExtentReportUtils.pass("User click on the Store Manager Page");
            JSUtils.JSclickWithTimeout(storeManagerHomePage.productLink);
            ExtentReportUtils.pass("User Click on the Products Link from the Left Menu Bar");
            JSUtils.JSclickWithTimeout(allProductsPage.newProductButton);
            ExtentReportUtils.pass("User Click on the New Product Button");

        }

        @Test
        public void addExistingCategoryTest() {
            ExtentReportUtils.createTestReport("AddExistingCategoryTest", "User Attempt to add new Category Name");
// 2.Click on the add new category link under the categories

            JSUtils.JSclickWithTimeout(newProductsPage.addNewCategory);
            ExtentReportUtils.pass("User Click on the add New Category Link");

// 3.Type the Category name you know already in the list

            newProductsPage.categoryNameAdd.sendKeys("Morning Suit");
            ExtentReportUtils.pass("User type Morning Suit as a new Category Name");

// 4.Select related parent category from the dropdown list (Uncategorized)
            Select select = new Select(newProductsPage.selectParentCategory);
            select.selectByValue("15");

// 5.Click add button

            JSUtils.JSclickWithTimeout(newProductsPage.addCategoryButton);

            ExtentReportUtils.failAndCaptureScreenshotEx("Website has send and alert that; this Category name already exist ");

            Driver.getDriver().switchTo().alert().accept();

            Driver.getDriver().close();
            ExtentReportUtils.flush();
        }
    }

//        @Test
//        public void findCategoryIfAdded() {
//            ExtentReportUtils.createTestReport("findTheNewCategoryInTheList", "Check if new Category Added Succesfully");
//            List<WebElement> allCatgs = Driver.getDriver().findElements(By.xpath("product_cats_checklist"));
//// 6.Check from the category list if the new category has been added succesfully
//
//            int i = 0;
//            for (WebElement each : allCatgs) {
//
//                for (i = 0; i < allCatgs.size(); i++) ;
//                {
//                    Assert.assertFalse(each.getText().contains("Morning Suit"));
//                }
//            }
//            ExtentReportUtils.failAndCaptureScreenshotEx("test Failed");
//            Driver.getDriver().close();
//            ExtentReportUtils.flush();
//        }
//    }

// Check how many same brand name has occurred
//
//                String brandToCount = "Morning Suit";
//
//                int count = 0;
//                for (WebElement eachCatg : allCatgs) {
//
//                    if (eachCatg.getText().equalsIgnoreCase(brandToCount)) {
//                        count++;
//                        System.out.println("The brand '" + brandToCount + "' appears " + count + " times.");
//                    }
//
//                }
//
//                Assert.assertTrue(count>1);
//        }

