package tn.esprit.rh.achat.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Produit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IProduitServiceTest {

    @Autowired
    IProduitService produitService;
    private static final Logger l = LogManager.getLogger(ProduitServiceImpl.class);

    @Test
    public void retrieveProduit() {
        try {
            Produit sa = new Produit();
            sa.setCodeProduit("f-515546");
            sa.setLibelleProduit("Telephone");
            Produit savedProduit = produitService.addProduit(sa);
            Produit prod = produitService.retrieveProduit(savedProduit.getIdProduit());
            l.info("Produit : " + prod.getLibelleProduit());
            assertNotNull(produitService.retrieveProduit(savedProduit.getIdProduit()));
        } catch (Exception e) {
            l.info(e.getMessage());
        }
    }

    @Test
    public void testRetrieveAllProduit() {
        List<Produit> produits = produitService.retrieveAllProduits();
        System.out.println(produits.size());
        assertNotNull(produits);
    }

    @Test
    public void addProduit() throws ParseException {
        Produit prod = new Produit();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateFormat.parse("10/02/2020");
        Date date2 = dateFormat.parse("12/09/2022");
        prod.setCodeProduit("f-455112");
        prod.setLibelleProduit("Jus");
        prod.setDateCreation(date1);
        prod.setDateDerniereModification(date2);
        produitService.addProduit(prod);
        Produit savedProduit = produitService.addProduit(prod);
        l.info("Produit added : " + prod.getLibelleProduit());
        assertNotNull(produitService.retrieveProduit(savedProduit.getIdProduit()));
    }

    @Test
    public void deleteProduit() {
        List<Produit> Produits = produitService.retrieveAllProduits();
        int actuel = Produits.size();//14
        Produit sa = new Produit();
        sa.setCodeProduit("f-5156");
        sa.setLibelleProduit("pc");
        Produit savedProduit = produitService.addProduit(sa);
        l.info(" count" + Produits.size());
        produitService.deleteProduit(savedProduit.getIdProduit());
        //produitService.deleteProduit(15L);
        // List<Produit> produitsUpdated = produitService.retrieveAllProduits();
        //int updated = produitsUpdated.size();//13
        assertNull(produitService.retrieveProduit(savedProduit.getIdProduit()));
        //assertNotEquals(actuel,updated);

    }


}