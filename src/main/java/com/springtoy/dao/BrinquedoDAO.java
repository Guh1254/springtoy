package com.springtoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.springtoy.model.Brinquedo;
import com.springtoy.util.ConnectionFactory;





public class BrinquedoDAO {

	// classes de banco de dados
		private Connection conn; // abre a conexao do banco de dados
		private PreparedStatement ps; // permite que scripts SQL sejam executados a partir do Java
		private ResultSet rs; // representa as tabelas
		// classe JavaBean
		private Brinquedo brinquedo;

		public BrinquedoDAO() throws Exception {
			// chama a classe ConnectionFactory e estabele uma conexao
			try {
				this.conn = ConnectionFactory.getConnection();
			} catch (Exception e) {
				throw new Exception("erro: \n" + e.getMessage());
			}
		}
		
		// metodo de salvar brinquedo
		public void salvar(Brinquedo brinquedo) throws Exception {
			if (brinquedo == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "INSERT INTO tbbrinquedo (codigo, nome, descricao, categoria, "
						+ "valor, imagem, detalhes, marca) values (?, ?, ?, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, brinquedo.getCodigo());
				ps.setString(2, brinquedo.getNome());
				ps.setString(3, brinquedo.getDescricao());
				ps.setString(4, brinquedo.getCategoria());
				ps.setString(5, brinquedo.getValor());
				ps.setString(6, brinquedo.getImg());
				ps.setString(7, brinquedo.getDetalhes());
				ps.setString(8, brinquedo.getMarca());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao inserir dados " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
		}

		// metodo de atualizar brinquedo
		
		public void atualizar(Brinquedo brinquedo) throws Exception {
			if (brinquedo == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "UPDATE tbbrinquedo set nome=?, descricao=?, categoria=?, valor=?, " + "imagem=?, detalhes=?, marca=?, codigo=? WHERE codBrinquedo=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, brinquedo.getNome());
				ps.setString(2, brinquedo.getDescricao());
				ps.setString(3, brinquedo.getCategoria());
				ps.setString(4, brinquedo.getValor());
				ps.setString(5, brinquedo.getImg());
				ps.setString(6, brinquedo.getDetalhes());
				ps.setString(7, brinquedo.getMarca());
				ps.setInt(8, brinquedo.getCodigo());
				ps.setInt(9, brinquedo.getCodBrinquedo());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao alterar dados " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
		}
	
		// metodo de excluir
		public void excluir(Brinquedo brinquedo) throws Exception {
			if (brinquedo == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "DELETE from tbbrinquedo WHERE codBrinquedo=?";
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, brinquedo.getCodBrinquedo());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao excluir dados " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
		}
		
		// Consultar Aluno
		public Brinquedo consultar(Brinquedo brinquedo) throws Exception {
			try {
				ps = conn.prepareStatement("SELECT * FROM tbbrinquedo WHERE codBrinquedo=?");
				ps.setInt(1, brinquedo.getCodBrinquedo());
				rs = ps.executeQuery();
				while (rs.next()) {
					int codBrinquedo = rs.getInt("codBrinquedo");
					int codigo = rs.getInt("codigo");
					String nome = rs.getString("nome");
					String descricao = rs.getString("descricao");
					String categoria = rs.getString("categoria");
					String valor = rs.getString("valor");
					String img = rs.getString("imagem");
					String detalhes = rs.getString("detalhes");
					String marca = rs.getString("marca");
					brinquedo = new Brinquedo(codBrinquedo,codigo, nome, descricao, categoria, valor, img, detalhes, marca);
				}
				return brinquedo;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
	
		// Listar todos os alunos
		public List<Brinquedo> todosBrinquedos() throws Exception {
			try {
				ps = conn.prepareStatement("SELECT * FROM tbbrinquedo");
				rs = ps.executeQuery();
				List<Brinquedo> list = new ArrayList<Brinquedo>();

				while (rs.next()) {
					int codBrinquedo = rs.getInt("codBrinquedo");
					int codigo = rs.getInt("codigo");
					String nome = rs.getString("nome");
					String descricao = rs.getString("descricao");
					String categoria = rs.getString("categoria");
					String valor = rs.getString("valor");
					String img = rs.getString("imagem");
					String detalhes = rs.getString("detalhes");
					String marca = rs.getString("marca");
					list.add(new Brinquedo(codBrinquedo, codigo, nome, descricao, categoria, valor, img, detalhes, marca));
				}
				return list;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		
		public List<Brinquedo> todosBrinquedoscatalogados(Brinquedo brinquedo) throws Exception {
			try {
				ps = conn.prepareStatement("SELECT * FROM tbbrinquedo WHERE categoria=?");
				ps.setString(1, brinquedo.getCategoria());
				rs = ps.executeQuery();
				List<Brinquedo> list = new ArrayList<Brinquedo>();

				while (rs.next()) {
					int codBrinquedo = rs.getInt("codBrinquedo");
					int codigo = rs.getInt("codigo");
					String nome = rs.getString("nome");
					String descricao = rs.getString("descricao");
					String categoria = rs.getString("categoria");
					String valor = rs.getString("valor");
					String img = rs.getString("imagem");
					String detalhes = rs.getString("detalhes");
					String marca = rs.getString("marca");
					list.add(new Brinquedo(codBrinquedo, codigo, nome, descricao, categoria, valor, img, detalhes, marca));
				}
				return list;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
}
