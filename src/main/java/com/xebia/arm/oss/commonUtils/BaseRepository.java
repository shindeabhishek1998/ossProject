package com.xebia.arm.oss.commonUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class BaseRepository {

	@PersistenceContext
	EntityManager entityManager;

	protected Session getCurrentSession() {
		return entityManager.unwrap(Session.class);
	}

}
