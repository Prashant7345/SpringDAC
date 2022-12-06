package com.hibernate.inheritance.test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.CardPayment;
import com.met.model.ChequePayment;
import com.met.model.Payment;

public class HibernateInheritanceTest {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		Payment payment = new Payment();
		payment.setAmount(5000);
		payment.setPayDate(new Date(System.currentTimeMillis()));
		
		ChequePayment chequePayment = new ChequePayment();
		chequePayment.setAmount(150000);
		chequePayment.setPayDate(new Date(System.currentTimeMillis()));
		chequePayment.setBankName("ICICI");
		chequePayment.setChequeNo("12345");
		
		CardPayment cardPayment = new CardPayment();
		cardPayment.setAmount(15000);
		cardPayment.setPayDate(new Date(System.currentTimeMillis()));
		cardPayment.setCardNo("XXXX 1234");
		cardPayment.setCardType("VISA");
		
		try(Session session = sessionFactory.openSession()){
			
			Transaction tx = session.beginTransaction();
			
			session.save(payment);
			session.save(chequePayment);
			session.save(cardPayment);
			
			tx.commit();
			
		}
		
		
		
	}
	
}








