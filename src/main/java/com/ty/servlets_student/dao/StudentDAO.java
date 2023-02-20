package com.ty.servlets_student.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.servlets_student.dto.Student;


public class StudentDAO {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveStudent(Student student ) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}
	
	public Student getStudent(int id) {
		EntityManager entityManager=getEntityManager();
		String jpql="select s from Student s where s.id=?1 ";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, id);
		Student student=(Student)query.getSingleResult();
		return student;
	}


}
