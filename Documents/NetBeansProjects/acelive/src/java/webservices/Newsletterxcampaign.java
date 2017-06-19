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
@Table(name = "NEWSLETTERXCAMPAIGN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Newsletterxcampaign.findAll", query = "SELECT n FROM Newsletterxcampaign n"),
    @NamedQuery(name = "Newsletterxcampaign.findByNewsletterId", query = "SELECT n FROM Newsletterxcampaign n WHERE n.newsletterxcampaignPK.newsletterId = :newsletterId"),
    @NamedQuery(name = "Newsletterxcampaign.findByCampaignId", query = "SELECT n FROM Newsletterxcampaign n WHERE n.newsletterxcampaignPK.campaignId = :campaignId"),
    @NamedQuery(name = "Newsletterxcampaign.findByInscriptionCampaign", query = "SELECT n FROM Newsletterxcampaign n WHERE n.inscriptionCampaign = :inscriptionCampaign")})
public class Newsletterxcampaign implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NewsletterxcampaignPK newsletterxcampaignPK;
    @Column(name = "inscriptionCampaign")
    @Temporal(TemporalType.DATE)
    private Date inscriptionCampaign;
    @JoinColumn(name = "newsletterId", referencedColumnName = "newsletterId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Newsletter newsletter;
    @JoinColumn(name = "campaignId", referencedColumnName = "campaignId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Campaign campaign;

    public Newsletterxcampaign() {
    }

    public Newsletterxcampaign(NewsletterxcampaignPK newsletterxcampaignPK) {
        this.newsletterxcampaignPK = newsletterxcampaignPK;
    }

    public Newsletterxcampaign(int newsletterId, int campaignId) {
        this.newsletterxcampaignPK = new NewsletterxcampaignPK(newsletterId, campaignId);
    }

    public NewsletterxcampaignPK getNewsletterxcampaignPK() {
        return newsletterxcampaignPK;
    }

    public void setNewsletterxcampaignPK(NewsletterxcampaignPK newsletterxcampaignPK) {
        this.newsletterxcampaignPK = newsletterxcampaignPK;
    }

    public Date getInscriptionCampaign() {
        return inscriptionCampaign;
    }

    public void setInscriptionCampaign(Date inscriptionCampaign) {
        this.inscriptionCampaign = inscriptionCampaign;
    }

    public Newsletter getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Newsletter newsletter) {
        this.newsletter = newsletter;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsletterxcampaignPK != null ? newsletterxcampaignPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Newsletterxcampaign)) {
            return false;
        }
        Newsletterxcampaign other = (Newsletterxcampaign) object;
        if ((this.newsletterxcampaignPK == null && other.newsletterxcampaignPK != null) || (this.newsletterxcampaignPK != null && !this.newsletterxcampaignPK.equals(other.newsletterxcampaignPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.Newsletterxcampaign[ newsletterxcampaignPK=" + newsletterxcampaignPK + " ]";
    }
    
}
