package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import dao.UserPosDAO;
import model.Userposjava;


public class TesteBancoJdbc{
	
	@Test
	public void initBanco() {
		//SingleConnection.getConnection();
		
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(6L);
		userposjava.setNome("Kelly");
		userposjava.setEmail("Kelly@gmail.com");
		
		
		
		userPosDAO.salvar(userposjava);
		
	}
}
