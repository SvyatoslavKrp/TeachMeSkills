package org.example.web;

import org.example.entities.Horse;
import org.example.entities.Pair;
import org.example.entities.Rider;
import org.example.services.Hippodrome;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/createPairs")
public class CreatePairController {

    Hippodrome hippodrome;

    public CreatePairController(Hippodrome hippodrome) {
        this.hippodrome = hippodrome;
    }

    @GetMapping
    public String goToPage() {
        return "createPairs";
    }

    @PostMapping
    public ModelAndView createPair(@ModelAttribute(name = "rider's name") @Valid Rider rider, BindingResult riderResult,
                                   @ModelAttribute(name = "horse's name") @Valid Horse horse, BindingResult horseResult) {

        ModelAndView modelAndView1 = new ModelAndView("createPairs");

        if (riderResult.hasErrors()) {
            return checkErrors(riderResult, "rider_");
        }

        if (horseResult.hasErrors()) {
            return checkErrors(horseResult, "horse_");
        }

        Pair pair = new Pair(horse, rider);

        hippodrome.registerPair(pair);

        ModelAndView modelAndView = new ModelAndView("createPairs");

        modelAndView.addObject("pairs", hippodrome.getParticipants().keySet());

        return modelAndView;
    }

    private ModelAndView checkErrors(BindingResult result, String entity) {
        ModelAndView modelAndView = new ModelAndView("createPairs");

        Map<String, String> errorsMap = new HashMap<>();

        List<FieldError> errorList = result.getFieldErrors();

        for (FieldError error : errorList) {
            errorsMap.put(entity + error.getField(), error.getDefaultMessage());
        }
        modelAndView.addAllObjects(errorsMap);
        modelAndView.addObject("pairs", hippodrome.getParticipants().keySet());
        return modelAndView;

    }

}
