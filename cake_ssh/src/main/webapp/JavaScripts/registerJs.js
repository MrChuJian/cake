angular.module('app',[])
.controller('registerCtrl',function ($scope,$http) {
	$scope.pone_inp=document.getElementById("phone_num");
	$scope.ifPoneTrue=true;
	$scope.password_in1=document.getElementById("password1");
	$scope.password_in2=document.getElementById("password2");
	$scope.register_btn=document.getElementById("registerBtn");

	$scope.pone_inp.onblur=function(){
		$scope.pone_inp.setAttribute("style","border:solid 1px #ccc;");
		if($scope.pone_inp.value!=""){
			if(!/^1[3|4|5|7|8]\d{9}$/.test($scope.pone_inp.value)){
				alert("手机号输入错误，请重新输入！");
				$scope.ifPoneTrue=false;
			}else{
				$scope.pone_inp.setAttribute("style","border:solid 1px #008000;");
				$scope.ifPoneTrue=true;
			}
		}
	}


	$scope.register_btn.onclick=function(){
		if($scope.ifPoneTrue){
			if(angular.equals($scope.password_in1.value, $scope.password_in2.value)){
				//向服务器发送注册请求
				if($scope.ver_num==$scope.verification_code){
					document.getElementById("register_form").submit();
					return true;
				}else{
					alert("验证码输入错误");
					return;
				}
				//return true;
			}else{
				alert("请确保两次密码输入相同");
			}
		}else{
			alert("手机号输入错误，请重新输入！");
		}
	}

	document.getElementById("get_code").onclick=function(){
		$http({
			url: "http://192.168.1.109:8080/cake_ssh/user_getRegisterVerificationCode.action",
			method: "GET",
			params: {
				phone: $scope.phone_num
			}
		}).then(function(res){
			if(res.data=="该手机号已被注册!"){
				alert(res.data);
			}else{
				$scope.verification_code=res.data;
				alert(res.data);
				if(res.data.code!=""){
					alert("验证码请求成功");
				}else{
					alert("验证码请求失败");
				}
			}
						
		});
	}

});