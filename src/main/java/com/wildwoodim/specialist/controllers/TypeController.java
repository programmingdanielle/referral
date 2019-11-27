package com.wildwoodim.specialist.controllers;

import com.wildwoodim.specialist.models.data.TypeDao;
import com.wildwoodim.specialist.models.forms.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "type")
public class TypeController {

    @Autowired
    TypeDao typeDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addType(Model model) {

        model.addAttribute("title", "WWIM: Add Type");
        model.addAttribute(new Type());

        return "type/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processTypeForm(@ModelAttribute @Valid Type newType,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "WWIM: Add Type");
            return "type/add";
        }

        typeDao.save(newType);

        return "redirect:/";

    }

}