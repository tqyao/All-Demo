package collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 如果不调用List的contains()、indexOf()这些方法，那么放入的元素就不需要实现equals()方法。
 */
public class Demo1 {
    public static void main(String[] args) {
        List list1 = Arrays.asList (11, 22, 33, 44); // 生成List容器
        System.out.println (Arrays.toString (list1.toArray ())); // List 容器转数组 一
        System.out.println (Arrays.toString (list1.toArray (new Object[0]))); // List 转数组  二

        Person p1 = new Person ("zhangsan", 3);
        Person p2 = new Person ("lisi", 44);

        List<Person> list2 = Arrays.asList (
                new Person ("zhangsan", 3),
                p2
        );

        System.out.println (list2.contains (p2));
        System.out.println (list2.contains (p1));


        /********************************************************/


        List<Integer> l3 = Arrays.asList (11, 222, 33, 4, 55);
        l3.sort (Integer::compareTo);
        System.out.println (l3);
    }

    static class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass () != o.getClass ()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals (name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash (name, age);
        }
    }
}
