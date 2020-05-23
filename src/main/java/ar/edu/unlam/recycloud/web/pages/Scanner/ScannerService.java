package ar.edu.unlam.recycloud.web.pages.scanner;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScannerService {

    public List<ScannerModel> TraerCategorias() {
        ScannerModel model1 = new ScannerModel("Plastico", "Botella");
        ScannerModel model2 = new ScannerModel("Plastico", "Tapa");
        List<ScannerModel> ListaDeCategorias = new ArrayList<>();
        ListaDeCategorias.add(model1);
        ListaDeCategorias.add(model2);

        return ListaDeCategorias;
    }
}
