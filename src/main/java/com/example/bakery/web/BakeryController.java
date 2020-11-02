package com.example.bakery.web;

import com.example.bakery.domain.Bread;
import com.example.bakery.domain.BreadRepository;
import com.example.bakery.domain.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller

// The @RestController annotation identifies that this class will be the controller for the RESTful web service:
//Using @RestController /breadlist endpoint can't return HTML page anymore
//While you can also create RESTful service by using @Controller and @ResponseBody annotations, /breadlist and others endpoints can return HTML pages
//At the same time, /breads endpoint can return breads in JSON
public class BakeryController {
    @Autowired
    private BreadRepository breadRepository;

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping(value = "/breadlist")
    public String breadList(Model model){
        model.addAttribute("breads", breadRepository.findAll());
        return "breadlist";
    }

    @GetMapping(value = "/add")
    public String addBread(Model model){
        model.addAttribute("bread", new Bread());
        //Inject type repository to controller
        model.addAttribute("types", typeRepository.findAll());
        return "addbread";
    }

    @PostMapping(value = "/save")
    public String save(Bread  bread){
        breadRepository.save(bread);
        return "redirect:breadlist";
    }

    //Delete function
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/delete/{id}")
    public String deleteBread(@PathVariable("id") Long breadId, Model model){
        breadRepository.deleteById(breadId);
        return "redirect:../breadlist";
    }

    //Edit bread
    @GetMapping(value = "/edit/{id}")
    public String editBread(@PathVariable("id") Long id, Model model){
        model.addAttribute("bread", breadRepository.findById(id));
        model.addAttribute("types", typeRepository.findAll());
        return "editbread";
    }

    // Restful service to get all cars
    @GetMapping(value = "/breads")
    public @ResponseBody Iterable<Bread> getBreads(){

        return breadRepository.findAll();
    }

    //Restful service to find bread by id using path variable
    @GetMapping(value = "/bread/{id}")
    public @ResponseBody Bread findByIdRest(@PathVariable("id") Long breadId){
        return breadRepository.findAllById(breadId);
    }

    //Security


}

















