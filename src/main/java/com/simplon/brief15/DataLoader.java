package com.simplon.brief15;

import java.util.Optional;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simplon.brief15.models.Emprunteur;
import com.simplon.brief15.models.Genre;
import com.simplon.brief15.models.Livre;
import com.simplon.brief15.models.Emprunt;
import com.simplon.brief15.repositories.EmpruntRepository;
import com.simplon.brief15.repositories.EmprunteurRepository;
import com.simplon.brief15.repositories.GenreRepository;
import com.simplon.brief15.repositories.LivreRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner testMigrations(LivreRepository livreRepository,
                                    EmprunteurRepository emprunteurRepository,
                                    EmpruntRepository empruntRepository,
                                    GenreRepository genreRepository) {
        return args -> {

            // Ajout d'un genre
            Genre genreComedie = new Genre();
            genreComedie.setNom("Comédie");
            genreComedie = genreRepository.save(genreComedie);

            // Ajout de livres
            Livre livre1 = new Livre();
            livre1.setTitre("1984");
            livre1.setAuteur("George Orwell");
            livre1 = livreRepository.save(livre1);

            Livre livre2 = new Livre();
            livre2.setTitre("Le Meilleur des Mondes");
            livre2.setAuteur("Aldous Huxley");
            livre2 = livreRepository.save(livre2);

            // Ajout d'un emprunteur
            Emprunteur emprunteur1 = new Emprunteur();
            emprunteur1.setFirstname("sandrine");
            emprunteur1.setLastname("faucher");
            emprunteur1.setEmail("sfaucher@test.com");
            emprunteur1 = emprunteurRepository.save(emprunteur1);


            // Création d'un emprunt
            Emprunt emprunt1 = new Emprunt();
            emprunt1.setEmprunteur(emprunteur1); // Association avec l'emprunteur
            emprunt1.setLivre(livre1);           // Association avec le livre
            emprunt1.setDebut(LocalDate.of(2025, 1, 1));
            emprunt1.setFin(LocalDate.of(2025, 2, 1));
            empruntRepository.save(emprunt1);



            // Affichage des données
            System.out.println("Livres disponibles:");
            livreRepository.findAll().forEach(livre ->
                    System.out.println(" - " + livre.getTitre() + " par " + livre.getAuteur())
            );

            System.out.println("Emprunteurs enregistrés:");
            emprunteurRepository.findAll().forEach(emprunteur ->
                    System.out.println(" - " + emprunteur.getFirstname() + " " + emprunteur.getLastname() + " (" + emprunteur.getEmail() + ")")
            );

            System.out.println("Emprunts:");
            empruntRepository.findAll().forEach(emprunt -> {
                Livre livre = emprunt.getLivre();
                Emprunteur emprunteur = emprunt.getEmprunteur();

                System.out.println(" - " + (emprunteur != null ? emprunteur.getFirstname() : "Unknown")
                        + " a emprunté " + (livre != null ? livre.getTitre() : "Unknown")
                        + " du " + emprunt.getDebut() + " au " + (emprunt.getFin() != null ? emprunt.getFin() : "indéfini"));
            });
        };
    }
}
