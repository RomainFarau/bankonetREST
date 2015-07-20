package com.bankonet.ejb;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;











import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bankonet.model.Client;
import com.bankonet.model.Departement;
import com.bankonet.model.Employe;

@Stateless
public class EmployeEJB {
	
	@PersistenceContext(unitName="bankonetRest") private EntityManager em;

	public List<Employe> findAll(){
		List<Employe> employes=new ArrayList<Employe>();
		try{
			String textQuery="Select e From Employe e";
			Query query=em.createQuery(textQuery);
			
			employes=(List<Employe>)query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Force l'appel aux gets
		for(Employe e : employes) {
			System.out.println(e.getProjets());
			System.out.println(e.getParticipations());
		}
		
		return employes;
	}
	
	public Employe findById(Integer id){
		Employe employe=new Employe();
		System.out.println("Cherche employe");
		try{
			//String textQuery="Select e From Employe e Where e.id='"+id.toString()+"'";
			//Query query=em.createQuery(textQuery);
			employe=em.find(Employe.class, id);
			//employe=(Employe)query.getResultList().get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(employe.getProjets());
		System.out.println(employe.getParticipations());
		
		return employe;
	}
	
	public void addEmploye(Employe employe){
		em.persist(employe);
	}
	
	 private void closeConnection(Connection connection)
	    {
	        try
	        {
	            if (connection != null && (!connection.isClosed()))
	            {
	                connection.close();
	            }
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	            
	        }
	    }
}
