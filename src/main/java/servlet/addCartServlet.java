package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * Servlet implementation class addCartServlet
 */
@WebServlet("/add-cart-servlet")
public class addCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		List<ItemBean> cartList = new ArrayList<>();
		
		itemDAO dao = new itemDAO();
		
		try {
			//DAOを使って情報を取得
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			System.out.println("取り急ぎ" + itemId + amount);
			cartList = dao.cartAdd(itemId, amount);
//			System.out.println("アイテムリストを表示" + itemList);
		} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
		}
		
		//リストをリクエストスコープに設定
		HttpSession session = request.getSession();
		session.setAttribute("cartList",cartList);
		
	RequestDispatcher rd = request.getRequestDispatcher("/itemList.jsp");
	rd.forward(request, response);
	}
}
