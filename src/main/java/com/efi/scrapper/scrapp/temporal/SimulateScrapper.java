package com.efi.scrapper.scrapp.temporal;

import com.efi.scrapper.domain.Category;
import com.efi.scrapper.domain.ComputerProduct;
import com.efi.scrapper.service.ComputerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SimulateScrapper {

    @Autowired
    ComputerProductService computerProductService;

    public static HashMap<String, String> fillHashMapSmarthPhone(){
        HashMap<String, String> smarthphoneEsp = new HashMap<>();
        smarthphoneEsp.put("NAME","XIAOMI MI 10T 6GB 128GB NEGRO");
        smarthphoneEsp.put("BRAND","XIAOMY");
        smarthphoneEsp.put("MODEL","MI 10T");
        smarthphoneEsp.put("CATEGORY","Celulares");
        smarthphoneEsp.put("WARRANTY","1 AÑO");
        smarthphoneEsp.put("REAR_CAMERA","64+13+5MP");
        smarthphoneEsp.put("FRONT_CAMERA","20MP");
        smarthphoneEsp.put("SCREEN_SIZE","6.67 pulgadas");
        smarthphoneEsp.put("MEMORY","128GB");
        smarthphoneEsp.put("PROCESSOR","SD865 Octacore");
        smarthphoneEsp.put("VELOCITY_CPU","2.84 GHz");
        smarthphoneEsp.put("RAM","6GB");
        smarthphoneEsp.put("BATTERY","5000 mAh");
        smarthphoneEsp.put("DIMENSIONS","(16.5x7.64x0.96)");

        return smarthphoneEsp;
    }

    public static ComputerProduct hashMaptoObjetc(HashMap<String, String> smartPhoneEspec){
        return new ComputerProduct
                .ComputerProductBuilder(null, smartPhoneEspec.get("NAME"), smartPhoneEspec.get("MODEL"),
                                        smartPhoneEspec.get("BRAND"), smartPhoneEspec.get("WARRANTY"),
                                        new Category(1, smartPhoneEspec.get("CATEGORY"),1) )
                .setRearCamera(smartPhoneEspec.get("REAR_CAMERA"))
                .setFrontCamera(smartPhoneEspec.get("FRONT_CAMERA"))
                .setScreenSize(smartPhoneEspec.get("SCREEN_SIZE"))
                .setMemory(smartPhoneEspec.get("MEMORY"))
                .setProcessor(smartPhoneEspec.get("PROCESSOR"))
                .setVelocityCPU(smartPhoneEspec.get("VELOCITY_CPU"))
                .setRAM(smartPhoneEspec.get("RAM"))
                .setBattery(smartPhoneEspec.get("BATTERY"))
                .setDimensions(smartPhoneEspec.get("DIMENSIONS"))
                .build();
    }

    //ignore,  use polimorfism later
    public void storeProducts(Object product){
        String className = product.getClass().getSimpleName();

        switch (className){
            case "ComputerProduct": computerProductService.saveProduct((ComputerProduct) product); break;
            case "HomeProduct": break;
        }
    }

    public void scrapShop(String URLShop){
        System.out.println(URLShop);
        HashMap<String, String> productHashMap = fillHashMapSmarthPhone();
        System.out.println("Caracteristicas de Producto scrapeado");
        ComputerProduct product = hashMaptoObjetc(productHashMap);
        computerProductService.saveProduct(product);
        System.out.println("Producto guardado!");
    }
}
