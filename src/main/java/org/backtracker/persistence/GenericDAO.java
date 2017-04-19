package org.backtracker.persistence;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


public abstract class GenericDAO<E, K> {
	
	protected String mapper;
	
	@Inject
	protected SqlSessionTemplate sess;
	
	public GenericDAO() {
		mapper = this.getClass().getName();
	}
	
	public E read(K key){
		return sess.selectOne(mapper+".read", key);
	}
	
	public void create(E vo){
		sess.insert(mapper+".create", vo);
		
		
	}
	

}
