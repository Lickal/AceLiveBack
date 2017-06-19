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
@Table(name = "CAMPAIGN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campaign.findAll", query = "SELECT c FROM Campaign c"),
    @NamedQuery(name = "Campaign.findByCampaignId", query = "SELECT c FROM Campaign c WHERE c.campaignId = :campaignId"),
    @NamedQuery(name = "Campaign.findByCampaignName", query = "SELECT c FROM Campaign c WHERE c.campaignName = :campaignName"),
    @NamedQuery(name = "Campaign.findByCampaignDescription", query = "SELECT c FROM Campaign c WHERE c.campaignDescription = :campaignDescription"),
    @NamedQuery(name = "Campaign.findByCampaignClic", query = "SELECT c FROM Campaign c WHERE c.campaignClic = :campaignClic")})
public class Campaign implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "campaignId")
    private Integer campaignId;
    @Size(max = 255)
    @Column(name = "campaignName")
    private String campaignName;
    @Size(max = 255)
    @Column(name = "campaignDescription")
    private String campaignDescription;
    @Column(name = "campaignClic")
    private Integer campaignClic;
    @OneToMany(mappedBy = "campaignId")
    private Collection<Newsletter> newsletterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campaign")
    private Collection<Newsletterxcampaign> newsletterxcampaignCollection;

    public Campaign() {
    }

    public Campaign(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignDescription() {
        return campaignDescription;
    }

    public void setCampaignDescription(String campaignDescription) {
        this.campaignDescription = campaignDescription;
    }

    public Integer getCampaignClic() {
        return campaignClic;
    }

    public void setCampaignClic(Integer campaignClic) {
        this.campaignClic = campaignClic;
    }

    @XmlTransient
    public Collection<Newsletter> getNewsletterCollection() {
        return newsletterCollection;
    }

    public void setNewsletterCollection(Collection<Newsletter> newsletterCollection) {
        this.newsletterCollection = newsletterCollection;
    }

    @XmlTransient
    public Collection<Newsletterxcampaign> getNewsletterxcampaignCollection() {
        return newsletterxcampaignCollection;
    }

    public void setNewsletterxcampaignCollection(Collection<Newsletterxcampaign> newsletterxcampaignCollection) {
        this.newsletterxcampaignCollection = newsletterxcampaignCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campaignId != null ? campaignId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campaign)) {
            return false;
        }
        Campaign other = (Campaign) object;
        if ((this.campaignId == null && other.campaignId != null) || (this.campaignId != null && !this.campaignId.equals(other.campaignId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.Campaign[ campaignId=" + campaignId + " ]";
    }
    
}
