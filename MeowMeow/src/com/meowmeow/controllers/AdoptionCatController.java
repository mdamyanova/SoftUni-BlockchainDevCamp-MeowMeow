package com.meowmeow.controllers;

import com.meowmeow.models.AdoptionCat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdoptionCatController {
    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("someAttribute", "someValue");
        return "index";
    }
    // TODO
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView all() {
        return new ModelAndView("adoptionCat", "command", new AdoptionCat());
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("MeowMeow")AdoptionCat cat, ModelMap model) {
        model.addAttribute("name", cat.getName());
        model.addAttribute("age", cat.getAge());
        model.addAttribute("gender", cat.getGender());
        model.addAttribute("town", cat.getTown());
        model.addAttribute("description", cat.getDescription());
        model.addAttribute("imageHash", cat.getImageHash());
        model.addAttribute("organization", cat.getOrganization());

        return "result";
    }
}