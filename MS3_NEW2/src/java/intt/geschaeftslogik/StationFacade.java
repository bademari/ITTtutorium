/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intt.geschaeftslogik;

import intt.datenlogik.Station;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author inttentwickler
 */


@Stateless
public class StationFacade extends AbstractFacade<Station> {  /*erbt von der abstrakten Methode AbstractFacade*/

    @PersistenceContext(unitName = "Marius_TestatPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StationFacade() {
        super(Station.class);
    }
    
    /*kann hier mit Methoden erweitert werden, um NamedQueries aus der Entity Bean Station.java unter der Datenlogik verwendet
    oder über die persisten Fasade AbstractFacade.java die generischen Methoden, die diese für sämtliche Klassen anbietet verwenden*/
    
}
