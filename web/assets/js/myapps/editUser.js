
$(document).ready(function(){
    //nouveau pub.........
    $('#bntEdit').on('click', function(des){
        des.preventDefault();
        $('#modifUserModal').modal('show');
        $('#i_id').hide();

    });
    
    $('#validationModif').on('click', function(x){
        x.preventDefault();

        $('#modifUserModal').modal('toggle');
        swal('Attention', "Enregistrer les modification?", {
            icon:'warning',
            buttons:{
                confirm:{
                   className: 'btn btn-primary'
                },
                cancel: {
                    visible: true,
                    text:'Annuler',
                    className: 'btn btn-warning'
                }
            }
        }).then((Delete) => {
            if (Delete) {     
                var formData = new FormData($("#userEditForm")[0]);
                url = $('#userEditForm').attr('action');
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: formData,
                    processData: false,
                    contentType: false,
                    success: function(response) {
                        $('#modifUserModal').modal('toggle');
                        console.log(response);
                        if (response.success){
                            //alert('ok');
                            window.location.reload();
                        }
                    },
                    error: function(xhr, status, error) {
                        console.log(error);
                    }
                });
            }

        });
        
    });
});