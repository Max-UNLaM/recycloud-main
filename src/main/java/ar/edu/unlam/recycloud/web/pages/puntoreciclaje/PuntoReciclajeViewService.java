package ar.edu.unlam.recycloud.web.pages.puntoreciclaje;

import ar.edu.unlam.recycloud.app.map.dialog.Dialog;
import ar.edu.unlam.recycloud.app.map.dialog.DialogService;
import ar.edu.unlam.recycloud.app.map.pin.Pin;
import ar.edu.unlam.recycloud.app.map.pin.PinService;
import ar.edu.unlam.recycloud.app.puntoreciclaje.PuntoReciclaje;
import ar.edu.unlam.recycloud.app.puntoreciclaje.PuntoReciclajeService;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import ar.edu.unlam.recycloud.web.pages.puntoreciclaje.edit.PuntoReciclajeCreateVMService;
import ar.edu.unlam.recycloud.web.pages.puntoreciclaje.edit.PuntoReciclajeEdit;
import ar.edu.unlam.recycloud.web.pages.puntoreciclaje.edit.PuntoReciclajeEditFactory;
import ar.edu.unlam.recycloud.web.pages.puntoreciclaje.edit.PuntoReciclajeEditViewModel;
import ar.edu.unlam.recycloud.web.pages.puntoreciclaje.home.PuntoReciclajeHomeVMService;
import ar.edu.unlam.recycloud.web.pages.puntoreciclaje.home.PuntoReciclajeHomeViewModel;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
class PuntoReciclajeViewService {

    private final DialogService dialogService;
    private final PinService pinService;
    private final PuntoReciclajeCreateVMService puntoReciclajeCreateVMService;
    private final PuntoReciclajeHomeVMService puntoReciclajeHomeVMService;
    private final PuntoReciclajeEditFactory puntoReciclajeEditFactory;
    private final PuntoReciclajeService puntoReciclajeService;

    PuntoReciclajeViewService(
            DialogService dialogService,
            PinService pinService, PuntoReciclajeCreateVMService puntoReciclajeCreateVMService,
            PuntoReciclajeHomeVMService puntoReciclajeHomeVMService,
            PuntoReciclajeEditFactory puntoReciclajeEditFactory,
            PuntoReciclajeService puntoReciclajeService
    ) {
        this.dialogService = dialogService;
        this.pinService = pinService;
        this.puntoReciclajeCreateVMService = puntoReciclajeCreateVMService;
        this.puntoReciclajeHomeVMService = puntoReciclajeHomeVMService;
        this.puntoReciclajeEditFactory = puntoReciclajeEditFactory;
        this.puntoReciclajeService = puntoReciclajeService;
    }

    PuntoReciclajeHomeViewModel buildHome(Usuario usuario) {
        return puntoReciclajeHomeVMService.build(usuario);
    }

    PuntoReciclajeEditViewModel buildCreate() {
        return puntoReciclajeCreateVMService.buildCreate();
    }

    PuntoReciclajeEditViewModel buildEdit(Long id) {
        return puntoReciclajeCreateVMService.buildEdit(id);
    }

    PuntoReciclajeEdit getPuntoReciclajeEditById(Long id) {
        PuntoReciclaje puntoReciclaje = puntoReciclajeService.getById(id);
        Dialog dialog = dialogService.getDialogFromDouble(puntoReciclaje.getCoordinatesAsDouble());
        return puntoReciclajeEditFactory.build(dialog);
    }

    public PuntoReciclaje getPuntoById(Long id) {
        return puntoReciclajeService.getById(id);
    }

    public PuntoReciclaje save(PuntoReciclajeEdit puntoEdit, Long userId) {
        create(buildPin(puntoEdit), buildDialog(puntoEdit));
        return savePunto(puntoEdit, userId);
    }

    public PuntoReciclaje update(PuntoReciclajeEdit puntoEdit, Long userId, Long puntoId) {
        Dialog dialog = buildDialog(puntoEdit);
        update(buildPin(puntoEdit), dialog);
        return updatePunto(puntoEdit, userId, puntoId);
    }

    private PuntoReciclaje savePunto(PuntoReciclajeEdit create, Long userId) {
        PuntoReciclaje puntoReciclaje = new PuntoReciclaje();
        puntoReciclaje.setCoordinates(create.getCoordinates());
        puntoReciclaje.setUsuarioId(userId);
        return puntoReciclajeService.create(puntoReciclaje);
    }

    private PuntoReciclaje updatePunto(PuntoReciclajeEdit create, Long userId, Long puntoId) {
        PuntoReciclaje puntoReciclaje = new PuntoReciclaje();
        puntoReciclaje.setCoordinates(create.getCoordinates());
        puntoReciclaje.setUsuarioId(userId);
        puntoReciclaje.setId(puntoId);
        return puntoReciclajeService.update(puntoReciclaje);
    }

    private Pin buildPin(PuntoReciclajeEdit puntoEdit) {
        Pin pin = new Pin();
        pin.setTitle(puntoEdit.getTitle());
        pin.setCategories(puntoEdit.getCategoriesAsList());
        pin.setLocation(puntoEdit.getLocation());
        return pin;
    }

    private Dialog buildDialog(PuntoReciclajeEdit puntoEdit) {
        Dialog dialog = new Dialog();
        dialog.setAddress(puntoEdit.getAddress());
        dialog.setCategories(puntoEdit.getCategoriesAsList());
        dialog.setLink(puntoEdit.getLink());
        dialog.setSchedule(puntoEdit.getFullHour());
        dialog.setDays(Collections.singletonList(puntoEdit.getDays()));
        dialog.setFirstHeading(puntoEdit.getTitle());
        dialog.setLocation(puntoEdit.getLocation());
        dialog.setBodyContent(puntoEdit.getContent());
        return dialog;
    }

    private void create(Pin pin, Dialog dialog) {
        this.pinService.set(pin);
        this.dialogService.createDialog(dialog);
    }

    private void update(Pin pin, Dialog dialog) {
        this.pinService.update(pin);
        this.dialogService.updateDialog(dialog);
    }

}
