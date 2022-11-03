package main;

//Author: madelineSaunders_3274_PE12.2-3
//Date: November 1st
public class FixedPriceItem extends AbstractItem
{
  private String description;
  private double charge;

  /*
   * Construct an item that has a fixed charge
   * @param aDescription the description for the item
   * @param aCharge the charge
   */
  public FixedPriceItem(String description, double charge) {
      this.description = description;
      this.charge = charge;
  }

  /*
   * Computes the total cost of this item
   * @return the total price
   */
  public double getTotalPrice() {
      return charge;
  }

  public String getDescription(int length) {
      return String.format("%-" + (length - 13) + "s%8.2f        ", this.description, this.charge);
  }

}
