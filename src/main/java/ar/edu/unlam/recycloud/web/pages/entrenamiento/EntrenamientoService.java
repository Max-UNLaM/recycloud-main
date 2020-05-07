package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import org.springframework.stereotype.Service;

@Service
public class EntrenamientoService {

    static Object lista = new Object();

    public void guardarClasificador(Object a) {

        String aux = a.toString();
        aux=aux.replaceAll("\\\\","locura123");
        aux= aux.replaceAll("\"","retraso123");
        this.lista=aux;
    }

    public Object traerClasificador() {
        return this.lista;
    }

}
