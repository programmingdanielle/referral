package com.wildwoodim.specialist.controllers;

import com.wildwoodim.specialist.models.Insurance;
import com.wildwoodim.specialist.models.Rating;
import com.wildwoodim.specialist.models.data.RatingDao;
import com.wildwoodim.specialist.models.data.SpecialistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "rating")
public class RatingController {

    @Autowired
    RatingDao ratingDao;

    @Autowired
    SpecialistDao specialistDao;

    @RequestMapping(value = "")
    public String indexRating(Model model) {

        model.addAttribute("title", "Available Ratings");
        model.addAttribute("ratings", ratingDao.findAll());

        return "rating/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addInsuranceForm(Model model) {

        model.addAttribute("title", "WWIM: Add Rating");
        model.addAttribute(new Rating());

        return "rating/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processInsuranceForm(@ModelAttribute @Valid Rating newRating,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "WWIM: Add Insurance");
            return "rating/add";
        }

        ratingDao.save(newRating);

        return "redirect:/rating";

    }

}
