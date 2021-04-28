package com.efi.scrapper.service;

import com.efi.scrapper.repository.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CelularServiceImpl implements CelularService{

    @Autowired
    CelularRepository celularRepository;

    @Override
    public void insertarCelular(int id, String nombre, String marca, int pantalla, String procesador, int ram, String camFrontal,
                                String camPosterior, int memoInterna, String sistemaOperativo, int bateria, List<Double> dimensiones) {

    }

}
