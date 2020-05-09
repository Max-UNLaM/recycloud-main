package ar.edu.unlam.recycloud.web.pages.Scanner;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class ScannerModel {

    public ScannerModel(String categoria, String imagen) {
        this.categoria = categoria;
        this.imagen = imagen;
    }

    private String categoria;
    private String imagen;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
