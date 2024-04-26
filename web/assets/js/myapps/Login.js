/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$(document).ready(function(){
    //swal("Chargement...", {
      //  buttons:false,
        //timer: 1500
    //});
    $('#tolog').on('click', function(ex){
        //alert("espoir");
        ex.preventDefault(); 
        if ($('#iduname').val() ==""){
            swal('Attention',"Veuillez remplir le champs Compte", {
                icon:'warning',
                buttons:{
                    confirm:{
                        className: 'btn btn-primary'
                    }
                }
            });
        }else{
            if ($('#idpass').val() ==""){
                swal('Attention',"Veuillez remplir le champs mot de passe", {
                    icon:'warning',
                    buttons:{
                        confirm:{
                            className: 'btn btn-primary'
                        }
                    }
                });
            }else{
                url = $('#logForm').attr('action');
                var garbage = $('#logForm').serialize();
                console.log(garbage);
                $.ajax({
                    url: url,
                    type:'POST',
                    data: garbage,
                    dataType:'json',
                    success:function(reponse,status){
                        console.log(reponse);

                        if (reponse.success){
                            console.log(reponse.success);
                            window.location.href = "/Immobilier/HomeServlet";
                        }else{
                            if (reponse.error){
                                console.log(reponse.error);
                                swal("Echec", reponse.error, {
                                    icon : "error",
                                    buttons: {        			
                                        confirm: {
                                            className : 'btn btn-secondary',
                                            
                                        }
                                    },
                                });
                            }
                        }
                    
                    }
                })
            }
        }
    });
});