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
              
              <div class="alert alert-success alert-dismissible">
                <h4><i class="icon fa fa-check"></i> Conferma inserimento!</h4>
                L'inserimento è andato a buon fine!
              </div>
              
              <a href="home.jsp"><button type="button" class="btn btn-block btn-primary btn-lg">Torna alla home</button></a>
              
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