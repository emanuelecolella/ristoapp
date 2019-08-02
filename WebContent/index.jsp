<%@ include file="header.jspf"%>


<div class="content-wrapper" style="min-height: 671px;">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>${pageContext.request.servletPath}</h1>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="box box-primary">
					<div class="box-body pad table-responsive">

						<form class="formregistrazione" method="post"
							action="inserimentoComanda">
							<label>Coperti</label> <input type="text" name="coperti"
								class="form-control my-colorpicker1 colorpicker-element"
								placeholder="Quanti coperti?" value=""></input><br>
								
							<label>Tavolo</label>
							
								<c:forEach items="${tavoli}" var="t">
									<input type="radio" name="idtavolo" value="${t.id}">${t.id}
								</c:forEach>
							<br>
							<br>

						<c:forEach items="${menu}" var="p">
							<label>
								<input type="radio" name="idpiatto" value="${p.id}">
									<%-- <img src="img/<%=piatto.getNome()%>.jpg"> --%> ${p.nome} 
							</label><br>
						</c:forEach>

							<button type="submit" class="btn btn-block btn-primary btn-lg">
								Conferma ordinazione
							</button>
						</form>
						
						<c:choose>
						<c:when test="${inserimentoRiuscito!=null}">
							<br>
							<div class="alert alert-success alert-dismissible">
								<h4><i class="icon fa fa-check"></i> Congratulazioni!</h4>
								Inserimento comanda avvenuto correttamente!
							</div>
						</c:when>
						</c:choose>
					</div>
					<!-- /.box -->
				</div>
			</div>
			<!-- /.col -->
		</div>

	</section>
	<!-- /.content -->
</div>

<%@ include file="footer.jspf"%>