/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Benjamin
 */
@Entity
@Table(name = "ADMINISTRATEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrateur.findAll", query = "SELECT a FROM Administrateur a"),
    @NamedQuery(name = "Administrateur.findByAdminName", query = "SELECT a FROM Administrateur a WHERE a.adminName = :adminName"),
    @NamedQuery(name = "Administrateur.findByAdminMail", query = "SELECT a FROM Administrateur a WHERE a.adminMail = :adminMail"),
    @NamedQuery(name = "Administrateur.findByAdminPassword", query = "SELECT a FROM Administrateur a WHERE a.adminPassword = :adminPassword")})
public class Administrateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "adminName")
    private String adminName;
    @Size(max = 255)
    @Column(name = "adminMail")
    private String adminMail;
    @Size(max = 255)
    @Column(name = "adminPassword")
    private String adminPassword;

    public Administrateur() {
    }

    public Administrateur(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminMail() {
        return adminMail;
    }

    public void setAdminMail(String adminMail) {
        this.adminMail = adminMail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminName != null ? adminName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrateur)) {
            return false;
        }
        Administrateur other = (Administrateur) object;
        if ((this.adminName == null && other.adminName != null) || (this.adminName != null && !this.adminName.equals(other.adminName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.Administrateur[ adminName=" + adminName + " ]";
    }
    
}
