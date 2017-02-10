/**
 * 添加品牌
 */
var flag=false;
function submitUser(){
	if(flag){
		return;
	}
	flag=true;
	var userNike=$("#userNike").val();
	var email=$("#email").val();
	if(userNike==""){
		noty({text:"用户昵称不能为空",layout:'topCenter',type:"error",timeout:3000})
		flag=false;
		return;
	}
	if(email==""){
		noty({text:"邮箱不能为空",layout:'topCenter',type:"error",timeout:3000})
		flag=false;
		return;
	}
	var city=$("#city").val().trim();
	var id=$("#id").val().trim();
	var gender=$("#gender").val().trim();
	if(gender==""){
		noty({text:"用户性别不能为空",layout:'topCenter',type:"error",timeout:3000})
		flag=false;
		return;
	}
	if(city==""){
		noty({text:"城市不能为空",layout:'topCenter',type:"error",timeout:3000})
		flag=false;
		return;
	}
	if(id<1){
		flag=false;
		return;
	}
	$.ajax({
		url:"../home/EditUser",
		type:"POST",
		dataType:"json",
		data:{"userNike":userNike,"email":email,"city":city,"gender":gender,"id":id},
		success:function(data){
			if(data!=null){
				if(data.result==1){
					noty({text:"修改成功",layout:'topCenter',type:"success",timeout:2000})
					setTimeout(function(){window.location.href="../home/ShowUser";flag=false;},2000);
					
				}else{
					noty({text:data.msg,layout:'topCenter',type:"error",timeout:3000})
					flag=false;
				}
			}else{
				noty({text:"请求出错",layout:'topCenter',type:"error",timeout:2000})
				flag=false;
			}
		}
	})
}

function submitPassword(){
	var password=$("#password").val();
	var cpassword=$("#cpassword").val();
	if(password==""|| password.length<6 || password.length>12){
		noty({text:"用户密码不符合规则",layout:'topCenter',type:"error",timeout:3000})
		return;
	}
	if(password!=cpassword){
		noty({text:"两次密码不一样",layout:'topCenter',type:"error",timeout:3000})
		return;
	}
	$.ajax({
		url:"../home/updatePassword",
		type:"POST",
		dataType:"json",
		data:{"password":password},
		success:function(data){
			if(data!=null){
				if(data.result==1){
					noty({text:"修改成功",layout:'topCenter',type:"success",timeout:2000})
					setTimeout(function(){window.location.href="../home/login";},2000);
				}else{
					noty({text:data.msg,layout:'topCenter',type:"error",timeout:3000})
				}
			}else{
				noty({text:"请求出错",layout:'topCenter',type:"error",timeout:2000})
			}
		}
	})
}