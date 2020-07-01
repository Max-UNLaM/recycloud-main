package ar.edu.unlam.recycloud.app.map.pin;

import ar.edu.unlam.recycloud.app.utils.GsonTools;
import ar.edu.unlam.recycloud.app.utils.JsonTools;
import com.google.inject.internal.util.Lists;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static ar.edu.unlam.recycloud.conf.ProjectConstants.MOCK_PATH;

@Service
public class PinMockRepository implements PinRepository<Pin> {

    private static final String PIN_MOCK = "/pines.json";
    JsonTools jsonTools;

    PinMockRepository(GsonTools gsonTools) {
        this.jsonTools = gsonTools;
    }

    @Override
    public List<Pin> findAll() {
        try {
            return Lists.newArrayList(jsonTools.loadFile(MOCK_PATH + PIN_MOCK, Pin[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return Lists.newArrayList(new Pin());
        }
    }

    @Override
    public List<Pin> find(Bson filter) {
        return null;
    }

    @Override
    public List<Pin> find(Map<String, String> filters) {
        return null;
    }

    @Override
    public void setPunto(Pin punto) {

    }

    @Override
    public void updatePunto(Pin pin) {

    }
}
