package org.usteniuk.pages.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.usteniuk.driver.DriverHolder;
import org.usteniuk.pages.home.Home;

public class Shop {
    @FindBy(xpath = "//*[@href = 'http://practice.automationtesting.in']")
    WebElement home;


    public Home goToHome(){
        home.click();
        return new Home();
    }

    public Shop(){
        PageFactory.initElements(DriverHolder.getInstance().getDriver(),this);
    }

}