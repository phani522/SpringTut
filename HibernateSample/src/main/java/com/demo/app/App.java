package com.demo.app;

//import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.demo.Alien;
import com.demo.AlienName;
import com.demo.Laptop;
import com.demo.Student;
import javax.persistence.*;
//import jakarta.transaction.Transaction;
import org.hibernate.*;
import org.hibernate.Query;

public class App {
	

	public static void main(String[] args) {
		/*
		 * AlienName alienName = new AlienName();
		 * alienName.setFname("phani");alienName.setMname("kanth");alienName.setLname(
		 * "J"); Alien alien=new Alien(); alien.setAid(1); alien.setAname(alienName);
		 * alien.setColor("white");
		 */
		
		Alien a =null;
		
		/*
		 * Laptop l=new Laptop(); l.setlId(2);l.setLname("HP"); Student student=new
		 * Student();
		 * student.setRoll(101);student.setName("Phani");student.setMarks(78);
		 * student.getLaptop().add(l); //l.setStudent(student);
		 */		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		//ServiceRegistry reg=new ServiceRegistryBuild
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		/*
		 * session.save(student); session.save(l);
		 */
		a=(Alien)session.get(Alien.class, 1);
		System.out.println(a);
		
		System.out.println("----------------------------");
		a=(Alien)session.get(Alien.class, 1);
		System.out.println(a);
		System.out.println("----------------------------");
		
		tx.commit();
		session.close();
		
		  Session session2=sf.openSession(); session2.beginTransaction();
		  //org.hibernate.Query q=session2.createQuery("from alien where aid=1");
		  Query q1=session2.createQuery("from Alien where aid=1");
		  q1.setCacheable(true);
		  a=(Alien)q1.uniqueResult();
		  //a=(Alien) q.uniqueResult(); 
		 // a=(Alien) session2.get(Alien.class, 1);
		  System.out.println(a); session2.getTransaction().commit();
		 
	
	
	}

}
