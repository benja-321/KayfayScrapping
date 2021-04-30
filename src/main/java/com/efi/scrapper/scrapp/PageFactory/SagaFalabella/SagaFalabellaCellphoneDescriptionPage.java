package com.efi.scrapper.scrapp.PageFactory.SagaFalabella;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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

    public List<String> getListFeaturesName(){
        List<String> featuresName = new ArrayList<>();
        for (WebElement feature:cellphoneFeaturesName ) {
            featuresName.add(feature.getText());
        }
        return featuresName;
    }

    public List<String> getListFeaturesValues(){
        List<String> featuresValue = new ArrayList<>();
        for (WebElement feature:cellphoneFeaturesValue ) {
            featuresValue.add(feature.getText());
        }
        return featuresValue;
    }

    public HashMap<String,String> getCellphoneFeatures(List<String> cellphoneFeatures){
        HashMap<String,String> features = new HashMap<>();
        List<String> featuresSearched = new LinkedList<>(cellphoneFeatures);
        ArrayList<String> featuresName = new ArrayList<>();
        ArrayList<String> featuresValue = new ArrayList<>();
        try{
            featuresName = (ArrayList) this.getListFeaturesName();
            Thread.sleep(1000);
            featuresValue = (ArrayList) this.getListFeaturesValues();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = "";
        String value = "";
        int n = 0;
        boolean encontrados = false;
        while( !encontrados && n < featuresName.size()){
            name = featuresName.get(n);
            for( String featureName:featuresSearched){
                if( name.compareTo(featureName) == 0 ){
                    value = featuresValue.get(n);
                    features.put(name,value);
                    featuresSearched.remove(featureName);
                    encontrados = featuresSearched.isEmpty();
                }
            }
            n++;
        }
        return features;
    }


}
