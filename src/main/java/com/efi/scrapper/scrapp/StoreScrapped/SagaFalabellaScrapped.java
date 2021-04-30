package com.efi.scrapper.scrapp.StoreScrapped;

import com.efi.scrapper.scrapp.PageFactory.SagaFalabella.SagaFalabellaCellphoneDescriptionPage;
import com.efi.scrapper.scrapp.PageFactory.SagaFalabella.SagaFalabellaCellphonesPage;
import com.efi.scrapper.scrapp.PageFactory.SagaFalabella.SagaFalabellaHomePage;
import com.efi.scrapper.service.CelularService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class SagaFalabellaScrapped {

    public static final String[] FEATURES_CELLPHONE = {"Nombre comercial","Marca"};

    @Autowired
    CelularService celularService;

    public void start(String urlFalabella){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("window-size=800,480");
        WebDriver driverHome = new ChromeDriver(chromeOptions);
        driverHome.get(urlFalabella);
        SagaFalabellaHomePage homePage = new SagaFalabellaHomePage(driverHome);
        String urlCellphonesPage = homePage.getLinkToProducts("cellphone");
        if(!urlCellphonesPage.isBlank()){
            WebDriver driverCellphones = new ChromeDriver(chromeOptions);
            driverCellphones.get(urlCellphonesPage);
            SagaFalabellaCellphonesPage cellphonesPage = new SagaFalabellaCellphonesPage(driverCellphones);
            List<String> urlCellphonesDescription = cellphonesPage.getLinkCellphonesCard();
            WebDriver driverCellphoneDescription = new ChromeDriver(chromeOptions);
            SagaFalabellaCellphoneDescriptionPage cellphoneDescriptionPage;
            HashMap<String,String> cellphoneFeatures = new HashMap<>();
            List<String> featuresCellphone = new ArrayList<>();
            featuresCellphone = Arrays.asList(FEATURES_CELLPHONE);
            for( String urlCellphoneDescription : urlCellphonesDescription){
                driverCellphoneDescription.get(urlCellphoneDescription);
                cellphoneDescriptionPage = new SagaFalabellaCellphoneDescriptionPage(driverCellphoneDescription);
                cellphoneFeatures = cellphoneDescriptionPage.getCellphoneFeatures(featuresCellphone);
                System.out.println(cellphoneFeatures.toString());
            }
            driverCellphoneDescription.close();
            driverCellphones.close();
        }
        driverHome.close();
    }
}
