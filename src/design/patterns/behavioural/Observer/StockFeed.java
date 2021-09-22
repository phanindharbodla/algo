package design.patterns.behavioural.Observer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class StockFeed {
    private List<FeedObserver> subscribers = new LinkedList<>();
    private List<Integer> price_data = new LinkedList<>();

    public void add_subscriber(FeedObserver feedObserver) {
        this.subscribers.add(feedObserver);
    }

    public void add_price_data(Integer price) {
        this.price_data.add(price);
        this.broadcast();
    }

    private void broadcast() {
        for (FeedObserver observer : subscribers) {
            observer.notify_new_feed();
        }
    }

    public List<Integer> price_data() {
        return Collections.unmodifiableList(this.price_data);
    }
}
