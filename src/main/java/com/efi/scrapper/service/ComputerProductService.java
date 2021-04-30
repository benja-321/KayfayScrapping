package com.efi.scrapper.service;

import com.efi.scrapper.domain.ComputerProduct;

public interface ComputerProductService {
    public void saveProduct(ComputerProduct product);
    public int updateProduct(String ID, ComputerProduct product);
    public ComputerProduct getProductById(String ID);
}
