package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import ar.edu.unlam.recycloud.app.utils.GsonTools;
import ar.edu.unlam.recycloud.app.utils.JsonTools;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

import static ar.edu.unlam.recycloud.conf.ProjectConstants.MOCK_PATH;

@Component
public class DialogMockRepository implements DialogRepository {

    private static final String DIALOG_MOCK = "/dialogs.json";
    JsonTools jsonTools;

    DialogMockRepository(GsonTools gsonTools) {
        this.jsonTools = gsonTools;
    }

    @Override
    public Dialog findByLocation(Location location) {
        try {
            Dialog[] dialogs = jsonTools.loadFile(MOCK_PATH + DIALOG_MOCK, Dialog[].class);
            return Arrays.stream(dialogs)
                    .filter(dialog -> dialog.location.equals(location))
                    .findFirst()
                    .orElse(new Dialog());
        } catch (IOException ioException) {
            return new Dialog();
        }
    }

    @Override
    public void setDialog(Dialog dialog) {
    }

    @Override
    public void updateDialog(Dialog dialog) {

    }
}
