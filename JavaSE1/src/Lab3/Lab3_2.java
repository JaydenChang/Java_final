package Lab3;

public class Lab3_2 {
    public static void main(String[] args) {
        (new People()).speakHello();
        (new ChinesePeople()).speakHello();
        (new ChinesePeople()).chinaKungFU();
    }
}

class People {
    protected double height, weight;

    public void speakHello() {
        System.out.println("people: hello");
    }

    public void averageHeight() {
    }

    public void averageWeight() {
    }

}

class ChinesePeople extends People {
    @Override
    public void speakHello() {
        System.out.println("ChinesePeople: hello");
    }

    public void chinaKungFU() {
        System.out.println("heng heng ha hei");
    }
}