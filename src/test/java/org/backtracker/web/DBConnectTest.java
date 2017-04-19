package org.backtracker.web;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.backtracker.domain.BoardVO;
import org.backtracker.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class DBConnectTest {
	
	private static Logger logger = Logger.getLogger(DBConnectTest.class);
	
	
	@Inject
	BoardDAO dao;
	
	@Inject
	DataSource ds;
	
	
	
	
	@Test
	public void tt()throws Exception{
/*		String className="com.mysql.jdbc.Driver";
		
		String url="jdbc:mysql://localhost:3306/sample_db?useSSL=false";
		
		String user="bit92";
		
		String password="bit92";
		
		Class.forName(className);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		System.out.println(con);*/
		
		Connection con = ds.getConnection();

		
		con.close();
	}
	
	@Test
	public void readTest(){
		BoardVO vo = new BoardVO();
		vo.setContent("하 제발");
		vo.setTitle("망할년아");
		vo.setWriter("내가 박정손이다!!!");
		dao.create(vo);
		
	}
	@Test
	public void sibal(){
		logger.info(dao.read(1));
		
	}
/*	class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	<property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"></property>
	<property name="url" value="jdbc:log4jdbcmysql://192.168.0.9:3306/sample_db?useSSL=false"></property>
	<property name="username" value="gru"></property>
	<property name="password" value="e3r4f8g9"></property>*/

}
