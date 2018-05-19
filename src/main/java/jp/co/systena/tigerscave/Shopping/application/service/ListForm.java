package jp.co.systena.tigerscave.Shopping.application.service;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jp.co.systena.tigerscave.Shopping.application.model.Cart;
import jp.co.systena.tigerscave.Shopping.application.model.Order;

/**
 * @author systena
 *
 */
@Controller
public class ListForm {

  private Cart cart;

  /**
   * コンストラクタ
   */
  public ListForm() {
    cart = new Cart();
  }


  /**
   * カート情報を表示
   * @param session セッション
   * @param model モデル
   * @return テンプレート名
   */
  @RequestMapping(value = "/Shopping", params="orderList" , method = RequestMethod.GET)
  public String getInCartList(HttpSession session, Model model) {

    Cart cart = ((ListForm) session.getAttribute("listForm")).getCart();

    // 注文情報
    Map<String, Map<String, Integer>> orderMap = new HashMap<>();

    // 注文情報集計
    for (Order order : cart.getOrdarList()) {

      // 注文情報詳細MAP
      Map<String, Integer> orderDetailMap = new HashMap<>();
      if (orderMap.get(order.getItem().getName()) == null) {
        // 注文情報設定
        orderDetailMap.put("price", order.getNum() * order.getItem().getPrice());
        orderDetailMap.put("num", order.getNum());

        orderMap.put(order.getItem().getName(), orderDetailMap);
      } else {
        // 計算済みの値を取得
        int price = orderMap.get(order.getItem().getName()).get("price");
        int num = orderMap.get(order.getItem().getName()).get("num");

        // 注文情報を加算
        orderDetailMap.put("price", price + order.getNum() * order.getItem().getPrice());
        orderDetailMap.put("num", num + order.getNum());

        orderMap.put(order.getItem().getName(), orderDetailMap);
      }
    }

    // 合計金額を算出
    int totalAmount = 0;
    for (String key : orderMap.keySet()) {
      totalAmount += orderMap.get(key).get("price");
    }

    // 表示情報を設定
    session.setAttribute("orderMap", orderMap);
    session.setAttribute("totalAmount", totalAmount);
    model.addAttribute("orderMap", orderMap);
    model.addAttribute("itemList", session.getAttribute("itemList"));
    model.addAttribute("totalAmount",totalAmount);

    return "ShoppingOrder";
  }

  /**
   * カート情報を取得
   * @return カート情報
   */
  public Cart getCart() {
    return cart;
  }

  /**
   * カート情報を設定
   * @param cart カート情報
   */
  public void setCart(Cart cart) {
    this.cart = cart;
  }
}
