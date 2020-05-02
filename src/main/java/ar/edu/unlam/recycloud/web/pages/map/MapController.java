package ar.edu.unlam.recycloud.web.pages.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @GetMapping("/map")
    public String home() {
        return "/map/map";
    }
}
