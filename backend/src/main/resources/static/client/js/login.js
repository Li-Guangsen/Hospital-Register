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
                console.log(resp);
                if (resp.success) {
                    location.href = ctx + "/client/list";
                }
            }
        });
    });
});