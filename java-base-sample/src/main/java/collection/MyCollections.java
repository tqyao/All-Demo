package collection;

import java.util.*;

public class MyCollections {
    public static void main(String[] args) {

        //以下创建的集合都是不可变的,不支持add remove

        // 创建空集合
        List<Object> objects = Collections.emptyList ();
        Map<Object, Object> objectObjectMap = Collections.emptyMap ();
        Set<Object> objects1 = Collections.emptySet ();


        // 单元素
        List<Object> objects2 = Collections.singletonList ("single");
        Map<String, String> single = Collections.singletonMap ("1", "single");
        Set<String> set = Collections.singleton ("set");
//        set.add ("something");


    }

}
