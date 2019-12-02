package com.wildwoodim.specialist.controllers;

import com.wildwoodim.specialist.models.data.InsuranceDao;
import com.wildwoodim.specialist.models.data.SpecialistDao;
import com.wildwoodim.specialist.models.data.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {

    @Autowired
    SpecialistDao specialistDao;

    @Autowired
    TypeDao typeDao;

    @Autowired
    InsuranceDao insuranceDao;

/*    @RequestMapping(value = "")
    public String indexProfile(Model model) {

        model.addAttribute("title", "Profile");

        return "profile/index";
    }*/

 /*   @RequestMapping(value = "specialist/{specialistId}/")
    public String displayProfile(Model model, @PathVariable int specialistId) {

        model.addAttribute("title", "View Profile");
        model.addAttribute("specialists", specialistDao.findById(specialistId));

        return "profile/index";

    }*/
}
