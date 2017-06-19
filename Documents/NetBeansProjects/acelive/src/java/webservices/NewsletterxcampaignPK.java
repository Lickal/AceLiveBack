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

/**
 *
 * @author Benjamin
 */
@Embeddable
public class NewsletterxcampaignPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "newsletterId")
    private int newsletterId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "campaignId")
    private int campaignId;

    public NewsletterxcampaignPK() {
    }

    public NewsletterxcampaignPK(int newsletterId, int campaignId) {
        this.newsletterId = newsletterId;
        this.campaignId = campaignId;
    }

    public int getNewsletterId() {
        return newsletterId;
    }

    public void setNewsletterId(int newsletterId) {
        this.newsletterId = newsletterId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) newsletterId;
        hash += (int) campaignId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewsletterxcampaignPK)) {
            return false;
        }
        NewsletterxcampaignPK other = (NewsletterxcampaignPK) object;
        if (this.newsletterId != other.newsletterId) {
            return false;
        }
        if (this.campaignId != other.campaignId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.NewsletterxcampaignPK[ newsletterId=" + newsletterId + ", campaignId=" + campaignId + " ]";
    }
    
}
