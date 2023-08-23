package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteUser {
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the user id to be deleted");
		int id = sc.nextInt();
		User u = s.get(User.class, id);
		Transaction t = s.beginTransaction();
		if (u != null) {
			s.delete(u);
			t.commit();
		} else {
			System.err.println("You have entered an invalid id");
		}
		sc.close();
	}

}
