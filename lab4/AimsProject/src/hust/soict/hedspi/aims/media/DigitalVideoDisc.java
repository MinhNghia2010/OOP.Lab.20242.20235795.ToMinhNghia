package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    private static int nbDigitalVideoDiscs = 0;

    //title only
    public DigitalVideoDisc(String title){
        super(++nbDigitalVideoDiscs, title, "", 0.0f, 0, "");
    }

//    public DigitalVideoDisc(String title){
//        super();
//        this.title = title;
//    }

    //category, title and cost
    public DigitalVideoDisc(String category, String title, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, "");
    }

    //director, category, title and cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, director);
    }

    //all attributes
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

    @Override
    public String toString(){
        return "DVD - Title: " + getTitle() + " - Director: " + getDirector() + " - Length: " + getLength() + " mins - Cost: " + getCost() +"$";
    }

    @Override
    public String play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
        return null;
    }

    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
}

//Question 10:
//Answer: Không vì 2 hàm phương thức khởi tạo đều có chung 1 kiểu signature là
// DigitalVideoDisc(String)
// Khi khởi tạo title và category thì lúc gọi Java sẽ không biết mình đang gọi hàm nào nên sẽ báo lỗi
// Thường thi java sẽ cảnh cáo luôn khi mình đang khởi tạo rồi

