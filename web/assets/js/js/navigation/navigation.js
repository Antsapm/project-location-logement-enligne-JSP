$(document).ready(function(){
    
    // NAVIGARION ==========================================
    $('.menu-list').each(function(){
        $(this).click(function() {
            $('menu-list').removeClass('active');
            $(this).addClass('active');
            var page = $(this).find('a').attr('href');
            //alert(page);
            $('.page').removeClass('active');
            $(page).addClass('active');
        });
    });
    $('.menu-link').hover(function() {
        $(this).addClass('hover');
        }, function() {
        $(this).removeClass('hover');
    });

    // /NAVIGATION==========================================

    $('.mes').each(function(){
        $(this).on('clicl',function(){
            alert('coll');
        });
    });
});