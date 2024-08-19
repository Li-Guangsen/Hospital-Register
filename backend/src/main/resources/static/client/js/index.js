$(() => {
    //点击导航菜单，显示iframe
    $("#nav>.item").click(function () {
        $(this).siblings().removeClass("active");
        $(this).addClass("active");
        let url = $(this).children("a").attr("href");
        $(".body>iframe").attr("src", url);

    });

    //阻止超链接的默认行为
    $("#nav>.item>a").click(function (e) {
        e.preventDefault();//阻止默认事件，即阻止超链接的默认行为
    });
});