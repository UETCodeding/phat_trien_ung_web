$(document).ready( function () {
    $('#tblStudent').DataTable( {
        paging: true,
        searching: true,
        info:false,
        columnDefs: [ {
            orderable: false,
            targets:   [0, 5]
        } ],
        order: [[ 0, 'none' ]]
    } );
} );