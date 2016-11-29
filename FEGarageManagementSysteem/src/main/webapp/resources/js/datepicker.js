$(function () {
    $(".datepicker").datepicker({
        format: 'dd-mm-yyyy',
        autoclose: true,
        startDate: '0'
    });
    $(".timepicker").clockpicker({
        autoclose: true,
        'default': 'now'

    });
});