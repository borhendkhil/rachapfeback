//
// package org.example.eshopfinal.service;

//import jakarta.persistence.EntityNotFoundException;
//import jakarta.transaction.Transactional;
//import org.apache.coyote.BadRequestException;
//import org.example.eshopfinal.entities.CaracteristiquesProduits;
//import org.example.eshopfinal.entities.Possede;
//import org.example.eshopfinal.entities.Theme;
//import org.example.eshopfinal.entities.codePossede;
//import org.example.eshopfinal.repository.CaracteristiquesProduitsRepository;
//import org.example.eshopfinal.repository.ThemeRepository;
//import org.example.eshopfinal.repository.possedeRepository;

//import java.sql.SQLException;
import java.util.List;
//import java.util.stream.Collectors;

//public interface possedeService (possedeRepository, ThemeRepository themeRepository, CaracteristiquesProduitsRepository caracteristiqueRepository) {
//      this.possedeRepository = possedeRepository;
//      this.themeRepository = themeRepository;
//      this.caracteristiqueRepository = caracteristiqueRepository;
//}

//@Transactional(rollbackFor = {SQLException.class})
//public PossedeDto createPossede(Possede possedeDto) {
//  Theme theme;
//  CaracteristiquesProduits caracteristique;
//  if (themeRepository.findByLibelle(possedeDto.getTheme().getLibelle()).isPresent()) {
//      theme = themeRepository.findByLibelle(possedeDto.getTheme().getLibelle()).get();
//  } else {
//      theme = new Theme();
//      theme.setLibelle(possedeDto.getTheme().getLibelle());
//      theme = themeRepository.save(theme);
//  }

//  if (caracteristiqueRepository.findByThemeAndLibelle(theme, possedeDto.getCaracteristique().getLibelle()).isPresent()) {
//      caracteristique = caracteristiqueRepository.findByThemeAndLibelle(theme, possedeDto.getCaracteristique().getLibelle()).get();
//  } else {
//      caracteristique = new Caracteristique();
//      caracteristique.setLibelle(possedeDto.getCaracteristique().getLibelle());
//      caracteristique.setTheme(theme);
//      caracteristique = caracteristiqueRepository.save(caracteristique);
//  }

//  return PossedeDto.fromEntity(
//          possedeRepository.save(
//                  Possede.builder()
//                          .codePossede(CodePossedeDto.toEntity(CodePossedeDto.builder()
//                                  .codeTheme(theme.getCodeTheme())
//                                  .codeCaracteristique(caracteristique.getCodeCaracteristique())
//                                  .codeProduit(possedeDto.getProduit().getCodeProduit())
//                                  .build()))
//                          .valueofcaracteristique(possedeDto.getValueofcaracteristique())
//                          .theme(theme)
//                          .produit(possedeDto.getProduit())
//                          .caracteristique(caracteristique)
//                          .build()
//          )
//  );
//}

//Override
//public List<PossedeDto> findAll() {
//  List<Possede> possedeList = possedeRepository.findAll();
//  return possedeList.stream()
//          .map(PossedeDto::fromEntity)
//          .collect(Collectors.toList());
//}

//@Override
//public List<PossedeDto> findAllByProduitCodeProduit(long codeProduit) {
//  List<Possede> possedeList = possedeRepository.find(codeProduit).orElseThrow(
//          () -> new EntityNotFoundException("No Possede found for product with code " + codeProduit)
//  );
//  return possedeList.stream()
//          .map(PossedeDto::fromEntity)
//          .collect(Collectors.toList());
//}



//@Override
//public PossedeDto updatePossede(Long id, PossedeDto possedeDto) throws BadRequestException {
//        if (!id.equals(possedeDto.getCodePossede().getId())) {
//            throw new BadRequestException("ID in path and request body don't match");
//        }
//        CodePossede cp = new CodePossede();
//        try {
//
//            //cp.setId(id);
//            cp.setCodeCaracteristique(possedeDto.getCaracteristique().getCodeCaracteristique());
//            cp.setCodeProduit(possedeDto.getProduit().getCodeProduit());
//            cp.setCodeTheme(possedeDto.getTheme().getCodeTheme());
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        Possede optionalPossede = possedeRepository.findByCodePossede(cp).orElseThrow(
//                () -> new EntityNotFoundException("No Possede found with code " + cp)
//
//        );
//
//        if (optionalPossede == null) {
//            return null; // Entity not found
//        }
//
//
//        // Update properties of existingPossede with values from possedeDto
//        optionalPossede.setValueofcaracteristique(possedeDto.getValueofcaracteristique());
//        // Update other properties as needed based on your logic
//
//        Possede savedPossede = possedeRepository.save(optionalPossede);
//        return PossedeDto.fromEntity(savedPossede);
//  return null;
//}

//@Override
//@Transactional
//public PossedeDto deletePossede(codePossede) {
//  Possede possede = possedeRepository.findByCodePossede(codePossede).orElseThrow(
//          () -> new EntityNotFoundException("No Possede found with code " + codePossede)
//  );
//  possedeRepository.deleteByCodePossede(codePossede);
//  return PossedeDto.fromEntity(possede);
//}
//}

