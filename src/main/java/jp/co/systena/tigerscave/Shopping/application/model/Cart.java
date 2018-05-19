package jp.co.systena.tigerscave.Shopping.application.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author systena
 *
 */
public class Cart {

  /**
   * 注文商品一覧
   */
  private List<Order> ordarList;

  /**
   * コンストラクタ
   */
  public Cart() {
    ordarList = new ArrayList<Order>();
  }

  /**
   * 注文商品一覧を取得
   * @return 注文商品一覧
   */
  public List<Order> getOrdarList() {
    return ordarList;
  }

  /**
   * 注文商品を設定
   * @param ordarList 注文商品一覧
   */
  public void setOrdar(Item item, int num) {

    Order order = new Order();

    // 注文情報をカートに設定
    order.setItem(item);
    order.setNum(num);

    this.ordarList.add(order);
  }
}
