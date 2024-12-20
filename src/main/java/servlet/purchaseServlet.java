package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.itemDAO;
import model.entity.ItemBean;


/**
 * Servlet implementation class purchaseServlet
 */
@WebServlet("/purchaseServlet")
public class purchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public purchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");
		
		//ユーザーデータ用
		HttpSession session = request.getSession();

        String userName = (String) session.getAttribute("userName");
        if (userName == null) {
//        	RequestDispatcher rd = request.getRequestDispatcher("amazon.co.jp");
//            rd.forward(request, response);
        	response.sendRedirect("https://www.amazon.co.jp/");
        } else {
		//購入するアイテムリストのクラスを受け取る
		List<ItemBean> cartList = ( List<ItemBean> )session.getAttribute("cartList");

		//購入判定用
		itemDAO itemDao = new itemDAO();
		
		try {
			//購入判定する
			if( itemDao.purchase( cartList, session ) ) {
				//成功
				RequestDispatcher rd = request.getRequestDispatcher("purchaseDecision.jsp");
				rd.forward(request, response);
			}else {
				//失敗
				request.setAttribute("errormessage", "購入残高が足りておりません。");
				RequestDispatcher rd = request.getRequestDispatcher("purchaseFailure.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        }

		
	}

}
