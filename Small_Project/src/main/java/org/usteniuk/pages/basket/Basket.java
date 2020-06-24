package org.usteniuk.pages.basket;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.usteniuk.driver.DriverHolder;
import org.usteniuk.pages.home.Home;

public class Basket {
    @FindBy(xpath = "//tbody/tr/td[@class = 'product-name']")
    WebElement name;

    @FindBy(xpath = "//*[@class = 'remove']")
    WebElement removal;

    @FindBy(xpath = "//*[@href = 'http://practice.automationtesting.in']")
    WebElement home;

    @FindBy(xpath = "//*[@class = 'woocommerce-message']")
    WebElement removeBasketMasage;

    public Home goToHome(){
        home.click();
        return new Home();
    }

    public String getName(){
        return name.getText();
    }

    public Basket removalOfBook(){
        removal.click();
        return new Basket();
    }

    public String removeBasketMassage(){
        return removeBasketMasage.getText();
    }

    public Basket(){
        PageFactory.initElements(DriverHolder.getInstance().getDriver(),this);
    }
}

