/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Benjamin
 */
@Entity
@Table(name = "MAILINGGROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mailinggroup.findAll", query = "SELECT m FROM Mailinggroup m"),
    @NamedQuery(name = "Mailinggroup.findByGroupID", query = "SELECT m FROM Mailinggroup m WHERE m.groupID = :groupID"),
    @NamedQuery(name = "Mailinggroup.findByGroupName", query = "SELECT m FROM Mailinggroup m WHERE m.groupName = :groupName")})
public class Mailinggroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "groupID")
    private Integer groupID;
    @Size(max = 255)
    @Column(name = "groupName")
    private String groupName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mailinggroup")
    private Collection<Groupxusers> groupxusersCollection;

    public Mailinggroup() {
    }

    public Mailinggroup(Integer groupID) {
        this.groupID = groupID;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @XmlTransient
    public Collection<Groupxusers> getGroupxusersCollection() {
        return groupxusersCollection;
    }

    public void setGroupxusersCollection(Collection<Groupxusers> groupxusersCollection) {
        this.groupxusersCollection = groupxusersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupID != null ? groupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mailinggroup)) {
            return false;
        }
        Mailinggroup other = (Mailinggroup) object;
        if ((this.groupID == null && other.groupID != null) || (this.groupID != null && !this.groupID.equals(other.groupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.Mailinggroup[ groupID=" + groupID + " ]";
    }
    
}
