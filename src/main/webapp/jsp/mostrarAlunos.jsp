<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.edu.fatecitaquera.model.Aluno"%>
<!DOCTYPE html>
<html>
<head>
<title>Lista Alunos</title>
<link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css">
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<th colspan="8" style="display: flex;">
			<h1>Lista de Alunos</h1>
				<a href="./html/incluir.html" style="padding: 12px"><img src="./imgs/adicionar.png" alt="add" width="30px"></a>			
			</th>
		</tr>
		<tr>
			<th>ID - Atualizar</th>
			<th>Nome</th>
			<th>Endereço</th>
			<th>E-mail</th>
			<th>Nascimento</th>
			<th>Periodo</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
		<%
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		List<Aluno> lista = new ArrayList<Aluno>();
		lista = (ArrayList) request.getAttribute("alunosList");
		// for each
		for (Aluno a : lista) {
		%>
		<tr>
			<td><%=a.getRa()%></td>
			<td><%=a.getNome()%></td>
			<td><%=a.getEndereco()%></td>
			<td><%=a.getEmail()%></td>
			<td><%=data.format(a.getDataNascimento())%></td>
			<td><%=a.getPeriodo()%></td>
			<td><a href="ServletAluno?cmd=atu&txtRa=<%=a.getRa()%>"><img src="./imgs/edit.png" alt="updt" width="30px"></a></td>
			<td><a href="ServletAluno?cmd=exc&txtRa=<%=a.getRa()%>"><img src="./imgs/delete.png" alt="del" width="30px"></a></td>
		</tr>
		<%
		}
		%>
		<tr>
			<th colspan="8" style="text-align:center"><a href="Index.html">Página Principal</a></th>
		</tr>
	</table>
	
</body>
</html>