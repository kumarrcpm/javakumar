package com.maan.eway.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.maan.eway.auth.dto.LoginRequest;
import com.maan.eway.auth.service.LoginCriteriaQueryService;
import com.maan.eway.auth.token.passwordEnc;
import com.maan.eway.bean.LoginMaster;

@Component
public class LoginCriteriaQueryServiceImpl implements LoginCriteriaQueryService {

	private Logger log = LogManager.getLogger(LoginCriteriaQueryServiceImpl.class);
	
	@PersistenceContext
	private EntityManager em;

	public List<LoginMaster> isvalidUser(LoginRequest req) {
		List<LoginMaster> data = new ArrayList<LoginMaster>();
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<LoginMaster> query = cb.createQuery(LoginMaster.class);

			Root<LoginMaster> login = query.from(LoginMaster.class);

			passwordEnc passEnc = new passwordEnc();
			String password = passEnc.crypt(req.getPassword().trim());

			Predicate p1 = cb.equal(login.get("loginId"), req.getLoginId());
			Predicate p3 = cb.equal(login.get("password"), password);
			Predicate p2 = cb.equal(login.get("status"), "Y");
			query.select(login).where(p1, p2, p3);

			TypedQuery<LoginMaster> result = em.createQuery(query);
			data = result.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

		
}

