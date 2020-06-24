package org.usteniuk;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.usteniuk.pages.arrivals.Arrivals;
import org.usteniuk.pages.basket.Basket;
import org.usteniuk.driver.BaseTestClass;
import org.usteniuk.pages.home.Home;
import org.usteniuk.pages.shop.Shop;


public class HomePage extends BaseTestClass {
    Home home;
    Shop shop;
    Arrivals arrivals;
    Basket basket;

    @BeforeTest
    public void beforeTest() {
        goToUrl(Url.BASE_URL);
        home = new Home();
        shop = new Shop();
        arrivals = new Arrivals();
        basket = new Basket();
    }

    @Test(priority = 1)
    public void threeArrivalsOnly(){
        home.goToShop();
        shop.goToHome();
        Assert.assertEquals(home.countOfArrivals(), 3);

    }

    @Test(priority = 2)
    public void imagesInArrivalsShouldNavigate(){
        home.goToArrivals(home.numberOfArrivals(1));
        Assert.assertTrue(arrivals.addToBasketDisplay());
        arrivals.goToHome();

        home.goToArrivals(home.numberOfArrivals(2));
        Assert.assertTrue(arrivals.addToBasketDisplay());
        arrivals.goToHome();

        home.goToArrivals(home.numberOfArrivals(3));
        Assert.assertTrue(arrivals.addToBasketDisplay());
        arrivals.goToHome();
    }

    @Test(priority = 3)
    public void arrivalsImagesDescription(){
        home.goToArrivals(home.numberOfArrivals(1));
        arrivals.nameOfBook();
        Assert.assertTrue(arrivals.descriptionInclude());
        arrivals.goToHome();

        home.goToArrivals(home.numberOfArrivals(2));
        arrivals.nameOfBook();
        Assert.assertTrue(arrivals.descriptionInclude());
        arrivals.goToHome();

        home.goToArrivals(home.numberOfArrivals(3));
        arrivals.nameOfBook();
        Assert.assertTrue(arrivals.descriptionInclude());
        arrivals.goToHome();
    }

    @Test(priority = 4)
    public void arrivalsImagesReviews() throws InterruptedException {
        home.goToArrivals(home.numberOfArrivals(1));
        arrivals.goToReviews();
        Assert.assertTrue(arrivals.reviewsInclude());
        arrivals.goToHome();

        Thread.sleep(3000);
        home.goToArrivals(home.numberOfArrivals(2));
        arrivals.goToReviews();
        Assert.assertTrue(arrivals.reviewsInclude());
        arrivals.goToHome();

        home.goToArrivals(home.numberOfArrivals(3));
        arrivals.goToReviews();
        Assert.assertTrue(arrivals.reviewsInclude());
        arrivals.goToHome();
    }

    @Test(priority = 5)
    public void arrivalsImagesAddToBasket(){
        String nameOfBook;
        home.goToArrivals(home.numberOfArrivals(1));
        arrivals.addToBasket();
        Assert.assertTrue(arrivals.addBasketMasage());
        nameOfBook = arrivals.getName();
        arrivals.goToBasket();
        Assert.assertEquals(basket.getName(), nameOfBook);
        basket.removalOfBook();
        Assert.assertTrue(basket.removeBasketMassage().contains(nameOfBook + " removed."));
        basket.goToHome();

        home.goToArrivals(home.numberOfArrivals(2));
        arrivals.addToBasket();
        Assert.assertTrue(arrivals.addBasketMasage());
        nameOfBook = arrivals.getName();
        arrivals.goToBasket();
        Assert.assertEquals(basket.getName(), nameOfBook);
        basket.removalOfBook();
        Assert.assertTrue(basket.removeBasketMassage().contains(nameOfBook + " removed."));
        basket.goToHome();

        home.goToArrivals(home.numberOfArrivals(3));
        arrivals.addToBasket();
        Assert.assertTrue(arrivals.addBasketMasage());
        nameOfBook = arrivals.getName();
        arrivals.goToBasket();
        Assert.assertEquals(basket.getName(), nameOfBook);
        basket.removalOfBook();
        Assert.assertTrue(basket.removeBasketMassage().contains(nameOfBook + " removed."));
        basket.goToHome();
    }

    @Test(priority = 6) //Заведомо провальный тест
    public void failedTest(){
        home.goToShop();
        shop.goToHome();
        Assert.assertEquals(home.countOfArrivals(), 2);

    }
}
