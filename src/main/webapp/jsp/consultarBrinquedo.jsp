<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SpringToys - Loja de Brinquedos</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>

<body>

    <!-- Navbar -->
  <div class="navComponentsjsp">
   
</div>

	<!-- linkar com o modal Brinquedo -->
    	<jsp:useBean id="brinquedo" scope="session"
		class="com.springtoy.model.Brinquedo" />
		
    <!-- Main Content -->
    <main class="main-content">
        <!-- Detalhes do Brinquedo -->
        <section class="container">
            <div class="row mt-4">
                <div class="col-md-6">
                    <img src="<%=brinquedo.getImg()%>" class="img-fluid" alt="Brinquedo sem imagem" style="Margin-bottom:30px">
                </div>
                <div class="col-md-6">
                    <h2 class="section-title">Detalhes do Brinquedo</h2>
                    <p><strong>Código:</strong> <%=brinquedo.getCodigo()%></p>
                    <p><strong>Nome:</strong> <%=brinquedo.getNome()%></p>
                    <p><strong>Categoria:</strong> <%=brinquedo.getCategoria()%></p>
                    <p><strong>Descrição:</strong> <%=brinquedo.getDescricao()%></p>
                    <p><strong>Preço:</strong> <%=brinquedo.getMarca()%></p>
                    <p><strong>Marca:</strong> <%=brinquedo.getDetalhes()%></p>
                    <p><strong>Detalhes:</strong> <%=brinquedo.getValor()%></p>
                    <button type="submit" class="btn btn-primary" id="comprar">Comprar</button>
                </div>
            </div>
        </section>
    </main>
    <div class="footerComponentsjsp"></div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  	<script src="./javascript/script3.js"></script>
    <script src="./javascript/Componentes.js"></script>
</body>

</html>