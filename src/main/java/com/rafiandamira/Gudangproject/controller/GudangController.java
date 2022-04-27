package com.rafiandamira.Gudangproject.controller;

import com.rafiandamira.Gudangproject.exception.GudangNotFoundException;
import com.rafiandamira.Gudangproject.entity.Gudang;
import com.rafiandamira.Gudangproject.service.framework.GudangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/api/comic")
public class GudangController {

    private final GudangService gudangService;

    @Autowired
    public GudangController(GudangService gudangservice) {
        this.gudangService = gudangservice;
    }

    @GetMapping
    public List<Gudang> getAllGudang() {
        return gudangService.getAllGudang();
    }

    @GetMapping(value = "/{id}")
    public Gudang getGudangById(@PathVariable("id") @Min(1) Long id) {
        Gudang std = gudangService.findById(id)
                .orElseThrow(() -> new GudangNotFoundException("Gudang with " + id + " is Not Found!"));
        return std;
    }

    @PostMapping
    public Gudang addGudang(@Valid @RequestBody Gudang std) {
        return gudangService.save(std);
    }

    @PutMapping(value = "/{id}")
    public Gudang updateGudang(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Gudang newStd) {
        Gudang Gudang = gudangService.findById(id)
                .orElseThrow(() -> new GudangNotFoundException("Gudang with " + id + " is Not Found!"));
        Gudang.setBarangName(newStd.getBarangName());
        Gudang.setPemilikName(newStd.getPemilikName());
        Gudang.setJumlah(newStd.getJumlah());
        Gudang.setEmail(newStd.getEmail());
        Gudang.setBarangDate(newStd.getBarangDate());
        return gudangService.save(Gudang);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteComic(@PathVariable("id") @Min(1) Long id) {
        Gudang std = gudangService.findById(id)
                .orElseThrow(() -> new GudangNotFoundException("Gudang with " + id + " is Not Found!"));
        gudangService.deleteById(std.getId());
        return "Gudang with ID :" + id + " is deleted";
    }
}
