package com.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {
	
	public static void main (String[] arg) {
		
		StandardServiceRegistry ssr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		Employee e1=new Employee();
		e1.setId(10);
		e1.setFirstName("hari");
		e1.setLastName("krishnan");
		
		session.save(e1);
		t.commit();
		System.out.println("succesfully saved");
		factory.close();
		session.close();
		
		
	}

}
