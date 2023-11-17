package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
	public static final int MAX_NUMBERS_ORDER = 20;
	
	ArrayList<DigitalVideoDisc> itemsOrder = new ArrayList<DigitalVideoDisc>();
	
	private int qtyOrdered;
	
	public int getQtyOrder() {
        return qtyOrdered;
    }
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDER){
            itemsOrder.add(disc);
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
	}
	
	public void displayCart() {
        System.out.println("------- Cart Display -------");
        for (DigitalVideoDisc disc : itemsOrder){
            System.out.printf("%-20s %-15s %-20s %-5d %-5.2f \n", disc.getTitle(), disc.getCategory(),
                    disc.getDirector(), disc.getLength(), disc.getCost());
        }
    }
	
	public double totalCost() {
		double total = 0;
		for (DigitalVideoDisc disc : itemsOrder){
			total += (double) disc.getCost();
		}
		return total;
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		itemsOrder.remove(disc);
		qtyOrdered--;
		System.out.printf("The disc %s has been removed\n",disc.getTitle());
	}
	
	/**
     * This function adds a list of DVDs to the cart
     * @param dvdList an array of hust.soict.dsai.aims.disc.DigitalVideoDisc objects
     * @return The method returns a boolean value.
     */
	public boolean addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        for (int i = 0; i < dvdList.length; i++){
            if (qtyOrdered <= MAX_NUMBERS_ORDER){
                itemsOrder.add(dvdList[i]);
                qtyOrdered++;
            } else {
                System.out.println("The cart is almost full");
                return false;
            }
        }
        System.out.println("The disc has been added");
        return true;
    }
	
	/**
    * This function adds 2 DVDs to the cart
    * @param dvd1,dvd2
    * @return The method returns a boolean value.
    */
	public boolean addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if (qtyOrdered < MAX_NUMBERS_ORDER -1 ){
            itemsOrder.add(dvd1);
            itemsOrder.add(dvd2);
            qtyOrdered+=2;
            System.out.println("2 disc has been added");
            return true;
        } else {
            System.out.println("The cart is almost full");
            return false;
        }
	}
	
	/**
	    * This function display cart according to the assignment required format
	    * ***********************CART***********************
		* Ordered Items:
		* 1. DVD - [Title] - [category] - [Director] - [Length]: [Prsice] $
		* 2. DVD - [Title] - ...
		* Total cost: [total cost]
		* ***************************************************
	*/
	public void displayCart2() {
        System.out.println("***********************CART***********************\nOrdered Items:");
        int i=1;
        double total = 0;
        for (DigitalVideoDisc disc : itemsOrder){
            System.out.printf("%d. DVD %-20s %-15s %-20s %-5d %-5.2f \n",i, disc.getTitle(), disc.getCategory(),
                    disc.getDirector(), disc.getLength(), disc.getCost());
            i++;
            total += (double) disc.getCost();
        }
        System.out.printf("Total cost: %f", total);
    }
	
	/**
     * It searches for a DVD in the cart by its id.
     * @param id of the DVD to search
     * @return The method returns a boolean value.
     */
    public boolean searchInCart(int id){
        for (DigitalVideoDisc disc: itemsOrder){
            if(disc.getId() == id){
                System.out.println(disc.toString());
                return true;
            }
        }
        System.out.println("Not found!");
        return false;
    }
	
}
