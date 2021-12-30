package com.webapp.crm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.crm.entity.Customer;

@Repository
public class CustomerDAoImpl implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session appSession = sessionFactory.getCurrentSession();

		@SuppressWarnings("deprecation")
		Query<Customer> query = appSession.createQuery("from Customer order by name");

		List<Customer> resList = query.getResultList();

		return resList;

	}

	@Override
	public void saveCustomer(Customer newCustomer) {
		
		Session appSession = sessionFactory.getCurrentSession();
		
		appSession.saveOrUpdate(newCustomer);
		
	}

	@Override
	public Customer getCustomerByID(int id) {
		
		Session appSession = sessionFactory.getCurrentSession();

		Customer dbCopy = appSession.get(Customer.class, id); 
		return dbCopy;
	}

	@Override
	public void deleteById(int id) {
		Session appSession = sessionFactory.getCurrentSession();
		
		Query<Customer> query = appSession.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", id);
		
		query.executeUpdate();
	}

}
