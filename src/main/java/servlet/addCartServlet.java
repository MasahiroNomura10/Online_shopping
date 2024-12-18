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
 
@WebServlet("/add-cart-servlet")
public class addCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public addCartServlet() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
 
        // リストをリクエストスコープに設定
        HttpSession session = request.getSession();
        List<ItemBean> cartList = (List<ItemBean>) session.getAttribute("cartList");
        if (cartList == null) {
            cartList = new ArrayList<>(); // 初回アクセス時に空のリストを作成
        }
        //商品IDと数量を取得
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        System.out.println("idやで" + itemId + "am" + amount);
        itemDAO dao = new itemDAO();
        //商品情報を取得
        try {
        	cartList.add(dao.cartAdd(itemId, amount));
			System.out.println("cart" + cartList);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

        //セッションにカート情報を保存

//        try {
//            // 複数のitemIdとamountをリクエストパラメータから取得
//            String[] itemIdStrings = request.getParameterValues("itemId");
//            String[] amountStrings = request.getParameterValues("amount");
//            System.out.println("Item IDs: " + Arrays.toString(itemIdStrings));
//            System.out.println("Amounts" + Arrays.toString(amountStrings));
//            
//
//            // itemIdの配列をリストに変換
//            if (itemIdStrings != null && amountStrings != null) {
//            	// それぞれをList<Integer>に変換
//                List<Integer> itemIds = new ArrayList<>();
//                List<Integer> amounts = new ArrayList<>();
//                
//                for (int i = 0; i < itemIdStrings.length; i++) {
//                	int amount = Integer.parseInt(amountStrings[i]);
//                	if (amount > 0) { //購入数が０より大きいもののみ追加
//                		itemIds.add(Integer.parseInt(itemIdStrings[i]));
//                		amounts.add(amount);
//                	}
//                }
//                
//                System.out.println(itemIds);
//                System.out.println(amounts);
//
//            // DAOを使って情報を取得
//            itemDAO dao = new itemDAO();
//            List<ItemBean> newItems = dao.cartAdd(itemIds, amounts);  // 複数の商品と数量を渡して取得
//            System.out.println("新規アイテム：" + newItems);
//            // 取得したアイテムを既存カートリストに追加
//            for (ItemBean newItem : newItems) {
//                boolean itemExists = false;
//
//                // すでに同じカートに同じアイテムがある場合は購入数を更新
//                for (ItemBean item : cartList) {
//                    if (item.getItemId() == newItem.getItemId()) {
//                        item.setAmount(item.getAmount() + newItem.getAmount());
//                        itemExists = true;
//                        break;
//                    }
//                }
//
//                // 新しいアイテムの場合はリストに追加
//                if (!itemExists) {
//                    cartList.add(newItem);
//                }
//            }
//        }
//
//        } catch (SQLException | ClassNotFoundException | NumberFormatException e) {
//            e.printStackTrace();
//        }
        // カートリストをセッションに保存
        session.setAttribute("cartList", cartList);
        System.out.println("cart" + cartList);
 
        // 商品一覧画面にリダイレクト
        RequestDispatcher rd = request.getRequestDispatcher("/itemList.jsp");
        rd.forward(request, response);
    }
}

