    <%@page import="com.beans.Commentaire"%>
<%@page import="java.util.List"%>
<%@page import="com.database.PubMethod"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title id="titre">Home</title>
    <!-- HTML5 Shim and Respond.js IE9 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
      
      <!-- Favicon icon -->
      <link rel="icon" href="assets/images/icon/accueil.png" type="image/x-icon">
      
      <%@include file="./includes/code_header.jsp" %>
      <link rel="stylesheet" type="text/css" href="assets/css/jquery.mCustomScrollbar.css">
  </head>

  <body>
    <!-- Pre-loader start -->
    
    <%@include file="./includes/loader.jsp" %>
    <!-- Pre-loader end -->
    <div id="pcoded" class="pcoded">
        <div class="pcoded-overlay-box"></div>
        <div class="pcoded-container navbar-wrapper">
            
            <%@include file="./includes/sidebar.jsp" %>
            <div class="pcoded-main-container">
                <div class="pcoded-wrapper">

                    <%@include file="./includes/menu.jsp" %>
                    <div id="acceuil" class="page active">
                        <div class="pcoded-content">
                            <div class="pcoded-inner-content">
                                <div class="main-body">
                                    <div class="page-wrapper">
                                    
                                        <div class="page-body">
                                            <div class="row">
                                                <!-- Data widget start -->
                                                
                                                <c:forEach items="${actualite}" var="pub">
                                                
                                                    <div class="col-md-12 col-xl-12">
                                                        <div class="card project-task">
                                                            <div class="card-header">
                                                                <div class="card-header-left ">
                                                                <div class="row">
                                                                    <div class="col-md-12 col-xl-12">
                                                                        <c:choose>
                                                                            <c:when test="${not empty pub.photo}">
                                                                                <img class="img-40 img-radius" src="assets/images/profil/<c:out value="${pub.photo}" />" alt="User-Profile-Image">
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <img class="img-40 img-radius" src="assets/images/profil/user.png" alt="User-Profile-Image">
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        <div class="d-inline-block m-l-20">
                                                                        <div class="row">
                                                                            <span class="col-md-12">
                                                                                <label style="font-weight: bold;color:rgb(105, 0, 100);"><c:out value="${pub.name}" /></label>
                                                                                <label style="color:rgb(105, 0, 100);"> a posté une maison à </label>
                                                                                <label style="font-weight: bold;"> <c:out value="${pub.localisation}" /> </label>
                                                                                <label style="color:rgb(105, 0, 100);"> avce un loyer de </label>
                                                                                <label style="font-weight: bold;"> <c:out value="${pub.loyer}" /> </label>
                                                                                <br>Il y a <c:out value="${pub.duration}" />
                                                                            </span>
                                                                        </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                </div>
                                                                <div class="card-header-right">
                                                                    <ul class="list-unstyled card-option">
                                                                        <li><i class="icofont icofont-simple-left "></i></li>
                                                                        <li><i class="icofont icofont-maximize full-card"></i></li>
                                                                        <li><i class="icofont icofont-minus minimize-card"></i></li>
                                                                        <li><i class="icofont icofont-refresh reload-card"></i></li>
                                                                        <li><i class="icofont icofont-error close-card"></i></li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                            <div class="card-block p-b-10">
                                                                <p class="col-md-12 col-xl-8">
                                                                    <c:out value="${pub.description}" />
                                                                </p>
                                                                <img class="image-post" src="assets/images/post/<c:out value="${pub.photo_pub}" />">
                                                                <p class="text-muted">${pub.effJaime} like, ${pub.effComs} commentaire</p>
                                                            </div>
                                                            <div class="card-block text-center">
                                                                <div class="row">
                                                                    <div class="col-6 b-r-default">
                                                                        <c:choose>
                                                                            <c:when test="${pub.jaime == true}">
                                                                                <img src="assets/images/icon/islike.png" class="dislike_pub" id="<c:out value="${pub.id_pub}" />" width="40px" height="height" alt="alt"/> 
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <img src="assets/images/icon/like.png" class="like_pub" id="<c:out value="${pub.id_pub}" />" width="40px" height="height" alt="alt"/> 
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                            <!-- <label style="font-size:40px;">23</label> -->
                                                                        <p class="text-muted">j'aime</p>
                                                                    </div>
                                                                    <div class="col-6">
                                                                        <a class="commentaire" data-toggle="collapse" id="<c:out value="${pub.id_pub}" />" data-parent="#accordion" href="#collapse<c:out value="${pub.id_pub}" />"
                                                                            aria-expanded="true" aria-controls="collapseAll">
                                                                            <img src="assets/images/icon/comment.png" class="com_pub" width="40px" height="height" alt="alt"/> 
                                                                            <!-- <label style="font-size:40px;">23</label> -->
                                                                            <p class="text-muted">Commentaire</p>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                                <div class="panel-collapse collapse in col-lg-12" id="collapse<c:out value="${pub.id_pub}" />" role="tabpanel" aria-labelledby="headingOne">
                                                                    <div class="card-block accordion-block">
                                                                        <div id="accordion" class="comArea<c:out value="${pub.id_pub}" />" role="tablist" aria-multiselectable="true">
                                                                            <!-- COmmentaire COntent -->
                                                                        </div>
                                                                                
                                                                    </div>
                                                                    <div class="card-block accordion-block">
                                                                        <div class="pcoded-search">
                                                                            <span class="searchbar-toggle">  </span>
                                                                            <div class="pcoded-search-box ">
                                                                                <input class="form-control form-control-round" id="contenu" placeholder="commentez............" type="text">
                                                                                <span class="search-icon postCOm" id="<c:out value="${pub.id_pub}" />"><i class="ti-location-arrow" aria-hidden="true"></i></span>
                                                                            </div>
                                                                        </div>
                                                                                
                                                                    </div>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </c:forEach>                                               

                                            </div>
                                        </div>
                                        
                                        <div id="styleSelector">
                                        
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                            
                    </div>

                    <div id="message" class="page">
                        <div class="pcoded-content">
                            <div class="pcoded-inner-content">
                                <div class="main-body">
                                    <div class="page-wrapper">
                                    
                                        <div class="page-body">
                                            <div class="row" id="begin">
                                                <!-- Data widget start -->
                                                
                                                <div class="col-md-12 col-xl-12 mes" id="">
                                                    <div class="card project-task">
                                                        <div class="card-header">
                                                            <div class="card-header-left ">
                                                            <div class="row">
                                                                <div class="col-md-12 col-xl-12">
                                                                    <div class="task-contain">
                                                                        <h6 class="bg-c-green d-inline-block text-center">A</h6>
                                                                        <p class="d-inline-block m-l-20">Alison Becker</p>
                                                                        <p class="">3 nouveaux messages</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            </div>
                                                            <div class="card-header-right">
                                                                <ul class="list-unstyled card-option">
                                                                    <li><i class="icofont icofont-simple-left "></i></li>
                                                                    <li><i class="icofont icofont-maximize full-card"></i></li>
                                                                    <li><i class="icofont icofont-minus minimize-card"></i></li>
                                                                    <li><i class="icofont icofont-refresh reload-card"></i></li>
                                                                    <li><i class="icofont icofont-error close-card"></i></li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                            </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="page3" class="page">
                        <p>PAGE 3</p>
                    </div>
                </div>
                <div class="fixed-button">
                    <a href="/Immobilier/HomeServlet" target="_blank" class="btn btn-md btn-primary">
                      <i class="fa fa-shopping-cart" aria-hidden="true"></i> Afficher plus
                    </a>
                </div>
            </div>
                                                            <!-- update modal -->
        
            <%@include file="./includes/newPostModal.jsp" %>

        </div>

        
