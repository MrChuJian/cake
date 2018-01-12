var left_can=document.getElementById("leftCan");
var right_can=document.getElementById("rightCan");
var y1=document.getElementById("y1");
var y2=document.getElementById("y2");
var y3=document.getElementById("y3");
if(left_can.getContext){
	var leftc=left_can.getContext("2d");
	var rightc=right_can.getContext("2d");
	leftc.beginPath();
	leftc.fillStyle="#000";
	leftc.lineWidth=2;
	leftc.moveTo(5,25);
	leftc.lineTo(45,5);
	leftc.moveTo(5,25);
	leftc.lineTo(45,45);
	leftc.stroke();
	rightc.beginPath();
	rightc.fillStyle="#000";
	rightc.lineWidth=2;
	rightc.moveTo(45,25);
	rightc.lineTo(5,5);
	rightc.moveTo(45,25);
	rightc.lineTo(5,45);
	rightc.stroke();
}
$("#myCarousel").carousel('cycle');
angular.module('app', ['ngRoute','ngAnimate'])
.controller('CookieCtrl', function ($scope,$http) {
	if(document.cookie!=""){
		$scope.isCookie=true;
		$scope.user_cookie=document.cookie.split("=")[1];
	}else{
		$scope.isCookie=false;
	}
})
.controller('ItemCtrl', function ($scope,$location,$anchorScroll,$http) {
	$scope.one_cake=true;
	$scope.two_cake=true;
	$scope.three_cake=true;
	$scope.one_snack=true;
	$scope.two_snack=true;
	$scope.three_snack=true;
	
	$scope.chang=function(){
		$location.hash('lingshi');
		$anchorScroll();

	}

	$http.get('')
	.then(function(res){
		$scope.cakes=res.data;
	});
	
})
.controller('All_CakeCtrl', function ($scope) {
	$scope.$parent.one_cake=true;
	$scope.$parent.two_cake=true;
	$scope.$parent.three_cake=true;
})
.controller('One_CakeCCtrl', function ($scope) {
	$scope.$parent.one_cake=true;
	$scope.$parent.two_cake=false;
	$scope.$parent.three_cake=false;
})
.controller('Two_CakeCCtrl', function ($scope) {
	$scope.$parent.one_cake=false;
	$scope.$parent.two_cake=true;
	$scope.$parent.three_cake=false;
})
.controller('Three_CakeCCtrl', function ($scope,$route) {
	$scope.$route=$route;
	$scope.$parent.one_cake=false;
	$scope.$parent.two_cake=false;
	$scope.$parent.three_cake=true;
})
.config(function ($routeProvider,$locationProvider) {
	$locationProvider.hashPrefix('');

	$routeProvider
	.when('/all_cake', {
		template: 'all_cake.html',
		controller: 'All_CakeCtrl'
	})
	.when('/one_cake', {
		template: 'one_cake.html',
		controller: 'One_CakeCCtrl'
	})
	.when('/two_cake', {
		template: 'two_cake.html',
		controller: 'Two_CakeCCtrl'
	})
	.when('/three_cake', {
		template: 'three_cake.html',
		controller: 'Three_CakeCCtrl'
	});

});