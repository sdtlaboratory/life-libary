package com.sdtLabalatory.libary_life.app.repository.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import com.sdtLabalatory.libary_life.app.repository.base.GenericDao;

public interface HibernateDao<T, PK extends Serializable> extends GenericDao<T, PK> {
	
	List<T> findByCriteria(Criterion criterion);

}
