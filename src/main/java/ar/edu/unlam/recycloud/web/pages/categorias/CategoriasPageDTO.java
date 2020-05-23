package ar.edu.unlam.recycloud.web.pages.categorias;

import ar.edu.unlam.recycloud.app.categoria.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoriasPageDTO {
    List<String> nombresCategorias;
    Categoria categoria;
}
