package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.Userposjava;


public class TesteBancoJdbc{
	
	@Test
	public void initBanco() { //metodo insert
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(6L);
		userposjava.setNome("Kelly");
		userposjava.setEmail("Kelly@gmail.com");
		
		userPosDAO.salvar(userposjava);
		
	}
	
	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			
			for(Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("------------------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava userposjava = dao.buscar(1L);
			
			System.out.println(userposjava);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initAtualizar() {
		try {
		
		UserPosDAO dao = new UserPosDAO();
		
		Userposjava objetoBanco = dao.buscar(5L);
		
		objetoBanco.setNome("Nome mudado com metodo atualizar");
		
		dao.atualiar(objetoBanco);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}











