package com.wildwoodim.specialist.controllers;


import com.wildwoodim.specialist.models.data.InsuranceDao;
import com.wildwoodim.specialist.models.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "insurance")
public class InsuranceController {

    @Autowired
    InsuranceDao insuranceDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addInsuranceForm(Model model) {

        model.addAttribute("title", "WWIM: Add Insurance");
        model.addAttribute(new Insurance());

        return "insurance/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processInsuranceForm(@ModelAttribute @Valid Insurance newInsurance,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "WWIM: Add Insurance");
            return "insurance/add";
        }

        insuranceDao.save(newInsurance);

        return "redirect:/";

    }

}
