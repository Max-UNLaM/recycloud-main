package ar.edu.unlam.recycloud.web.pages.categorias;

import ar.edu.unlam.recycloud.web.pages.Scanner.ScannerModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class categoriaService {

    public static List<ScannerModel> listaDeCategorias = new ArrayList<>();

    public void setListaDeCategoria(ScannerModel x){

        if(x.getImagen() == "" | x.getCategoria() == ""){

        }else{listaDeCategorias.add(x);}
    }

    public List<ScannerModel> getListaDeCategoria(){
        return listaDeCategorias;
    }
}
