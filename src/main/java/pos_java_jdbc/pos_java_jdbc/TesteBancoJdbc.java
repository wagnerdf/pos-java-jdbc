package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import conexao_jdbc.SingleConnection;


public class TesteBancoJdbc{
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}
	

}
