package fr.oc.projet.microservicelivreunique.dao;

import fr.oc.projet.microservicelivreunique.model.LivreUnique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreUniqueDao extends JpaRepository<LivreUnique,Integer> {
    LivreUnique findById(int id);

    Integer countLivreUniqueByLivreIdAndBibliothequeIdAndDisponibleIsTrue(int livreId, int bibliothequeId);

    Integer countLivreUniqueByLivreIdAndDisponibleIsTrue(int livreId);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE l.titre LIKE %:titre%" +
            " AND l.auteur LIKE %:auteur% " +
            " AND l.isbn LIKE %:isbn% " +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueTitreAuteurISBN(@Param("titre") String titre,@Param("auteur") String auteur,@Param("isbn") String isbn);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE l.titre LIKE %:titre%" +
            " AND l.auteur LIKE %:auteur% " +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueTitreAuteur(@Param("titre") String titre,@Param("auteur") String auteur);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE " +
            " l.auteur LIKE %:auteur% " +
            " AND l.isbn LIKE %:isbn% " +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueAuteurISBN(@Param("auteur") String auteur,@Param("isbn") String isbn);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE l.titre LIKE %:titre%" +
            " AND l.isbn LIKE %:isbn% " +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueTitreISBN(@Param("titre") String titre,@Param("isbn") String isbn);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE l.titre LIKE %:titre%" +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueTitre(@Param("titre") String titre);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE " +
            " l.auteur LIKE %:auteur% " +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueAuteur(@Param("auteur") String auteur);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE " +
            " l.isbn LIKE %:isbn% " +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueISBN(@Param("isbn") String isbn);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE l.titre LIKE %:titre%" +
            " AND l.auteur LIKE %:auteur% " +
            " AND l.isbn LIKE %:isbn% " +
            " AND bibliotheque_id = :bibliothequeId" +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueTitreAuteurISBNBibliotheque(@Param("titre") String titre,@Param("auteur") String auteur,@Param("isbn") String isbn,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE l.titre LIKE %:titre%" +
            " AND l.auteur LIKE %:auteur% " +
            " AND bibliotheque_id = :bibliothequeId" +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueTitreAuteurBibliotheque(@Param("titre") String titre,@Param("auteur") String auteur,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE " +
            " l.auteur LIKE %:auteur% " +
            " AND l.isbn LIKE %:isbn% " +
            " AND bibliotheque_id = :bibliothequeId" +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueAuteurISBNBibliotheque(@Param("auteur") String auteur,@Param("isbn") String isbn,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE l.titre LIKE %:titre%" +
            " AND l.isbn LIKE %:isbn% " +
            " AND bibliotheque_id = :bibliothequeId" +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueTitreISBNBibliotheque(@Param("titre") String titre,@Param("isbn") String isbn,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE l.titre LIKE %:titre%" +
            " AND bibliotheque_id = :bibliothequeId" +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueTitreBibliotheque(@Param("titre") String titre,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE " +
            " l.auteur LIKE %:auteur% " +
            " AND bibliotheque_id = :bibliothequeId" +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueAuteurBibliotheque(@Param("auteur") String auteur,@Param("bibliothequeId") Integer bibliothequeId);

    @Query(value = "SELECT * FROM livre_unique,livre l WHERE " +
            " l.isbn LIKE %:isbn% " +
            " AND bibliotheque_id = :bibliothequeId" +
            " AND l.id = livre_unique.livre_id " +
            "  ORDER BY titre ",
            nativeQuery = true)
    List<LivreUnique> getListLivreUniqueISBNBibliotheque(@Param("isbn") String isbn,@Param("bibliothequeId") Integer bibliothequeId);
}
