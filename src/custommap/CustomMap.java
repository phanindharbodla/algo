package custommap;

public class CustomMap {
    private int prime = 19;
    private int size = 0;
    private KVPair table[] = new KVPair[prime];

    public String get(String k) {
        int hash = k.hashCode() % prime;
        KVPair kvPair = table[hash];
        while (kvPair != null) {
            if (kvPair.key.equals(k)) {
                return kvPair.value;
            }
            kvPair = kvPair.next;
        }
        return null;
    }

    public void put(String k, String v) {
        int hash = k.hashCode() % prime;
        if (table[hash] == null) {
            table[hash] = new KVPair(k, v);
            size++;
            return;
        }
        KVPair kvPair = table[hash];
        while (kvPair != null) {
            if (kvPair.key.equals(k)) {
                kvPair.value = v;
                break;// break on update
            }
            if (kvPair.next != null)
                kvPair = kvPair.next;
            else {
                kvPair.next = new KVPair(k, v);
                size++;
                break;
            }
        }

    }

    // TODO additional (resize()// if size exceed or bucket exceed a given limit we can invoke this )
    class KVPair {
        String key;
        String value;
        KVPair next;

        KVPair(String k, String v) {
            key = k;
            value = v;
        }
    }
}