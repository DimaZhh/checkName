package constructors;

public class House {

    String street;
    int price;
    int age;

    public House(String street, int price, int age){
        this.street = street;
        this.price = price;
        this.age = age;
    }

    public House(String street) {
        this.street = street;
    }

    public House(){
        System.out.println("Он отработал");
    }


    public static void main(String[] args) {

        House house = new House("Centralnaya, 12", 150000, 5);
        House house1 = new House("Centralnaya, 12111", 1500001, 5);
        House house2 = new House("Centralnaya, 13", 1500002, 5);
        House house3 = new House("Centralnaya, 121", 1500020, 5);

        System.out.println(house.street + ", " + house.price + ", " + house.age);
        System.out.println(house1.street + ", " + house1.price + ", " + house1.age);
        System.out.println(house2.street + ", " + house2.price + ", " + house2.age);
        System.out.println(house3.street + ", " + house3.price + ", " + house3.age);

        House house4 = new House("NewStreet, 11");
        System.out.println(house4.street + ", " + house4.price + ", " + house4.age);

        House house11 = new House();
        System.out.println(house11.street + ", " + house11.price + ", " + house11.age);
    }
}
