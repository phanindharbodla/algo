package design.patterns.creational.Prototype;

public abstract class OS implements Cloneable {
    public String brand;
    public String series;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    public void info() {
        System.out.println(brand + " " + series);
    }

    public abstract void installApps();
}
