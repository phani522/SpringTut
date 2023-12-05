package com.demo.app;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.Stu;

public class App2 {
	public static void main(String[] args) {
		Stu st=null;
		Configuration config=new Configuration().configure().addAnnotatedClass(Stu.class);
		SessionFactory sf=config.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		//Query q=ses.createQuery("");
		Random r=new Random();
		/*
		 * for(int i=1;i<=50;i++) { st=new Stu(); st.setId(i);
		 * st.setMarks(r.nextInt(100)); st.setName("Name "+i); ses.save(st); }
		 */
		
		Query q=ses.createQuery("from Stu"); 
		
		/*
		 * List<Stu> stulist=(List<Stu>)q.list(); for(Stu s:stulist) {
		 * System.out.println(s); }
		 */
		 
		q=ses.createQuery("select id,name,marks from Stu");
		List<Object[]> stObj=q.list();
		/*
		 * for(Object[] ob:stObj) { System.out.println(ob[0]+"  "+ob[1]+"  "+ob[2]); }
		 */
		int d=60;
		q=ses.createQuery("select sum(marks) from Stu s where s.marks> :d");//"s.marks>"+d
		q.setParameter("d", d);
		Long res=(Long) q.uniqueResult();
		System.out.println(res);
		
		
		// SQL Queries.................Native Queries
		
		SQLQuery q1=ses.createSQLQuery("select * from stu");
		q1.addEntity(Stu.class);
		List<Stu> students=q1.list();
		for(Stu s:students) {
			System.out.println(s);
		}
		
		q1=ses.createSQLQuery("select marks,id from stu");
		q1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List stude=q1.list();
		for(Object o:stude) {
			Map m=(Map)o;
			System.out.println("marks :"+m.get("marks")+"  id : "+m.get("id"));
		}
		
		
		tx.commit();
	}

}
