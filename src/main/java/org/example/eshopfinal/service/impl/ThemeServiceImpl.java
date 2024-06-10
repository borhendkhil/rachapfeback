package org.example.eshopfinal.service.impl;


import org.example.eshopfinal.entities.Theme;
import org.example.eshopfinal.service.IThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.ThemeRepository;

import java.util.List;

@Service
public class ThemeServiceImpl implements IThemeService {
    @Autowired
    ThemeRepository RepTheme;
    @Override
    public Theme AjouterTheme(Theme t) {
        RepTheme.save(t);
        return t;
    }

    @Override
    public List<Theme> getAllTheme() {
        return (List<Theme>) RepTheme.findAll();
    }

    @Override
    public void UpdateTheme(Long idtheme, Theme t) {
        Theme ThemeToUpdate = RepTheme.findById(idtheme).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"theme existe pas dans la bd")

        );
        if(t.getLibtheme()!=null && !t.getLibtheme().isEmpty()){
            ThemeToUpdate.setLibtheme(t.getLibtheme());
        }


    }

    @Override
    public void SupprimerTheme(Long idtheme) throws ChangeSetPersister.NotFoundException {
       Theme theme = RepTheme.findById(idtheme)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        RepTheme.deleteById(idtheme);
        //logger.info("theme {} is deleted", theme.getIdTheme());


    }


}
