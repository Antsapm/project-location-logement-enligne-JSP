<nav class="pcoded-navbar">
                        <div class="sidebar_toggle"><a href="#"><i class="icon-close icons"></i></a></div>
                        <div class="pcoded-inner-navbar main-menu">
                            <div class="">
                                <div class="main-menu-header">
                                    <c:choose>
                                        <c:when test="${not empty userloged[0].photo}">
                                            <img class="img-40 img-radius" src="assets/images/profil/<c:out value="${userloged[0].photo}" />" alt="User-Profile-Image">
                                        </c:when>
                                        <c:otherwise>
                                            <img class="img-40 img-radius" src="assets/images/profil/user.png" alt="User-Profile-Image">
                                        </c:otherwise>
                                    </c:choose>
                                    <div class="user-details">
                                        <span><c:out value="${userloged[0].pseudo}" /></span>
                                        <span id="more-details">Actif</span>
                                    </div>
                                </div>
                            </div>
                            <div class="pcoded-search">
                                <span class="searchbar-toggle">  </span>
                                <div class="pcoded-search-box ">
                                    <form action="SearchAjax" method="post">
                                        <input type="text" name="search" id="isearch" placeholder="Recherche..">
                                        <button type="submit" id="recherche" class="search-icon"><i class="ti-search" aria-hidden="true"></i></button>
                                    </form>
                                    
                                </div>
                            </div>
                            <div class="pcoded-navigatio-lavel" data-i18n="nav.category.navigation">Activité</div>
                            <ul class="pcoded-item pcoded-left-item">
                                <li class="active" id = "refresh">
                                    <a href="#">
                                        <span class="pcoded-micon"><i class="ti-home"></i><b>D</b></span>
                                        <span class="pcoded-mtext" data-i18n="nav.dash.main">Actualité</span>
                                        <span class="pcoded-mcaret"></span>
                                    </a>
                                </li>
                                <li class="pcoded-hasmenu">
                                    <a href="javascript:void(0)">
                                        <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i></span>
                                        <span class="pcoded-mtext"  data-i18n="nav.basic-components.main">Publication</span>
                                        <span class="pcoded-mcaret"></span>
                                    </a>
                                    <ul class="pcoded-submenu">
                                        <li class=" ">
                                            <a href="#">
                                                <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                                                <span class="pcoded-mtext" id="newPost" data-i18n="nav.basic-components.alert">Nouveau</span>
                                                <span class="pcoded-mcaret"></span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            
                        </div>
                    </nav>