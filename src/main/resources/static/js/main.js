$(function () {
    let $form = $("#form");

    $("#submit").on("click", function() {
        var data = $form.serializeArray();
        var url = $form.attr("action");

        $.ajax({
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(response){
                $("#responseContent").text(JSON.stringify(response, null, 2));
            },
            processData: false,
            type: 'POST',
            url: url
        });
    });
});

$(function () {
    markNavigation();
});

function getCurrentUrl() {
    return $(location).attr('pathname');
}

function updateButtonClass($linkButton) {
    if (getCurrentUrl() === $linkButton.attr('href')) {
        $linkButton.addClass('btn-dark');
        return;
    }
    $linkButton.addClass('btn-light');
}

function markNavigation() {
    $(".navigation").each(function () {
        updateButtonClass($(this));
    });
}