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
public class GroupxusersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "groupId")
    private int groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userMail")
    private String userMail;

    public GroupxusersPK() {
    }

    public GroupxusersPK(int groupId, String userMail) {
        this.groupId = groupId;
        this.userMail = userMail;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) groupId;
        hash += (userMail != null ? userMail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupxusersPK)) {
            return false;
        }
        GroupxusersPK other = (GroupxusersPK) object;
        if (this.groupId != other.groupId) {
            return false;
        }
        if ((this.userMail == null && other.userMail != null) || (this.userMail != null && !this.userMail.equals(other.userMail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.GroupxusersPK[ groupId=" + groupId + ", userMail=" + userMail + " ]";
    }
    
}
