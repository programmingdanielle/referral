package com.wildwoodim.specialist.controllers;

import com.wildwoodim.specialist.models.Specialist;
import com.wildwoodim.specialist.models.Type;
import com.wildwoodim.specialist.models.data.InsuranceDao;
import com.wildwoodim.specialist.models.data.SpecialistDao;
import com.wildwoodim.specialist.models.data.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SearchController {

    @Autowired
    InsuranceDao insuranceDao;

    @Autowired
    SpecialistDao specialistDao;

    @Autowired
    TypeDao typeDao;

    @RequestMapping(value = "")
    public String indexSearch(Model model) {

        model.addAttribute("types", typeDao.findAll());

        return "index";

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexSelectedSearch(Model model) {

        model.addAttribute("types", typeDao.findAll());

        return "index";

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String searchResults(@RequestParam Integer typeId, Model model) {



        model.addAttribute("title", "Search Results");/*
        model.addAttribute("types", typeDao.findById(typeId).orElse(null));*/
        model.addAttribute("results", specialistDao.findByTypeId(typeId));

        return "display/search";

    }

}
