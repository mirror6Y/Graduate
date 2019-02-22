//登录
function jump() {


    //获取账号
    var account = $("#account").val();
    var password = $("#password").val();

    //json字符串
    var object = {
        username: account,
        password: password,
    }

    $.ajax({
        "url": "/login/login",        //login是登录接口
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: {
            "account":
            account,
            "password":
            password
        }
        ,
//      JSON.stringify(object),
        success: function (result) {
            if (result == "index") {
                alert("登录成功");
            } else {
                layer.alert("账号或密码不正确");
            }
        }
        ,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
            layer.alert('网络异常！尝试刷新网页解决问题')
        }
    })
    ;
}
