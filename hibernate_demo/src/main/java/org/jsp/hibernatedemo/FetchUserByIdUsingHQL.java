package org.jsp.hibernatedemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByIdUsingHQL {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id to display the details");
		int id=sc.nextInt();
		String qry="select u from User u where u.id=:id";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		Query<User> q=s.createQuery(qry);
		q.setParameter("id", id);
		try {
			User u=q.getSingleResult();
			System.out.println("id:"+u.getId());
			System.out.println("name:"+u.getName());
			System.out.println("email:"+u.getEmail());
			System.out.println("phone:"+u.getPhone());
		}
		catch (NoResultException e) {
			System.err.println("You have entered an invalid id");
		}
		sc.close();
		
	}

}
