package CodeAnalysis.Collection;



public class HashMap<K,V> implements Map<K,V> {

    private Entry<K,V>[] table = null;
    private static int defalutLenth = 16;
    private int size = 0;

    public HashMap() {
        table = new Entry[defalutLenth];

    }

    @Override
    public V put(K k, V v) {
        int index = hash(k);
        Entry entrie = table[index];
        if (null == entrie){
            table[index] = new Entry<>(k,v,null,index);
            size++;
        }else {
            table[index] = new Entry<>(k,v,entrie,index);
        }
        return table[index].getValue();
    }

    @Override
    public V get(K k) {
        if (size == 0){
            return null;
        }
        int index = hash(k);
        Entry<K,V> entry = getEntry(k,index);
        return entry == null ? null:entry.getValue();
    }

    private Entry getEntry(K k, int index) {
        for (Entry e = table[index]; e != null; e = e.next ) {
            if (e.hash == index && (e.getKey() == k || k.equals(e.getKey()))){
             return e;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    class Entry<K,V> implements Map.Entry<K,V>{

        private K k;
        private V v;
        private Entry next;
        private int hash;

        public Entry(K k, V v, Entry next, int hash) {
            this.k = k;
            this.v = v;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

    private int hash(K k){
        int index = k.hashCode()%(defalutLenth-1);
        return Math.abs(index);
    }
}
