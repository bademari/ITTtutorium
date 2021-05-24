/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intt.geschaeftslogik;

import intt.datenlogik.Inventory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/**
 *
 * @author inttentwickler
 */
@Stateless
public class InventoryFacade extends AbstractFacade<Inventory> {

    @PersistenceContext(unitName = "Marius_TestatPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventoryFacade() {
        super(Inventory.class);
    }
    
    /*kann hier mit Methoden erweitert werden, um NamedQueries aus der Entity Bean Inventory.java unter der Datenlogik verwendet
    oder über die persisten Fasade AbstractFacade.java die generischen Methoden, die diese für sämtliche Klassen anbietet verwenden*/
    
    
    //#################Codeveränderung!!!!#################
    
    
    public List<Inventory> inventoryByStation(java.lang.Integer stationID){
    
        List<Inventory> inv = em.createNamedQuery("inventory.findByStationID")
                .setParameter("stationID", stationID)
                .getResultList();
        
        return inv;
    }
    
    
      
    public List<Inventory> inventoryByProduct(java.lang.Integer productID){
    
        List<Inventory> inv = em.createNamedQuery("inventory.findByProductID")
                .setParameter("productID", productID)
                .getResultList();
        
        return inv;
    }
    
    
    //#################Codeveränderung ENDE!!!!#################
    
}
