<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html  class="no-js" lang="en">
    <head>
        <title>Login</title>
        <link rel="icon" href="assets/images/icon/accueil.png" type="image/x-icon">
        
        <%@include file="./includes/code_header.jsp" %>
        </head>
    <body class="fix-menu">

        <%@include file="./includes/loader.jsp" %>
<div class="login p-fixed d-flex text-left common-img-bg">
    <!-- Container-fluid starts -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12">
                <!-- Authentication card start -->
                <div class="signup-card card-block auth-body mr-auto ml-auto">
                    <form method="POST" action="/Immobilier/SeConnecterAjax" class="md-float-material" id="logForm">
                        <div class="auth-box">
                            <div class="row m-b-20">
                                <div class="col-md-12">
                                    <h3 class="text-center txt-primary">Se connecter</h3>
                                </div>
                            </div>
                            <hr/>
                            <div class="form-group">
                                <label>Compte utilisateur</label>
                                <input type="text" class="form-control" name="username" id="iduname" placeholder="Compte" maxlength="50">
                                <span class="md-line"></span>
                            </div>
                            <div class="form-group">
                                <label>Mot de passe</label>
                                <input type="password" name="pass" id="idpass" class="form-control" placeholder="********" maxlength="12">
                                <span class="md-line"></span>
                            </div>
                            <div class="row m-t-30">
                                <div class="col-md-12">
                                    <button type="submit" id="tolog" class="btn btn-primary btn-md btn-block waves-effect text-center m-b-20">Se connecter</button>
                                </div>
                                <div class="col-md-12">
                                    <a href="/Immobilier/RegisterServlet">
                                        <button type="button" class="btn btn-warning btn-md btn-block waves-effect text-center m-b-20">Créer votre compte</button>
                                    </a>
                                </div>
                            </div>
                            <hr/>
                            <div class="row">
                                <div class="col-md-10">
                                    <p class="text-inverse text-left"><b>e-Immobilier Team</b></p>
                                </div>
                                <div class="col-md-2">
                                    <img src="assets/images/icon/domicile.png" width="50px" alt="small-logo.png">
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- end of form -->
                </div>
                <!-- Authentication card end -->
            </div>
            <!-- end of col-sm-12 -->
        </div>
        <!-- end of row -->
    </div>
    <!-- end of container-fluid -->
</div>

    
        <script src="./assets/js/myapps/Login.js"></script>
    
    </body>
</html>
 