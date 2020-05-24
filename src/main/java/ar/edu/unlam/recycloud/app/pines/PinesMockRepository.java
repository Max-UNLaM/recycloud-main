package ar.edu.unlam.recycloud.app.pines;

import ar.edu.unlam.recycloud.app.utils.GsonTools;
import ar.edu.unlam.recycloud.app.utils.JsonTools;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static ar.edu.unlam.recycloud.conf.ProjectConstants.MOCK_PATH;

@Service
public class PinesMockRepository implements PinesRepository {

    private static final String PIN_MOCK = "/pines.json";
    JsonTools jsonTools;

    PinesMockRepository(GsonTools gsonTools) {
        this.jsonTools = gsonTools;
    }

    @Override
    public Pin[] findAll() {
        try {
            return jsonTools.loadFile(MOCK_PATH + PIN_MOCK, Pin[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Pin[]{};
        }
    }
}
