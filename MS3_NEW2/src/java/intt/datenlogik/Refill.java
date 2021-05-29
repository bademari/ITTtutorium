/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intt.datenlogik;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inttentwickler
 */
@Entity
@Table(name = "refill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Refill.findAll", query = "SELECT r FROM Refill r"),
    @NamedQuery(name = "Refill.findByRefillID", query = "SELECT r FROM Refill r WHERE r.refillID = :refillID"),
    @NamedQuery(name = "Refill.findByAmount", query = "SELECT r FROM Refill r WHERE r.amount = :amount"),
    @NamedQuery(name = "Refill.findByTimestamp", query = "SELECT r FROM Refill r WHERE r.timestamp = :timestamp")})
public class Refill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "refillID")
    private Integer refillID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @JoinColumn(name = "stationID", referencedColumnName = "stationID")
    @ManyToOne(optional = false)
    private Station stationID;
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    @ManyToOne(optional = false)
    private Products productID;

    public Refill() {
    }

    public Refill(Integer refillID) {
        this.refillID = refillID;
    }

    public Refill(Integer refillID, int amount, Date timestamp) {
        this.refillID = refillID;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Integer getRefillID() {
        return refillID;
    }

    public void setRefillID(Integer refillID) {
        this.refillID = refillID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Station getStationID() {
        return stationID;
    }

    public void setStationID(Station stationID) {
        this.stationID = stationID;
    }

    public Products getProductID() {
        return productID;
    }

    public void setProductID(Products productID) {
        this.productID = productID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refillID != null ? refillID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Refill)) {
            return false;
        }
        Refill other = (Refill) object;
        if ((this.refillID == null && other.refillID != null) || (this.refillID != null && !this.refillID.equals(other.refillID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intt.datenlogik.Refill[ refillID=" + refillID + " ]";
    }
    
}
