package com.efi.scrapper.scrapp.PageFactory.SagaFalabella;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SagaFalabellaHomePage {

    WebDriver driver;
    @FindBy(xpath = "//div[@id=\"header-med-categories-menu-CategoryMenu-1df0cec7-821b-4456-ad50-2c712dfbd7b4\"]/div[1]")
    List<WebElement> homePageIconMenu;
    @FindBy(xpath = "//div[@id=\"header-med-categories-menu-CategoryMenu-1df0cec7-821b-4456-ad50-2c712dfbd7b4\"]/div[2]/div[1]/div")
    List<WebElement> homePageCategories;
    @FindBy(xpath = "//div[@id=\"header-med-categories-menu-CategoryMenu-1df0cec7-821b-4456-ad50-2c712dfbd7b4\"]/div[2]/div[1]/div[1]/div[2]/div/div")
    List<WebElement> homePageSubMenus;
    @FindBys({
            @FindBy(xpath = "//*[@id=\"header-med-categories-menu-CategoryMenu-1df0cec7-821b-4456-ad50-2c712dfbd7b4\"]/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[2]/ul/li"),
            @FindBy(tagName = "a")
    })
    WebElement homePageCellphoneCategory;
    @FindBy(className = "dy-lb-close")
    WebElement homePageClosePublicity;
    /*@FindBy(id = "acc-alert-close")
    WebElement closeNotification;*/

    public SagaFalabellaHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickIconMenu(){
        homePageIconMenu.get(0).click();
    }

    public void clickTechnologyCategory(){
        homePageCategories.get(0).click();
    }

    public void clickTelephoneMenu(){
        homePageSubMenus.get(1).click();
    }

    public String getLinkToCellphone(){
        return homePageCellphoneCategory.getAttribute("href");
    }

    public void clickClosePublicity(){
        homePageClosePublicity.click();
    }

    public String getLinkToProducts(String product){
        String url = "";
        //closeNotification.click();
        try{
            this.clickClosePublicity();
            this.clickIconMenu();
            Thread.sleep(1000);
            this.clickTechnologyCategory();
            Thread.sleep(1000);
            switch(product){
                case "cellphone":
                    this.clickTelephoneMenu();
                    url = this.getLinkToCellphone();
                    break;

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return url;
    }
}
