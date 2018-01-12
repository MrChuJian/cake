package zzw.po;

/**  
*   
* <p>项目名称：	cake_ssh	</p>
* <p>类名称：	Test	</p>
* <p>类描述：   					</p>
* @author	zzw  
* @date		2017年10月19日 下午4:06:27 
* @version  JDK1.8
*/

public class Test {

	public static void main(String[] args) {
		String s1 = "Programming";
        String s2 = reverse(s1);
        System.out.println(s2);

	}
	public static void change(String str) {
		str = new String("123");
	}
	
	public static String reverse(String originStr) {
	      if(originStr == null || originStr.length() <= 1) 
	          return originStr;
	      return reverse(originStr.substring(1)) + originStr.charAt(0);
	  }

}
