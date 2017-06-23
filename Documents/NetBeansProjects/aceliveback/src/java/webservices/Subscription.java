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
@Table(name = "SUBSCRIPTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s"),
    @NamedQuery(name = "Subscription.findByUserMail", query = "SELECT s FROM Subscription s WHERE s.subscriptionPK.userMail = :userMail"),
    @NamedQuery(name = "Subscription.findByNewsletterId", query = "SELECT s FROM Subscription s WHERE s.subscriptionPK.newsletterId = :newsletterId"),
    @NamedQuery(name = "Subscription.findByInscriptionNewsletter", query = "SELECT s FROM Subscription s WHERE s.inscriptionNewsletter = :inscriptionNewsletter")})
public class Subscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubscriptionPK subscriptionPK;
    @Column(name = "inscriptionNewsletter")
    @Temporal(TemporalType.DATE)
    private Date inscriptionNewsletter;
    @JoinColumn(name = "userMail", referencedColumnName = "userMail", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;
    @JoinColumn(name = "newsletterId", referencedColumnName = "newsletterId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Newsletter newsletter;

    public Subscription() {
    }

    public Subscription(SubscriptionPK subscriptionPK) {
        this.subscriptionPK = subscriptionPK;
    }

    public Subscription(String userMail, int newsletterId) {
        this.subscriptionPK = new SubscriptionPK(userMail, newsletterId);
    }

    public SubscriptionPK getSubscriptionPK() {
        return subscriptionPK;
    }

    public void setSubscriptionPK(SubscriptionPK subscriptionPK) {
        this.subscriptionPK = subscriptionPK;
    }

    public Date getInscriptionNewsletter() {
        return inscriptionNewsletter;
    }

    public void setInscriptionNewsletter(Date inscriptionNewsletter) {
        this.inscriptionNewsletter = inscriptionNewsletter;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Newsletter getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Newsletter newsletter) {
        this.newsletter = newsletter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subscriptionPK != null ? subscriptionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) object;
        if ((this.subscriptionPK == null && other.subscriptionPK != null) || (this.subscriptionPK != null && !this.subscriptionPK.equals(other.subscriptionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.Subscription[ subscriptionPK=" + subscriptionPK + " ]";
    }
    
}
