package com.efi.scrapper.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This class groups products that have processing like computers, laptops, smartphones also
 * products that are related to these like PC peripheries or mobile accessories.
 * We are using Builder Pattern to build these complex objects, notice we are using a improved
 * version of the Builder pattern introduced by J. Bloch in his book Effective Java.
 */
@Document("computer_products")
public class ComputerProduct {
    @Id
    private String id;
    private String name;
    private String model;
    private String brand;
    private String warranty;
    private Category category;
    @Field("screen_size")
    private String screenSize;
    private String processor;
    @Field("velocity_cpu")
    private String velocityCPU;
    private String RAM;
    @Field("front_camera")
    private String frontCamera;
    @Field("rear_camera")
    private String rearCamera;
    private String dimensions;
    private String color;
    private String memory;
    @Field("capacity_storage")
    private String capacityStorage;
    @Field("operating_system")
    private String operatingSystem;
    private String battery;

    public ComputerProduct(ComputerProductBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.model = builder.model;
        this.brand = builder.brand;
        this.warranty = builder.warranty;
        this.category = builder.category;
        this.screenSize = builder.screenSize;
        this.processor = builder.processor;
        this.velocityCPU = builder.velocityCPU;
        this.RAM = builder.RAM;
        this.frontCamera = builder.frontCamera;
        this.rearCamera = builder.rearCamera;
        this.dimensions = builder.dimensions;
        this.color = builder.color;
        this.memory = builder.memory;
        this.capacityStorage = builder.capacityStorage;
        this.operatingSystem = builder.operatingSystem;
        this.battery = builder.battery;
    }

    public static class ComputerProductBuilder{
        private String id;
        private String name;
        private String model;
        private String brand;
        private String warranty;
        private Category category;
        private String screenSize;
        private String processor;
        private String velocityCPU;
        private String RAM;
        private String frontCamera;
        private String rearCamera;
        private String dimensions;
        private String color;
        private String memory;
        private String capacityStorage;
        private String operatingSystem;
        private String battery;

        //All Mandatory parameters goes with this constructor
        public ComputerProductBuilder(String id, String name, String model, String brand, String warranty, Category category) {
            this.id = id;
            this.name = name;
            this.model = model;
            this.brand = brand;
            this.warranty = warranty;
            this.category = category;
        }

        public ComputerProductBuilder setId(String id){
            this.id = id;
            return this;
        }

        public ComputerProductBuilder setName(String name){
            this.name = name;
            return this;
        }

        public ComputerProductBuilder setModel(String model){
            this.model = model;
            return this;
        }

        public ComputerProductBuilder setBrand(String brand){
            this.brand = brand;
            return this;
        }

        public ComputerProductBuilder setWarranty(String warranty){
            this.warranty = warranty;
            return this;
        }

        public ComputerProductBuilder setCategory(Category category){
            this.category = category;
            return this;
        }

        //setters for optional parameters which returns this same builder
        //to support fluent design
        public ComputerProductBuilder setScreenSize(String screenSize){
            this.screenSize = screenSize;
            return this;
        }

        public ComputerProductBuilder setProcessor(String processor){
            this.processor = processor;
            return this;
        }

        public ComputerProductBuilder setVelocityCPU(String velocityCPU){
            this.velocityCPU = velocityCPU;
            return this;
        }

        public ComputerProductBuilder setRAM(String RAM){
            this.RAM = RAM;
            return this;
        }

        public ComputerProductBuilder setFrontCamera(String frontCamera){
            this.frontCamera = frontCamera;
            return this;
        }

        public ComputerProductBuilder setRearCamera(String rearCamera){
            this.rearCamera = rearCamera;
            return this;
        }

        public ComputerProductBuilder setDimensions(String dimensions){
            this.dimensions = dimensions;
            return this;
        }

        public ComputerProductBuilder setColor(String color){
            this.color = color;
            return this;
        }

        public ComputerProductBuilder setMemory(String memory){
            this.memory = memory;
            return this;
        }

        public ComputerProductBuilder setCapacityStorage(String capacityStorage){
            this.capacityStorage = capacityStorage;
            return this;
        }

        public ComputerProductBuilder setOperatingSystem(String operatingSystem){
            this.operatingSystem = operatingSystem;
            return this;
        }

        public ComputerProductBuilder setBattery(String battery){
            this.battery = battery;
            return this;
        }

        public ComputerProduct build(){
            return new ComputerProduct(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getWarranty() {
        return warranty;
    }

    public Category getCategory() {
        return category;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public String getProcessor() {
        return processor;
    }

    public String getVelocityCPU() {
        return velocityCPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public String getRearCamera() {
        return rearCamera;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String getColor() {
        return color;
    }

    public String getMemory() {
        return memory;
    }

    public String getCapacityStorage() {
        return capacityStorage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getBattery() {
        return battery;
    }
}
