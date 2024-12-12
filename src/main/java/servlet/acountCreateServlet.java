package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.TopDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class acountCreateServlet
 */
@WebServlet("/acountCreateServlet")
public class acountCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acountCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
//		ここでの変数をjspファイルで書かれた内容を使って作る。
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String mailAddres = request.getParameter("mailAddres");
		int money = Integer.parseInt(request.getParameter("money"));
		
//		USEBEANを使って、手に入れた内容をbeanに送り込む。
		UserBean user = new UserBean();
		user.setUserName(userName);
		user.setPassword(password);
		user.setMailAddres(mailAddres);
		user.setMoney(money);
		
//		DAOのメソッドを使うためインスタンス？する。
		TopDAO dao = new TopDAO();
		boolean result = false;
//		boolean result2 = false;
		try {
//			アカウント情報取得メソッド発動
			dao.getAllUser();
//			アカウント作成メソッド発動。
//			result2=dao.acountSearch(userName);
			result=dao.acountCreate(user);
			
//			if(result2) {
//				request.setAttribute("errormessage","このユーザー名はすでに使用されています。");
//				RequestDispatcher rd = request.getRequestDispatcher("acountCreateFailure.jsp");
//				rd.forward(request, response);
//			}else {
//				エラーが起きたらエラーページに行くように条件分岐させる。
//				}
			if(result) {
				request.setAttribute("user",user );
				RequestDispatcher rd = request.getRequestDispatcher("entry.jsp");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("acountCreateFailure.jsp");
				rd.forward(request, response);
			}
		}catch(ClassNotFoundException | SQLException e ) {
			request.setAttribute("errormessage","このユーザー名はすでに使用されています。");
			RequestDispatcher rd = request.getRequestDispatcher("acountCreateFailure.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}
}

