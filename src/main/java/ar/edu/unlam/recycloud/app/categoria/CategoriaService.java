package ar.edu.unlam.recycloud.app.categoria;

import ar.edu.unlam.recycloud.app.categoriaEntrenada.CategoriaEntrenada;
import ar.edu.unlam.recycloud.app.categoriaEntrenada.CategoriaEntrenadaRepository;
import ar.edu.unlam.recycloud.app.categoriaInformacion.CategoriaInformacion;
import ar.edu.unlam.recycloud.app.categoriaInformacion.CategoriaInformacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaEntrenadaRepository categoriaEntrenadaRepository;
    private final CategoriaInformacionRepository categoriaInformacionRepository;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaEntrenadaRepository categoriaEntrenadaRepository, CategoriaInformacionRepository categoriaInformacionRepository) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaEntrenadaRepository = categoriaEntrenadaRepository;
        this.categoriaInformacionRepository = categoriaInformacionRepository;
    }

    public List<Categoria> findAll(){
      return categoriaRepository.findAll();
    }

    public List<Categoria> findAllFiltrada(){
        List<Categoria> categoria = categoriaRepository.findAll();
        List<CategoriaInformacion> categoriainfo = categoriaInformacionRepository.findAll();
        List<Categoria> cate =categoriaRepository.findAll();

        for (Categoria c : categoria){
            for (CategoriaInformacion ci : categoriainfo){

                if (c.getNombre().equals(ci.getCategoria().getNombre()))
                {
                    cate.remove(c);
                }
            }
        }
        return cate;
    }

    public void guardarCategoriaEntrenada(CategoriaEntrenada categoriaEntrenada){

        List<Categoria> categoria = categoriaRepository.findAll();
                Categoria cate = new Categoria();
                for (Categoria c : categoria) {
                    if (c.getNombre().equals(categoriaEntrenada.getCategoria().getNombre())) {
                        cate.setNombre(c.getNombre());
                        cate.setId(c.getId());
                    }
                }
                categoriaEntrenada.setCategoria(cate);
                categoriaEntrenadaRepository.save(categoriaEntrenada);
            }

    public void guardarCategoriaInformacion(CategoriaInformacion categoriaInformacion){
        List<Categoria> categoria = categoriaRepository.findAll();

        for (Categoria ca : categoria) {
            if(ca.getNombre().equals(categoriaInformacion.getCategoria().getNombre())) {
                Categoria cate = new Categoria();
                cate.setId(ca.getId());
                cate.setNombre(ca.getNombre());
                categoriaInformacion.setCategoria(cate);
                categoriaInformacionRepository.save(categoriaInformacion);
            }
        }
    }

    public CategoriaInformacion findFirstBy(){
        List<CategoriaInformacion> cate = categoriaInformacionRepository.findAll();
        if (cate.size() == 0){
        CategoriaInformacion ci = new CategoriaInformacion();
        Categoria c = new Categoria();
        c.setNombre("vacio");
        ci.setCategoria(c);
        ci.setComo("Vacio");
        ci.setDescripcion("vacio");
        ci.setDonde("vacio");
        ci.setTipos("Vacio");
        return ci;
        }
        return categoriaInformacionRepository.findFirstBy();
    }

    public CategoriaInformacion getCategoriaById(String cate){
        List<CategoriaInformacion> categoria = categoriaInformacionRepository.findAll();
        for (CategoriaInformacion ca : categoria) {
            if(ca.getCategoria().getNombre().equals(cate)) {
                return ca;
            }
        }
        return null;
    }
}
