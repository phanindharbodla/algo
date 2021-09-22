package design.patterns.behavioural.Observer;

public class Demo {
    public static void main(String args[]) {
        StockFeed dataFeed = new StockFeed();
        SuggestionEmailPublisher emailDigest = new SuggestionEmailPublisher(dataFeed);
        StockDashbaord stockDashbaord = new StockDashbaord(dataFeed);
        int[] input = {1, 45, 11, 78, 2, 3, 4,};
        for (int i : input)
            dataFeed.add_price_data(i);


    }
}
