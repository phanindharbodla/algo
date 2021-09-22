package design.patterns.behavioural.Observer;

public abstract class FeedObserver {
    protected StockFeed data_source;

    public abstract void notify_new_feed();
}
