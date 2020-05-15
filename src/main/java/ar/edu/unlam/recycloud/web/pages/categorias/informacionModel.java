package ar.edu.unlam.recycloud.web.pages.categorias;

public class informacionModel {

    private String categoria;
    private String descripcion;
    private String tipos;
    private String como;
    private String donde;

    public informacionModel(String categoria, String tipos, String como, String donde, String descripcion) {
        this.categoria = categoria;
        this.tipos = tipos;
        this.como = como;
        this.donde = donde;
        this.descripcion=descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        this.tipos = tipos;
    }

    public String getComo() {
        return como;
    }

    public void setComo(String como) {
        this.como = como;
    }

    public String getDonde() {
        return donde;
    }

    public void setDonde(String donde) {
        this.donde = donde;
    }
}
