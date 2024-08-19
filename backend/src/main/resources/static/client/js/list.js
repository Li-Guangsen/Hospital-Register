$(() => {
    $(".schedule-details .book").click(function () {
        //排班编号
        let scheduleId = $(this).closest("li").attr("id");
            $.ajax({
                url: ctx + "/client/book",
                method: "post",
                dataType: "json",
                data: {
                    scheduleId
                },
                success(resp) {
                    if (resp.success) {
                        alert("预约成功");
                    }
                },
                error(resp) {
                    if (resp.status === 401) {
                        location.href = ctx + "/client/login";
                    }
                }
            });
    });
});