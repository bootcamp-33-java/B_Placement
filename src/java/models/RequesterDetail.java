/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tutus W
 */
@Entity
@Table(name = "REQUESTER_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequesterDetail.findAll", query = "SELECT r FROM RequesterDetail r")
    , @NamedQuery(name = "RequesterDetail.findById", query = "SELECT r FROM RequesterDetail r WHERE r.id = :id")
    , @NamedQuery(name = "RequesterDetail.findByQuantity", query = "SELECT r FROM RequesterDetail r WHERE r.quantity = :quantity")
    , @NamedQuery(name = "RequesterDetail.findByStartDate", query = "SELECT r FROM RequesterDetail r WHERE r.startDate = :startDate")
    , @NamedQuery(name = "RequesterDetail.findByEndDate", query = "SELECT r FROM RequesterDetail r WHERE r.endDate = :endDate")
    , @NamedQuery(name = "RequesterDetail.findByNote", query = "SELECT r FROM RequesterDetail r WHERE r.note = :note")})
public class RequesterDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "NOTE")
    private String note;
    @JoinColumn(name = "REQUESTER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Requester requester;
    @JoinColumn(name = "SKILL", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Skill skill;

    public RequesterDetail() {
    }

    public RequesterDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Requester getRequester() {
        return requester;
    }

    public void setRequester(Requester requester) {
        this.requester = requester;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequesterDetail)) {
            return false;
        }
        RequesterDetail other = (RequesterDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.RequesterDetail[ id=" + id + " ]";
    }
    
}
