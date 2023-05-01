package com.tutorialsninja.testsuite;

import com.tutorialsninja.page.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {

    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        laptopsAndNotebooksPage.mouseHoverOnLaptopAndNotebooksTabAndClick();
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.selectSortByHighToLow();
        Assert.assertEquals(laptopsAndNotebooksPage.beforeSortingPriceHighToLow(), laptopsAndNotebooksPage.afterSortingPriceHighToLow(), "Error message ");

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        laptopsAndNotebooksPage.mouseHoverOnLaptopAndNotebooksTabAndClick();
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.selectSortByHighToLow();

        //2.4 Select Product “MacBook
        laptopsAndNotebooksPage.clickOnMacBook();

        // 2.5 Verify the text “MacBook”
        String expectedText = "MacBook";
        String actualText = laptopsAndNotebooksPage.verifyTextMacBook();
        Assert.assertEquals(actualText, expectedText, "Error message");

        // 2.6 Click on ‘Add To Cart’ button
        laptopsAndNotebooksPage.clickOnAddToCart();

        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!"
        String expectedMessage = "Success: You have added MacBook to your shopping cart!";
        String actualMessage = laptopsAndNotebooksPage.getAddedMacBookText();
        boolean message = actualMessage.contains(expectedMessage.trim());
        Assert.assertTrue(message);

        // 2.8 Click on link “shopping cart” display into success message
        laptopsAndNotebooksPage.clickOnShoppingCart();

        // 2.9 Verify the text "Shopping Cart"
        String expectedCart = "Shopping Cart  (0.00kg)";
        String actualCart = laptopsAndNotebooksPage.verifyTextShoppingCart();
        Assert.assertEquals(actualCart, expectedCart, "Error message");

        // 2.10 Verify the Product name "MacBook"
        String expectedName = "MacBook";
        String actualName = laptopsAndNotebooksPage.verifyProductNameMacBook();
        Assert.assertEquals(actualName, expectedName, "Error message");

        // 2.11 Change Quantity "2"
        laptopsAndNotebooksPage.changeQuantity();

        // 2.12 Click on “Update” Tab
        laptopsAndNotebooksPage.clickOnUpdateTab();

        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedMessage1 = "Success: You have modified your shopping cart!";
        String actualMessage1 = laptopsAndNotebooksPage.verifyModifiedYourShoppingCart();
        boolean message1 = actualMessage1.contains(expectedMessage1.trim());
        Assert.assertTrue(message1);

        // 2.14 Verify the Total £737.45
        String expectedTotal = "$1,204.00";
        String actualTotal = laptopsAndNotebooksPage.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Error message");

        // 2.15 Click on “Checkout” button
        laptopsAndNotebooksPage.clickOnCheckoutButton();

        // 2.16 Verify the text “Checkout”
        String expectedText1 = "Checkout";
        String actualText1 = laptopsAndNotebooksPage.verifyTheTextCheckout();
        Assert.assertEquals(actualText1, expectedText1, "Error message");

        // 2.17 Verify the Text “New Customer”
        Thread.sleep(2000);
        String expectedText2 = "New Customer";
        String actualText2 = laptopsAndNotebooksPage.verifyTheTextNewCustomer();
        Assert.assertEquals(actualText2, expectedText2, "Error message");

        // 2.18 Click on “Guest Checkout” radio button
        laptopsAndNotebooksPage.clickOnGuestCheckOutRadioButton();

        // 2.19 Click on “Continue” tab
        laptopsAndNotebooksPage.clickOnContinueTab();

        // 2.20 Fill the mandatory fields
        laptopsAndNotebooksPage.enterFirstName();
        laptopsAndNotebooksPage.enterLastName();
        laptopsAndNotebooksPage.enterEmailId();
        laptopsAndNotebooksPage.enterTelephone();
        laptopsAndNotebooksPage.enterAddress();
        laptopsAndNotebooksPage.enterCity();
        laptopsAndNotebooksPage.enterPostCode();
        laptopsAndNotebooksPage.selectCountryFromDropDown();
        laptopsAndNotebooksPage.selectRegionFromDropDown();

        // 2.21 Click on “Continue” Button
        laptopsAndNotebooksPage.clickOnContinueButton();

        // 2.22 Add Comments About your order into text area
        laptopsAndNotebooksPage.addCommentsAboutYourOrder();

        // 2.23 Check the Terms & Conditions check box
        laptopsAndNotebooksPage.clickOnTermsAndConditionsCheckBox();

        // 2.24 Click on “Continue” button
        laptopsAndNotebooksPage.clickOnContinue();

        // 2.25 Verify the message “Warning: Payment method required!"
        String expectedMessage2 = "Warning: Payment method required!";
        String actualMessage2 = laptopsAndNotebooksPage.verifyMessagePaymentMethodRequired();
        boolean message2 = actualMessage2.contains(expectedMessage2.trim());
        Assert.assertTrue(message2);

    }
}
