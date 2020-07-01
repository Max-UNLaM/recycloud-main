package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.geolocation.Location;

public interface DialogRepository {
    Dialog findByLocation(Location location);
    void setDialog(Dialog dialog);
    void updateDialog(Dialog dialog);
}
