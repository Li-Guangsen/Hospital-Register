$(() => {
    $("#logout").click(function () {
        if(confirm('确定退出登录吗？')) {
            $.ajax({
                url: ctx + "/client/logout",
                method: "post",
                success(resp) {
                    if (resp.success) {
                        alert('已退出登录！');
                        location.href = ctx + "/client/list";
                    }
                }
            });
        }
    });
    $('#editPwd').on('click', function() {
        $('#modal').css('display', 'flex');
    });

    // 关闭模态框
    $('.close-btn').on('click', function() {
        $('#modal').css('display', 'none');
    });
    $('.submit-btn').on('click', function() {
        let patientId =  document.querySelector('#patId').innerText;
        // console.log(patientId);
        const oldPassword = $('#old-password').val();
        const newPassword = $('#new-password').val();
        if(!oldPassword || !newPassword){
            alert('请输入密码！');
            return;
        }
        // console.log('原密码:', oldPassword);
        // console.log('新密码:', newPassword);
        if(confirm('确定修改密码吗？')) {
            $.ajax({
                url: ctx + "/client/editPwd",
                method: "post",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify({
                    id: patientId,
                    oldPwd: oldPassword,
                    newPwd: newPassword,
                }),
                success(resp) {
                    // console.log('密码修改！');
                    if (resp.success) {
                        alert('密码修改成功！');
                        $('#modal').css('display', 'none');
                        // console.log('密码修改成功！');
                        location.href = ctx + "/client/my";
                    } else {
                        alert(resp.error);
                    }
                },
                error: function () {
                    // 处理错误
                    alert('密码修改失败，请重试。');
                }
            });
        }
    });
});

