package com.efi.scrapper.repository;

import com.efi.scrapper.domain.ComputerProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComputerProductRepository extends MongoRepository<ComputerProduct,String> {
}