package br.edu.fatecitaquera.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import br.edu.fatecitaquera.dao.AlunoDAO;
import br.edu.fatecitaquera.model.Aluno;
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
@WebServlet("/ServletAluno")
public class ServletAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// metodo para conversao de String para data
		private Date strToDate(String data) throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataF = formato.parse(data);
		return dataF;
		}
	
		protected void processRequest(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Aluno aluno = new Aluno();
			AlunoDAO dao;
			String cmd = request.getParameter("cmd");
			try {
				if (cmd.equals("incluir") || cmd.equals("atualizar")) {
					aluno.setRa(Integer.parseInt(request.getParameter("txtRa")));
					aluno.setNome(request.getParameter("txtNome"));
					aluno.setEmail(request.getParameter("txtEmail"));
					aluno.setEndereco(request.getParameter("txtEndereco"));
					aluno.setPeriodo(request.getParameter("cmbPeriodo"));
					aluno.setDataNascimento(strToDate(request.getParameter("txtData")));
				} else {
					aluno.setRa(Integer.parseInt(request.getParameter("txtRa")));
				}
			} catch (Exception e) {
				// System.out.println("Erro na data");
				System.out.println(e.getMessage());
			}
			try {
				dao = new AlunoDAO();
				// Dispatcher - direciona para uma nova página
				RequestDispatcher rd = null;
				if (cmd.equalsIgnoreCase("incluir")) {
					dao.salvar(aluno);
					rd = request.getRequestDispatcher("ServletAluno?cmd=listar");
				} else if (cmd.equalsIgnoreCase("listar")) {
					List<Aluno> alunosList = dao.todosAlunos();
					// sessão
					request.setAttribute("alunosList", alunosList);
					rd = request.getRequestDispatcher("jsp/mostrarAlunos.jsp");
				} else if (cmd.equalsIgnoreCase("atu")) {
					aluno = dao.consultar(aluno);
					HttpSession session = request.getSession(true);
					session.setAttribute("aluno", aluno);
					rd = request.getRequestDispatcher("jsp/atualizarAluno.jsp");
				} else if (cmd.equalsIgnoreCase("atualizar")) {
					dao.atualizar(aluno);
					rd = request.getRequestDispatcher("ServletAluno?cmd=listar");
				} else if (cmd.equalsIgnoreCase("con")) {
					aluno = dao.consultar(aluno);
					HttpSession session = request.getSession(true);
					session.setAttribute("aluno", aluno);
					rd = request.getRequestDispatcher("jsp/consultarAluno.jsp");
				} else if (cmd.equalsIgnoreCase("exc")) {
					aluno = dao.consultar(aluno);
					HttpSession session = request.getSession(true);
					session.setAttribute("aluno", aluno);
					rd = request.getRequestDispatcher("jsp/excluirAluno.jsp");
				} else if (cmd.equalsIgnoreCase("excluir")) {
					dao.excluir(aluno);
					rd = request.getRequestDispatcher("ServletAluno?cmd=listar");
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

}
