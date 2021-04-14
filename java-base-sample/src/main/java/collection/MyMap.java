package collection;

import java.util.*;

/**
 * Map和List不同的是，Map存储的是key-value的映射关系，并且，它不保证顺序。在遍历的时候，遍历的顺序既不一定是put()时放入的key的顺序，
 * 也不一定是key的排序顺序。使用Map时，任何依赖顺序的逻辑都是不可靠的。以HashMap为例，假设我们放入"A"，"B"，"C"这3个key，遍历的时候，
 * 每个key会保证被遍历一次且仅遍历一次，但顺序完全没有保证，甚至对于不同的JDK版本，相同的代码遍历的输出顺序都是不同的！
 */
public class MyMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<> ();
        map.put ("apple", 123);
        map.put ("pear", 456);
        map.put ("banana", 789);

        for (String key : map.keySet ()) {
            System.out.println (key + "=" + map.get (key));
        }

        System.out.println ();
        for (Map.Entry<String, Integer> entry : map.entrySet ()) {
            System.out.println (entry);
        }

        System.out.println ();
        testTreeMap ();

        System.out.println ();
        testTreeMap2();
    }

    /**
     * 使用TreeMap时，放入的Key必须实现Comparable接口。
     * String、Integer这些类已经实现了Comparable接口，因此可以直接作为Key使用。作为Value的对象则没有任何要求。
     */
    public static void testTreeMap() {
        Map<Person, Integer> map = new TreeMap<> (new Comparator<Person> () {
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo (p2.name);
            }
        });
        map.put (new Person ("Tom"), 1);
        map.put (new Person ("Bob"), 2);
        map.put (new Person ("Lily"), 3);
        for (Person key : map.keySet ()) {
            System.out.println (key);
        }
        // {Person: Bob}, {Person: Lily}, {Person: Tom}
        System.out.println (map.get (new Person ("Bob"))); // 2
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
        }

        public String toString() {
            return "{Person: " + name + "}";
        }
    }

    /**
     * 我们来看一个稍微复杂的例子：这次我们定义了Student类，并用分数score进行排序，高分在前：
     * 在p1.score和p2.score不相等的时候，它的返回值是正确的，但是，在p1.score和p2.score相等的时候，
     * 它并没有返回0！这就是为什么TreeMap工作不正常的原因：TreeMap在比较两个Key是否相等时，
     * 依赖Key的compareTo()方法或者Comparator.compare()方法。在两个Key相等时，必须返回0
     */
    public static void testTreeMap2(){
        Map<Student, Integer> map = new TreeMap<> (new Comparator<Student> () {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.score > o2.score ? 1 : (o1 == o2) ? 0 : -1;
            }
        });
        map.put(new Student("Tom", 77), 1);
        map.put(new Student("Bob", 66), 2);
        map.put(new Student("Lily", 99), 3);
        for (Student key : map.keySet()) {
            System.out.println(key);
        }
    }

}


class Student {
    public String name;
    public int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return String.format ("{%s: score=%d}", name, score);
    }
}