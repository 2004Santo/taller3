import java.util.ArrayList;
import java.util.List;

public class BookDemo {
  public static void main(String[] args) throws CloneNotSupportedException {
    BookShop bs = new BookShop();
    bs.setShopName("Novelty");
    bs.loadData();
    System.out.println(bs);

    BookShop bs1 = bs.clone();       // copia (lista nueva, mismos objetos Book)
    bs.getBooks().remove(2);         // quitamos un libro del original
    bs1.setShopName("A1");

    System.out.println(bs);
    System.out.println(bs1);
  }
}

// --------- clases de apoyo (sin public) ---------

class Book {
  private int bid;
  private String bname;

  public int getBid() { return bid; }
  public void setBid(int bid) { this.bid = bid; }

  public String getBname() { return bname; }
  public void setBname(String bname) { this.bname = bname; }

  @Override
  public String toString() {
    return "Book [bid=" + bid + ", bname=" + bname + "]";
  }
}

import java.util.ArrayList;
import java.util.List;

class BookShop implements Cloneable {
  private String shopName;
  private List<Book> books = new ArrayList<>();

  public String getShopName() { return shopName; }
  public void setShopName(String shopName) { this.shopName = shopName; }

  public List<Book> getBooks() { return books; }
  public void setBooks(List<Book> books) { this.books = books; }

  public void loadData() {
    for (int i = 1; i <= 10; i++) {
      Book b = new Book();
      b.setBid(i);
      b.setBname("Book" + i);
      books.add(b);
    }
  }

  @Override
  public String toString() {
    return "BookShop [shopName=" + shopName + ", books=" + books + "]";
  }

  @Override
  protected BookShop clone() throws CloneNotSupportedException {
    // Copia superficial de los elementos (lista nueva, mismas instancias Book)
    BookShop shop = new BookShop();
    shop.setShopName(this.shopName);
    for (Book b : this.books) {
      shop.getBooks().add(b);
    }
    return shop;
  }
}
