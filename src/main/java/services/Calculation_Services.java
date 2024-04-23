package services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejbs.Calculation;

@Stateless
@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Calculation_Services {

    @PersistenceContext(unitName = "hello")
    private EntityManager em;

    

    public int oper(Calculation user) {
        if (user.getOperation().equals("*")) { 
            return user.multii(); 
        } else if (user.getOperation().equals("+")) { 
            return user.suum(); // *
        } else if (user.getOperation().equals("-")) { 
            return user.suub(); 
        } else {
            return user.divv();
        }
    }

    @Path("calc")
    @POST
    public String save(Calculation a) {
    	try {
        em.persist(a);
        return "result = "+oper(a);}
    	catch(Exception e) {
    		return e.getMessage();
    	}
    }
    @Path("calculations")
	@GET
	public Response getAll(){
		try {
			return Response.ok(em.createQuery("SELECT c FROM Calculation c").getResultList()).build();
		}catch(Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
}
