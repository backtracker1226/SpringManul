package org.backtracker.persistence;

import org.backtracker.domain.BoardVO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO extends GenericDAO<BoardVO, Integer> {
	
	
	
	public String getTime(){
		return sess.selectOne("org.backtracker.mapperTest.getTime");
	}

}
