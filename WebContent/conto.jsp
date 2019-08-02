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
            
            <form class="formregistrazione" method="post" action="stampaConto">
            	<input type="text" name="idtavolo"  class="form-control my-colorpicker1 colorpicker-element" placeholder="Inserisci numero tavolo da stampare"><br>
				<button type="submit" class="btn btn-block btn-primary btn-lg">Stampa conto</button>
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