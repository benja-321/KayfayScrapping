package com.efi.scrapper.scrapp.PageFactory.SagaFalabella;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SagaFalabellaCellphonesPage {

    WebDriver driver;
    @FindBys({
            @FindBy(xpath = "//div[@id=\"testId-searchResults-products\"]/div"),
            @FindBy(tagName = "a")
    })
    List<WebElement> cellphoneCards;
    @FindBy(xpath = "//button[@id=\"testId-pagination-top-arrow-right\"]")
    WebElement cellphonePageNext;
    /*@FindBy(id = "acc-alert-close")
    WebElement closeNotification;*/

    public SagaFalabellaCellphonesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public List<String> getLinkCellphonesCard(){
        //closeNotification.click();
        List<String> links = new ArrayList<String>();
        String link;
        links.add(cellphoneCards.get(0).getAttribute("href"));
        int m = 0;
        for(int n = 1; n < cellphoneCards.size(); n++){
            link = cellphoneCards.get(n).getAttribute("href");
            if( !links.get(m).equals(link) ){
                links.add(link);
                m += 1;
            }
        }
        return links;
    }
}
