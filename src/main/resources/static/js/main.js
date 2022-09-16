$(function () {
    let $form = $("#form");

    $("#submit").on("click", function() {
        var data = $form.serializeArray();

        $.ajax({
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(response){
                console.info(response);
            },
            processData: false,
            type: 'POST',
            url: '/v1'
        });
    })
});