<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.springtoy.model.Brinquedo"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SpringToys - Administração</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    
    <link rel="stylesheet" href="./css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>

<body>

    <!-- Navbar -->
    <div class="navComponentsjsp">
   
</div>

    <!-- Main Content -->
    <main class="main-content">
        <!-- Admin Section -->
        <section class="container">
            <div class="row mt-4">
                <div class="col-md-12">
                    <h2 class="section-title">Administração</h2>
                    <!-- Botão para incluir novo brinquedo -->
                    <a href="./html/incluir.html" class="btn btn-primary">Incluir Novo Brinquedo</a>
                    <hr> <!-- Adiciona uma linha horizontal para separar o botão da tabela -->
                    <h2 class="section-title">Lista de Brinquedos</h2>
                    <div class="table-responsive">
                        <table class="table table-striped table-dark">
                            <thead>
                                <tr>
                                	<th>CodBrinquedo</th>
                                	<th>Codigo</th>
                                    <th>Nome</th>
                                    <th>Descrição</th>
                                    <th>Categoria</th>
                                     <th>Marca</th>
                                    <th>Imagem</th>
                                    <th>Detalhes</th>
                                    <th>Valor</th>
                                    <th>Controles</th>
                                </tr>
                            </thead>
                            <tbody>
		<%
		
		List<Brinquedo> lista = new ArrayList<Brinquedo>();
		lista = (ArrayList) request.getAttribute("brinquedosList");
		// for each
		for (Brinquedo a : lista) {
		%>
		
                  <!-- Exemplo de linha na tabela (substituir com os dados do banco) -->
        <tr>
        	<td><%=a.getCodBrinquedo()%></td>
			<td><%=a.getCodigo()%></td>
			<td><%=a.getNome()%></td>
			<td><%=a.getDescricao()%></td>
			<td><%=a.getCategoria()%></td>
			<td><%=a.getDetalhes()%></td>
			<td><img src="<%=a.getImg()%>" alt="Brinquedo sem img" width="100px" height="80px"></td>
			<td><%=a.getValor()%></td>
			<td>R$ <%=a.getMarca()%></td>
			<td>
			    <a  href="ServletBrinquedo?cmd=atu&txtcodBrinquedo=<%=a.getCodBrinquedo()%>" class="btn btn-primary"><i class="fa fa-pencil"></i> Editar</a>
               <button class="btn btn-danger" onclick="confirmarExclusao(<%=a.getCodBrinquedo()%>)"><i class="fa fa-trash"></i> Excluir</button>
               <!--   <a  href="ServletBrinquedo?cmd=exc&txtcodBrinquedo=<%=a.getCodBrinquedo()%>" class="btn btn-danger"><i class="fa fa-trash"></i> Excluir</a>-->
            </td>
		</tr>
		<%
		}
		%>
		                  </tbody>
                        </table>
				   </div>
                </div>
            </div>
        </section>
    </main>
    <div class="footerComponentsjsp"></div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="./javascript/script.js"></script>
    <script src="./javascript/Componentes.js"></script>
</body>

</html>
