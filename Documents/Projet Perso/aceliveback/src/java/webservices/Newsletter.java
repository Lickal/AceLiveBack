/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Benjamin
 */
@Entity
@Table(name = "NEWSLETTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Newsletter.findAll", query = "SELECT n FROM Newsletter n"),
    @NamedQuery(name = "Newsletter.findByNewsletterId", query = "SELECT n FROM Newsletter n WHERE n.newsletterId = :newsletterId"),
    @NamedQuery(name = "Newsletter.findByNewsletterTitle", query = "SELECT n FROM Newsletter n WHERE n.newsletterTitle = :newsletterTitle"),
    @NamedQuery(name = "Newsletter.findByNewsletterDate", query = "SELECT n FROM Newsletter n WHERE n.newsletterDate = :newsletterDate"),
    @NamedQuery(name = "Newsletter.findByNewsletterPJ", query = "SELECT n FROM Newsletter n WHERE n.newsletterPJ = :newsletterPJ")})
public class Newsletter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "newsletterId")
    private Integer newsletterId;
    @Size(max = 255)
    @Column(name = "newsletterTitle")
    private String newsletterTitle;
    @Column(name = "newsletterDate")
    @Temporal(TemporalType.DATE)
    private Date newsletterDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "newsletterDescription")
    private String newsletterDescription;
    @Size(max = 255)
    @Column(name = "newsletterPJ")
    private String newsletterPJ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newsletter")
    private Collection<Subscription> subscriptionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newsletter")
    private Collection<Newsletterxcampaign> newsletterxcampaignCollection;

    public Newsletter() {
    }

    public Newsletter(Integer newsletterId) {
        this.newsletterId = newsletterId;
    }

    public Integer getNewsletterId() {
        return newsletterId;
    }

    public void setNewsletterId(Integer newsletterId) {
        this.newsletterId = newsletterId;
    }

    public String getNewsletterTitle() {
        return newsletterTitle;
    }

    public void setNewsletterTitle(String newsletterTitle) {
        this.newsletterTitle = newsletterTitle;
    }

    public Date getNewsletterDate() {
        return newsletterDate;
    }

    public void setNewsletterDate(Date newsletterDate) {
        this.newsletterDate = newsletterDate;
    }

    public String getNewsletterDescription() {
        return newsletterDescription;
    }

    public void setNewsletterDescription(String newsletterDescription) {
        this.newsletterDescription = newsletterDescription;
    }

    public String getNewsletterPJ() {
        return newsletterPJ;
    }

    public void setNewsletterPJ(String newsletterPJ) {
        this.newsletterPJ = newsletterPJ;
    }

    @XmlTransient
    public Collection<Subscription> getSubscriptionCollection() {
        return subscriptionCollection;
    }

    public void setSubscriptionCollection(Collection<Subscription> subscriptionCollection) {
        this.subscriptionCollection = subscriptionCollection;
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
        hash += (newsletterId != null ? newsletterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Newsletter)) {
            return false;
        }
        Newsletter other = (Newsletter) object;
        if ((this.newsletterId == null && other.newsletterId != null) || (this.newsletterId != null && !this.newsletterId.equals(other.newsletterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservices.Newsletter[ newsletterId=" + newsletterId + " ]";
    }
    
}
