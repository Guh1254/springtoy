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
    <title>SpringToys - Catálogo</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/style.css">
</head>

<body>
<jsp:useBean id="aluno" scope="session"
		class="br.edu.fatecitaquera.model.Aluno" />
    <!-- Navbar -->
  <div class="navComponentsjsp">
   
</div>
    <!-- Main Content -->
   <main class="main-content">
        <!-- Categories -->
        <section class="container">
            <div class="row mt-4">
                <div class="col-md-12">
                    <h2 class="section-title">Categorias de Brinquedos</h2>
                </div>
		<%
		
		List<Brinquedo> lista = new ArrayList<Brinquedo>();
		lista = (ArrayList) request.getAttribute("brinquedosList");
		// for each
		for (Brinquedo a : lista) {
		%>
		
                  <!-- Exemplo de linha na tabela (substituir com os dados do banco) -->
       <div class="col-md-4">
                    <div class="card">
                     <a href="ServletBrinquedo?cmd=con&txtcodBrinquedo=<%=a.getCodBrinquedo()%>">
                     <img src="<%=a.getImg()%>" class="card-img-top" alt="Bolas">
                        <div class="card-body">
                            <h5 class="card-title">nome: <%=a.getNome()%></h5>
                            <p class="card-text">Valor: <%=a.getMarca()%></p>
                            <p class="card-text">Marca: <%=a.getValor()%></p>
                            </a>
                        </div>
                    </div>
                </div>
                
                
                
  
		<%
		}
		%>
		                  
 
            </div>
        </section>
    </main>
        <div class="footerComponentsjsp"></div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="./javascript/Componentes.js"></script>
</body>

</html>
