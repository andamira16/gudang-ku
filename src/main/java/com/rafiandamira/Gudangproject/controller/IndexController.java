package com.rafiandamira.Gudangproject.controller;

import com.rafiandamira.Gudangproject.entity.Gudang;
import com.rafiandamira.Gudangproject.service.framework.GudangService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class IndexController {
    private GudangService gudangService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("gudang", gudangService.getAllGudang());
        return "index";
    }
    @GetMapping(value = "/create")
    public String create1(Model model) {
        model.addAttribute("gudang", new Gudang());
        return "formGudang";
    }

    @PostMapping(value = "/create")
    public String tambahGudang(Model model, Gudang Gudang) {
        model.addAttribute("gudang", gudangService.save(Gudang));
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("gudang", gudangService.findById(id));
        return "formGudang";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusGudang(@PathVariable Long id) {
        gudangService.deleteById(id);
        return "redirect:/";
    }

}

