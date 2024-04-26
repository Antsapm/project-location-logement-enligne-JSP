<!DOCTYPE html>
<html lang="en">

<head>
    
    <title>SignUp</title>
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
                        <form id="registerForm" action="http://localhost:8081/Immobilier/InsertionAjax" method="POST" class="md-float-material form">
                            <div class="auth-box">
                                <div class="row m-b-20">
                                    <div class="col-md-12">
                                        <h3 class="text-center txt-primary">Créer votre compte</h3>
                                    </div>
                                </div>
                                <hr/>
                                <div class="form-group s1">
                                    <label>Nom</label>
                                    <input type="text" id="inom" name="nom" class="form-control" placeholder="Votre Nom" maxlength="50">
                                    <span class="md-line"></span>
                                </div>
                                <div class="form-group s1">

                                    <label>Prénom</label>
                                    <input type="text" id="iprenom" name="prenom" class="form-control" placeholder="Votre Prénom" maxlength="50">
                                    <span class="md-line"></span>
                                </div>
                                <div class="form-group s1">

                                    <label>Adresser</label>
                                    <input type="text" id="iadresse" name="adresse" class="form-control" placeholder="Votre Adresse" maxlength="50">
                                    <span class="md-line"></span>
                                </div>
                                <div class="form-check s1">
                                    <label>Genre</label><br/>
                                    <label class="form-radio-label">
                                        <input class="form-radio-input" type="radio" name="sexe" value="M"  checked="">
                                        <label class="text-inverse text-left m-b-0">Homme</label>
                                    </label>
                                    <label class="form-radio-label ml-3">
                                        <input class="form-radio-input" type="radio" name="sexe" value="F">
                                        <label class="text-inverse text-left m-b-0">Femme</label>
                                    </label>
                                </div>
                                
             <!-- ========================================================================================= -->
                                
                                <div class="form-group s2">
                                    <label>Pseudo utilisateur</label>
                                    <input type="text" id="ipseudo" name="pseudo" class="form-control" placeholder="Nom en tant qu'utilisateur" maxlength="50">
                                    <span class="md-line"></span>
                                </div>
                                <div class="form-group s2">
                                    <label>Mail</label>
                                    <input type="text" id="imail" name="mail" class="form-control" placeholder="Votre Adresse mail" maxlength="50">
                                    <span class="md-line"></span>
                                </div>
                                <div class="form-group s2">
                                    <label>Téléphone</label>
                                    <input type="text" id="itel" name="tel" class="form-control" placeholder="Votre numèro téléphone" maxlength="17">
                                    <span class="md-line"></span>
                                </div>
                                <div class="form-group s2">
                                    <label>Mot de passe</label>
                                    <input type="password" id="ipassword" name="password" class="form-control" placeholder="Mot de passe" maxlength="12">
                                    <span class="md-line"></span>
                                </div>
                                <div class="form-group s2">
                                    Confirmation
                                    <input type="password" id="iconfpassword" name="confpassword" class="form-control" placeholder="Confirmer le mot de passe" maxlength="12">
                                    <span class="md-line"></span>
                                </div>

                                <div class="row m-t-30">
                                    <div class="col-md-6">
                                        <button type="button" id="prev" class="btn btn-primary btn-md btn-block waves-effect text-center m-b-20">Retour.</button>
                                    </div>
                                    <div class="col-md-6">
                                        <button type="submit" id="sub" class="btn btn-success btn-md btn-block waves-effect text-center m-b-20">Enregistrer.</button>
                                    </div>
                                </div>
       <!-- ================================================================================================ -->
                                <div class="row m-t-30 s1">
                                    <div class="col-md-6">
                                        <a href="/Immobilier/LoginServlet">
                                            <button type="button" class="btn btn-danger btn-md btn-block waves-effect text-center m-b-20">Retour.</button>
                                        </a>
                                    </div>
                                    <div class="col-md-6">
                                        <button type="button" id= "next" class="btn btn-primary btn-md btn-block waves-effect text-center m-b-20">Suivant.</button>
                                    </div>
                                </div>
                                <hr/>
                                <div class="row">
                                    <div class="col-md-10">
                                        <p class="text-inverse text-left m-b-0">Créer un compte est le prémière étape pour utiliser l'application.</p>
                                        <p class="text-inverse text-left m-b-0"><c:out value="${rapport}"/></p>
                                        <p class="text-inverse text-left"><b>e-Immobilier Team</b></p>
                                    </div>
                                    <div class="col-md-2">
                                        <img src="assets/images/icon/domicile.png" alt="small-logo.png" width="50px">
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
</body>

    <script src="assets/js/myapps/Register.js"></script>

</html>
