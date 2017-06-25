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
    @NamedQuery(name = "Mailinggroup.findByGroupId", query = "SELECT m FROM Mailinggroup m WHERE m.groupId = :groupId"),
    @NamedQuery(name = "Mailinggroup.findByGroupName", query = "SELECT m FROM Mailinggroup m WHERE m.groupName = :groupName")})
public class Mailinggroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "groupId")
    private Integer groupId;
    @Size(max = 255)
    @Column(name = "groupName")
    private String groupName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mailinggroup")
    private Collection<Groupxusers> groupxusersCollection;

    public Mailinggroup() {
    }

    public Mailinggroup(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mailinggroup)) {
            return false;
        }
        Mailinggroup other = (Mailinggroup) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.Mailinggroup[ groupId=" + groupId + " ]";
    }
    
}
