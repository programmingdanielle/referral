package com.wildwoodim.specialist.controllers;

import com.wildwoodim.specialist.models.data.InsuranceDao;
import com.wildwoodim.specialist.models.data.SpecialistDao;
import com.wildwoodim.specialist.models.data.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    InsuranceDao insuranceDao;

    @Autowired
    TypeDao typeDao;

    @Autowired
    SpecialistDao specialistDao;

/*    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Wildwood Internal Medicine");
        model.addAttribute("types", typeDao.findAll());
        model.addAttribute("insurances", insuranceDao.findAll());

        return "index";
    }*/

    @RequestMapping(value = "display")
    public String displayAllSpecialists(Model model) {
        model.addAttribute("title", "Display All Specialists");
        model.addAttribute("specialists", specialistDao.findAll());
        model.addAttribute("insurances", insuranceDao.findAll());
        model.addAttribute("types", typeDao.findAll());

        return "display/index";
    }

    @RequestMapping(value="test")
    public String testMaps() {

        return "test";

    }
}
