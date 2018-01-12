try{
	alert("");
var scroll_demo=document.getElementById("scroll_div");
setInterval(function(){
	scroll_demo.scrollLeft=scroll_demo.scrollLeft-400;
},500);}catch(e){
	alert(e.message);
}