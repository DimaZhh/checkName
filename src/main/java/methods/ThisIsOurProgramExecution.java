package methods;

public class ThisIsOurProgramExecution {

    public static void main(String[] args) {

        Car car = new Car();
        car.setLength(4);
        car.setWidth(2);
        car.setHeight(1);
        car.setWeight(2000);
        car.setNew(false);

        Car car2 = new Car();
        car2.setLength(3);
        car2.setLength(3);
        car2.setWidth(2);
        car2.setHeight(1);
        car2.setWeight(2000);
        car2.setNew(true);

        Car car3 = new Car();
        car3.setLength(5);
        car3.setWidth(2);
        car3.setHeight(1);
        car3.setWeight(2000);
        car3.setNew(false);

        int multiply1 = car.calculateCarDetails();
        int multiply2 = car2.calculateCarDetails();
        int multiply3 = car3.calculateCarDetails();
        System.out.println("First car - $" + multiply1 + " | is it new one? " + car.getIsNew());
        System.out.println("Second car - $" + multiply2 + " | is it new one? " + car2.getIsNew());
        System.out.println("Third car - $" + multiply3 + " | is it new one? " + car3.getIsNew());

        Car car4 = new Car();
        int multiply4 = car4.calculateAndPrint(1, 4, 8, 200, "FirstName");
        System.out.println(multiply4 + " " + car4.getNameOfStudent());

        car4.calculateCarDetails();
        car4.calculateCarDetails("dasdsadsa");
        car4.calculateCarDetails("dasdas", "dasdsads");

        System.out.println("Car1 - " + car.getLength() + " Car2 - " + car2.getLength() + " Car3 - " + car3.getLength());

        car4.saySomething("Name123!!!!");
        car4.saySomething("Name1", "Name2");
        car4.saySomething("Name1", "Name2", "Name3", "Name4", "Name5", "Name6", "Name50");
    }

}
