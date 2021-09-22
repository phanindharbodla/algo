package design.patterns.behavioural.Observer;

import java.util.List;

public class SuggestionEmailPublisher extends FeedObserver {
    public SuggestionEmailPublisher(StockFeed dataFeed) {
        this.data_source = dataFeed;
        this.data_source.add_subscriber(this);
    }

    @Override
    public void notify_new_feed() {
        List<Integer> out = data_source.price_data();
        System.out.println("Latest Price : " + out.get(out.size() - 1));
    }
}
