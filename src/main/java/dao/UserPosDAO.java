package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import conexao_jdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {
	
	private Connection connection;
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Userposjava userposjava) {
		try {
		String sql = "insert into userposjava (id, nome, email) values (?,?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setLong(1, userposjava.getId());
		insert.setString(2, userposjava.getNome());
		insert.setString(3, userposjava.getEmail());
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
	

}
