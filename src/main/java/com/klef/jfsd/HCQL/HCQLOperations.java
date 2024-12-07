package com.klef.jfsd.HCQL;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class HCQLOperations 
{
	public static void main(String args[])
	{
		HCQLOperations operations = new HCQLOperations();
		operations.addProject();
		//operations.aggregatefunctions();
	}
	public void addProject()
	{
		 Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 
		 SessionFactory sf = cfg.buildSessionFactory();
		 Session session = sf.openSession();
		 
		 Transaction transaction = session.beginTransaction();
		 
		 Project f = new Project();
		 f.setId(102);
		 f.setProjectname("EP");
		 f.setDuration("four months");
		 f.setBudget(40000);
		 f.setTeamlead("harshi");
		 
	 	 session.persist(f);
	 	 transaction.commit();
	 	 System.out.println("Employee Added Successfully");
	 	 
	 	 session.close();
	 	 sf.close();
	}
	
	
	
	public void aggregatefunctions() 
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery<Long> cq=cb.createQuery(Long.class);
        Root<Project>  root=cq.from(Project.class);
        cq.select(cb.count(root.get("Budget")));
        Long count=session.createQuery(cq).getSingleResult();
        System.out.println("Budget count:="+count);

        CriteriaBuilder b=session.getCriteriaBuilder();
        CriteriaQuery<Double> q=b.createQuery(Double.class);
        Root<Project>  root1 =q.from(Project.class); 
        q.select(b.sum(root1.get("Budget")));
        Double sum=session.createQuery(q).getSingleResult();
        System.out.println("Budget sum:="+sum);
  
        CriteriaBuilder c=session.getCriteriaBuilder();
        CriteriaQuery<Double> h=c.createQuery(Double.class);
        Root<Project>  root2=h.from(Project.class);
        h.select(c.max(root2.get("Budget")));
        Double max=session.createQuery(h).getSingleResult();
        System.out.println("Budget:="+max);

        CriteriaBuilder cb1=session.getCriteriaBuilder();
        CriteriaQuery<Double> cq1=cb1.createQuery(Double.class);
        Root<Project>  root3=cq1.from(Project.class);
        cq1.select(cb1.min(root3.get("Budget")));
        Double min=session.createQuery(cq1).getSingleResult();
        System.out.println("Budget:="+min);

        CriteriaBuilder cb2=session.getCriteriaBuilder();
        CriteriaQuery<Double> cq2=cb2.createQuery(Double.class);
        Root<Project>  root0=cq2.from(Project.class);
        cq2.select(cb2.avg(root0.get("Budget")));
        Double avg=session.createQuery(cq2).getSingleResult();
        System.out.println(" average:="+avg);


		session.close();
		sf.close();
	}
}