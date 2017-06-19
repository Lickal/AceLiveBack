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
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "newsletterId")
    private int newsletterId;

    public SubscriptionPK() {
    }

    public SubscriptionPK(String userName, int newsletterId) {
        this.userName = userName;
        this.newsletterId = newsletterId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        hash += (userName != null ? userName.hashCode() : 0);
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
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        if (this.newsletterId != other.newsletterId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.SubscriptionPK[ userName=" + userName + ", newsletterId=" + newsletterId + " ]";
    }
    
}
