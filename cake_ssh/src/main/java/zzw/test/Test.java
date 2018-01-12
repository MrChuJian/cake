package zzw.test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import zzw.entity.User;

/**  
*   
* <p>项目名称：	cake_ssh	</p>
* <p>类名称：	Test	</p>
* <p>类描述：   					</p>
* @author	zzw  
* @date		2017年11月28日 下午3:29:58 
* @version  JDK1.8
*/

public class Test {

	public static void main(String[] args) {
		Map<String, String[]> map = new HashMap<>();
		String[] strs = {"er"};
//		map.put("yi", strs);
//		map.put("si", strs);
//		Map<String, String> map = new HashMap<>();
		map.put("username", strs);
		map.put("password", strs);
		System.out.println(map);
		User user = new User();
		try {
			BeanUtils.copyProperties(user, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(user);
	}
}
