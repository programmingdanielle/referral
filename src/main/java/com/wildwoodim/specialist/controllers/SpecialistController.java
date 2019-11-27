package com.wildwoodim.specialist.controllers;

import com.wildwoodim.specialist.models.data.InsuranceDao;
import com.wildwoodim.specialist.models.data.SpecialistDao;
import com.wildwoodim.specialist.models.forms.Insurance;
import com.wildwoodim.specialist.models.forms.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class SpecialistController {

    @Autowired
    public SpecialistDao specialistDao;

    @Autowired
    public InsuranceDao insuranceDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Wildwood Internal Medicine");
        model.addAttribute("specialists", specialistDao.findAll());
        model.addAttribute("insurances", insuranceDao.findAll());

        return "index";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String displayAddSpecialist(Model model) {

        model.addAttribute("title", "WWIM: Add Specialist");
        model.addAttribute(new Specialist());
        model.addAttribute("insurances", insuranceDao.findAll());

        return "specialist/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddSpecialist(@ModelAttribute @Valid Specialist newSpecialist, @RequestParam int insuranceId,
                                       Errors errors, Model model) {

        Optional<Insurance> optionalInsurance =  insuranceDao.findById(insuranceId);
        Insurance insurances = optionalInsurance.get();

        if (errors.hasErrors()) {
            model.addAttribute("title", "New Specialist");
            return "specialist/add";
        }

        newSpecialist.setInsurance(insurances);
        specialistDao.save(newSpecialist);


        return "redirect:/";

    }

    @RequestMapping(value = "display")
    public String displayAllSpecialists(Model model) {
        model.addAttribute("title", "Display All Specialists");
        model.addAttribute("specialists", specialistDao.findAll());
        model.addAttribute("insurances", insuranceDao.findAll());

        return "display/index";
    }

}
