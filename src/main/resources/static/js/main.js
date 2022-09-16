$(function () {
    let $form = $("#form");

    $("#submit").on("click", function() {
        var data = $form.serializeArray();

        $.ajax({
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(response){
                $("#responseContent").text(JSON.stringify(response, null, 2));
            },
            processData: false,
            type: 'POST',
            url: '/v1'
        });
    })
});