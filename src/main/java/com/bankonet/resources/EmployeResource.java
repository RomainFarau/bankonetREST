package com.bankonet.resources;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.bankonet.ejb.EmployeEJB;
import com.bankonet.model.Employe;


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
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employe findById(@PathParam("id") Integer id){
		
		Employe employe=employeEjb.findById(id);
		if(employe!=null){
				Reponse("200");
		}else{
			Reponse("404 Not Found");
		}
		return employe;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addEmploye(){
		Employe employe= new Employe();
		
		employeEjb.addEmploye(employe);
		Reponse("200");
	}
}
