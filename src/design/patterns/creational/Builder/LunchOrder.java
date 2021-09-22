package design.patterns.creational.Builder;

final public class LunchOrder {

    private final String bread;
    private final String condiments;
    private final String dressing;
    private final String meat;
    private LunchOrder(Builder builder) {
        // validate your logic here
        // ex: is bread available etc
        this.bread = builder._bread;
        this.condiments = builder._condiments;
        this.dressing = builder._dressing;
        this.meat = builder._meat;
    }

    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }

    public static class Builder {
        private String _bread;
        private String _condiments;
        private String _dressing;
        private String _meat;

        public Builder() {

        }

        public LunchOrder build() {
            return new LunchOrder(this);
        }

        public Builder bread(String bread) {
            this._bread = bread;
            return this;
        }

        public Builder condiments(String condiments) {
            this._condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing) {
            this._dressing = dressing;
            return this;
        }

        public Builder meat(String meat) {
            this._meat = meat;
            return this;
        }

    }

}
