package org.usteniuk.pages.arrivals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.usteniuk.pages.basket.Basket;
import org.usteniuk.driver.DriverHolder;
import org.usteniuk.pages.home.Home;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Arrivals {
    List<String> nameBook = new ArrayList<>();

    @FindBy(xpath = "//*[@href = 'http://practice.automationtesting.in']")
    WebElement home;

    @FindBy (xpath = "//*[@class='single_add_to_cart_button button alt']")
    WebElement addToBasket;

    @FindBy(xpath = "//*[@class = 'product_title entry-title']")
    WebElement name;

    @FindBy(id = "tab-description")
    WebElement description;

    @FindBy(xpath = "//*[@href = '#tab-reviews']")
    WebElement reviews;

    @FindBy(xpath = "//*[@class = 'comment-reply-title']")
    WebElement reviewsBook;

    @FindBy(id = "wpmenucartli")
    WebElement basket;

    @FindBy(xpath = "//*[@class = 'woocommerce-message']")
    WebElement addBasketMasage;

    public Home goToHome(){
        home.click();
        return new Home();
    }

    public Arrivals addToBasket(){
        addToBasket.click();
        return new Arrivals();
    }

    public boolean addToBasketDisplay(){
        return addToBasket.isDisplayed();
    }

    public void nameOfBook(){
        for(String s: name.getText().split(" ")){
            nameBook.add(s);
        }
    }

    public String getName(){
        return name.getText();
    }

    public boolean addBasketMasage(){
        return addBasketMasage.getText().contains("has been added to your basket");
    }

    public Basket goToBasket(){
        basket.click();
        return new Basket();
    }

    public boolean descriptionInclude(){
        for (int i = 0; i < nameBook.size(); i++){
            if (description.getText().toLowerCase().contains(nameBook.get(i).toLowerCase())){
                return true;
            }
        }        
        return  false;
    }

    public Arrivals goToReviews(){
        reviews.click();
        return new Arrivals();
    }

    public  boolean reviewsInclude(){
        return reviewsBook.getText().toLowerCase().contains(name.getText().toLowerCase());
    }


    public Arrivals(){
        PageFactory.initElements(DriverHolder.getInstance().getDriver(),this);
    }
}
