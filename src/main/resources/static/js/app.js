$("body").append("<div id='overlay'></div>");

$("#overlay")
    .css({
        'opacity': 0.4,
        'position': 'absolute',
        'top': 0,
        'left': 0,
        'background-color': 'black',
        'width': '100%',
        'z-index': 5000
    });


$(document).ready(function () {
    console.log('ready 0 $(document).ready(function() {...');
    $("#overlay").remove();
});

jQuery(function ($) {
    $("#ajax_loader").ajaxStop(function () {
        $(this).hide();
    });
    $("#ajax_loader").ajaxStart(function () {
        $(this).show();
    });
});

