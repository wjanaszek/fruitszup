package org.wjanaszek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wjanaszek.model.Fruit;
import org.wjanaszek.services.FruitService;

@Controller
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public void setFruitService(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @RequestMapping("/fruit/new")
    public String newProduct(Model model) {
        model.addAttribute("fruit", new Fruit());
        return "fruitform";
    }

    @RequestMapping(value = "fruit", method = RequestMethod.POST)
    public String saveFruit(Fruit fruit) {
        fruitService.saveFruit(fruit);
        return "redirect:/fruit/" + fruit.getId();
    }

    @RequestMapping("fruit/{id}")
    public String showFruit(@PathVariable Integer id, Model model) {
        model.addAttribute("fruit", fruitService.getFruitById(id));
        return "productshow";
    }

    @RequestMapping(value = "/fruits", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("fruits", fruitService.listAllFruits());
        return "fruits";
    }

    @RequestMapping("fruit/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("fruit", fruitService.getFruitById(id));
        return "fruitform";
    }

    @RequestMapping("fruit/delete/{id}")
    public String delete(@PathVariable Integer id) {
        fruitService.deleteFruit(id);
        return "redirect:/fruits";
    }
}
