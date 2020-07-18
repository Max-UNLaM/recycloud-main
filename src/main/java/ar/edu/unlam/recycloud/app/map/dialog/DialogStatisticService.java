package ar.edu.unlam.recycloud.app.map.dialog;

import ar.edu.unlam.recycloud.app.statistics.StatisticService;
import ar.edu.unlam.recycloud.app.statistics.models.PuntoStatistic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DialogStatisticService {
    private final StatisticService statisticService;
    private final DialogService dialogService;

    public DialogStatisticService(
            StatisticService statisticService,
            DialogService dialogService
    ) {
        this.statisticService = statisticService;
        this.dialogService = dialogService;
    }

    public List<PuntoStatistic> getTopDialogs(int year, int month) {
        List<PuntoStatistic> dialogsList = new ArrayList<>();
        this.statisticService.getTopLocation(year, month).forEach(
                (location, count) -> {
                    try {
                        dialogsList.add(
                                new PuntoStatistic(
                                        dialogService.getDialogFromLocation(location).getAddress(),
                                        count
                                )
                        );
                    } catch (NullPointerException npe) {
                        System.out.println(String.format("Error al traer: %s %s", location.get(0), location.get(1)));
                    }
                }
        );
        return dialogsList;
    }
}
