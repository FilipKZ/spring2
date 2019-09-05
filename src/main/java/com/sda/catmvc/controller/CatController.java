package com.sda.catmvc.controller;

import com.sda.catmvc.model.Cat;
import com.sda.catmvc.service.CatManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/cats")
public class CatController {

    private CatManager catManager;

    public CatController(CatManager catManager) {
        this.catManager = catManager;
    }

    @GetMapping
    String catView (Model model) {
        List<Cat> cats = catManager.getCats();
        model.addAttribute("cats", cats);
        return "cats";
    }

    @GetMapping("/add")
    String catAddView () {
        return "addcat";
    }

    @PostMapping
    String addCat (Cat cat) {
        catManager.saveCat(cat);
        return "redirect:cats";
    }

    @PostMapping("/delete/{id}")
    RedirectView deleteCat (@PathVariable Long id) {
        catManager.deleteCat(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/cats");
        return redirectView;
    }

    @GetMapping("/edit/{id}")
    String editCatView (Model model, @PathVariable("id") Long id) {
        Cat cat = catManager.getCat(id);
        model.addAttribute("cat", cat);
        return "editcat";
    }

    @PostMapping("/edit/{aaa}")
    RedirectView editCat (@PathVariable("aaa") Long aaa, Cat cat) {
        catManager.editCat(aaa, cat);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/cats");
        return redirectView;
    }

}
