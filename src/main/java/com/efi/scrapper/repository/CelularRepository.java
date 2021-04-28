package com.efi.scrapper.repository;

import com.efi.scrapper.domain.Celular;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CelularRepository extends MongoRepository<Celular,Integer> {
}
