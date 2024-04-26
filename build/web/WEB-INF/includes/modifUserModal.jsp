<!-- ________________________________________________________________________________________________________________________________________ -->

            <div class="modal fade" id="modifUserModal" tablindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                        <!-- Modal body -->
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-sm-12">
                                    <!-- Authentication card start -->
                                    <div class="signup-card card-block auth-body mr-auto ml-auto">
                                        <form method="POST" action="/Immobilier/ModificationAjax" class="md-float-material" id="userEditForm" enctype="multipart/form-data">
                                            <div class="auth-box">
                                                <div class="row m-b-20">
                                                    <div class="col-md-12">
                                                        <h3 class="text-center txt-primary" id="modalTitre"></h3>
                                                        <div class="card-header-right">
                                                            <button type="button" style="display: inline-block;" class="close" data-dismiss="modal">&times;</button>
                                                        </div>
                                                    </div>
                                                </div>
                                                <hr/>
                                                <div class="form-group">
                                                    <label>Pseudo</label>
                                                    <input type="text" name="mdps" id="imdps" class="form-control" maxlength="12"hidden="true">
                                                    <input type="text" name="pseudonyme" id="ipsudonyme" class="form-control" maxlength="50">
                                                    <span class="md-line"></span>
                                                </div>
                                                <div class="form-group">
                                                    <label>Nom</label>
                                                    <input type="text" name="id" id="i_id" class="form-control">
                                                    <input type="text" name="name" id="iname" class="form-control" disabled="true">
                                                    <span class="md-line"></span>
                                                </div>
                                                <div class="form-group">
                                                    <label>Adresse</label>
                                                    <input type="text" name="address" id="iaddress" class="form-control" maxlength="100">
                                                    <span class="md-line"></span>
                                                </div>
                                                <div class="row m-t-30">
                                                    <div class="col-md-12">
                                                        <button type="submit" id="validationModif" class="btn btn-primary btn-md btn-block waves-effect text-center m-b-20">Modifier</button>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <button type="button" class="btn btn-warning btn-md btn-block waves-effect text-center m-b-20" id="annuler">Annuler</button>
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
                                    </div>
                                </div>
                            </div>
                        </div>                          
                </div>

            </div>

        <!-- :__________________________________________________________________________________________________________________________________________ -->



