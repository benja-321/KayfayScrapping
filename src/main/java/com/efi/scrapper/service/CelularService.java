package com.efi.scrapper.service;

import java.util.List;

public interface CelularService {
    public void insertarCelular(int id, String nombre, String marca, int pantalla, String procesador, int ram, String camFrontal,
                                String camPosterior, int memoInterna, String sistemaOperativo, int bateria, List<Double> dimensiones);
}
