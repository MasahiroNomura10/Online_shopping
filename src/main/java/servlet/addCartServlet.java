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
		
		//リストをリクエストスコープに設定
		HttpSession session = request.getSession();
		List<ItemBean> cartList = (List<ItemBean>) session.getAttribute("cartList");
		if (cartList == null) {
			cartList = new ArrayList<>(); //初回アクセス時にからのリストを作成
			
		}
		
		try {
			//DAOを使って情報を取得
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			itemDAO dao = new itemDAO();
			List<ItemBean> newItems = dao.cartAdd(itemId, amount);
			
			
			//取得したアイテムを既存カートリストに追加
			if (!newItems.isEmpty()) {
				ItemBean newItem = newItems.get(0);
				boolean itemExists = false;
				
				//すでに同じカートに同じアイテムがある場合は購入数を更新
				for (ItemBean item : cartList) {
					if (item.getItemId() == newItem.getItemId()) {
						item.setAmount(item.getAmount() + newItem.getAmount());
						itemExists = true;
						break;
					}
				}
				
				//新しいアイテムの場合はリストに追加
				if (!itemExists) {
					cartList.add(newItem);
				}
			}
			} catch (SQLException | ClassNotFoundException | NumberFormatException e) {
				e.printStackTrace();
			}
			
			//カートリストをセッションに保存
			session.setAttribute("cartList", cartList);
			System.out.println(cartList);
			
			//商品一覧画面にリダイレクト
			RequestDispatcher rd = request.getRequestDispatcher("/itemList.jsp");
			rd.forward(request, response);
	}
	

		
//			System.out.println("買うもの" + itemId + amount);
//			cartList = dao.cartAdd(itemId, amount);
//			System.out.println("アイテムリストを表示" + itemList);
//		} catch (SQLException | ClassNotFoundException e) {
//				e.printStackTrace();
//		}
//		
//		//リストをリクエストスコープに設定
//		HttpSession session = request.getSession();
//		session.setAttribute("cartList",cartList);
		
	
}