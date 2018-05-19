package jp.co.systena.tigerscave.Shopping.application.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jp.co.systena.tigerscave.Shopping.application.model.Cart;
import jp.co.systena.tigerscave.Shopping.application.service.ListForm;
import jp.co.systena.tigerscave.Shopping.application.service.ListService;

/**
 * @author systena
 *
 */
@Controller
public class ListController {

  // リストサーバ
  private ListService itemList = new ListService();
  // セッション
  @Autowired
  HttpSession session;

  /**
   * コントローラ
   * @param model モデル
   * @return テンプレート名
   */
  @RequestMapping("/Shopping")
  public String show(Model model) {
    // Viewに渡すデータを設定
    model.addAttribute("itemList", itemList);
    session.setAttribute("itemList", itemList);

    // セッションの初期化
    ListForm listForm = new ListForm();
    // セッションを保存
    session.setAttribute("listForm", listForm);
    // 合計金額初期値設定
    session.setAttribute("totalAmount", 0);
    model.addAttribute("totalAmount", 0);

    // テンプレート名を返す
    return "ShoppingOrder";
  }

  /**
   * 注文をカートに入れる
   * @param model モデル
   * @param input0 注文情報
   * @param input1 注文情報
   * @param input2 注文情報
   * @param input3 注文情報
   * @return テンプレート名
   */
  @RequestMapping(value = "/Shopping", params="order" , method = RequestMethod.POST)
  public String order(Model model,
      @RequestParam(name = "input0", required = false) Integer input0
      ,@RequestParam(name = "input1", required = false) Integer input1
      ,@RequestParam(name = "input2", required = false) Integer input2
      ,@RequestParam(name = "input3", required = false) Integer input3) {



    ListForm listForm = new ListForm();
    // 注文商品インスタンス取得
    listForm = (ListForm)session.getAttribute("listForm");

    // 注文済み商品取得
    Cart cart = listForm.getCart();

    // カートに商品を追加
    if (input0 != 0) {
      cart.setOrdar(itemList.getItemList().get(0), input0);
    }

    if (input1 != 0) {
      cart.setOrdar(itemList.getItemList().get(1), input1);
    }

    if (input2 != 0) {
      cart.setOrdar(itemList.getItemList().get(2), input2);
    }

    if (input3 != 0) {
      cart.setOrdar(itemList.getItemList().get(3), input3);
    }

    // Viewに渡すデータを設定
    model.addAttribute("itemList", itemList);
    model.addAttribute("orderMap", session.getAttribute("orderMap"));
    model.addAttribute("totalAmount", session.getAttribute("totalAmount"));

    // セッションを保存
    session.setAttribute("listForm", listForm);

    // テンプレート名を返す
    return "ShoppingOrder";
  }

}
