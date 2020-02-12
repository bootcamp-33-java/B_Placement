/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tutus W
 */
@Entity
@Table(name = "REQUESTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requester.findAll", query = "SELECT r FROM Requester r")
    , @NamedQuery(name = "Requester.findById", query = "SELECT r FROM Requester r WHERE r.id = :id")
    , @NamedQuery(name = "Requester.findByUserName", query = "SELECT r FROM Requester r WHERE r.userName = :userName")
    , @NamedQuery(name = "Requester.findBySiteName", query = "SELECT r FROM Requester r WHERE r.siteName = :siteName")
    , @NamedQuery(name = "Requester.findByAddress", query = "SELECT r FROM Requester r WHERE r.address = :address")
    , @NamedQuery(name = "Requester.findByDivision", query = "SELECT r FROM Requester r WHERE r.division = :division")
    , @NamedQuery(name = "Requester.findByTeam", query = "SELECT r FROM Requester r WHERE r.team = :team")})
public class Requester implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "SITE_NAME")
    private String siteName;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "DIVISION")
    private String division;
    @Column(name = "TEAM")
    private String team;
    @OneToMany(mappedBy = "requester", fetch = FetchType.LAZY)
    private List<Interview> interviewList;
    @OneToMany(mappedBy = "requester", fetch = FetchType.LAZY)
    private List<RequesterDetail> requesterDetailList;

    public Requester() {
    }

    public Requester(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @XmlTransient
    public List<Interview> getInterviewList() {
        return interviewList;
    }

    public void setInterviewList(List<Interview> interviewList) {
        this.interviewList = interviewList;
    }

    @XmlTransient
    public List<RequesterDetail> getRequesterDetailList() {
        return requesterDetailList;
    }

    public void setRequesterDetailList(List<RequesterDetail> requesterDetailList) {
        this.requesterDetailList = requesterDetailList;
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
        if (!(object instanceof Requester)) {
            return false;
        }
        Requester other = (Requester) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Requester[ id=" + id + " ]";
    }
    
}
