package rohitkadam.jsondemo;

public class JSON {
    String name;
    String discription;
    String id;
    String img;

    public JSON(String name, String discription, String id,String img) {
        this.name = name;
        this.discription = discription;
        this.id = id;
        this.img = img;
    }

    public JSON(String name, String discription, String img) {
        this.name = name;
        this.discription = discription;
        this.img = img;
    }

    public JSON(String name, String img) {
        this.name = name;
        this.img = img;
    }

    public JSON() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}