package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_data")
public class product1
{
    @Id
    @Column(name="book_id")
    private int  bookID;
    @Column(name="book_name")
    private String bookName;
    @Column(name="book_price")
    private double bookPrice;

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return bookID+"\t"+bookName+"\t"+bookPrice;
    }
}
