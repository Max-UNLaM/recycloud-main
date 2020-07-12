package ar.edu.unlam.recycloud.app.puntoreciclaje;

public class EstadisticasPuntoReciclaje {

    private Integer eventosTotales;
    private Integer pinesTotales;
    private Integer pinesVisitas;
    private String categoriaMasBuscada;

    public Integer getEventosTotales() {
        return eventosTotales;
    }

    public void setEventosTotales(Integer eventosTotales) {
        this.eventosTotales = eventosTotales;
    }

    public Integer getPinesTotales() {
        return pinesTotales;
    }

    public void setPinesTotales(Integer pinesTotales) {
        this.pinesTotales = pinesTotales;
    }

    public Integer getPinesVisitas() {
        return pinesVisitas;
    }

    public void setPinesVisitas(Integer pinesVisitas) {
        this.pinesVisitas = pinesVisitas;
    }

    public String getCategoriaMasBuscada() {
        return categoriaMasBuscada;
    }

    public void setCategoriaMasBuscada(String categoriaMasBuscada) {
        this.categoriaMasBuscada = categoriaMasBuscada;
    }
}
