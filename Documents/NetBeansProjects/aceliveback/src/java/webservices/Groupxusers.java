/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author Benjamin
 */
@Entity
@Table(name = "GROUPXUSERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupxusers.findAll", query = "SELECT g FROM Groupxusers g"),
    @NamedQuery(name = "Groupxusers.findByGroupId", query = "SELECT g FROM Groupxusers g WHERE g.groupxusersPK.groupId = :groupId"),
    @NamedQuery(name = "Groupxusers.findByUserMail", query = "SELECT g FROM Groupxusers g WHERE g.groupxusersPK.userMail = :userMail"),
    @NamedQuery(name = "Groupxusers.findByInscriptionGroupe", query = "SELECT g FROM Groupxusers g WHERE g.inscriptionGroupe = :inscriptionGroupe")})
public class Groupxusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GroupxusersPK groupxusersPK;
    @Column(name = "inscriptionGroupe")
    @Temporal(TemporalType.DATE)
    private Date inscriptionGroupe;
    @JoinColumn(name = "groupId", referencedColumnName = "groupId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Mailinggroup mailinggroup;
    @JoinColumn(name = "userMail", referencedColumnName = "userMail", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Groupxusers() {
    }

    public Groupxusers(GroupxusersPK groupxusersPK) {
        this.groupxusersPK = groupxusersPK;
    }

    public Groupxusers(int groupId, String userMail) {
        this.groupxusersPK = new GroupxusersPK(groupId, userMail);
    }

    public GroupxusersPK getGroupxusersPK() {
        return groupxusersPK;
    }

    public void setGroupxusersPK(GroupxusersPK groupxusersPK) {
        this.groupxusersPK = groupxusersPK;
    }

    public Date getInscriptionGroupe() {
        return inscriptionGroupe;
    }

    public void setInscriptionGroupe(Date inscriptionGroupe) {
        this.inscriptionGroupe = inscriptionGroupe;
    }

    public Mailinggroup getMailinggroup() {
        return mailinggroup;
    }

    public void setMailinggroup(Mailinggroup mailinggroup) {
        this.mailinggroup = mailinggroup;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupxusersPK != null ? groupxusersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupxusers)) {
            return false;
        }
        Groupxusers other = (Groupxusers) object;
        if ((this.groupxusersPK == null && other.groupxusersPK != null) || (this.groupxusersPK != null && !this.groupxusersPK.equals(other.groupxusersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.Groupxusers[ groupxusersPK=" + groupxusersPK + " ]";
    }
    
}
