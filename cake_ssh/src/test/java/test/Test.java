package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import zzw.entity.User;

public class Test {
	private static List<User> list = new LinkedList<>();
	private static Set<Integer> set = new HashSet<>();
	private static Map<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		User user = new User();
		String json;
		JsonConfig jsonConfig = new JsonConfig();
//				解决自循环
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONObject jsonObject = JSONObject.fromObject(list,jsonConfig);
		json = jsonObject.toString();
		System.out.println(json);
	}
	
}
