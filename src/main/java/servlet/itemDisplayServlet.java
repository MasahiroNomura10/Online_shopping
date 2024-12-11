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

import model.DAO.itemDAO;
import model.entity.ItemBean;

/**
 * Servlet implementation class itemDisplayServlet
 */
@WebServlet("/itemDisplayServlet")
public class itemDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public itemDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");
		
		List<ItemBean> itemList = null;
		
		//DAOのインスタンスを生成
		itemDAO dao = new itemDAO();
		
		try {
			//DAOを使って情報を取得
			itemList = dao.selectAllItems();
		} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
		}
		
		//リストをリクエストスコープに設定
		request.setAttribute("itemList",itemList);
		
		//ページにリクエストを送信
		RequestDispatcher rd = request.getRequestDispatcher("buy.jsp");
		rd.forward(request, response);
	}

}
