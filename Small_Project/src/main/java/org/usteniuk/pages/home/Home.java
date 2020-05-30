package org.usteniuk.pages.home;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.usteniuk.pages.arrivals.Arrivals;
import org.usteniuk.driver.DriverHolder;
import org.usteniuk.pages.shop.Shop;

import java.util.List;

public class Home {
    @FindBy (xpath = "//*[text()='Shop']")
    WebElement shop;

    @FindBy (xpath = "//*[@class='products']")
    List<WebElement> arrivals;

    @FindBy (xpath = "//*[@class = 'attachment-shop_catalog size-shop_catalog wp-post-image']")
    List<WebElement> imageArrivals;

    public Shop goToShop(){
        shop.click();
        return new Shop();
    }

    public int countOfArrivals(){
        return arrivals.size();
    }

    public WebElement numberOfArrivals(int number){
        WebElement numberA = null;
        for ( int i = number - 1; i < imageArrivals.size(); i++){
            numberA = imageArrivals.get(i);
            break;
        }
        return numberA;
    }

    public Arrivals goToArrivals(WebElement webElement){
        webElement.click();
        return new Arrivals();
    }



    public Home(){
        PageFactory.initElements(DriverHolder.getInstance().getDriver(),this);
    }


}
