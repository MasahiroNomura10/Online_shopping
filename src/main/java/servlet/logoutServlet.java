package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logoutServlet
 */
@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
    	
    	request.setCharacterEncoding("UTF-8"); //リクエストの文字エンコーディングをUTF-8に設定
    	response.setContentType("text/html; charset=UTF-8"); //レスポンスの文字エンコーディングをUTF-８に設定
    	
    	HttpSession session = request.getSession(false);
    	
    	if (session != null) {
    		//セッションを無効化
    		session.invalidate();
    	}
    	
    	RequestDispatcher rd = request.getRequestDispatcher("top.jsp");
		rd.forward(request, response);
	}

}
