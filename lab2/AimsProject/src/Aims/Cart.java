package Aims;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered = 0;

    //add disc
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered + 1 > MAX_NUMBER_ORDERED) {
            System.out.println("The cart is full");
        } else {
            itemOrdered[qtyOrdered++] = disc;
            System.out.println("The item has been added");
        }
    }

    //add list
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        int numDvd = 0;
        for (int i = 0; i < MAX_NUMBER_ORDERED; i++) {
            if (dvdList[i] != null) {
                numDvd++;
            } else break;
        }
        if (qtyOrdered + numDvd > MAX_NUMBER_ORDERED) {
            System.out.println("The cart is full");
        } else {
            for (int i = 0; i < numDvd; i++) {
                itemOrdered[qtyOrdered++] = dvdList[i];
            }
            System.out.println("The items have been added");
        }
    }

    //overload
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    //remove disc
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        boolean found = false;
        for (int i = 0; i <qtyOrdered; i++){
            if(itemOrdered[i].getTitle().equals(disc.getTitle())){
                found = true;
                for(int j = i; j < qtyOrdered; j++){
                    itemOrdered[j] = itemOrdered[j+1];
                }
                itemOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed");
                break;
            }
        }
        if(!found){
            System.out.println("Disc not found");
        }
    }

    //total cost
    public float totalCost(){
        float total = 0;
        for(int i = 0; i < qtyOrdered; i++){
            total += itemOrdered[i].getCost();
        }
        return total;
    }

    public void cartDisplay(){
        for (int i = 0; i <qtyOrdered;i++){
            DigitalVideoDisc disc = itemOrdered[i];
            System.out.println(i+1 + " " + disc.getTitle() + " " + disc.getCost());
        }
    }
}