package com.wildwoodim.specialist.controllers;

import com.wildwoodim.specialist.models.Specialist;
import com.wildwoodim.specialist.models.Type;
import com.wildwoodim.specialist.models.data.InsuranceDao;
import com.wildwoodim.specialist.models.data.SpecialistDao;
import com.wildwoodim.specialist.models.data.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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

        model.addAttribute("title", "Wildwood Internal Medicine: Referral Coordinator");
        model.addAttribute("types", typeDao.findAll());
        model.addAttribute("insurances", insuranceDao.findAll());

        return "index";

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexSelectedSearch(Model model) {

        model.addAttribute("title", "Wildwood Internal Medicine: Referral Coordinator");
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
        model.addAttribute("specialists", specialistDao.findAllByTypeIdAndInsuranceId(typeId, insuranceId));
        model.addAttribute("insurance", specialistDao.findFirstByInsuranceId(insuranceId));
        model.addAttribute("type", specialistDao.findFirstByTypeId(typeId));
        model.addAttribute("size", totalSize);
        return "display/search";

    }

    @RequestMapping(value = "specialist/{specialistId}")
    public String displayProfile(Model model, @PathVariable int specialistId) {

        model.addAttribute("title", "View Profile");
        model.addAttribute("specialists", specialistDao.findById(specialistId));

        return "profile/index";

    }

}
