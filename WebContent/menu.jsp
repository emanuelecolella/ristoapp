<%@ include file="header.jspf" %>
			
	
	<div class="content-wrapper" style="min-height: 671px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        ${pageContext.request.servletPath}
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-12">
          <div class="box box-primary">
            <div class="box-body pad table-responsive">				
				<form class="formregistrazione" method="post" action="inserimentoMenu">
					<input type="text" name="nome" placeholder="Inserisci nome piatto" class="form-control my-colorpicker1 colorpicker-element" ></input><br>
					<input type="text" name="prezzo" placeholder="Prezzo piatto" class="form-control my-colorpicker1 colorpicker-element" ></input><br>
					<button type="submit" class="btn btn-block btn-primary btn-lg">Conferma inserimento</button>
				</form>
			</div>
            <!-- /.box -->
          </div>
        </div>
        <!-- /.col -->
      </div>

    </section>
    <!-- /.content -->
  </div>
<%@ include file="footer.jspf" %>