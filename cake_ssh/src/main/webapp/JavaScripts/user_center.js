var 
	user_address=[
			{aid:0,addressee:"ddd1",address:"s-h-i-hg-ig1",addressee_phone:"#",telephone:"#",addr_default:true,user_color:''}
		];
	exchang_array(user_address);

var user_older_form=[
		{oid: 0,info:"",price:"",num:"",pay:"",state:"#"}
	];

var use_cards=[
	{cid:0,name:"a",time:"a",code:"a",state:"#"}
	/*{card_name:"a1",card_time:"a",card_code:"a1",state:"unactive"},
	{card_name:"a2",card_time:"a",card_code:"a2",state:"use_card"},
	{card_name:"a3",card_time:"a",card_code:"a3",state:"used_card"},
	{card_name:"a4",card_time:"a",card_code:"a4",state:"past_card"},
	{card_name:"a5",card_time:"a",card_code:"a5",state:"unactive"},
	{card_name:"a6",card_time:"a",card_code:"a6",state:"use_card"},
	{card_name:"a7",card_time:"a",card_code:"a7",state:"used_card"},
	{card_name:"a8",card_time:"a",card_code:"a8",state:"past_card"}*/
];

var balance_now="100",
	out_in_record=[
		{time:"",out_in:"#",sum:"",form_num:""}
		/*{time:"a",out_in:"存入",sum:"",form_num:""},
		{time:"v",out_in:"取出",sum:"",form_num:""}*/
	];

