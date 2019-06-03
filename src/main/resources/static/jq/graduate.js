
function addGraduate() {

    $.ajax({
        url: "/graduate/addGraduate",        //教师信息接口 添加教师信息方法
        type: 'POST',
        dataType: 'text',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        data: $("#addGraduate").serialize(),//字符串
        success: function (result) {
            if (result === "success") {
                alert("添加成功");
                location.href = "/graduate/getGraduates";
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
            console.log($("#addGraduate").serializeArray());
        }
    });
}
