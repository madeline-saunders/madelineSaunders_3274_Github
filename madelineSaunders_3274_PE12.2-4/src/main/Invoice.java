package main;

import java.util.ArrayList;
//Author: madelineSaunders_3274_PE12.4


public class Invoice {
  private Address billingAddress;
  private ArrayList<AbstractItem> items;
  private Product Product;

  public Invoice(Address anAddress)
  {
      items = new ArrayList<AbstractItem>();
              billingAddress = anAddress;
  }
  public void add(AbstractItem item){
      items.add(item);
  }


  public void add(int quantity){
      add(new QuantityItem(Product, quantity));
  }
  public String format(){
      String r = "I N V O I C E\n\n"+
              billingAddress.format()
              +
              String.format("\\n\\n%-30s%8s%5s%8s\\n","Description","Price", "Qty", "Total");
      for (AbstractItem i : items){
          r = r + i.format() + "\n";
      }
      r = r + String.format("\nAMOUNT DUE: $%8.2f", getAmountDue());
      return r;
  }
  private double getAmountDue()
  {
      double amountDue = 0;
      for (AbstractItem item : items) {
          amountDue = amountDue + item.getTotalPrice();
      }
      return amountDue;
      }

  public void setProduct(main.Product product) {
      Product = product;
  }

  public void add(main.Product toaster, int i) {
  }
}

