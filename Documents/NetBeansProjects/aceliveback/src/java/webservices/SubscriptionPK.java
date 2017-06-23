/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Benjamin
 */
@Embeddable
public class SubscriptionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userMail")
    private String userMail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "newsletterId")
    private int newsletterId;

    public SubscriptionPK() {
    }

    public SubscriptionPK(String userMail, int newsletterId) {
        this.userMail = userMail;
        this.newsletterId = newsletterId;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getNewsletterId() {
        return newsletterId;
    }

    public void setNewsletterId(int newsletterId) {
        this.newsletterId = newsletterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userMail != null ? userMail.hashCode() : 0);
        hash += (int) newsletterId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubscriptionPK)) {
            return false;
        }
        SubscriptionPK other = (SubscriptionPK) object;
        if ((this.userMail == null && other.userMail != null) || (this.userMail != null && !this.userMail.equals(other.userMail))) {
            return false;
        }
        if (this.newsletterId != other.newsletterId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.SubscriptionPK[ userMail=" + userMail + ", newsletterId=" + newsletterId + " ]";
    }
    
}
