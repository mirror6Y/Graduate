//添加教师信息
function addTeacher() {

    $.ajax({
        url: "/teacher/addTeacher",        //教师信息接口 添加教师信息方法
        type: 'POST',
        dataType: 'text',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        data: $("#addTeacher").serialize(),//字符串
        success: function (result) {
            if (result === "success") {
                alert("添加成功");
                location.href = "/teacher/getTeachers";
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
            console.log($("#addTeacher").serializeArray());
        }
    });
}

//信息详情
function getTeacherById(id) {

    $.ajax({
        url: "/teacher/getTeacherById/" + id,        //教师信息接口 添加教师信息方法
        type: 'GET',
        dataType: 'json',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        // data: $("#addTeacher").serialize(),//字符串
        success: function (result) {
            if (result === "success") {
                alert("查看信息成功");
            } else {
                alert("查看信息失败");
            }
        }
        ,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:' + XMLHttpRequest);
            console.log('textStatus:' + textStatus);
            console.log('errorThrown:' + errorThrown);
            alert('网络异常！尝试刷新网页解决问题');
            console.log($("#addTeacher").serializeArray());
        }
    });
}

//删除教师信息
$("#updateTeacher").click(function () {
    $('#myModalLabel').modal('show');

    let id = $('#deleteTeacherById').val();

    $.ajax({
        url: "/teacher/deleteTeacher/"+ id ,        //教师信息接口 删除教师信息方法
        type: 'DELETE',
        dataType: 'text',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: function (result) {
            if (result === "success") {
                alert("删除成功");
                location.href = "/teacher/getTeachers";
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

    alert('模态框打开了');
});


