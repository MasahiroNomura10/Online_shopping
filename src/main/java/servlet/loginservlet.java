package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.TopDAO;
import model.hash.hash;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginservlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		ユーザーネームとパスワードを受け取り、変数に入れちゃう。
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		hash h = new hash();
		h.hash(password);
//		password=//ハッシュ化されたパスワードにする必要がある？
//		ブーリアンで認証結果出せるようにする。
		boolean i =false;
		try {
//			DAOのユーザー認証メソッド発動
			i=TopDAO.userSearch(userName, password);
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
//		ブーリアンがtrueならユーザーにセッションを付与し商品一覧に遷移する。
		if(i) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			RequestDispatcher rd = request.getRequestDispatcher("itemDisplayServlet");
			rd.forward(request, response);
			
//			そのままTOPページに残る
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("loginFailure.jsp");
			rd.forward(request, response);
		}
		
	}

}
