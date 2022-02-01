package Lab4;

public class Lab4_3 {
    public static void main(String[] args) {
        AlarmDoor al = new AlarmDoor();
        al.open();
        al.close();
        al.alarming();
    }
}

abstract class Door {
    public Door() {
        System.out.println("this is a door.");
    }

    abstract public void open();

    abstract public void close();
}

interface alarm {
    public void alarming();
}

class AlarmDoor extends Door implements alarm {
    // @Override
    public AlarmDoor() {
        System.out.println("this a alarm door");
    }

    public void open() {
        System.out.println("open the alarm door");
    }

    public void close() {
        System.out.println("close the alarm door");
    }

    @Override
    public void alarming() {
        System.out.println("the AlarmDoor is alarming.");
    }
}