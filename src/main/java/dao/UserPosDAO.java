package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import conexao_jdbc.SingleConnection;
import model.Telefone;
import model.Userposjava;

public class UserPosDAO {
	
	private Connection connection;
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Userposjava userposjava) {
		try {
		String sql = "insert into userposjava (nome, email) values (?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, userposjava.getNome());
		insert.setString(2, userposjava.getEmail());
		insert.execute();
		connection.commit();//salava no banco
		
		}catch (Exception e) {
			try {
				connection.rollback();//reverte operação
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void salvarTelefone(Telefone telefone) {
		
		try {
			
			String sql = "INSERT INTO telefoneuser (numero, tipo, usuariopessoa) VALUES (?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, telefone.getNumero());
			statement.setString(2, telefone.getTipo());
			statement.setLong(3, telefone.getUsuario());
			statement.execute();
			connection.commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public List<Userposjava> listar() throws Exception{
		List<Userposjava> list = new ArrayList<Userposjava>();
		
		String sql = "select * from userposjava";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while(resultado.next()) {
			Userposjava userposjava = new Userposjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
			
			list.add(userposjava);
		}
		
		return list;
	}
	
	public Userposjava buscar(long id) throws Exception{
		Userposjava retorno = new Userposjava();
		
		String sql = "select * from userposjava where id = " + id;
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while(resultado.next()) { // retorna apenas um ou nenhum 
			
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));

		}
		
		return retorno;
	}
	
	public void atualiar(Userposjava userposjava) {
		try {
			String sql = "update userposjava set nome = ? where id = " + userposjava.getId();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userposjava.getNome());

			statement.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
	
	public void deletar(Long id) {
		try {
			
			String sql = "delete from userposjava where id = " + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
		}catch(Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
	}

}
















