angular.module('my_app', [])
.controller('numCtrl', function ($scope,$http) {
	$scope.cid;
	$scope.cake_num_value=1;
	$scope.sel_color="#fff";
	$scope.red=function(){
		if($scope.cake_num_value!=1){
			$scope.cake_num_value--;
		}else{
			$scope.cake_num_value=1;
		}
	};
	$scope.add=function(){
		if($scope.cake_num_value<50){
			$scope.cake_num_value++;
		}else{
			$scope.cake_num_value=50;
		}
	};
	$scope.sel=function(){
		if($scope.sel_color=="#600"){
			$scope.sel_color="#fff";
		}else{
			$scope.sel_color="#600";
		}
	};
	//加入购物车
	$scope.add_car=function(){
		$http({
			url:'http://192.168.1.109:8080/cake_ssh/cake_addToShopCar.action',
			method:'get',
			params:{
				cid:$scope.cid
			}
		});
	}
	//立即购买
	$scope.buy=function(){}
});