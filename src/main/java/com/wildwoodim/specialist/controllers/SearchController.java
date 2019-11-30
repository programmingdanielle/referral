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
import java.util.List;
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
        model.addAttribute("insurances", insuranceDao.findAll());

        return "index";

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexSelectedSearch(Model model) {

        model.addAttribute("types", typeDao.findAll());
        model.addAttribute("insurances", insuranceDao.findAll());

        return "index";

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String searchResults(@RequestParam Integer typeId, @RequestParam Integer insuranceId, Model model) {

        List<Specialist> size = specialistDao.findAllByTypeIdAndInsuranceId(typeId, insuranceId);
        int totalSize = size.size();

        model.addAttribute("title", "Search Results");/*
        model.addAttribute("types", typeDao.findById(typeId).orElse(null));*/
        model.addAttribute("results", specialistDao.findAllByTypeIdAndInsuranceId(typeId, insuranceId));
        model.addAttribute("insurance", specialistDao.findByInsuranceId(insuranceId));
        model.addAttribute("type", specialistDao.findByTypeId(typeId));
        model.addAttribute("size", totalSize);

        return "display/search";

    }

}
