<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br"><!--<![endif]-->
    <head>
        <!--Load the AJAX API-->
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">

            google.charts.load('current', {
                callback: function () {
                    var data = new google.visualization.DataTable();
                    data.addColumn('date', 'Data');
                    data.addColumn('number', 'Total diário R$');
                    data.addRows(${orderData});

                    var tickMarks = [];
                    for (var i = 0; i < data.getNumberOfRows(); i++) {
                        tickMarks.push(data.getValue(i, 0));
                    }

                    var options = {
                        chart: {
                            title: 'Total em vendas diária',
                            subtitle: 'Total em vendas diária'
                        },
                        legend: {position: 'none'},
                        width: '100%',
                        pointSize: 10,
                        explorer: {actions: ['Arraste para ampliar', 'Botão direito para resetar']},
                        hAxis: {
                            format: 'dd/MM/yyyy',
                            ticks: tickMarks
                        }
                    };

                    /* var chart = new google.charts.Line(document.getElementById('linechart_material'));
                     chart.draw(data, google.charts.Line.convertOptions(options));
                     */
                    chart = new google.visualization.LineChart(document.getElementById('linechart_core'));
                    chart.draw(data, options);
                },
                packages: ['corechart', 'line']
            });
        </script>

        <%@include file="/view/fragments/head.jsp"%>
        <title>Estatística de venda diária</title>
    </head>
    <body class="body_wrap" style="background-color: #13181e;">
        <%@include file="/view/fragments/header.jsp" %>

        <div id="information-information" class="container">
            <ul class="breadcrumb">
                <li><a href="#"><i class="fa fa-home"></i></a></li>                
            </ul>

            <div class="row">
                <script src="https://www.gstatic.com/charts/loader.js"></script>

                <H3>Gráfico com vendas diárias</H3>
                <div class="row">
                    <c:choose>
                        <c:when test="${empty orderData}">
                            <h1>Não há dados no período</h1>
                        </c:when>
                    </c:choose>
                    <div id="linechart_core"></div>
                </div>
                <form method="post" action="/ZZZ_ag_908/livraria?rca=ddOd" class="panel-group" id="daily-sales-report">
                    <div class="row">
                        <div class="form-horizontal">
                            <div class="form-group col-sm-3" data-toggle="tooltip" data-placement="top" title="Data inicial da busca">
                                <label class="control-label" for="input-initial-date"><i class="fa fa-calendar"></i>Data de inicial</label>
                                <input type="date" name="stard-date" id="input-initial-date" class="form-control">
                            </div>
                            <div class="form-group col-sm-3" data-toggle="tooltip" data-placement="top" title="Data final">
                                <label class="control-label" for="input-final-date"><i class="fa fa-calendar"></i>Data de final</label>
                                <input type="date" name="end-date" id="input-final-date" class="form-control">
                            </div>
                            <div class="form-group col-sm-3" data-toggle="tooltip" data-placement="top" title="Clique para buscar">
                                <label class="control-label" for="input-final-date">Buscar</label>
                                <button type="submit" class="form-control btn btn-default" value="Submit">Buscar período</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <%@include file="/view/fragments/footer.jsp" %>            
        </div><!-- body_wrap -->
    </body>
</html>