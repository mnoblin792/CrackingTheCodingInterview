import com.marknoblin.myhashtable.MyHashTable;

void main() {
    MyHashTable<String, Integer> table = new MyHashTable<>();

    table.add("this", 1);
    table.add("that", 2);
    table.add("the other", 3);
    table.add("that", 4);

    IO.println(table.size());               // Expect size = 3
    IO.println(table.get("this"));          // Expect value = 1
    IO.println(table.get("that"));          // Expect value = 4
    IO.println(table.remove("that"));  // Expect return value = 4
    IO.println(table.remove("that"));  // Expect return value = null, since key = "that" no longer exists
    IO.println(table.size());               // Expect size = 2
    IO.println(table.isEmpty());            // Expect false since table still has 2 values
}
