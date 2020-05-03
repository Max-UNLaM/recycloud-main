package ar.edu.unlam.recycloud.web.pages.entrenamiento;

import org.springframework.stereotype.Service;

@Service
public class entrenamientoService {

    static entrenamientoModel lista = new entrenamientoModel();

    public void guardarClasificador(entrenamientoModel a){
        this.lista=a;
    }

    public entrenamientoModel traerClasificador(){
        return this.lista;
    }

}
