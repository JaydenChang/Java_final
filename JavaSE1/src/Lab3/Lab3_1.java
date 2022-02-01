package Lab3;

public class Lab3_1 {
    public static void main(String[] args) {
        double reg = (new Rectangle(5, 6)).calc();
        double cir = (new circle(2)).calc();
        if (reg - cir >= 0) {
            (new Lab3_1()).show(reg, cir);
        } else {
            System.out.println("the Rectangle is smaller than the circle");
        }
    }

    public void show(double reg, double cir) {
        System.out.print("the shadow area: ");
        String result = String.format("%.2f", reg - cir);
        System.out.println(result);
    }
}

class Rectangle {
    double x, y, area;

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
        area = x * y;
    }

    public double calc() {
        // return x * y;
        return area;
    }
}

class circle {
    double r, area;

    public circle(double r) {
        this.r = r;
        area = 3.14 * r * r;
    }

    public double calc() {
        // return 3.14 * r * r;
        return area;
    }
}