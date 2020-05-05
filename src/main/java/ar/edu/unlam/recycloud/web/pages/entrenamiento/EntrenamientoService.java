package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import org.springframework.stereotype.Service;

@Service
public class EntrenamientoService {

    static Object lista = new Object();

    public void guardarClasificador(Object a) {
        this.lista = a;
    }

    public Object traerClasificador() {
        return this.lista;
    }

}
