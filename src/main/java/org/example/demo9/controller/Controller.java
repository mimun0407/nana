package org.example.demo9.controller;
import jdk.internal.icu.text.NormalizerBase;
import org.example.demo9.model.City;
import org.example.demo9.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@org.springframework.stereotype.Controller
@RequestMapping("/City")
public class Controller {
    @Autowired
    ICityService service;

    @RequestMapping
    public ModelAndView ShowAll() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("CityList", service.showALl());
        return modelAndView;
    }

    @GetMapping("/ShowCreate")
    public ModelAndView showF() {
        ModelAndView modelAndView = new ModelAndView("/createF");
        modelAndView.addObject("newCity", new City());
        modelAndView.addObject("AllCountry", service.showCountry());
        return modelAndView;
    }
    @PostMapping("/CreateCity")
    public ModelAndView create(@Valid City city, BindingResult bindingResult){
        ModelAndView modelAndView=new ModelAndView("/createF");
        if (bindingResult.hasErrors()){
            modelAndView.addObject("eRRList",bindingResult.getAllErrors());
            modelAndView.addObject("newCity", new City());
        }
        else {
            service.Create(city);
            modelAndView.addObject("newCity", new City());
            modelAndView.addObject("eRR","Thanh cong");
        }
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("redirect:/City");
        service.delete(id);
        return modelAndView;
    }
    @GetMapping("/FindById/{id}")
    public ModelAndView ShowCity(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("/view");
        modelAndView.addObject("city1",service.ShowInf(id));
        return modelAndView;
    }
    @GetMapping("/editF/{id}")
    public ModelAndView editF(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("/editF");
        Optional<City> city=service.ShowInf(id);
        modelAndView.addObject("AllCountry", service.showCountry());
        modelAndView.addObject("city2",city.get());
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView update(@Valid City city, BindingResult bindingResult, @RequestParam("id")int id){

        if (bindingResult.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("/editF");
            modelAndView.addObject("AllCountry", service.showCountry());
            modelAndView.addObject("HER",bindingResult.getAllErrors());
            modelAndView.addObject("city2",service.ShowInf(id));
            return modelAndView;
        }
        else {
            ModelAndView modelAndView=new ModelAndView("redirect:/City");
            service.Update(city,id);
            return modelAndView;
        }
    }
}
