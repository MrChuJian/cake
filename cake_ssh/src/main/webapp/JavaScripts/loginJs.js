angular.module('app',['ngRoute'])
.controller('ParentCtrl', ['$scope', function ($scope) {

	$scope.nomalDiv=document.getElementById("nomal");
	$scope.flashDiv=document.getElementById("flash");
	$scope.loginbtn_show=true;
	//alert(window.location.href);

	if(window.location.href.indexOf("error")>0){
		$scope.errorInfo=true;
	}else{
		$scope.errorInfo=false;
	}


}])
.controller('NomalCtrl', function ($scope, $route) {
	$scope.$route = $route;
	$scope.$parent.nomalDiv.setAttribute("style","background-color: #da4f49;color:#fff;");
	$scope.$parent.flashDiv.setAttribute("style","background-color: #fff;");
	$scope.$parent.loginbtn_show=true;

	$scope.phone_inp=document.getElementById("user");
	phoneCheck($scope.phone_inp);
	
})
.controller('FlashCtrl', function ($scope, $http, $route) {
	$scope.$route = $route;
	$scope.$parent.flashDiv.setAttribute("style","background-color: #da4f49;color:#fff;");
	$scope.$parent.nomalDiv.setAttribute("style","background-color: #fff;");
	$scope.$parent.loginbtn_show=true;
	$scope.phone_num;
	$scope.verification_code;
	$scope.ver_num;

	document.getElementById("get_code").onclick=function(){
		$http({
			url: "http://192.168.1.109:8080/cake_ssh/user_getLoginVerificationCode.action",
			method: "GET",
			params: {
				phone: $scope.phone_num
			}
		}).then(function(res){
			$scope.verification_code=res.data;
			alert(res.data);
			if(res.data.code!=""){
				alert("验证码请求成功");
			}else{
				alert("验证码请求失败");
			}			
		});
	}

	$scope.toVer=function(){
		if($scope.ver_num==$scope.verification_code){
			document.getElementById("login_form").submit();
			return true;
		}else{
			alert("验证码输入错误");
			return;
		}
	}

	$scope.phone_inp=document.getElementById("phone_num");
	phoneCheck($scope.phone_inp);
	
})
.controller('WeixinCtrl', ['$scope', function ($scope,$route) {
	$scope.$route=$route;
	$scope.$parent.nomalDiv.setAttribute("style","background-color: #fff;");
	$scope.$parent.flashDiv.setAttribute("style","background-color: #fff;");
	$scope.$parent.loginbtn_show=false;
}])
.config(function ($routeProvider,$locationProvider) {

	$locationProvider.hashPrefix('');

	$routeProvider
	.when('/nomal', {
		templateUrl: 'embedded.nomal.html',
		controller: 'NomalCtrl'
	})
	.when('/flash', {
		templateUrl: 'embedded.flash.html',
		controller: 'FlashCtrl'
	})
	.when('/weixin', {
		templateUrl: 'weixin.html',
		controller: 'WeixinCtrl'
	})
	.otherwise({ redirectTo: '/nomal' });
});

function phoneCheck(phoneinp){
	phoneinp.onblur=function(){
		phoneinp.setAttribute("style","border:solid 1px #ccc;");
		if(phoneinp.value!=""){
			if(!/^1[3|4|5|7|8]\d{9}$/.test(phoneinp.value)){
				alert("手机号输入错误，请重新输入！");
			}else{
				phoneinp.setAttribute("style","border:solid 1px #008000;");
			}
		}
	}
}