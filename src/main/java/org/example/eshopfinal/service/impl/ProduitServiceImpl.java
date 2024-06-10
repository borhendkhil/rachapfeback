package org.example.eshopfinal.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Produit;
import org.example.eshopfinal.repository.ProduitRepository;
import org.example.eshopfinal.service.IProduitService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements IProduitService {

    private final ProduitRepository RepProduit;

    //LoggerFactory logger=new LoggerFactory(ProduitServiceImpl.class)

    @Override
    public Produit ajouterproduit(Produit p) {
        RepProduit.save(p);
        return p;
    }

    @Override
    public void updateproduit(Produit p,Long idprod) {
        Produit produitToUpdate = RepProduit.findById(idprod).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"produit existe pas dans la base de données")

        );
        if(p.getNomprod()!=null && !p.getNomprod().isEmpty()){
            produitToUpdate.setNomprod(p.getNomprod());
        }
        if(p.getDescription()!=null && !p.getDescription().isEmpty()){
            produitToUpdate.setDescription(p.getDescription());
        }
        if(p.getPrix()== Float.parseFloat(null)){
            produitToUpdate.setPrix(p.getPrix());
        }
        if(p.getReference()!=null ){
            produitToUpdate.setReference(p.getReference());
        }
    }

    @Override
    public void supprimerProduit(Long idprod) throws ChangeSetPersister.NotFoundException {
        Produit produit = RepProduit.findById(idprod)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        RepProduit.deleteById(idprod);
        //  logger.info("Product {} is deleted", produit.getIdPROD());
    }




@Override
public List<Produit> getAllProduit() {
    return RepProduit.findAll();
}
@Override
public Produit getProduitById(Long id){
    return RepProduit.findById(id).orElseThrow(()->
            new ResponseStatusException(HttpStatus.NOT_FOUND,"produit existe pas dans la bd")
    );
}
@Override
public Produit getProduitByNom(String nom){
    return (Produit) RepProduit.findByNomprod(nom).orElseThrow(()->
            new ResponseStatusException(HttpStatus.NOT_FOUND,"produit existe pas dans la bd")
    );
}
@Override
public List<Produit> getProduitByCategorie(Long idcat) {
    List<Produit> produits = RepProduit.findByCategorieId(idcat);
    if (produits.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun produit trouvé pour cette catégorie.");
    }
    return produits;
}
@Override
public List<Produit> getProduitByMarque(Long id){
    List<Produit> produits = RepProduit.findByM_Id(id);
    if (produits.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun produit trouvé pour cette marque.");
    }
    return produits;
}
}
