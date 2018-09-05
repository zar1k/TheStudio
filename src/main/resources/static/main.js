$(document).ready(function () {
    $("#bth-calculate").click(function (event) {
        // Stop default form Submit.
        event.preventDefault();

        ajaxSubmitForm();
    });
});

function ajaxSubmitForm() {
    var dec = $("#dec").val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "api/parse",
        data: JSON.stringify(dec),
        dataType: 'json',
        cache: false,
        timeout: 1000000,
        success: function (data) {

            var json = "<p class=\"text-monospace h5\">" + "Число " + "<span class=\"badge badge-primary\">" + dec + "</span>"
                + " имеет бинарное представление " + "<span class=\"badge badge-primary\">"
                + data.bin + "</span>" + " - содержит интервалов " + "<span class=\"badge badge-primary\">"
                + data.intervalCount + "</span>" + " длиной "
                + "<span class=\"badge badge-primary\">" + data.intervalLength + "</span>" + "</p>";

            $('#feedback').html(json);
            // reset
            $("#dec").val('');
        },
        error: function (jqXHR, textStatus, errorThrown) {

            $("#feedback").html(jqXHR.responseText);
            console.log("ERROR : ", jqXHR.responseText);
        }
    });
}