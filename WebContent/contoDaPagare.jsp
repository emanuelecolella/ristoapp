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
            <h2>Il totale da pagare è: <span style="color:red;">${conto} &euro;</span></h2>
              
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