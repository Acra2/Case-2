$(function () {
    $(".datepicker").datepicker({
        format: 'dd-mm-yyyy',
        autoclose: true
    });
    $(".timepicker").clockpicker({
        autoclose: true,
        'default': 'now'
    });

});
function printDiv(divName) {
    var printContents = document.getElementById(divName).innerHTML;
    var originalContents = document.body.innerHTML;

    document.body.innerHTML = printContents;

    window.print();

    document.body.innerHTML = originalContents;
}