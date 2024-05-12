<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SpringToys - Alterar Brinquedo</title>
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
    <!-- linkar com o modal Brinquedo -->
    	<jsp:useBean id="brinquedo" scope="session"
		class="com.springtoy.model.Brinquedo" />
    
        <!-- Alterar Section -->
        <section class="container">
            <div class="row mt-4">
                <div class="col-md-12">
                    <h2 class="section-title">Excluir Brinquedo</h2>
                   <form action="ServletBrinquedo?cmd=excluir" method="post">
                    	
                    	<div class="form-group">
                            <label for="codigo">CodBrinquedo</label>
                            <input type="text" class="form-control" id="codigo" name="txtcodBrinquedo" value="<%=brinquedo.getCodBrinquedo()%>" readonly>
                        </div>
                        <div class="form-group">
                            <label for="codigo">Código</label>
                            <input type="text" class="form-control" id="codigo" name="txtcodigo" value="<%=brinquedo.getCodigo()%>" readonly>
                        </div>
                        <div class="form-group">
                            <label for="nome">nome</label>
                            <input type="text" class="form-control" name="txtnome" id="nome" value="<%=brinquedo.getNome()%>" readonly>
                        </div>
                        <div class="form-group">
                            <label for="descricao">Descrição</label>
                            <input type="text" class="form-control" name="txtdescricao" id="descricao" value="<%=brinquedo.getDescricao()%>" readonly>
                        </div>
                        <div class="form-group">
                            <select class="form-select" aria-label="Default select example" name="cmbcategoria" readonly> 
								<option selected><%=brinquedo.getCategoria()%></option>
								<option>boneco</option>
								<option>carrinho</option>
								<option>bola</option>
							</select>
                        </div>
                        <div class="form-group">
                            <label for="marca">Marca</label>
                            <input type="text" class="form-control" id="marca" name="txtmarca" value="<%=brinquedo.getValor()%>" readonly>
                        </div>     
                        <div class="form-group">
                            <label for="imagem">Imagem <%=brinquedo.getImg()%></label>
                            <input type="file" class="form-control-file" name="imgbrinquedo" id="imagem" readonly>
                        </div>
                        <div class="form-group">
                            <label for="valor">Valor</label>
                            <input type="text" class="form-control" id="valor" name="txtvalor" value="<%=brinquedo.getMarca()%>" readonly>
                        </div>
                        <div class="form-group">
                            <label for="detalhes">Detalhes</label>
                            <textarea class="form-control" id="detalhes" rows="3" name="txtdetalhes" placeholder="<%=brinquedo.getDetalhes()%>" value="<%=brinquedo.getDetalhes()%>" readonly></textarea>
                        </div>
                        <button type="submit" onclick="confirmarExclusao()" class="btn btn-primary">Excluir</button>
                    </form>
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
