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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Benjamin
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName"),
    @NamedQuery(name = "Users.findByUserMail", query = "SELECT u FROM Users u WHERE u.userMail = :userMail"),
    @NamedQuery(name = "Users.findByUserAge", query = "SELECT u FROM Users u WHERE u.userAge = :userAge")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "userName")
    private String userName;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userMail")
    private String userMail;
    @Column(name = "userAge")
    private Integer userAge;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<Groupxusers> groupxusersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<Subscription> subscriptionCollection;

    public Users() {
    }

    public Users(String userMail) {
        this.userMail = userMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @XmlTransient
    public Collection<Groupxusers> getGroupxusersCollection() {
        return groupxusersCollection;
    }

    public void setGroupxusersCollection(Collection<Groupxusers> groupxusersCollection) {
        this.groupxusersCollection = groupxusersCollection;
    }

    @XmlTransient
    public Collection<Subscription> getSubscriptionCollection() {
        return subscriptionCollection;
    }

    public void setSubscriptionCollection(Collection<Subscription> subscriptionCollection) {
        this.subscriptionCollection = subscriptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userMail != null ? userMail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userMail == null && other.userMail != null) || (this.userMail != null && !this.userMail.equals(other.userMail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.Users[ userMail=" + userMail + " ]";
    }
    
}
