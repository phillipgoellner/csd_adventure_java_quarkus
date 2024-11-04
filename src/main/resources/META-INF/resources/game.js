$( document ).ready(function() {
    $('#command').focus();
    $('#commandForm').submit(function( event ) {
        event.preventDefault();
        $.ajax({
            url: "/command",
            data: {command: $('#command').val()},
        })
            .done(function( data ) {
                $("#gameInfo").html(data.gameInfo);
                $('#command').val("");
                $('#actions').html(data.actions);
            });
    });

});