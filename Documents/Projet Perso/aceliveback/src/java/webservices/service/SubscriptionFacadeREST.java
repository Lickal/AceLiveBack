/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import webservices.Subscription;
import webservices.SubscriptionPK;

/**
 *
 * @author Benjamin
 */
@Stateless
@Path("webservices.subscription")
public class SubscriptionFacadeREST extends AbstractFacade<Subscription> {

    @PersistenceContext(unitName = "acelivebackPU")
    private EntityManager em;

    private SubscriptionPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;userMail=userMailValue;newsletterId=newsletterIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        webservices.SubscriptionPK key = new webservices.SubscriptionPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> userMail = map.get("userMail");
        if (userMail != null && !userMail.isEmpty()) {
            key.setUserMail(userMail.get(0));
        }
        java.util.List<String> newsletterId = map.get("newsletterId");
        if (newsletterId != null && !newsletterId.isEmpty()) {
            key.setNewsletterId(new java.lang.Integer(newsletterId.get(0)));
        }
        return key;
    }

    public SubscriptionFacadeREST() {
        super(Subscription.class);
    }

    @POST
    @Override
    @Consumes({ MediaType.APPLICATION_JSON})
    public void create(Subscription entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Subscription entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        webservices.SubscriptionPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Subscription find(@PathParam("id") PathSegment id) {
        webservices.SubscriptionPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Subscription> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Subscription> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