angular.module('user_app', ['ngRoute'])
.filter('search_filter',function(){
	return function(items,filter_str){
		var arr=[];
		if(filter_str!=""){
			angular.forEach(items, function(item){
				if(item.older_info.indexOf(filter_str)>-1){
					arr.push(item);
				}
			});
		}else{
			arr=items;
		}
		return arr;		
	}
})
.filter('select_filter',function(){
	return function(items,string){
		var arr=[];
		if(string=="all"){
			return items;
		}
		angular.forEach(items, function(item){
			if(item.state==string){
				arr.push(item)
			}
		});
		return arr;
	}
})
.controller('CookieCtrl', function ($scope,$http) {
	if(document.cookie!=""){
		$scope.isCookie=true;
		$scope.user_cookie=document.cookie.split("=")[1];
	}else{
		$scope.isCookie=false;
	}

})
.controller('User_InfoCtrl', function ($scope,$http) {
	$scope.uid;
 	$scope.user_name;
 	$scope.user_phone;
 	$scope.user_mail;
 	$scope.user_password;
 	$scope.user_sex;
 	$scope.lunar;
 	$scope.year;
 	$scope.mouth;
 	$scope.day;
 	$scope.sex_man;
 	$scope.sex_woman
	$scope.cale=false;
	$scope.lunar=false;

	$scope.request_user_info=$http.get('http://192.168.1.109:8080/cake_ssh/user_getBasicInformation.action')
	.then(function(res){
		$scope.uid=res.data.uid;
		$scope.user_name=res.data.username;
		$scope.user_phone=res.data.phone;
		$scope.user_mail=res.data.email;
		$scope.user_password=res.data.password;
		$scope.user_sex=res.data.sex;
		$scope.isLunar=res.data.isLunar;
		$scope.user_birth=res.data.birth;
		$scope.sex_woman=false;
		$scope.sex_man=true;

		var birth=new Array();
		birth=$scope.user_birth.split("-");
		$scope.year=birth[0];
		$scope.mouth=birth[1];
		$scope.day=birth[2].split("T")[0];

		if($scope.user_sex==="男"){
			$scope.sex_man=true;
			$scope.sex_woman=false;
		}
		if($scope.user_sex==="女"){
			$scope.sex_woman=true;
			$scope.sex_man=false;
		}	 
		if($scope.isLunar===true){
			$scope.lunar=true;
			$scope.cale=false;
		}
		if($scope.isLunar===false){
			$scope.cale=true;
			$scope.lunar=false;
		}
			

	});
	 $scope.send_basicInfo=function(){

		if(document.getElementsByName("birth")[0].value){
			$scope.isLunar=true;
		}else{
			$scope.isLunar=false;
		}
		$scope.user_sex=document.getElementById("sexInp").checked?'男':'女';
		$scope.isLunar=document.getElementById("lunarInp").checked?true:false;
		
		alert($scope.sex_man);

		$http({
			url: "http://192.168.1.109:8080/cake_ssh/user_update.action",
			method: "GET",
			params: {
				uid: $scope.uid,
				username: $scope.user_name,
				phone: $scope.user_phone,
				email: $scope.user_mail,
				password: $scope.user_password,
				sex: $scope.user_sex,
				isLunar: $scope.isLunar,
				birth: $scope.year+"-"+$scope.mouth+"-"+$scope.day
			}
		});
	}

})
.controller('AddressCtrl', function ($scope,$http) {

	var name=document.getElementById("addressee"),
		sheng=document.getElementById("sheng"),
		shi=document.getElementById("shi"),
		qv=document.getElementById("qu"),
		detail=document.getElementById("detail_addr"),
		postalcode=document.getElementById("postalcode"),
		phone1=document.getElementById("phone1"),
		phone2=document.getElementById("phone2"),
		addr_phone=0,
		default_addr=document.getElementById("def_addr");

	$scope.user_address;
	$scope.new_addr;

	$scope.request=$http.get("http://192.168.1.109:8080/cake_ssh/address_getAddressInformation.action")
	.then(function(res){
		$scope.user_address=res.data;
		if($scope.user_address==""){
			$scope.user_address=user_address;
			$scope.addr_null=true;
			$scope.u_d=false;
		}else{
			$scope.addr_null=false;
			$scope.u_d=true;
		}
	});

	$scope.u_d=true;
	$scope.edit=false;
	$scope.add=function(){
		$scope.u_d=!$scope.u_d;
		name.value="";sheng.value="";shi.value="";qv.value="";detail.value="";postalcode.value="";phone1.value="";phone2.value="";addr_phone=0;default_addr.checked="";
		$scope.edit=false;
		if($scope.user_address[0].addressee_phone=="#"){
			$scope.edit=true;
		}
	}

	$scope.save_addr=function(){

		if(name.value==""){
			alert("收件人不能为空");
			return;
		}else{
			if(sheng.value==""||shi.value==""||qv.value==""||detail.value==""||postalcode.value==""){
				alert("请填写完整地址信息");
				return;
			}else{
				if(phone1.value==""&&phone2.value==""){
					alert("手机号及座机号至少填写一个");
					return;
				}else{
					if(phone1.value!=""){
						if(!/^1[3|4|5|7|8]\d{9}$/.test(phone1.value)){
							alert("手机号输入错误，请重新输入！");
							return;
						}
					}

					//addr_phone=(phone1.value=="")?phone2.value:phone1.value;
										
				}
			}
		}

		if(!$scope.addr_null){
			if(!!default_addr.checked){
				for(var i=0;i<$scope.user_address.length;i++){
					$scope.user_address[i].user_color='';
					$scope.user_address[i].addr_default=false;
				}
			}
		}

		if(!!!$scope.edit){
			$scope.new_addr={
				aid:null,
				addressee:name.value,
				address:sheng.value+"-"+shi.value+"-"+qv.value+"-"+detail.value+"-"+postalcode.value,
				addressee_phone:phone1.value,
				telephone:phone2.value,
				addr_default:(!!default_addr.checked),
				user_color:(!!default_addr.checked)?'#a00':''
			}
			$scope.user_address.push($scope.new_addr);
		}else{
			$scope.user_address[$scope.edit-1].aid=$scope.user_address[$scope.edit-1].aid;
			$scope.user_address[$scope.edit-1].addressee=name.value;
			$scope.user_address[$scope.edit-1].address=sheng.value+"-"+shi.value+"-"+qv.value+"-"+detail.value+"-"+postalcode.value;
			$scope.user_address[$scope.edit-1].addressee_phone=phone1.value;
			$scope.user_address[$scope.edit-1].telephone=phone2.value;
			$scope.user_address[$scope.edit-1].addr_default=(!!default_addr.checked);
			$scope.user_address[$scope.edit-1].user_color=(!!default_addr.checked)?'#a00':'';
			$scope.edit=false;
		}

		$scope.add_arr=$scope.new_addr==null?$scope.user_address[$scope.edit-1]:$scope.new_addr;

		$http({
			url: "http://192.168.1.109:8080/cake_ssh/address_add.action",
			method: "GET",
			params: $scope.add_arr
		})
		.then(function(res){
			alert(res.data);
		});
		

		exchang_array($scope.user_address);

		if($scope.addr_null){
			$scope.addr_null=!$scope.addr_null;
		}

		name.value="";sheng.value="";shi.value="";qv.value="";detail.value="";postalcode.value="";phone1.value="";phone2.value="";addr_phone=0;default_addr.checked="";
	}

	$scope.set_default=function(index){
		
		if ($scope.user_address[index].addr_default) {
			$scope.user_address[index].user_color='';
			$scope.user_address[index].addr_default=false;
		}else{
			for(var i=0;i<$scope.user_address.length;i++){
				$scope.user_address[i].user_color='';
				$scope.user_address[i].addr_default=false;
			}
			$scope.user_address[index].user_color='#a00';
			$scope.user_address[index].addr_default=true;
			exchang_array($scope.user_address);
		}

		$http({
			url: "http://192.168.1.109:8080/cake_ssh/address_add.action",
			method: "GET",
			params: {aid:$scope.user_address[index].aid}
		})
		.then(function(res){
			alert(res.data);
		});
	}

	$scope.delete_addr=function(index){
		$http({
			url: "http://192.168.1.109:8080/cake_ssh/address_delete.action",
			method: "GET",
			params: {aid:$scope.user_address[index].aid}
		})
		.then(function(res){
			alert(res.data);
		});
		$scope.user_address.splice(index,1);
		if($scope.user_address==""){
			$scope.addr_null=true;
		}

	}

	$scope.edit_addr=function(index){
		$scope.u_d=false;
		if(!$scope.u_d){
		
			name.value="";sheng.value="";shi.value="";qv.value="";detail.value="";postalcode.value="";phone1.value="";phone2.value="";addr_phone=0;default_addr.checked="";
			arr=$scope.user_address[index].address.split("-");

			name.value=$scope.user_address[index].addressee;
			sheng.value=arr[0];
			shi.value=arr[1];
			qv.value=arr[2];
			detail.value=arr[3];
			postalcode.value=arr[4];
			if(/^1[3|4|5|7|8]\d{9}$/.test($scope.user_address[index].addressee_phone)){
				phone1.value=$scope.user_address[index].addressee_phone;
			}else{
				phone2.value=$scope.user_address[index].addressee_phone;
			}
			if($scope.user_address[index].addr_default){
				default_addr.checked=true;
			}else{
				default_addr.checked="";
			}

			$scope.edit=index+1;
		}
	}

})
.controller('User_FormCtrl',function ($scope,$http) {
	$scope.user_older_form;
	$scope.finish_num=0;
	$scope.payment_num=0;
	$scope.receipt_num=0;
	$scope.evaluation_num=0;
	$scope.search_str="";
	$scope.border_color_all="#600";
	$scope.border_color_finish="#eee";
	$scope.border_color_receipt="#eee";
	$scope.border_color_payment="#eee";
	$scope.border_color_evalution="#eee";
	$scope.filter_select="all";

	$http.get("http://192.168.1.109:8080/cake_ssh/orderForGoods_getOrderForGoodsInformation.action")
	.then(function(res){
		$scope.user_older_form=res.data;
		if($scope.user_older_form[0].state!="#"){		
			$scope.finish_num=0;
			$scope.payment_num=0;
			$scope.receipt_num=0;
			$scope.evaluation_num=0;
			for(var i=0;i<$scope.user_older_form.length;i++){
				switch($scope.user_older_form[i].state){
					case "finish":
						$scope.finish_num++;
						break;
					case "payment":
						$scope.payment_num++;
						break;
					case "receipt":
						$scope.receipt_num++;
						break;
					case "evaluation":
						$scope.evaluation_num++;
						break;
				}
			}
		}else{
			$scope.user_older_form=[];
		}
	});


	$scope.all=function(){
		$scope.border_color_all="#600";
		$scope.border_color_finish="#eee";
		$scope.border_color_receipt="#eee";
		$scope.border_color_payment="#eee";
		$scope.border_color_evalution="#eee";
		$scope.filter_select="all";
	}
	$scope.finish=function(){
		$scope.border_color_all="#eee";
		$scope.border_color_finish="#600";
		$scope.border_color_receipt="#eee";
		$scope.border_color_payment="#eee";
		$scope.border_color_evalution="#eee";
		$scope.filter_select="finish";
	}
	$scope.payment=function(){
		$scope.border_color_all="#eee";
		$scope.border_color_finish="#eee";
		$scope.border_color_receipt="#eee";
		$scope.border_color_payment="#600";
		$scope.border_color_evalution="#eee";
		$scope.filter_select="payment";
	}
	$scope.receipt=function(){
		$scope.border_color_all="#eee";
		$scope.border_color_finish="#eee";
		$scope.border_color_receipt="#600";
		$scope.border_color_payment="#eee";
		$scope.border_color_evalution="#eee";
		$scope.filter_select="receipt";
	}
	$scope.evaluation=function(){
		$scope.border_color_all="#eee";
		$scope.border_color_finish="#eee";
		$scope.border_color_receipt="#eee";
		$scope.border_color_payment="#eee";
		$scope.border_color_evalution="#600";
		$scope.filter_select="evaluation";
	}

	$scope.delete_form=function(index){		
		$scope.delete_id;
		if($scope.filter_select=="all"){
			switch($scope.user_older_form[index].state){
				case "finish":
					$scope.finish_num--;
					break;
				case "payment":
					$scope.payment_num--;
					break;
				case "receipt":
					$scope.receipt_num--;
					break;
				case "evaluation":
					$scope.evaluation_num--;
					break;
			}
			$scope.delete_id=$scope.user_older_form[index].oid;
			$scope.user_older_form.splice(index,1);	
		}else{
			var j=0;
			for(var k=0;k<$scope.user_older_form.length;k++){
				if($scope.user_older_form[k].state==$scope.filter_select){
					if(j==index){
						switch($scope.user_older_form[k].state){
							case "finish":
								$scope.finish_num--;
								break;
							case "payment":
								$scope.payment_num--;
								break;
							case "receipt":
								$scope.receipt_num--;
								break;
							case "evaluation":
								$scope.evaluation_num--;
								break;
						}
						$scope.delete_id=$scope.user_older_form[k].oid;
						$scope.user_older_form.splice(k,1);
						return;
					}else{
						j++;
					}
				}
			}
		}
		
		$http({
			url: "http://192.168.1.109:8080/cake_ssh/orderForGoods_delete.action",
			method: "GET",
			params: {oid: $scope.delete_id}
		}).then(function(res){
			alert(res.data);
		});
	}

})
.controller('BalanceCtrl',function ($scope,$http) {
	$scope.balance_now;
	$scope.out_in_record;

	$http.get("http://192.168.1.109:8080/cake_ssh/user_getBasicInformation.action")
	.then(function(res){
		$scope.balance_now=res.data.balance;
	});

	$http.get("http://192.168.1.109:8080/cake_ssh/tradeRecord_getTradeRecordInformation.action")
	.then(function(res){
		$scope.out_in_record=res.data;

		if($scope.out_in_record[0].out_in!="#"){
			//$scope.out_in_record=out_in_record;
		}else{
			$scope.out_in_record=[];
		}
	});
})
.controller('Card_BagCtrl',function ($scope,$http) {
	$scope.use_cards;
	$scope.delete_cid;

	$http.get("http://192.168.1.109:8080/cake_ssh/card_getCardInformation.action")
	.then(function(res){
		$scope.use_cards=res.data;

		if($scope.use_cards[0].state=="#"){
			$scope.use_cards=[];
		}
	});/*else{
		$scope.use_cards=use_cards;
	}*/

	$scope.border_color_all="#600";
	$scope.border_color_unactive="#eee";
	$scope.border_color_use="#eee";
	$scope.border_color_used="#eee";
	$scope.border_color_past="#eee";

	$scope.select_state="all";

	$scope.all_card=function(){
		$scope.select_state="all";	
		$scope.border_color_all="#600";
		$scope.border_color_unactive="#eee";
		$scope.border_color_use="#eee";
		$scope.border_color_used="#eee";
		$scope.border_color_past="#eee";
	}
	$scope.unactive=function(){
		$scope.select_state="unactive";	
		$scope.border_color_all="#eee";
		$scope.border_color_unactive="#600";
		$scope.border_color_use="#eee";
		$scope.border_color_used="#eee";
		$scope.border_color_past="#eee";
	}
	$scope.use_card=function(){
		$scope.select_state="use_card";	
		$scope.border_color_all="#eee";
		$scope.border_color_unactive="#eee";
		$scope.border_color_use="#600";
		$scope.border_color_used="#eee";
		$scope.border_color_past="#eee";
	}
	$scope.used_card=function(){
		$scope.select_state="used_card";	
		$scope.border_color_all="#eee";
		$scope.border_color_unactive="#eee";
		$scope.border_color_use="#eee";
		$scope.border_color_used="#600";
		$scope.border_color_past="#eee";
	}
	$scope.past_card=function(){
		$scope.select_state="past_card";	
		$scope.border_color_all="#eee";
		$scope.border_color_unactive="#eee";
		$scope.border_color_use="#eee";
		$scope.border_color_used="#eee";
		$scope.border_color_past="#600";
	}

	$scope.delete_card=function(index){
		if($scope.select_state=="all"){
			$scope.delete_cid=$scope.use_cards[index].cid;
			$scope.use_cards.splice(index,1);
		}else{
			var j=0;
			for(var i=0;i<$scope.use_cards.length;i++){
				if($scope.use_cards[i].state==$scope.select_state){
					if(j==index){						
						$scope.delete_cid=$scope.use_cards[i].cid;
						$scope.use_cards.splice(i,1);
					}else{
						j++;
					}
				}
			}
		}

		$http({
			url: "http://192.168.1.109:8080/cake_ssh/card_delete.action",
			method: "GET",
			params: {cid: $scope.delete_cid}
		}).then(function(res){
			alert(res.data)
		});
	}

	$scope.activible_card=function(){
		var str_num=document.getElementById("card_num");

		for(var i=0;i<$scope.use_cards.length;i++){
			if($scope.use_cards[i].code==str_num.value){
				if($scope.use_cards[i].state!="past_card"&&$scope.use_cards[i].state!="used_card"){					
					$http({
						url: "http://192.168.1.109:8080/cake_ssh/card_update.action",
						method: "GET",
						params: {
							cid:$scope.use_cards[i].cid,
							state:$scope.use_cards[i].state
						}
					}).then(function(res){
						if(res.data="激活成功"){
							$scope.use_cards[i].state="use_card";
							alert("该优惠券激活成功");
						}else{
							alert("激活失败");
						}					
					});
					str_num.value="";
				}else{
					if($scope.use_cards[i].state=="past_card"){
						alert("该优惠券已过期");
					}
					if($scope.use_cards[i].state=="used_card"){
						alert("该优惠券已经被使用");
					}
				}
				return;
			}
		}
		alert("该激活码不存在");
	}
})
.config(function ($routeProvider,$locationProvider) {
	$locationProvider.hashPrefix('');

	$routeProvider
	.when('/user_info', {
		templateUrl: 'user_info.html',
		controller: 'User_InfoCtrl'
	})
	.when('/address', {
		templateUrl: 'address.html',
		controller: 'AddressCtrl'
	})
	.when('/user_form', {
		templateUrl: 'user_form.html',
		controller: 'User_FormCtrl'
	})
	.when('/balance', {
		templateUrl: 'balance.html',
		controller: 'BalanceCtrl'
	})
	.when('/card_bag', {
		templateUrl: 'card_bag.html',
		controller: 'Card_BagCtrl'
	})
	/*.otherwise({ redirectTo: '/user_info' })*/;
});

function exchang_array(my_arr){
	if(my_arr){
		var j=0,arr;
		for(var i=0;i<my_arr.length;i++){
			if(my_arr[i].user_color=='#a00'){
				j=i;
				break;
			}
		}
		arr=my_arr[0];
		my_arr[0]=my_arr[j];
		my_arr[j]=arr;
	}
}