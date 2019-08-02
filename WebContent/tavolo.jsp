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
            	<form class="formregistrazione" method="post" action="inserimentoTavolo">						
					<input type="text" name="coperti" class="form-control my-colorpicker1 colorpicker-element" placeholder="Inserisci coperti"><br>
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