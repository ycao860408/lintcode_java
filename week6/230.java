public class AnimalShelter {
    /*
     * @param name: a string
     * @param type: an integer, 1 if Animal is dog or 0
     * @return: nothing
     */
    private int  total; 
    private LinkedList<String> dogs;
    private LinkedList<String> cats;
    
    public AnimalShelter() {
        total = 0;
        dogs = new LinkedList<String>();
        cats = new LinkedList<String>();
    }
    
    public void enqueue(String name, int type) {
        // write your code here
        total += 1;
        if (type == 1) {
            dogs.add(total + "#" + name);
        } else {
            cats.add(total+"#"+name);
        }
    }

    /*
     * @return: A string
     */
    public String dequeueAny() {
        // write your code here
        if(cats.isEmpty()) {
            return dequeueDog();
        } else if (dogs.isEmpty()) {
            return dequeueCat();
        } else {
            int d_time = getTime(dogs.getFirst());
            int c_time = getTime(cats.getFirst());
            if (c_time < d_time) {
                return dequeueCat();
            } else {
                return dequeueDog();
            }
        }
    }

    /*
     * @return: A string
     */
    public String dequeueDog() {
        // write your code here
        String name = getName(dogs.getFirst());
        dogs.removeFirst();
        return name;
    }

    /*
     * @return: A string
     */
    public String dequeueCat() {
        // write your code here
        String name = getName(cats.getFirst());
        cats.removeFirst();
        return name;
    }
    private String getName(String item) {
        return item.substring(item.indexOf('#') + 1, item.length());
    }
    
    private int getTime(String str) {
        return Integer.parseInt(str.substring(0, str.indexOf("#")));
    }
}