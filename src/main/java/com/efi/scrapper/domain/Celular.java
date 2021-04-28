package com.efi.scrapper.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Celular {

    @Id
    private int id;
    private String nombre;
    private String marca;
    private Integer pantalla;
    private String procesador;
    private Integer ram;
    private String camFrontal;
    private String camPosterior;
    private Integer memoInterna;
    private String sistemaOperativo;
    private Integer bateria;
    private List<Double> dimensiones;

    public Celular() {
    }

    public Celular(int id, String nombre, String marca, int pantalla, String procesador, int ram, String camFrontal,
                   String camPosterior, int memoInterna, String sistemaOperativo, int bateria, List<Double> dimensiones) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.pantalla = pantalla;
        this.procesador = procesador;
        this.ram = ram;
        this.camFrontal = camFrontal;
        this.camPosterior = camPosterior;
        this.memoInterna = memoInterna;
        this.sistemaOperativo = sistemaOperativo;
        this.bateria = bateria;
        this.dimensiones = dimensiones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getPantalla() {
        return pantalla;
    }

    public void setPantalla(Integer pantalla) {
        this.pantalla = pantalla;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getCamFrontal() {
        return camFrontal;
    }

    public void setCamFrontal(String camFrontal) {
        this.camFrontal = camFrontal;
    }

    public String getCamPosterior() {
        return camPosterior;
    }

    public void setCamPosterior(String camPosterior) {
        this.camPosterior = camPosterior;
    }

    public Integer getMemoInterna() {
        return memoInterna;
    }

    public void setMemoInterna(Integer memoInterna) {
        this.memoInterna = memoInterna;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public Integer getBateria() {
        return bateria;
    }

    public void setBateria(Integer bateria) {
        this.bateria = bateria;
    }

    public List<Double> getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(List<Double> dimensiones) {
        this.dimensiones = dimensiones;
    }
}
