package com.example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.models.Customer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			Customer customer1 = new Customer("sergio", "diaz", "avenida del aprobado");
			
			session.beginTransaction();
			// session.save(customer1); // deprecated method
			session.persist(customer1);
			session.getTransaction().commit();
			
			System.out.println("\n\nThe new customer was added successfully");
			System.out.println(customer1);
			
			session.close();
			
		} finally {
			// TODO: handle finally clause
			sessionFactory.close();
		}
	}

}
