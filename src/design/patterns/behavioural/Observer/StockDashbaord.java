package design.patterns.behavioural.Observer;

import java.util.List;

public class StockDashbaord extends FeedObserver {
    public StockDashbaord(StockFeed dataFeed) {
        this.data_source = dataFeed;
        this.data_source.add_subscriber(this);
    }

    @Override
    public void notify_new_feed() {
        List<Integer> out = data_source.price_data();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int a : out) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        System.out.println("Max Price : " + max);
        System.out.println("Min Price : " + min);
    }
}
