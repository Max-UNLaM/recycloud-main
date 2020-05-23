package ar.edu.unlam.recycloud.web.pages.categorias;


import ar.edu.unlam.recycloud.web.pages.scanner.ScannerModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    public static List<ScannerModel> listaDeCategorias = new ArrayList<>();
    public static List<informacionModel> listaDeInformacion = new ArrayList<>();

    public List<ScannerModel> getListaDeCategoria() {
        return listaDeCategorias;
    }

    public void setListaDeCategoria(ScannerModel x) {

        if (x.getImagen() == "" | x.getCategoria() == "") {
        } else {
            listaDeCategorias.add(x);
        }
    }

    public List<informacionModel> getListaDeInformacion() {
        return listaDeInformacion;
    }

    public void setListaDeInformacion(informacionModel x) {

        if (x.getCategoria() == "" | x.getComo() == "" | x.getDescripcion() == "" | x.getDonde() == "" | x.getTipos() == "") {

        } else {
            listaDeInformacion.add(x);
        }
    }

    public informacionModel getListaDeInformacionFiltrada(String x) {
        for (informacionModel i : listaDeInformacion) {
            if (i.getCategoria().equals(x)) {
                informacionModel info = i;
                return info;
            }
        }
        return null;
    }

    public informacionModel getListaDeInformacionFiltrada2() {
        for (informacionModel i : listaDeInformacion) {
            informacionModel info = i;
            return info;
        }
        return new informacionModel("Vacio", "Vacio", "Vacio", "Vacio", "Vacio");
    }

}
