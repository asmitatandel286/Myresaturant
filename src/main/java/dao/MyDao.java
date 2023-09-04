package dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Customer;
import dto.FoodType;

public class MyDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void add(Customer c) {
		et.begin();
		em.persist(c);
		et.commit();
	}

	public void addfoodtype(FoodType f) {
		et.begin();
		em.persist(f);
		et.commit();
	}

	public Customer fetchByEmail(String email) {
		// Query query = em.createQuery("select x from Customer x where
		// email=?1").setParameter(1, email);
//		Query query=em.createQuery("select x from Customer x where email=?1").setParameter(1, email);
		List<Customer> list = em.createQuery("select x from Customer x where email=?1").setParameter(1, email)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Customer fetchByPhone(long phone) {

		List<Customer> list = em.createQuery("select x from Customer x where phone=?1").setParameter(1, phone)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public List<FoodType> fetchAllItem() {
		return em.createQuery("select x from FoodType x").getResultList();
	}

	public FoodType find(int id) {

		return em.find(FoodType.class, id);
	}

	public void delete(FoodType item) {

		et.begin();
		em.remove(item);
		et.commit();

	}

	public void update(FoodType food) {

		et.begin();
		em.merge(food);
		et.commit();
		
	}

	public List<Customer> fetchCustomer() {
		return em.createQuery("select x from Customer x").getResultList();
	}

	public Customer findcusId(int id) {
		return em.find(Customer.class, id);
	}

	public void deleteCus(Customer c) {

		et.begin();
		em.remove(c);
		et.commit();

		
	}

}
