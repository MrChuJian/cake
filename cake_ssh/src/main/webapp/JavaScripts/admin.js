var myfileReader=new FileReader;
document.getElementById("selectImg").onchange=function(){
	document.getElementById("imgDiv").innerHTML="";
	for(var i=0;i<this.files.length;i++){
		var img=document.createElement("img");
		img.src=window.URL.createObjectURL(this.files[i]);
		document.getElementById("imgDiv").appendChild(img);
	}	
}

angular.module('app', [])
.controller('SeriesCtrl', function ($scope,$http) {
	$http.get("http://192.168.1.109:8080/cake_ssh/variety_findAll.action").then(function(res){
		$scope.SelectSeries=[];
		for(var k=0;k<res.data.length;k++){
			$scope.SelectSeries.push(res.data[k].variety);
		}		
	});
});