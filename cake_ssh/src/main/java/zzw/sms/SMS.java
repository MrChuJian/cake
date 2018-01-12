package zzw.sms;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SMS {
	String result;
	HttpClient client = new HttpClient();
	public void sendSMS(String phone , int code) {
		PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		NameValuePair[] data ={ 
				new NameValuePair("Uid", "zzw15766387390"),
				new NameValuePair("Key", "71483cd977faa8048872"),
				new NameValuePair("smsMob",phone), 
				new NameValuePair("smsText","验证码：" + code)};
		post.setRequestBody(data);
		try {
			client.executeMethod(post);
			Header[] headers = post.getResponseHeaders();
			int statusCode = post.getStatusCode();
			System.out.println("statusCode:"+statusCode);
			for(Header h : headers) {
				System.out.println(h.toString());
			}
			result = new String(post.getResponseBodyAsString().getBytes("gbk"));
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		post.releaseConnection();
	}
}
