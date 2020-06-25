package ar.edu.unlam.recycloud.web.pages.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {

    private final MapPageService mapPageService;

    public MapController(MapPageService mapPageService) {
        this.mapPageService = mapPageService;
    }

    @GetMapping("/map")
    public ModelAndView home() {
        return mapPageService.build();
    }
}
