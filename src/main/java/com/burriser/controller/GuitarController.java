package com.burriser.controller;

import com.burriser.model.Guitar;
import com.burriser.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by BurRiSer on 16.05.2017.
 */
@Controller()
public class GuitarController {
    public GuitarService guitarService;

    @Autowired(required = true)
    @Qualifier(value = "guitarService")
    public void setGuitarService(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @RequestMapping(value = "guitars", method = RequestMethod.GET)
    public String listGuitars(Model model){
        model.addAttribute("guitar", new Guitar());
        model.addAttribute("listGuitars", this.guitarService.listGuitars());

        return "guitars";
    }

    @RequestMapping(value = "/guitars/add", method = RequestMethod.POST)
    public String addGuitar(@ModelAttribute("guitar") Guitar guitar){
        if (guitar.getId() == 0)
            this.guitarService.addGuitar(guitar);
        else this.guitarService.updateGuitar(guitar);

        return "redirect:/guitars";
    }

    @RequestMapping("/remove/{id}")
    public String removeGuitar(@PathVariable("id") int id) {
        this.guitarService.removeGuitar(id);

        return "redirect:/guitars";
    }

    @RequestMapping("edit/{id}")
    public String editGuitar(@PathVariable("id") int id, Model model) {
        model.addAttribute("guitar", this.guitarService.getGuitarById(id));
        model.addAttribute("listGuitars", this.guitarService.listGuitars());

        return "guitars";
    }

    @RequestMapping("guitardata/{id}")
    public String guitarData(@PathVariable("id") int id, Model model) {
        model.addAttribute("guitar", this.guitarService.getGuitarById(id));

        return "guitardata";
    }
}
