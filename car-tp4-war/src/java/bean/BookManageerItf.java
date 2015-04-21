package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.ejb.Local;

/**
 * Interface du gestionnaire de livres de l'application.
 * 
 * @author Jean-Serge Monbailly
 */
@Local
public interface BookManageerItf {

    public void init();
    
    /**
     * Ajouter un livre à la base.
     * @param titre le titre du livre
     * @param auteur l'auteur du livre
     * @param annee l'année de parution du livre
     */
    public void addBook(String titre, String auteur, int annee);
    
    /**
     * Rechercher un livre dans la base
     * 
     * @param titre le titre du livre recherché
     * @return le livre demandé
     */
    public String getBook(String titre);
    
    public String listAllAuthors();
    
    public String listAllBooks();
}
