package jp.co.systena.tigerscave.Shopping.application.model;

/**
 * @author systena
 *
 */
public class Order {

  /**
   * 商品名
   */
  private Item item;

  /**
   * 注文数
   */
  private int num;

  /**
   * 商品名を取得
   * @return 商品名
   */
  public Item getItem() {
    return item;
  }

  /**
   * 商品名を設定
   * @param item 商品名
   */
  public void setItem(Item item) {
    this.item = item;
  }

  /**
   * 注文数を取得
   * @return 注文数
   */
  public int getNum() {
    return num;
  }

  /**
   * 注文数を設定
   * @param num 注文数
   */
  public void setNum(int num) {
    this.num = num;
  }

}
