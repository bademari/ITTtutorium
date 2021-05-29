/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intt.geschaeftslogik;

import intt.datenlogik.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author inttentwickler
 */
@Stateless
public class ProductsFacade extends AbstractFacade<Products> {

    @PersistenceContext(unitName = "Marius_TestatPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductsFacade() {
        super(Products.class);
    }
    
    
    /*############eigener Code (ACHTUNG: ist von Herrn Bader##################*/
    
    public List<Products> allProducts(){
    
    List<Products> prod = em.createNamedQuery("Products.findAll").getResultList();
    return prod;
    
    
    }
    
    
    
    /*###############Ende eigener Code##########################################*/
    
}
