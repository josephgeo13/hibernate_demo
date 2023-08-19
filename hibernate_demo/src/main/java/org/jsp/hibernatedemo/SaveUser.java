package org.jsp.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {
	public static void main(String[] args){
		User u= new User();
		u.setEmail("abc@gmail.com");
		u.setName("ABC");
		u.setPhone(7778888);
		u.setPassword("abc123");
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		int id=(Integer) s.save(u);
		Transaction t=s.beginTransaction();
		t.commit();
		System.out.println("user registered with id:"+id);
	}

}
