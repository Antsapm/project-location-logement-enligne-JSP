/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$(document).ready(function(){
    $('.s2').each(function(){
        $(this).hide();
    });
    $('#inom').focus();
    $('#sub').hide();
    $('#prev').hide();
    $('#next').on('click', function(){
        var nom = $('#inom').val();
        var prenom = $('#iprenom').val();
        var adresse = $('#iadresse').val();
        if (nom ===""){
            $('#inom').css('border', 'solid 2px red');
            $('#iprenom').css('border', '');
            console.log($('#inom'));
            $('#iadresse').css('border', '');
        }else{
            if (prenom ==="") {
                $('#iprenom').css('border', 'solid 2px red');
                $('#inom').css('border', '');
                $('#iadresse').css('border', '');
            } else {
                if (adresse ==="") {
                    $('#iadresse').css('border', 'solid 2px red');
                    $('#inom').css('border', '');
                    $('#iprenom').css('border', '');
                } else {
                    swal("Préparation...", {
                        buttons:false,
                        timer: 1100
                    });
                    $('#inom').css('border', '');
                    $('#iprenom').css('border', '');
                    $('#iadresse').css('border', '');
                    $('.s1').each(function(){
                        $(this).hide();
                    });
                    $('#prev').fadeIn(5);
                    $('#sub').fadeIn(5);
                    $('.s2').each(function(){
                        $(this).fadeIn(5);
                    });
                    
                }
            }
        }
    });
    $('#prev').on('click', function(){
        $('.s2').each(function(){
            $(this).hide();
        });
        $(this).hide();
        $('#sub').hide();
        $('.s1').each(function(){
            $(this).fadeIn(0);
        });
    });
    $('#sub').on('click', function(al){
        al.preventDefault();
        //===========================================CONTROL CHAMPS=======================================
        $('#ipseudo').css('border','');
        $('#imail').css('border','');
        $('#itel').css('border','');
        $('#ipassword').css('border','');
        $('#iconfpassword').css('border','');
        var control ="";
        if($('#ipseudo').val() ===""){
            $('#ipseudo').css('border','solid 2px red');
            
        }else{
            if ($('#imail').val() ==="") {
                $('#imail').css('border','solid 2px red');
                
            } else {
                if ($('#itel').val() ==="") {
                    $('#itel').css('border','solid 2px red');
                    
                    
                } else {
                    if ($('#ipassword').val() ==="") {
                        $('#ipassword').css('border','solid 2px red');
                        
                        
                    } else {
                        if ($('#iconfpassword').val() === $('#ipassword').val()) {
                            control='safety';
                        } else {
                            $('#iconfpassword').css('border','solid 2px red');
                            
                        }
                    }
                }
            }
        }
        //===========================================CONTROL CHAMPS=======================================
        if (control ==="safety"){
            url = $('#registerForm').attr('action');
            var garbage = $('#registerForm').serialize();
            console.log(garbage);
            $.ajax({
                url: url,
                type:'POST',
                data: garbage,
                dataType:'json',
                success:function(reponse,status){
                    console.log(reponse);
                    if (reponse.success){
                        swal("Succés", reponse.success, {
                            icon : "success",
                            buttons: {        			
                                confirm: {
                                    className : 'btn btn-success',
                                    
                                }
                            },
                        }).then((Delete) => {
                            if (Delete) {     
                                window.location.href = "/Immobilier/LoginServlet";
                            }

                        });
                    }
                    if (reponse.error){
                        console.log(reponse.error);
                        swal("Echèc", reponse.error, {
                            icon : "error",
                            buttons: {        			
                                confirm: {
                                    className : 'btn btn-secondary',
                                    
                                }
                            },
                        });
                    }
                }
            })
        }
    });

});