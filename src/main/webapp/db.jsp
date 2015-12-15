<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> <!-- TELLS container to use Struts 2 tags-->
<html>
<head>
    <title>Call events</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="//cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="/style/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="/script/script.js"></script>
</head>
<body>
<div class="container">

    <div class="panel panel-info">
        <div class="panel-heading"><h4><span class="glyphicon glyphicon-earphone"></span> CALL EVENTS</h4></div>
        <div class="panel-body">

            <table id="call-table" class="hover stripe row-border order-column">

                <thead>
                <th>id</th>
                <th>Caller</th>
                <th>Event</th>
                <th>Receiver</th>
                <th>Timestamp</th>
                </thead>

                <tbody>
                <s:iterator value="calls">
                    <tr class="call" rel="<s:property value="recordId"/>">
                        <td><s:property value="recordId"/></td>
                        <td><s:property value="caller"/></td>
                        <td><s:property value="eventName"/></td>
                        <td><s:property value="receiver"/></td>
                        <td><s:property value="recordDate"/></td>
                    </tr>
                </s:iterator>
                </tbody>

            </table>

            <button id="call-add" class="btn btn-primary"> Add Call </button>

        </div>
    </div>


    <!-- Modal -->
    <div id="call-modal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

</div>
</body>
</html>

