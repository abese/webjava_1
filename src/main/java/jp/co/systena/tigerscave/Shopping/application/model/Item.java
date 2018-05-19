package jp.co.systena.tigerscave.Shopping.application.model;

/**
 * @author systena
 *
 */
public class Item {

  /**
   * 商品名
   */
  private String name;
  /**
   * 価格
   */
  private int price;


  /**
   * 商品名を取得
   * @return 商品名
   */
  public String getName() {
    return name;
  }
  /**
   * 商品名を設定
   * @param name 商品名
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * 価格を取得
   * @return 価格
   */
  public int getPrice() {
    return price;
  }
  /**
   * 価格を設定
   * @param price 価格
   */
  public void setPrice(int price) {
    this.price = price;
  }
}
