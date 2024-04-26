/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function(){
    //nouveau pub.........
    $('#newPost').on('click', function(des){
        des.preventDefault();
        $('#newPostModal').modal('show');

    });
    $('#topost').on('click', function(x){
        var test = 'no';
        if ($('#idesc').val() === "" ){
            $('#idesc').addClass('error');
            $('#ilocalisation').addClass('defaul');
            $('#iloyer').addClass('defaul');
            $('#iphoto').addClass('defaul');
            //swal('Attention',"Décrire la publication", {
              //  icon:'warning',
                //toast: true,
                //buttons:{
                  //  confirm:{
                    //    className: 'btn btn-primary'
                    //}
                //}
            //});
            x.preventDefault();
        }else{
            if ($('#ilocalisation').val() === ""){

                $('#ilocalisation').addClass('error');
                $('#idesc').addClass('defaul');
                $('#iloyer').addClass('defaul');
                $('#iphoto').addClass('defaul');
                //swal('Attention',"Il faut indiquer la localisation", {
                  //  icon:'warning',
                    //toast: true,
                    //buttons:{
                      //  confirm:{
                        //    className: 'btn btn-primary'
                        //}
                    //}
                //});
                x.preventDefault();
            }else{
                if($('iloyer').val() === ""){
                    $('#iloyer').addClass('error');
                    $('#idesc').addClass('defaul');
                    $('#ilocalisation').addClass('defaul');
                    $('#iphoto').addClass('defaul');
                    //swal('Attention',"Veuillez mettre une facturation", {
                      //  icon:'warning',
                        //buttons:{
                          //  confirm:{
                            //    className: 'btn btn-primary'
                            //}
                        //}
                    //});
                    x.preventDefault();
                }else{
                    if($('#iphoto').val()){

                        test = "success";
                    }else{
                        $('#iphoto').addClass('error');
                        $('#idesc').addClass('defaul');
                        $('#iloyer').addClass('defaul');
                        $('#ilocalisation').addClass('defaul');
                        //swal('Attention',"Mettre des photos enfin d'accomplir la publication", {
                          //  icon:'warning',
                            //buttons:{
                              //  confirm:{
                                //    className: 'btn btn-primary'
                                //}
                            //}
                        //});
                        x.preventDefault();
                    }
                }
            }
        }

        if(test === "success"){
            x.preventDefault();

            //let ids = [];
            //len = userloged.userSession.length;
            //for(i=0; i<len; i++){
              //  id = userloged.userSession[i]['id'];
                //ids.push(id);
            //}

            //user = JSON.stringify(ids);
            
            var formData = new FormData($("#pubForm")[0]);
            $.ajax({
                url: 'PublicationAjax',
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                success: function(response) {
                    console.log(response);
                    if (response.success){

                        $('#newPostModal').modal('toggle');
                        swal('Attention', response.success, {
                            icon:'success',
                            buttons:{
                                confirm:{
                                   className: 'btn btn-primary'
                               }
                            }
                        }).then((Delete) => {
                            if (Delete) {     
                                window.location.reload();
                            }

                        });
                    }
                },
                error: function(xhr, status, error) {
                    console.log(error);
                }
            });
        }

    });
});