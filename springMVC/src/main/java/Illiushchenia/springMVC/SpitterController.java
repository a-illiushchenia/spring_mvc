package Illiushchenia.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.inject.Inject;
import javax.validation.Valid;

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
        Spitter spitter = spitterService.getSpitter(username);
        model.addAttribute(spitter);
        model.addAttribute(spitterService.getSpittlesForSpitter(username));

        return "spittles/list";
    }

    @RequestMapping(method=GET, params="new")
    public String createSpitterProfile(Model model) {
        model.addAttribute(new Spitter());
        return "spitters/edit";
    }

    @RequestMapping(method=POST)
    public String addSpitterFromForm(@Valid Spitter spitter,
                                     BindingResult bindingResult) {
        if(bindingResult.hasErrors()) { // Проверка ошибок
            return "spitters/edit";
        }
        spitterService.saveSpitter(spitter); // Сохранить объект Spitter
        return "redirect:/spitters/" + spitter.getUsername(); // Переадресовать
    }

    @RequestMapping(value="/{username}", method=GET)
    public String showSpitterProfile(@PathVariable String username,
                                     Model model) {
        model.addAttribute(spitterService.getSpitter(username));
        return "spitters/view";
    }
}
