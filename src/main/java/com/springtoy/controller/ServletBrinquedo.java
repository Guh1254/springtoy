package com.springtoy.controller;
	

import java.io.IOException;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.springtoy.dao.BrinquedoDAO;
import com.springtoy.model.Brinquedo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletAluno
 */
@WebServlet("/ServletBrinquedo")
public class ServletBrinquedo extends HttpServlet{
	private static final long serialVersionUID = 1L;

	// metodo para conversao de String para data
	//	private Date strToDate(String data) throws Exception {
	//	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	//	Date dataF = formato.parse(data);
	//	return dataF;
	//	}
	
		protected void processRequest(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Brinquedo brinquedo = new Brinquedo();
			BrinquedoDAO dao;
			String cmd = request.getParameter("cmd");
			//pega as informações do incluir
			try {
				if (cmd.equals("incluir")) {
				
					brinquedo.setCodigo(Integer.parseInt(request.getParameter("txtcodigo")));
					brinquedo.setNome(request.getParameter("txtnome"));
					brinquedo.setDescricao(request.getParameter("txtdescricao"));
					brinquedo.setCategoria(request.getParameter("cmbcategoria"));
					brinquedo.setMarca(request.getParameter("txtmarca"));
					brinquedo.setImg(request.getParameter("imgbrinquedo"));
					brinquedo.setValor(request.getParameter("txtvalor"));
					brinquedo.setDetalhes(request.getParameter("txtdetalhes"));
					//aluno.setDataNascimento(strToDate(request.getParameter("txtData")));
				}  else {
					brinquedo.setCodBrinquedo(Integer.parseInt(request.getParameter("txtcodBrinquedo")));
				}
			} catch (Exception e) {
				 System.out.println("Erro na data");
				System.out.println(e.getMessage());
			}
			//pega as informações do atualizar
			try {
				if (cmd.equals("atualizar")) {
					brinquedo.setCodBrinquedo(Integer.parseInt(request.getParameter("txtcodBrinquedo")));
					brinquedo.setCodigo(Integer.parseInt(request.getParameter("txtcodigo")));
					brinquedo.setNome(request.getParameter("txtnome"));
					brinquedo.setDescricao(request.getParameter("txtdescricao"));
					brinquedo.setCategoria(request.getParameter("cmbcategoria"));
					brinquedo.setMarca(request.getParameter("txtmarca"));
					brinquedo.setImg(request.getParameter("imgbrinquedo"));
					brinquedo.setValor(request.getParameter("txtvalor"));
					brinquedo.setDetalhes(request.getParameter("txtdetalhes"));
					//aluno.setDataNascimento(strToDate(request.getParameter("txtData")));
				
				}  else {
					brinquedo.setCodBrinquedo(Integer.parseInt(request.getParameter("txtcodBrinquedo")));
				}
			} catch (Exception e) {
				// System.out.println("Erro na data");
				System.out.println(e.getMessage());
			}
			
			try {
			if (cmd.equals("listarcat")) {
				System.out.println("adada");
				brinquedo.setCategoria(request.getParameter("cmbcategoria"));
			}
			}catch (Exception e) {
				// System.out.println("Erro na data");
				System.out.println(e.getMessage());
			}
			
			try {
				dao = new BrinquedoDAO();
				// Dispatcher - direciona para uma nova página
				RequestDispatcher rd = null;
				if (cmd.equalsIgnoreCase("incluir")) {
					dao.salvar(brinquedo);
					rd = request.getRequestDispatcher("ServletBrinquedo?cmd=listar");
				} else if (cmd.equalsIgnoreCase("listar")) {
					List<Brinquedo> List = dao.todosBrinquedos() ;
					// sessão
					request.setAttribute("brinquedosList", List);
					rd = request.getRequestDispatcher("jsp/mostrarbrinquedos.jsp");	
				
				} else if (cmd.equalsIgnoreCase("listarcat")) {
					List<Brinquedo> List = dao.todosBrinquedoscatalogados(brinquedo) ;
					// sessão
					request.setAttribute("brinquedosList", List);
					rd = request.getRequestDispatcher("jsp/mostrarcatalogo.jsp");
					
				} else if (cmd.equalsIgnoreCase("atu")) {
					brinquedo = dao.consultar(brinquedo);
					HttpSession session = request.getSession(true);
					session.setAttribute("brinquedo", brinquedo);
					rd = request.getRequestDispatcher("jsp/atualizarBrinquedo.jsp");
				} else if (cmd.equalsIgnoreCase("atualizar")) {
					dao.atualizar(brinquedo);
					rd = request.getRequestDispatcher("ServletBrinquedo?cmd=listar");
				} else if (cmd.equalsIgnoreCase("con")) {
					brinquedo = dao.consultar(brinquedo);
					HttpSession session = request.getSession(true);
					session.setAttribute("brinquedo", brinquedo);
					rd = request.getRequestDispatcher("jsp/consultarBrinquedo.jsp");
				} else if (cmd.equalsIgnoreCase("exc")) {
					brinquedo = dao.consultar(brinquedo);
					HttpSession session = request.getSession(true);
					session.setAttribute("brinquedo", brinquedo);
					rd = request.getRequestDispatcher("jsp/excluirBrinquedo.jsp");
				} else if (cmd.equalsIgnoreCase("excluir")) {
					dao.excluir(brinquedo);
					rd = request.getRequestDispatcher("ServletBrinquedo?cmd=listar");
				} 
				// executa a ação de direcionar para a página JSP
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
//	private String uploadImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String path = "C:\\Users\\Muril\\eclipse-workspace\\springtoy\\src\\main\\webapp\\imgs";
//		for(Part part : request.getParts()) {
//			System.out.println("viado");
//
//			if (part.getName().equals("imgbrinquedo") && part.getSize() > 0) {
//				System.out.println("viado");
//
//				part.write(path + File.separator + part.getSubmittedFileName());
//				return "imgs" + File.separator + part.getSubmittedFileName();
//			}
//		}
//		return null;
//		BrinquedoDAO jv = new BrinquedoDAO();
//		return jv.consultar(new Brinquedo(Integer.parseInt(request.getParameter("codBrinquedo")))).getImg();
//	}


}



