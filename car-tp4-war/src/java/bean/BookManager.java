package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import db.Books;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Implémentation du gestionnaire de livre.
 * 
 * @author Jean-Serge Monbailly
 */
@Singleton
public class BookManager implements BookManageerItf {

    @PersistenceContext
    private EntityManager em;
     
    /**
     * Initialise la base avec quelques livres.
     */    
    @Override
    @PostConstruct
    public void init(){
        addBook("Harry Potter", "J.K Rowling", 1997);
        addBook("Le seigneur des anneaux", "J.R.R Tolkien", 1954);
        addBook("Bilbo le hobbit", "J.R.R Tolkien", 1937);
        addBook("La cité des ténèbres", "Cassandra Clare", 2007);
        addBook("Uglies", "Scott Westerfeld", 2005);
    }
    
    /**
     * Ajoute un nouveau livre dans la base.
     * 
     * @param titre le titre du livre à ajouter
     * @param auteur le nom de l'auteur du livre à ajouter
     * @param annee l'année de parution du livre
     */
    @Override
    public void addBook(String titre, String auteur, int annee) {
        Books livre = new Books(titre, auteur, annee);
        em.persist(livre);
    }

    /**
     * Retourne un affichage en chaîne de caractère du livre demandé.
     * Retourne un message d'erreur au cas où le livre en question n'existe pas
     * dans la base.
     * 
     * @param titre le titre du livre recherché
     * @return le livre demandé 
     */
    @Override
    public String getBook(String titre) {
        Query q;
        q = em.createQuery("SELECT OBJECT(b) FROM Books b WHERE b.titre = :t");
        q.setParameter("t", titre);
        String retour;
        
        try{
            retour = q.getSingleResult().toString();
        }catch(NoResultException e){
            retour = "Le livre demandé n'existe pas dans la base.";
        }
        return retour;
    }

    /**
     * Liste les auteurs ayant au moins un livre dans la base.
     * 
     * @return la liste de tous les auteurs enregistrés
     */
    @Override
    public String listAllAuthors() {
       Query q;
       q = em.createQuery("SELECT DISTINCT b.auteur FROM Books b");
       
       String retour;
       
       try{
           retour = q.getResultList().toString();
       }catch(NoResultException e){
           retour = "Aucun auteur n'est présent dans la base.";
       }
       
       return retour;
    }

    /**
     * Retourne la liste de tous les livres dans la base.
     * 
     * @return la liste des livres de la base
     */
    @Override
    public String listAllBooks() {
        Query q;
        q = em.createQuery("SELECT OBJECT(b) FROM Books b");
        
        String retour;
        
        try{
            retour = q.getResultList().toString();
        } catch(NoResultException e){
            retour = "Aucune entrée dans la base.";
        }
        
        return retour;
    }

}
