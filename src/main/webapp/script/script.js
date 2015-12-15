$(function () {
    // SOME UI IMPROVEMENTS
    $(document).find('#call-table').DataTable({
        "aLengthMenu": [5, 10, 25],
        "iDisplayLength": 25
    });

    $(document).find('#call-table_filter input').addClass('form-control');
    $(document).find('#call-table_length select').addClass('form-control');

    // JS HANDLERS
    $(document).on('click', '#call-add', function () {
        $.post("/addEvent", function (data) {
            if (data == "success")
                location.reload();
            else
                alert(data);
        });
    });

    $(document).on('click', '.call', function () {
        var id = $(this).attr('rel');

        $.post("/getEvents", {id: id}, function (data) {
            var arObj = JSON.parse(data);
            var html = "<table class='hover stripe row-border order-column' id='event-table'>" +
                "<thead>" +
                    "<tr>" +
                        "<th>ID</th>" +
                        "<th>Event Name</th>" +
                        "<th>Timestamp</th>" +
                    "</tr>" +
                "</thead>" +
                "<tbody>";


            $.each(arObj, function (k, v) {
                html += "<tr>" +
                    "<td>" + v.recordId + "</td>" +
                    "<td>" + v.eventName + "</td>" +
                    "<td>" + v.recordDate.slice(0, -2) + "</td>" +
                    "</tr>"
            });

            html += "</tbody></table>";
            $('.modal-body').html(html);

            $('#event-table').DataTable({
                "paging":   false,
                "ordering": false,
                "iDisplayLength": 10
            });

            // HIDE FILTERS
            $('#event-table_filter').hide();
        });

        $('#call-modal').modal('show');
    });
});