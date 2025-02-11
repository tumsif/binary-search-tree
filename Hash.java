import java.util.Hashtable;

public class Hash{
    public static void main(String[] args){
        Hashtable<Integer, String> table = new Hashtable<>(10); 
        /* 
        have initial capacity of 11 elements and load factor of 0.75
        to change that add the (no_of_elements, load factor) manually
        The load factor represent the percentage of number of elements that need to be filled 
        before table manually expanding
        */
       table.put(100, "Spongebob");
       table.put(123, "Patric");
       table.put(321, "Sandy");
       table.put(555, "Squidward");
       table.put(777, "Gary");

       // table.keySet() takes all keys in the table and returns a key set which is iterable
       for(Integer key: table.keySet()){
            System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
       }
    }
}