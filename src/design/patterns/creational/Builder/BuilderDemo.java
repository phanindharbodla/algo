package design.patterns.creational.Builder;

public class BuilderDemo {

    public static void main(String args[]) {

        LunchOrder.Builder builder = new LunchOrder.Builder();
        builder.bread("Wheat").dressing("Mayo").meat("Turkey").condiments("spice");
        LunchOrder lunchOrder = builder.build();
        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());
        // Separate the construction of a complex object from its representation so that the
        // same construction process can create different representations.
        // helpful in creating immutable objects thread-safely by chained setters and allows
        // validation logic before creating an object.
    }
}