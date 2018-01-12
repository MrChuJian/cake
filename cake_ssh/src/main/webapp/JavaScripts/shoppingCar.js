angular.module('app', [])
.controller('CookieCtrl', function ($scope,$http) {
	if(document.cookie!=""){
		$scope.isCookie=true;
		$scope.user_cookie=document.cookie.split("=")[1];
	}else{
		$scope.isCookie=false;
	}

})
.controller('ItemCtrl', function ($scope,$rootScope,$http) {
	$scope.carItem;$scope
	$scope.itemNum=1;
	$scope.allMoney=0;
	$scope.carNull=false;
	$scope.kk;
	$scope.itemInpArr=new Array();
	$scope.sweetnessArr=new Array();

	$http.get("http://192.168.1.109:8080/cake_ssh/shopCar_findAll.action")
	.then(function(res){
		$scope.carItem=res.data;

		if($scope.carItem==""){
			$scope.carNull=true;
		}

		for(var i=0;i<$scope.carItem.length;i++){
			$scope.itemInpArr.push("itemInp"+i);
			$scope.sweetnessArr.push(new Array($scope.carItem[i].cake.sweetness));
			(function(k){
				$scope.$watch('carItem['+k+'].num', function(newValue, oldValue, scope) {
					if(newValue<1||newValue==null){
						$scope.carItem[k].num=1;
					}
					if(newValue>50){
						$scope.carItem[k].num=50;
					}
					$scope.carItem[k].totalFee=$scope.carItem[k].price*$scope.carItem[k].num;
				},true);
				})(i);
			(function(k){
				$scope.$watch('carItem['+k+'].totalFee', function(newValue, oldValue, scope) {
					if(document.getElementById("itemInp"+k).checked){
						$scope.allMoney=$scope.allMoney-oldValue+newValue;
					}
				}, true);
			})(i);
		}
	});

	$scope.selectAll=function(){
		$scope.allInp=document.getElementById("allInp").checked;

		for(var k=0;k<$scope.itemInpArr.length;k++){
			if(document.getElementById($scope.itemInpArr[k]).checked!=$scope.allInp){
				document.getElementById($scope.itemInpArr[k]).click();
			}			
		}
		
	}

	$scope.selectChang=function(index){
		$scope.itemInp=document.getElementById("itemInp"+index);

		if($scope.itemInp.checked){
			$scope.allMoney=$scope.allMoney+$scope.carItem[index].totalFee;
		}else{
			$scope.allMoney=$scope.allMoney-$scope.carItem[index].totalFee;
		}

	}	

		 

	$scope.upNum=function(index){
		if($scope.carItem[index].num<50){
			$scope.carItem[index].num++;
		}else{
			$scope.carItem[index].num=50;
		}
	}
	$scope.downNum=function(index){
		if($scope.carItem[index].num>1){
			$scope.carItem[index].num--;
		}else{
			$scope.carItem[index].num=1;
		}
	}

	$scope.delete=function(index){	

		$http({
			url:"http://192.168.1.109:8080/cake_ssh/shopCar_delete.action",
			method: "GET",
			params:{
				scid:$scope.carItem[index].scid
			}
		});
		$scope.carItem.splice(index,1);
		
		if($scope.carItem==""){
			$scope.carNull=true;
		}
	}

	$scope.deleteSelect=function(){
		var delArr=[];

		for(var i=0;i<$scope.carItem.length;i++){
			if(document.getElementById("itemInp"+i).checked){
				delArr.push($scope.carItem[i].scid);
			}
		}

		$http({
			url:'http://192.168.1.109:8080/cake_ssh/shopCar_delete.action',
			method:'get',
			params:{
				scid:delArr
			}
		}).then(function(res){
			if(res.data=="100"){
				location.reload(true);
				if($scope.carItem==""){
					$scope.carNull=true;
				}
			}
		});
	}

	$scope.doAccount=function(){
		//结算
	}
});
