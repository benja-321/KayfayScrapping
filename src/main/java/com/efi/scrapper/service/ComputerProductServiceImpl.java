package com.efi.scrapper.service;

import com.efi.scrapper.domain.ComputerProduct;
import com.efi.scrapper.repository.ComputerProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerProductServiceImpl implements ComputerProductService {
    @Autowired
    private ComputerProductRepository computerProductRepository;

    @Override
    public void saveProduct(ComputerProduct product) {
        computerProductRepository.save(product);
    }

    @Override
    public int updateProduct(String ID, ComputerProduct product) {
        return 0;
    }

    @Override
    public ComputerProduct getProductById(String ID) {
        return null;
    }
}
