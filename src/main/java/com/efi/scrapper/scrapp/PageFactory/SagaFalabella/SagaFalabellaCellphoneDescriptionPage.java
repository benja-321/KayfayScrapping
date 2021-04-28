package com.efi.scrapper.scrapp.PageFactory.SagaFalabella;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SagaFalabellaCellphoneDescriptionPage {

    WebDriver driver;
    @FindBys({
            @FindBy(xpath = "//tbody[@class=\"jsx-428502957\"]"),
            @FindBy(tagName = "tr"),
            @FindBy(className = "property-name")
    })
    List<WebElement> cellphoneFeaturesName;
    @FindBys({
            @FindBy(xpath = "//tbody[@class=\"jsx-428502957\"]"),
            @FindBy(tagName = "tr"),
            @FindBy(className = "property-value")
    })
    List<WebElement> cellphoneFeaturesValue;
    /*@FindBy(id = "acc-alert-close")
    WebElement closeNotification;*/
    
    public SagaFalabellaCellphoneDescriptionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getCellphoneName(){
        String name = "";
        String feature = "";
        int n = 0;
        boolean encontrado = false;
        while( !encontrado && n < cellphoneFeaturesName.size()){
            feature = cellphoneFeaturesName.get(n).getText();
            if( feature.compareTo("Cámara posterior") == 0 ){
                name = cellphoneFeaturesValue.get(n).getText();
                encontrado = true;
            }
            n++;
        }
        return name;
    }

}
