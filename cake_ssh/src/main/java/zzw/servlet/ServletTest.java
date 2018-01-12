package zzw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  
*   
* <p>项目名称：	cake_ssh	</p>
* <p>类名称：	ServletTest	</p>
* <p>类描述：   					</p>
* @author	zzw  
* @date		2017年10月28日 下午9:34:02 
* @version  JDK1.8
*/

public class ServletTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
	}
}
