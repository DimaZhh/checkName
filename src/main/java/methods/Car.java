package methods;

public class Car {

    private int length;
    private int width;
    private int height;
    private int weight;
    private boolean isNew;
    private String nameOfStudent;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
    }

    public int calculateCarDetails() {
        int calculatedValues = length * width * height * weight;
        return calculatedValues;
    }

    public int calculateCarDetails(String arg1) {
        int calculatedValues = length * width * height * weight;
        return calculatedValues;
    }

    public int calculateCarDetails(String arg1, String arg2) {
        int calculatedValues = length * width * height * weight;
        return calculatedValues;
    }

    public void saySomething(String name) {
        System.out.println("Hey mr./ms - " + name);
    }

    public void saySomething(String name, String name2) {
        System.out.println("Hey mr./ms - " + name + ", " + name2);
    }

    public void saySomething(String...names) {

        for (String name: names) {
            System.out.println("Hey mr./ms - " + name);
        }
    }

    public int calculateAndPrint(int length222, int width222, int height222, int weight222, String nameOfStudent) {
        int calculatedValues = length222 * width222 * height222 * weight222;
        this.nameOfStudent = nameOfStudent;
        return calculatedValues;
    }

    public boolean getIsNew(){
        return isNew;
    }


}
