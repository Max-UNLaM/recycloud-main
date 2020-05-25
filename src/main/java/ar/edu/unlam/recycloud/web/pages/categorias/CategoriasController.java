package ar.edu.unlam.recycloud.web.pages.categorias;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import ar.edu.unlam.recycloud.app.categoria.CategoriaRepository;
import ar.edu.unlam.recycloud.app.categoria.CategoriaService;
import ar.edu.unlam.recycloud.app.categoriaEntrenada.CategoriaEntrenada;
import ar.edu.unlam.recycloud.app.categoriaEntrenada.CategoriaEntrenadaService;
import ar.edu.unlam.recycloud.app.categoriaInformacion.CategoriaInformacion;
import ar.edu.unlam.recycloud.app.categoriaInformacion.CategoriaInformacionRepository;
import ar.edu.unlam.recycloud.web.pages.login.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class CategoriasController {

    @Autowired
    private final CategoriaService categoriaService;
    @Autowired
    private final CategoriaEntrenadaService categoriaEntrenadaService;
    @Autowired
    private final CategoriaRepository categoriaRepository;
    @Autowired
    private final CategoriaInformacionRepository categoriaInformacionRepository;

    public CategoriasController(CategoriaService categoriaService, CategoriaEntrenadaService categoriaEntrenadaService, CategoriaRepository categoriaRepository, CategoriaInformacionRepository categoriaInformacionRepository) {
        this.categoriaService = categoriaService;
        this.categoriaEntrenadaService = categoriaEntrenadaService;
        this.categoriaRepository = categoriaRepository;
        this.categoriaInformacionRepository = categoriaInformacionRepository;
    }

    @RequestMapping(path = "/categoria/categoria")
    public ModelAndView read(HttpSession session) {
        LoginModel l = (LoginModel) session.getAttribute("usuario");
        if (l == null) {
            return new ModelAndView("/index");
        }
        if (l.getRol() != 1) {
            return new ModelAndView("/index");
        }

        ModelMap mod = new ModelMap();
        mod.put("categoriasEntrenada", this.categoriaEntrenadaService.findAll());
        mod.put("categorias", this.categoriaService.findAll());
        return new ModelAndView("categoria/categoria", mod);
    }

    @RequestMapping(path = "/categoria/guardarCategoriaEntrenamiento")
    public String read(@ModelAttribute CategoriaEntrenada categoria, HttpSession session) {
        LoginModel l = (LoginModel) session.getAttribute("usuario");
        if (l == null) {
            return ("/index");
        }
        if (l.getRol() != 1) {
            return ("/index");
        }
        categoriaService.guardarCategoriaEntrenada(categoria);
        return "redirect:/categoria/categoria";
    }
    @RequestMapping(path = "/categoria/guardarCategoria")
    public String read(@ModelAttribute Categoria categoria, HttpSession session) {
        LoginModel l = (LoginModel) session.getAttribute("usuario");
        if (l == null) {
            return ("/index");
        }
        if (l.getRol() != 1) {
            return ("/index");
        }
        categoriaRepository.save(categoria);
        return "redirect:/categoria/categoria";
    }

    @RequestMapping(path = "/categoria/guardarinformacion")
    public String infodos(@ModelAttribute CategoriaInformacion categoria, HttpSession session) {
        LoginModel l = (LoginModel) session.getAttribute("usuario");
        if (l == null) {
            return ("/index");
        }
        if (l.getRol() != 1) {
            return ("/index");
        }
        categoriaService.guardarCategoriaInformacion(categoria);
        return "redirect:/categoria/informacion";
    }
    @RequestMapping(path = "/categoria/informacion")
    public ModelAndView info(HttpSession session) {
        LoginModel l= (LoginModel) session.getAttribute("usuario");
        if(l == null){
            return new ModelAndView("/index");
        }
        if(l.getRol() != 1){
            return new ModelAndView("/index");
        }
        ModelMap mod = new ModelMap();
        mod.put("informacion",this.categoriaInformacionRepository.findAll());
        mod.put("categorias",this.categoriaService.findAllFiltrada());
        return new ModelAndView ("/categoria/informacion",mod);
    }

    @GetMapping(path = "/categoria/all")
    public ModelAndView llevarAPantallaTodo() {
        ModelMap model = new ModelMap();
        model.put("allcategoria",this.categoriaRepository.findAll());
        model.put("informacion",this.categoriaService.findFirstBy());
        return new ModelAndView ("/categoria/descripcion",model);
    }

    @GetMapping(path = "/categoria/{categoria}")
    public ModelAndView leerCategoria(@PathVariable String categoria) {
        ModelMap viewModel = new ModelMap();
        viewModel.put("informacion", categoriaService.getCategoriaById(categoria));
        viewModel.put("allcategoria",this.categoriaRepository.findAll());
        return new ModelAndView("/categoria/descripcion", viewModel);
    }
    @GetMapping(path = "/categoria/redirect/{categoria}")
    public ModelAndView llevarAPantalla(@PathVariable String categoria) {
        ModelMap model = new ModelMap();
        model.put("informacion", categoriaService.getCategoriaById(categoria));
        model.put("allcategoria",this.categoriaRepository.findAll());
        return new ModelAndView("/categoria/descripcion", model);
    }
}
