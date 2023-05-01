package com.tutorialsninja.page;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    By laptopsAndNotebooksTab = By.linkText("Laptops & Notebooks");
    By showAllLaptopsAndNotebooks = By.linkText("Show AllLaptops & Notebooks");
    By sortBy = By.id("input-sort");
    By macBook = By.linkText("MacBook");
    By textMacBook = By.xpath("//h1[normalize-space()='MacBook']");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By macBookAddedText = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCart = By.linkText("shopping cart");
    By textShoppingCart = By.xpath("//h1[contains(text(),'Shopping Cart')]");
    By productNameMacBook = By.xpath("(//a[contains(text(),'MacBook')])[2]");
    By qty2 = By.cssSelector("input[value='1']");
    By updateTab = By.xpath("//i[@class='fa fa-refresh']");
    By modifiedCart = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By total = By.xpath("//tbody//tr//td[6]");
    By checkoutButton = By.xpath("//a[@class='btn btn-primary']");
    By textCheckout = By.xpath("//h1[normalize-space()='Checkout']");
    By newCustomer = By.xpath("//h2[normalize-space()='New Customer']");
    By guestCheckout = By.xpath("//input[@value='guest']");
    By continueTab = By.xpath("//input[@id='button-account']");
    By firstName = By.id("input-payment-firstname");
    By lastName = By.id("input-payment-lastname");
    By email = By.id("input-payment-email");
    By telephone = By.id("input-payment-telephone");
    By address = By.id("input-payment-address-1");
    By city = By.id("input-payment-city");
    By postCode = By.id("input-payment-postcode");
    By country = By.xpath("//select[@id='input-payment-country']");
    By region = By.xpath("//select[@id='input-payment-zone']");
    By continueButton = By.xpath("//input[@id='button-guest']");
    By comments = By.xpath("//textarea[@name='comment']");
    By termsAndCondition = By.xpath("//input[@name='agree']");
    By continue1 = By.xpath("//input[@id='button-payment-method']");
    By warningMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    By productPriceHighToLow = By.xpath("//div[@class='caption']//p[@class='price']");


    public void mouseHoverOnLaptopAndNotebooksTabAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooksTab);
    }

    public void clickOnShowAllLaptopsAndNotebooks() {
        clickOnElement(showAllLaptopsAndNotebooks);
    }

    public void selectSortByHighToLow() {
        selectByVisibleTextFromDropDown(sortBy, "Price (High > Low)");
    }

    public List<Double> beforeSortingPriceHighToLow() {
        List<WebElement> products = driver.findElements(productPriceHighToLow);
        List<Double> originalProductPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        //sort by reverse order
        Collections.sort(originalProductPrice, Collections.reverseOrder());
        System.out.println(originalProductPrice);
        return originalProductPrice;
    }


    public List<Double> afterSortingPriceHighToLow() {
        //After filter Price (High > Low) get all the products price and stored into array list
        List<WebElement> products = driver.findElements(productPriceHighToLow);
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        return afterSortByPrice;

    }

    public void clickOnMacBook() {
        clickOnElement(macBook);
    }

    public String verifyTextMacBook() {
        return getTextFromElement(textMacBook);
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

    public String getAddedMacBookText() {
        return getTextFromElement(macBookAddedText);
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCart);
    }

    public String verifyTextShoppingCart() {
        return getTextFromElement(textShoppingCart);
    }

    public String verifyProductNameMacBook() {
        return getTextFromElement(productNameMacBook);
    }

    public void changeQuantity() {
        clearValueFromTextBox(qty2);
        sendTextToElement(qty2, "2");
    }

    public void clickOnUpdateTab() {
        clickOnElement(updateTab);
    }

    public String verifyModifiedYourShoppingCart() {
        return getTextFromElement(modifiedCart);
    }

    public String verifyTotal() {
        return getTextFromElement(total);
    }

    public void clickOnCheckoutButton() {
        clickOnElement(checkoutButton);
    }

    public String verifyTheTextCheckout() {
        return getTextFromElement(textCheckout);
    }

    public String verifyTheTextNewCustomer() {
        return getTextFromElement(newCustomer);
    }

    public void clickOnGuestCheckOutRadioButton() {
        clickOnElement(guestCheckout);
    }

    public void clickOnContinueTab() {
        clickOnElement(continueTab);
    }

    public void enterFirstName() {
        sendTextToElement(firstName, "John");
    }

    public void enterLastName() {
        sendTextToElement(lastName, "Smith");
    }

    public void enterEmailId() {
        sendTextToElement(email, "john123@gmail.com");
    }

    public void enterTelephone() {
        sendTextToElement(telephone, "056981239");
    }

    public void enterAddress() {
        sendTextToElement(address, "CrossWay");
    }

    public void enterCity() {
        sendTextToElement(city, "Slough");
    }

    public void enterPostCode() {
        sendTextToElement(postCode, "363641");
    }

    public void selectCountryFromDropDown() {
        selectByVisibleTextFromDropDown(country, "United Kingdom");
    }

    public void selectRegionFromDropDown() {
        selectByVisibleTextFromDropDown(region, "Cardiff");
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void addCommentsAboutYourOrder() {
        sendTextToElement(comments, "I have added two products");
    }

    public void clickOnTermsAndConditionsCheckBox() {
        clickOnElement(termsAndCondition);
    }

    public void clickOnContinue() {
        clickOnElement(continue1);
    }

    public String verifyMessagePaymentMethodRequired() {
        return getTextFromElement(warningMessage);
    }


}
