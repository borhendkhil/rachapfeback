package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import org.example.eshopfinal.service.IThemeService;

import java.util.List;

@RequestMapping("api/v1/theme")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ThemeController {
    //Vendeur
    @Autowired

    IThemeService themeService;
    @GetMapping
    public List<Theme> getAllTheme(){
        List<Theme> list=themeService.getAllTheme();
        return list;
    }
    @PostMapping("/add")
    public Theme AjouterTheme(@RequestBody Theme t) {
        return themeService.AjouterTheme(t);

    }

    @DeleteMapping("delete/{id}")
    public void SupprimerTheme( @PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        themeService.SupprimerTheme(id);
    }

    @PutMapping("update/{id}")
    public void UpdateTheme(@PathVariable Long id, Theme t){
        themeService.UpdateTheme(id,t);
    }


}
