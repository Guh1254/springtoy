package com.springtoy.controller;

import java.io.IOException;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.springtoy.dao.AdmDAO;
import com.springtoy.model.Adm;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletAdm")
public class ServletAdm extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Adm adm = new Adm();
		AdmDAO dao;
		String cmd = request.getParameter("cmd");
		//pega as informações do incluir
		try {
			if (cmd.equals("logar")) {
				System.out.println("chego");
				adm.setEmail(request.getParameter("txtemail"));
				adm.setSenha(request.getParameter("txtpassword"));
				
			}  else {
				adm.setCodAdm(Integer.parseInt(request.getParameter("txtcodAdm")));
			}
		} catch (Exception e) {
			 System.out.println("Erro na data");
			System.out.println(e.getMessage());
		}
		
		try {
			dao = new AdmDAO();
			
			// Dispatcher - direciona para uma nova página
			RequestDispatcher rd = null;
			if (cmd.equalsIgnoreCase("logar")) {
				adm = dao.consultar(adm);
				if(adm.getLogin() == 1) {
					HttpSession session = request.getSession(true);
					session.setAttribute("adm", adm);
					rd = request.getRequestDispatcher("ServletBrinquedo?cmd=listar");
				} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("adm", adm);
				rd = request.getRequestDispatcher("../index.html");
				}
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

//private String uploadImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//	String path = "C:\\Users\\Muril\\eclipse-workspace\\springtoy\\src\\main\\webapp\\imgs";
//	for(Part part : request.getParts()) {
//		System.out.println("viado");
//
//		if (part.getName().equals("imgbrinquedo") && part.getSize() > 0) {
//			System.out.println("viado");
//
//			part.write(path + File.separator + part.getSubmittedFileName());
//			return "imgs" + File.separator + part.getSubmittedFileName();
//		}
//	}
//	return null;
//	BrinquedoDAO jv = new BrinquedoDAO();
//	return jv.consultar(new Brinquedo(Integer.parseInt(request.getParameter("codBrinquedo")))).getImg();
//}


	
}
