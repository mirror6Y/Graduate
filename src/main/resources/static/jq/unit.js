function addUnit() {

    $.ajax({
        url: "/unit/addUnit",        //毕业生信息接口 添加毕业生信息方法
        type: 'POST',
        dataType: 'text',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        data: $("#addUnit").serialize(),//字符串
        success: function (result) {
            if (result === "success") {
                alert("添加成功");
                location.href = "/unit/getUnits";
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
            console.log($("#addUnit").serializeArray());
        }
    });
}

function deleteUnit() {

    let id = $('#deleteUnitId').val();

    $.ajax({
        url: "/unit/deleteUnitById/" + id,        //教师信息接口 删除教师信息方法
        type: 'DELETE',
        dataType: 'text',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: function (result) {
            if (result === "success") {
                alert("删除成功");
                location.href = "/unit/getUnits";
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

function updateUnit() {

    $.ajax({
        url: "/unit/updateUnit",
        type: 'PUT',
        dataType: 'text',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        data: $("#updateUnit").serialize(),//字符串
        success: function (result) {
            if (result === "success") {
                alert("修改成功");
                location.href = "/unit/getUnits";
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
            console.log($("#updateUnit").serializeArray());
        }
    });
}
