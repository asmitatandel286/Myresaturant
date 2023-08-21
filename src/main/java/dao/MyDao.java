package dao;

import java.util.List;
import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Customer;

public class MyDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
		
	public void add(Customer c) {
		et.begin();
		em.persist(c);
		et.commit();
	}


	public Customer fetchByEmail(String email) {
		//Query query = em.createQuery("select x from Customer x where email=?1").setParameter(1, email);
//		Query query=em.createQuery("select x from Customer x where email=?1").setParameter(1, email);
		List<Customer> list=em.createQuery("select x from Customer x where email=?1").setParameter(1, email).getResultList();
		if(list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
	}


	public Customer fetchByPhone(long phone) {
		
		List<Customer> list=em.createQuery("select x from Customer x where phone=?1").setParameter(1, phone).getResultList();
		if(list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
	}
	
}
