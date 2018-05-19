package jp.co.systena.tigerscave.Shopping.application.service;

import java.util.ArrayList;
import java.util.List;
import jp.co.systena.tigerscave.Shopping.application.model.Item;

/**
 * @author systena
 *
 */
public class ListService {

  // 商品リスト
  private List<Item>itemList;

  /**
   * コンストラクタ
   */
  public ListService() {

    itemList = new ArrayList<>();
    // 商品1
    Item item1 = new Item();
    item1.setName("商品1");
    item1.setPrice(100);
    itemList.add(item1);

    // 商品2
    Item item2 = new Item();
    item2.setName("商品2");
    item2.setPrice(500);
    itemList.add(item2);

    // 商品3
    Item item3 = new Item();
    item3.setName("商品3");
    item3.setPrice(1200);
    itemList.add(item3);

    // 商品4
    Item item4 = new Item();
    item4.setName("商品4");
    item4.setPrice(80000);
    itemList.add(item4);

  }

  /**
   * 商品リストを取得
   * @return 商品リスト
   */
  public List<Item> getItemList() {
    return itemList;
  }

  /**
   * 商品リストを設定
   * @param itemList 商品リスト
   */
  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

}
