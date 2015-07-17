package com.bankonet.EJB;

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
			
			System.out.println(query);
			
			employes=(List<Employe>)query.getResultList();
			
			/*while(result.next()){
				Employe employe=new Employe(result.getString("NOM"));
				employe.setSalaire(BigDecimal.valueOf(Double.parseDouble(result.getString("SALAIRE"))));
				employes.add(employe);
			}*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(Employe e : employes) {
			System.out.println(e.getProjets());
			System.out.println(e.getParticipations());
		}
		
		
		//System.out.println("AAAAAAAAA");
		return employes;
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
