package fr.oc.projet.microservicepret.dao;

import fr.oc.projet.microservicepret.model.Pret;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface PretDao extends JpaRepository<Pret,Integer> {

    List<Pret> findPretByAbonneId(int abonneId);

    List<Pret> findAll();

    List<Pret> findByAbonneId(Integer abonneId);

    @Query(value = "SELECT * FROM pret,livre_unique WHERE livre_unique.livre_id = :livreId " +
            " AND livre_unique_id = livre_unique.id ", nativeQuery = true)
    List<Pret> getListPretLivre(@Param("livreId") Integer livreId);


    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE livre.id = :livreId " +
            " AND livre.id = livre_unique.livre_id " +
            " AND bibliotheque_id = :bibliothequeId ",nativeQuery = true)
    List<Pret> getListPretLivreBibliotheque(@Param("livreId") Integer livreId,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret WHERE abonne_id = :abonneId" +
            " AND bibliotheque_id = :bibliothequeId ",nativeQuery = true)
    List<Pret> getListPretAbonneBibliotheque(@Param("abonneId") Integer abonneId,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE %:isbn%" +
            " AND livre_unique.numero_interne LIKE %:numInterne%" +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id ",nativeQuery = true)
    List<Pret> getListPretLivreISBNNumInterne(@Param("isbn") String isbn,@Param("numInterne") String numInterne);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE %:isbn%" +
            " AND livre_unique.numero_interne LIKE %:numInterne%" +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id " +
            " AND bibliotheque_id = :bibliothequeId ",nativeQuery = true)
    List<Pret> getListPretLivreISBNNumInterneBibliotheque(@Param("isbn") String isbn,@Param("numInterne") String numInterne,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE %:isbn%" +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id ",nativeQuery = true)
    List<Pret> getListPretLivreISBN(@Param("isbn") String isbn);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE " +
            " livre_unique.numero_interne LIKE %:numInterne%" +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id " ,nativeQuery = true)
    List<Pret> getListPretLivreNumInterne(@Param("numInterne") String numInterne);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE %:isbn%" +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id " +
            " AND bibliotheque_id = :bibliothequeId ",nativeQuery = true)
    List<Pret> getListPretLivreISBNBibliotheque(@Param("isbn") String isbn,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE " +
            " livre_unique.numero_interne LIKE %:numInterne%" +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id " +
            " AND bibliotheque_id = :bibliothequeId ",nativeQuery = true)
    List<Pret> getListPretLivreNumInterneBibliotheque(@Param("numInterne") String numInterne,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE %:isbn%" +
            " AND titre LIKE %:titre%" +
            " AND auteur LIKE %:auteur% " +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id ",nativeQuery = true)
    List<Pret> getListPretLivreTitreAuteurISBN(@Param("titre") String titre,@Param("auteur") String auteur,@Param("isbn") String isbn);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE %:isbn%" +
            " AND titre LIKE %:titre%" +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id ",nativeQuery = true)
    List<Pret> getListPretLivreTitreISBN(@Param("titre") String titre,@Param("isbn") String isbn);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE " +
            " titre LIKE %:titre%" +
            " AND auteur LIKE %:auteur% " +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id ",nativeQuery = true)
    List<Pret> getListPretLivreTitreAuteur(@Param("titre") String titre,@Param("auteur") String auteur);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE %:isbn%" +
            " AND auteur LIKE %:auteur% " +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id ",nativeQuery = true)
    List<Pret> getListPretLivreAuteurISBN(@Param("auteur") String auteur,@Param("isbn") String isbn);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE " +
            " titre LIKE %:titre%" +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id ",nativeQuery = true)
    List<Pret> getListPretLivreTitre(@Param("titre") String titre);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE " +
            " auteur LIKE %:auteur% " +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id ",nativeQuery = true)
    List<Pret> getListPretLivreAuteur(@Param("auteur") String auteur);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE %:isbn%" +
            " AND titre LIKE %:titre%" +
            " AND auteur LIKE %:auteur% " +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id " +
            " AND bibliotheque_id = :bibliothequeId ",nativeQuery = true)
    List<Pret> getListPretLivreTitreAuteurISBNBibliotheque(@Param("titre") String titre,@Param("auteur") String auteur,@Param("isbn") String isbn,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE %:isbn%" +
            " AND titre LIKE %:titre%" +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id " +
            " AND bibliotheque_id = :bibliothequeId ",nativeQuery = true)
    List<Pret> getListPretLivreTitreISBNBibliotheque(@Param("titre") String titre,@Param("isbn") String isbn,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE " +
            " titre LIKE %:titre%" +
            " AND auteur LIKE %:auteur% " +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id " +
            " AND bibliotheque_id = :bibliothequeId ",nativeQuery = true)
    List<Pret> getListPretLivreTitreAuteurBibliotheque(@Param("titre") String titre,@Param("auteur") String auteur,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE %:isbn%" +
            " AND auteur LIKE %:auteur% " +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id " +
            " AND bibliotheque_id = :bibliothequeId ",nativeQuery = true)
    List<Pret> getListPretLivreAuteurISBNBibliotheque(@Param("auteur") String auteur,@Param("isbn") String isbn,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE " +
            " titre LIKE %:titre%" +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id " +
            " AND bibliotheque_id = :bibliothequeId ",nativeQuery = true)
    List<Pret> getListPretLivreTitreBibliotheque(@Param("titre") String titre,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,livre_unique,livre WHERE " +
            " auteur LIKE %:auteur% " +
            " AND livre_unique_id = livre_unique.id " +
            " AND livre.id = livre_unique.livre_id " +
            " AND bibliotheque_id = :bibliothequeId ",nativeQuery = true)
    List<Pret> getListPretLivreAuteurBibliotheque(@Param("auteur") String auteur,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND email LIKE %:email% " +
            " AND nom LIKE %:nom% " +
            " AND prenom LIKE %:prenom% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoEmailNomPrenom(@Param("pseudo") String pseudo,@Param("email") String email,@Param("nom") String nom,@Param("prenom") String prenom);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND nom LIKE %:nom% " +
            " AND email LIKE %:email% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoEmailNom(@Param("pseudo") String pseudo,@Param("email") String email,@Param("nom") String nom);


    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND email LIKE %:email% " +
            " AND prenom LIKE %:prenom% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoEmailPrenom(@Param("pseudo") String pseudo,@Param("email") String email,@Param("prenom") String prenom);


    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND nom LIKE %:nom% " +
            " AND prenom LIKE %:prenom% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoNomPrenom(@Param("pseudo") String pseudo,@Param("nom") String nom,@Param("prenom") String prenom);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " email LIKE %:email% " +
            " AND nom LIKE %:nom% " +
            " AND prenom LIKE %:prenom% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonneEmailNomPrenom(@Param("email") String email,@Param("nom") String nom,@Param("prenom") String prenom);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND email LIKE %:email% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoEmail(@Param("pseudo") String pseudo,@Param("email") String email);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " nom LIKE %:nom% " +
            " AND prenom LIKE %:prenom% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonneNomPrenom(@Param("nom") String nom,@Param("prenom") String prenom);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND prenom LIKE %:prenom% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoPrenom(@Param("pseudo") String pseudo,@Param("prenom") String prenom);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " email LIKE %:email% " +
            " AND nom LIKE %:nom% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonneEmailNom(@Param("email") String email,@Param("nom") String nom);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " email LIKE %:email% " +
            " AND prenom LIKE %:prenom% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonneEmailPrenom(@Param("email") String email,@Param("prenom") String prenom);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND nom LIKE %:nom% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoNom(@Param("pseudo") String pseudo,@Param("nom") String nom);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudo(@Param("pseudo") String pseudo);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " email LIKE %:email% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonneEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " nom LIKE %:nom% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonneNom(@Param("nom") String nom);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " prenom LIKE %:prenom% " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePrenom(@Param("prenom") String prenom);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND email LIKE %:email% " +
            " AND nom LIKE %:nom% " +
            " AND prenom LIKE %:prenom% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoEmailNomPrenomBibliotheque(@Param("pseudo") String pseudo,@Param("email") String email,@Param("nom") String nom,@Param("prenom") String prenom,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND email LIKE %:email% " +
            " AND nom LIKE %:nom% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoEmailNomBibliotheque(@Param("pseudo") String pseudo,@Param("email") String email,@Param("nom") String nom,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND email LIKE %:email% " +
            " AND prenom LIKE %:prenom% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoEmailPrenomBibliotheque(@Param("pseudo") String pseudo,@Param("email") String email,@Param("prenom") String prenom,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND nom LIKE %:nom% " +
            " AND prenom LIKE %:prenom% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoNomPrenomBibliotheque(@Param("pseudo") String pseudo,@Param("nom") String nom,@Param("prenom") String prenom,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " email LIKE %:email% " +
            " AND nom LIKE %:nom% " +
            " AND prenom LIKE %:prenom% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonneEmailNomPrenomBibliotheque(@Param("email") String email,@Param("nom") String nom,@Param("prenom") String prenom,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND email LIKE %:email% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoEmailBibliotheque(@Param("pseudo") String pseudo,@Param("email") String email,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " nom LIKE %:nom% " +
            " AND prenom LIKE %:prenom% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonneNomPrenomBibliotheque(@Param("nom") String nom,@Param("prenom") String prenom, @Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND prenom LIKE %:prenom% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoPrenomBibliotheque(@Param("pseudo") String pseudo,@Param("prenom") String prenom,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " email LIKE %:email% " +
            " AND nom LIKE %:nom% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonneEmailNomBibliotheque(@Param("email") String email,@Param("nom") String nom,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " email LIKE %:email% " +
            " AND prenom LIKE %:prenom% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonneEmailPrenomBibliotheque(@Param("email") String email,@Param("prenom") String prenom,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND nom LIKE %:nom% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoNomBibliotheque(@Param("pseudo") String pseudo,@Param("nom") String nom,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " pseudo LIKE %:pseudo%" +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePseudoBibliotheque(@Param("pseudo") String pseudo,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " email LIKE %:email% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonneEmailBibliotheque(@Param("email") String email,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " nom LIKE %:nom% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonneNomBibliotheque(@Param("nom") String nom,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM pret,abonne WHERE " +
            " prenom LIKE %:prenom% " +
            " AND bibliotheque_id = :bibliothequeId " +
            " AND pret.abonne_id = abonne.id ",nativeQuery = true)
    List<Pret> getListPretAbonnePrenomBibliotheque(@Param("prenom") String prenom,@Param("bibliothequeId") Integer bibliothequeId);

    Pret findById(int id);


}
