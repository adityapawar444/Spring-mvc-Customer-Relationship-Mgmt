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
		Query<Customer> query = appSession.createQuery("from Customer");

		List<Customer> resList = query.getResultList();

		return resList;

	}

}
