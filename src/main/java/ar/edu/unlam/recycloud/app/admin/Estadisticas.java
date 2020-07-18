package ar.edu.unlam.recycloud.app.admin;

public class Estadisticas {

    private Integer usuariosTotales;
    private Integer usuariosTotalesRol1;
    private Integer usuariosTotalesRol2;
    private Integer usuariosTotalesRol3;
    private Integer categoriasTotales;
    private Integer activo;
    private Integer total;
    private Integer inactivo;

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getInactivo() {
        return inactivo;
    }

    public void setInactivo(Integer inactivo) {
        this.inactivo = inactivo;
    }

    public Integer getUsuariosTotales() {
        return usuariosTotales;
    }

    public void setUsuariosTotales(Integer usuariosTotales) {
        this.usuariosTotales = usuariosTotales;
    }

    public Integer getUsuariosTotalesRol1() {
        return usuariosTotalesRol1;
    }

    public void setUsuariosTotalesRol1(Integer usuariosTotalesRol1) {
        this.usuariosTotalesRol1 = usuariosTotalesRol1;
    }

    public Integer getUsuariosTotalesRol2() {
        return usuariosTotalesRol2;
    }

    public void setUsuariosTotalesRol2(Integer usuariosTotalesRol2) {
        this.usuariosTotalesRol2 = usuariosTotalesRol2;
    }

    public Integer getUsuariosTotalesRol3() {
        return usuariosTotalesRol3;
    }

    public void setUsuariosTotalesRol3(Integer usuariosTotalesRol3) {
        this.usuariosTotalesRol3 = usuariosTotalesRol3;
    }

    public Integer getCategoriasTotales() {
        return categoriasTotales;
    }

    public void setCategoriasTotales(Integer categoriasTotales) {
        this.categoriasTotales = categoriasTotales;
    }
}
