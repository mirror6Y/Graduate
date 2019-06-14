function addRecruitment() {

    $.ajax({
        url: "/recruitment/addRecruitment",
        type: 'POST',
        dataType: 'text',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        data: $("#addRecruitment").serialize(),//字符串
        success: function (result) {
            if (result === "success") {
                alert("添加成功");
                location.href = "/recruitment/getRecruitments";
            } else {
                alert("添加失败");
            }
        }
        ,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:' + XMLHttpRequest);
            console.log('textStatus:' + textStatus);
            console.log('errorThrown:' + errorThrown);
            alert('网络异常！尝试刷新网页解决问题');
            console.log($("#addRecruitment").serializeArray());
        }
    });
}

function deleteRecruitment() {

    let id = $('#deleteRecruitmentId').val();

    $.ajax({
        url: "/recruitment/deleteRecruitmentId/" + id,        //教师信息接口 删除教师信息方法
        type: 'DELETE',
        dataType: 'text',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: function (result) {
            if (result === "success") {
                alert("删除成功");
                location.href = "/recruitment/getRecruitments";
            } else {
                alert("删除失败");
            }
        }
        ,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:' + XMLHttpRequest);
            console.log('textStatus:' + textStatus);
            console.log('errorThrown:' + errorThrown);
            alert('网络异常！尝试刷新网页解决问题');
        }
    });

};

function updateRecruitment() {

    $.ajax({
        url: "/recruitment/updateRecruitment",
        type: 'PUT',
        dataType: 'text',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        data: $("#updateRecruitment").serialize(),//字符串
        success: function (result) {
            if (result === "success") {
                alert("修改成功");
                location.href = "/recruitment/getRecruitments";
            } else {
                alert("修改失败");
            }
        }
        ,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:' + XMLHttpRequest);
            console.log('textStatus:' + textStatus);
            console.log('errorThrown:' + errorThrown);
            alert('网络异常！尝试刷新网页解决问题');
            console.log($("#updateRecruitment").serializeArray());
        }
    });
}
