package Illiushchenia.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.inject.Inject;

/**
 * Created by a.illiushchenia on 14.11.2016.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private final SpitterService spitterService;

    @Inject
    public SpitterController(SpitterService spitterService){
        this.spitterService = spitterService;
    }

    @RequestMapping(value="/spittles", method=GET)
    public String listSpittlesForSpitter(
            @RequestParam("spitter") String username, Model model){
        Spitter spitter = spitterService.getSpinner(username);
        model.addAttribute(spitter);
        model.addAttribute(spitterService.getSpittlesForSpitter(username));

        return "spittles/list";
    }
}
