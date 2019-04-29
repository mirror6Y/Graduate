//登录
function jump() {


    //获取账号
    let account = $('#account').val();
    let password = $('#password').val();

    //json字符串
    let object = {
        'account': account,
        'password': password
    };

    $.ajax({
        url: "/login/login",        //login是登录接口
        type: 'GET',
        dataType: 'text',
        contentType: 'application/json',
        data: object,
//      JSON.stringify(object),
        success: function (result) {
            if (result === "index") {
                alert("登录成功");
            } else {
                alert("账号或密码不正确");
            }
        }
        ,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:' + XMLHttpRequest);
            console.log('textStatus:' + textStatus);
            console.log('errorThrown:' + errorThrown);
            alert('网络异常！尝试刷新网页解决问题');
            console.log(object);
        }
    });
}
