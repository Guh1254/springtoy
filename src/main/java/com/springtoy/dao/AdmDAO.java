package com.springtoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.springtoy.model.Adm;
import com.springtoy.util.ConnectionFactory;

public class AdmDAO {
	// classes de banco de dados
			private Connection conn; // abre a conexao do banco de dados
			private PreparedStatement ps; // permite que scripts SQL sejam executados a partir do Java
			private ResultSet rs; // representa as tabelas
			// classe JavaBean
			private Adm adm;
			
			public AdmDAO() throws Exception {
				// chama a classe ConnectionFactory e estabele uma conexao
				try {
					this.conn = ConnectionFactory.getConnection();
				} catch (Exception e) {
					throw new Exception("erro: \n" + e.getMessage());
				}
			}
			
			// Consultar a Existência do Adm 
			public Adm consultar(Adm adm) throws Exception {
				try {
					ps = conn.prepareStatement("SELECT * FROM tbadm WHERE email=?, senha=?");
					ps.setString(1, adm.getEmail());
					ps.setString(2, adm.getSenha());
					rs = ps.executeQuery();
					
						String email = rs.getString("email");
						String senha = rs.getString("senha");
						String email_velho = adm.getEmail();
						String senha_velha = adm.getSenha();
						if(email == email_velho && senha == senha_velha) {
							adm = new Adm(1);
							return adm;
						}else {
							adm = new Adm(0);
							return adm;
						}
				} catch (SQLException sqle) {
					throw new Exception(sqle);
				} finally {
					ConnectionFactory.closeConnection(conn, ps, rs);
				}
			}
		

	
}