<!-- Required Jquery -->

<!-- modernizr js -->
<script type="text/javascript" src="assets/js/modernizr/modernizr.js"></script>
<!-- am chart -->
<script src="assets/pages/widget/amchart/amcharts.min.js"></script>
<script src="assets/pages/widget/amchart/serial.min.js"></script>
<!-- Todo js -->
<script type="text/javascript " src="assets/pages/todo/todo.js "></script>
<!-- Custom js -->
<script type="text/javascript" src="assets/pages/dashboard/custom-dashboard.js"></script>
<script type="text/javascript" src="assets/js/script.js"></script>
<script type="text/javascript " src="assets/js/SmoothScroll.js"></script>
<script src="assets/js/pcoded.min.js"></script>
<script src="assets/js/demo-12.js"></script>
<script src="assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>
var $window = $(window);
var nav = $('.fixed-button');
    $window.scroll(function(){
        if ($window.scrollTop() >= 200) {
         nav.addClass('active');
     }
     else {
         nav.removeClass('active');
     }
 });
</script>
<style>
    .error{
        border: solid 2px red;
    }
    .defaul{
        
    }
    
</style>
<script>
    $(document).ready(function(){
        // récuperation des sessions....
        
        var actu = '<%= request.getAttribute("actualite")%>';
        console.log(actu);
        var userloged = '<%= request.getAttribute("jsonuserloged")%>';
        userloged = JSON.parse(userloged);
        // renvoyer à la login  s'il y pas de Session...........
        if ((userloged) || (userloged !== null)){
            swal("Chargement...", {
                buttons:false,
                timer: 2000
            });
            
        }else{
            window.location.href = "/Immobilier/LoginServlet";
        }
        
        //Pour se déconncter.................
        $('#logOut').on('click', function(dis){
            dis.preventDefault();
            url = $(this).attr('href');

            swal({
                title: 'Attention',
                text: "Voulez vous vraiment vous deconnectez?",
                type: 'warning',
                icon: 'warning',
                buttons:{
                    confirm: {
                        text : 'Oui',
                        className : 'btn btn-warning'
                    },
                    cancel: {
                        visible: true,
                        text:'Annuler',
                        className: 'btn btn-primary'
                    }
                }
            }).then((Delete) => {
                if (Delete) {
                    let ids = [];
                    len = userloged.userSession.length;
                    for(i=0; i<len; i++){
                        id = userloged.userSession[i]['id'];
                        ids.push(id);
                    }
                    console.log(ids);
                    data = JSON.stringify(ids);
                    $.ajax({
                        url: 'SeDeconnecterAjax',
                        type:'POST',
                        data: {idList: data},
                        dataType:'json',
                        success:function(reponse,status){
                            console.log(reponse);
                            if (reponse){
                                window.location.reload();
                            }
                            
                        }
                    });
                } else {
                    swal.close();
                }
            });

        });
        
        // Rafraîchir la page..........
        $('#refresh').on('click', function(no){
            no.preventDefault();
            window.location.reload();
        });
        
        $('#recherche').on('click', function(ev){
            ev.preventDefault();
            var value = $('#isearch').val();
            window.location.href = "/Immobilier/SearchServlet?val="+value+"";
        });
        
        $('.like_pub').each(function(){
            $(this).on('click', function(){
                var id_pub = $(this).attr('id');
                var id = userloged.userSession[0].id;
                $.ajax({
                    url: 'JaimeAjax',
                    type:'POST',
                    data: {id_pub: id_pub, id:id},
                    dataType:'json',
                    success:function(reponse,status){
                        console.log(reponse);
                        if (reponse.success){
                            window.location.reload();
                        }
                        
                    }
                });
                //alert(id_pub);
            });
        });
        $('.dislike_pub').each(function(){
            $(this).on('click', function(){
                var id_pub = $(this).attr('id');
                var id = userloged.userSession[0].id;
                $.ajax({
                    url: 'disJaimeAjax',
                    type:'POST',
                    data: {id_pub: id_pub, id:id},
                    dataType:'json',
                    success:function(reponse,status){
                        console.log(reponse);
                        if (reponse.success){
                            window.location.reload();
                        }
                        
                    }
                });
                //alert(id_pub);
            });
        });
        
        
        $('.commentaire').each(function(){
            $(this).on('click', function(){
                id_pub = $(this).attr('id');
                $.ajax({
                    url: 'CommentaireAjax',
                    type:'POST',
                    data: {id_pub: id_pub},
                    dataType:'json',
                    success:function(reponse,status){
                        console.log(reponse.success);
                        if(reponse.success){
                            complace = ".comArea"+id_pub;
                            $.each(reponse.success, function(index,oneCome){
                                console.log(oneCome.pseudo);
                                $('.comPartition').each(function(){
                                   $(this).remove();
                                });
                                $(complace).html('<div class="accordion-panel" ><div class="accordion-heading" role="tab" id="heading'+oneCome.numerotation+'"><h3 class="card-title accordion-title"><p class="text-muted">Il y a '+oneCome.date_com+'</p><a class="accordion-msg" data-toggle="collapse" data-parent="#accordion" href="#collapseOne'+oneCome.numerotation+'"aria-expanded="true" aria-controls="collapseOne'+oneCome.numerotation+'"><img class="img-40 img-radius" style="border-radius:50%;" src="assets/images/profil/'+oneCome.photo_use+'"> '+oneCome.pseudo+'</a></h3></div><div id="collapseOne'+oneCome.numerotation+'" class="panel-collapse collapse show"role="tabpanel" aria-labelledby="heading'+oneCome.numerotation+'"><div class="accordion-content accordion-desc"><p>'+oneCome.contenu+'</p></div></div>');
                            });
                        }else{
                            complace = ".comArea"+id_pub;
                            $(complace).html('<p class="text-muted"> Aucun Commentaire </p>');
                        }
                    }
                });
            });
        });
        
        $('.postCOm').each(function(){
            $(this).on('click',function(){
               id_pub = $(this).attr('id');
                contenu = $('#contenu').val();
                var id = userloged.userSession[0].id;
                if (contenu){
                    $.ajax({
                        url: 'NewCommentaireAjax',
                        type:'POST',
                        data: {id_pub:id_pub, id:id, contenu:contenu},
                        //data: {'id_pub='+id_pub+'&&id='+id+'&&contenu='contenu},
                        dataType:'json',
                        success:function(reponse,status){
                            console.log(reponse);
                            if(reponse.success){
                                window.location.reload();
                            }

                        }
                    });
                } 
            });
        });
    });
</script>
        <script src="./assets/js/myapps/newPost.js"></script>
        <script src="./assets/js/myapps/Disconnexion.js"></script>
        <!--<script src="assets/js/js/navigation/navigation.js"></script>-->
        
</body>

</html>

