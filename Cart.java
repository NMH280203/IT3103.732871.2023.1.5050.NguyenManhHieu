package lab02;

// Nguyen Manh Hieu 20215050
import java.util.ArrayList;
//import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDER = 20;

    ArrayList<DigitalVideoDisc> itemsOrder = new ArrayList<DigitalVideoDisc>();

    private int qtyOrdered;

    public int getQtyOrder() {
        return qtyOrdered;
    }

    // Add DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDER) {
            itemsOrder.add(disc);
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    // In danh sách DVD đã order
    public void displayCart() {
        System.out.println("------- Cart Display -------");
        for (DigitalVideoDisc disc : itemsOrder) {
            System.out.printf("%-20s %-15s %-20s %-5d %-5.2f \n", disc.getTitle(), disc.getCategory(),
                    disc.getDirector(), disc.getLength(), disc.getCost());
        }
    }

    // Tính tổng số tiền DVD đã order
    public double totalCost() {
        double total = 0;
        for (DigitalVideoDisc disc : itemsOrder) {
            total += (double) disc.getCost();
        }
        return total;
    }

    // Remove DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        itemsOrder.remove(disc);
        qtyOrdered--;
        System.out.printf("The disc %s has been removed\n", disc.getTitle());
    }
}
