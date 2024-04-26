<!-- ________________________________________________________________________________________________________________________________________ -->

            <div class="modal fade" id="newPostModal" tablindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">

                        <!-- Modal Header -->
                        


                    <!-- Modal body -->
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-sm-12">
                                    <!-- Authentication card start -->
                                    <div class="signup-card card-block auth-body mr-auto ml-auto">
                                        <form method="POST" action="/Immobilier/PublicationAjax" class="md-float-material" id="pubForm" enctype="multipart/form-data">
                                            <div class="auth-box">
                                                <div class="row m-b-20">
                                                    <div class="col-md-12">
                                                        <h3 class="text-center txt-primary">Publication</h3>
                                                        <div class="card-header-right">
                                                            <button type="button" style="display: inline-block;" class="close" data-dismiss="modal">&times;</button>
                                                        </div>
                                                    </div>
                                                </div>
                                                <hr/>
                                                <div class="form-group">
                                                    <label>Déscription</label>
                                                    <textarea id="idesc" name="description" value="<c:out value="${name}"/>" class="form-control" rows="5" cols="50"placeholder="Déscription de la publication.........." maxlength="500"></textarea>
                                                    <span class="md-line"></span>
                                                </div>
                                                <div class="form-group">
                                                    <label>Localisation</label>
                                                    <input type="text" name="localisation" id="ilocalisation" class="form-control" placeholder="Quartier, ville, indication.." maxlength="50">
                                                    <span class="md-line"></span>
                                                </div>
                                                <div class="form-group">
                                                    <label>Loyer</label>
                                                    <input type="number" name="loyer" id="iloyer" class="form-control">
                                                    <span class="md-line"></span>
                                                </div>
                                                <div class="form-group">
                                                    <label>Photo</label>
                                                    <input type="file" name="photo" id="iphoto" class="form-control">
                                                    <span class="md-line"></span>
                                                </div>
                                                <div class="row m-t-30">
                                                    <div class="col-md-12">
                                                        <button type="submit" id="topost" class="btn btn-primary btn-md btn-block waves-effect text-center m-b-20">Publier</button>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <button type="button" class="btn btn-warning btn-md btn-block waves-effect text-center m-b-20" id="todiscard">Abandonner</button>
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


