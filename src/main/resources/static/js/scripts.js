var modal = document.getElementById('id01');

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}


function loginAjax(){

       $.post( "/login", function( data ) {
               if(data == 1){
                   window.location.replace("/");
               } else {
                    shakeModal();
               }
           });


    /*   Simulate error message from the server   */
    shakeModal();
}

function shakeModal(){
    $('#loginModal .modal-dialog').addClass('shake');
    $('.error').addClass('alert alert-danger').html("Invalid email/password combination");
    $('input[type="password"]').val('');
    setTimeout( function(){
        $('#loginModal .modal-dialog').removeClass('shake');
    }, 1000 );
}




