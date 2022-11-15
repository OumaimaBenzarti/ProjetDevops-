package tn.esprit.rh.achat;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.services.IFournisseurService;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FournisseurServiceImplTest {
    @Autowired
    IFournisseurService fournisseurService;


    @Test
    public void testAddFournisseur() throws ParseException {

       // SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Date dateCreation = dateFormat.parse("01/09/2020");
        //Date datemodification = dateFormat.parse("30/09/2020");

        Fournisseur c = new Fournisseur("AEDRE", "MOHSEN");
        Fournisseur fournisseur = fournisseurService.addFournisseur(c);
        

    }
    @Test
    public void testDeleteFournisseur() throws ParseException {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Date dateCreation = dateFormat.parse("01/09/2020");
       // Date dateModification = dateFormat.parse("30/09/2020");
        Fournisseur c = new Fournisseur("AEDRE", "MOHSEN");
        Fournisseur Fournisseur = fournisseurService.addFournisseur(c);


    }

    @Test
    public void testRetrieveAllFournisseurs() throws ParseException {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Date dateCreation = dateFormat.parse("30/09/2000");
        //Date dateModification = dateFormat.parse("30/09/2020");
        List<Fournisseur> Fournisseurs = fournisseurService.retrieveAllFournisseurs();
        int expected = Fournisseurs.size();
        Fournisseur c = new Fournisseur("AEDRE", "MOHSEN");


    }


}