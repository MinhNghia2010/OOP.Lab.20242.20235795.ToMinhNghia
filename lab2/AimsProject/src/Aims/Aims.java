package Aims;

public class Aims {

    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("Total Cost is: " + anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.println("Total Cost is: " + anOrder.totalCost());

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        TestPassingParameter.swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        TestPassingParameter.changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());

        anOrder.cartDisplay();
    }
}

//Question 15:
//Answer:
//• java sử dụng phương thức là pass by value
//  tức là khi gọi 1 phương thức thì 1 bản sao của giá trị được truyền vào phương thức
//  vậy nên trong swap() giá trị title được o1 và o2 trỏ tới chứ chúng không thay đổi
//  title của bản gốc
//• trong phương thức changeTitle(), dvd.setTitle thay đổi đối tượng DVD thật sự
//  và sau đó gán gía trị title cũ vào DVD mới bằng cách khởi tạo 1 DVD mới