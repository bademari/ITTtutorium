/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intt.geschaeftslogik;

import intt.datenlogik.Sales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author inttentwickler
 */
@Stateless
public class SalesFacade extends AbstractFacade<Sales> {

    @PersistenceContext(unitName = "Marius_TestatPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalesFacade() {
        super(Sales.class);
    }
    
}
