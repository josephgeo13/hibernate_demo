package org.jsp.hibernatedemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByName {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the username to display the details");
		String name=sc.next();
		String qry="select u from User u where u.name=?1";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, name);
		List<User> users =q.getResultList();
		if(users.size()>0)
		{
			for(User u:users)
			{
				System.out.println("id:"+u.getId());
				System.out.println("name:"+u.getName());
				System.out.println("email:"+u.getEmail());
				System.out.println("phone:"+u.getPhone());
			}
		}
		else
		{
			System.err.println("No user found with the entered name");
		}
		sc.close();
			
	}

}
