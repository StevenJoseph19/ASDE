package com.mycompany.hibernatefundamentals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mycompany.hibernatefundamentals.airport.Passenger;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex03");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Passenger john = new Passenger(1, "John Smith");
		john.setCity("Boston");
		john.setStreet("Flowers Street");
		john.setNumber("3");
		john.setZipCode("012345");

		john.setAreaCode("302");
		john.setPrefix("231");
		john.setLineNumber("951235");

		em.persist(john);

		em.getTransaction().commit();
		emf.close();

	}

}
