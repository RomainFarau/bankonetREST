package com.bankonet.resources;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.mysql.fabric.xmlrpc.Client;
import com.bankonet.EJB.EmployeEJB;
import com.bankonet.model.*;

@Path("/employes")
public class EmployeResource {


	@EJB
	EmployeEJB employeEjb;
	
	public Response Reponse(String code){
		ResponseBuilder builder=Response.ok(code);
		builder.language("fr").header("Content-type", "text/html");
		return builder.build();
	}
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employe> list() {
		List<Employe> employes = new ArrayList<Employe>();
		//employes.add(new Employe());
		employes=employeEjb.findAll();
		Reponse("200");
		return employes;
	}
	
	/*@GET
	@Path("/employes/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employe findById(@PathParam("id") Integer id){
		
		List<Employe> employes =  ;
		Iterator<Employe> it = employes.iterator();
		while(it.hasNext()){
			if(it.next().getId()==id.intValue()){
				Reponse("200");
				return it.next();
			}
		}
		Reponse("404 Not Found");
		return null;
	}
	
	@POST
	@Path("/employes")
	@Produces(MediaType.APPLICATION_JSON)
	public void addEmploye(){
		
	}*/
}
