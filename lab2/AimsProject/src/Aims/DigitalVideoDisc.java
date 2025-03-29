package Aims;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    private static int ndDigitalVideoDiscs = 0;
    private int id;

    //title only
    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++ndDigitalVideoDiscs;
    }

//    public DigitalVideoDisc(String title){
//        super();
//        this.title = title;
//    }

    //category, title and cost
    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.id = ++ndDigitalVideoDiscs;
    }

    //director, category, title and cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.id = ++ndDigitalVideoDiscs;
    }

    //all attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++ndDigitalVideoDiscs;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    //setter
    public void setTitle(String title) {
        this.title = title;
    }
}

//Question 10:
//Answer: Không vì 2 hàm phương thức khởi tạo đều có chung 1 kiểu signature là
// DigitalVideoDisc(String)
// Khi khởi tạo title và category thì lúc gọi Java sẽ không biết mình đang gọi hàm nào nên sẽ báo lỗi
// Thường thi java sẽ cảnh cáo luôn khi mình đang khởi tạo rồi