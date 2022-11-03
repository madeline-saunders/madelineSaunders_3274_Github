package main;

//Author: madelineSaunders_3274_PE12.2-3
//Date: November 1st
public class QuantityItem extends FixedPriceItem {
  private int quantity;

  public QuantityItem(Product product, int quantity) {
      super(product.getDescription(), product.getPrice());
      this.quantity = quantity;
  }

  @Override
  public double getTotalPrice() {
      return super.getTotalPrice() * quantity;
  }

  @Override
  public String getDescription(int length) {
      return super.getDescription(length) + this.quantity;
  }

}

