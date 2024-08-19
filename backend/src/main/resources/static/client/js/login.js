$(() => {
    $("#btn").click(function () {
        let phone = $("#phone").val();
        let password = $("#password").val();

        $.ajax({
            url: ctx + "/client/login",
            method: "post",
            dataType: "json",
            data: {
                phone,
                password
            },
            success(resp) {
                if (resp.success) {
                    alert("登录成功");
                    location.href = ctx + "/client/list";
                }
                else
                    alert(resp.error);
            }
        });
    });
});