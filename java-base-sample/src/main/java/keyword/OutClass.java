package keyword;

/**
 * 内部类 <https://www.cnblogs.com/qdhxhz/p/11368870.html>
 *
 * 区别特点：
 *  1.静态内部类可以有静态成员(方法，属性)，而非静态内部类则不能有静态成员(方法，属性)。
 *   2.静态内部类只能够访问外部类的静态成员,而非静态内部类则可以访问外部类的所有成员(方法，属性)。
 *   3.实例化一个非静态的内部类的方法：
 *          a.先生成一个外部类对象实例
 *          OutClass outClass=new OutClass();
 *          b.通过外部类的对象实例生成内部类对象
 *          OutClass.InnerClass inner=outClass.new InnerClass();
 *   4.实例化一个静态内部类的方法：
 *          a.不依赖于外部类的实例,直接实例化内部类对象
 *          OutClass.InnerStaticClass inner=new OutClass.InnerStaticClass();
 *          b.调用内部静态类的方法或静态变量,通过类名直接调用
 *          OutClass.InnerStaticClass.static_sex
 *
 *   内部类的作用
 * 1、内部类能够提供更好的隐蔽性。因为我们的内部类是可以用private和protected修饰的，所以在必要的时候我们可以保证在其它类里是
 *
 * 无法创建当前内部类对象的。就好比我们常用的静态内部类的单例模式。
 *
 * 2、通过内部类可以实现多继承。
 *
 * 3、代码可以更加整洁。因为我们在创建实体类的时候,可能类中还包含其它类，如果这个类只会被当前类使用，那我们只需创建一个内部类就可以了。
 */
public class OutClass {
    /**
     * 外部类静态属性
     */
    private static String name = "小小";
    /**
     * 外部类非静态属性
     */
    private Integer age = 3;

    /**
     * @Description: 非静态内部类
     */
    private class InnerClass {
        // TODO 非静态内部类不能声明或定义静态成员
        // private static String sex = "女";
        /**
         * 这里定义静态常量是不会报错的哦
         */
        public static final String sex = "女";
        /**
         * 可以定义 普通属性
         */
        private int flag = 0;

        /**
         * 构造函数
         */
        public InnerClass() {
            // 非静态内部类的非静态成员可以访问外部类的非静态变量和静态变量
            System.out.println ("非静态类访问外部对象的name" + name);
            System.out.println ("外部对象的age " + age);
        }
    }

    /**
     * @Description: 静态内部类
     */
    private static class InnerStaticClass {
        /**
         * 静态内部类可以有静态成员和非静态成员
         */
        private static String sex = "女";
        private int flag = 0;

        public InnerStaticClass() {
            System.out.println ("静态类访问外部对象的name" + name);
            //静态类只能访问外部的静态成员，不能访问非静态成员
            //System.out.println("外部对象的age " + age);
        }
    }

    public static void main(String[] args) {
        System.out.println ("==========非静态内部类调用==========");
        //new一个外部类
        OutClass outClass = new OutClass ();
        // 通过外部类的对象new一个非静态的内部类
        OutClass.InnerClass innerClass = outClass.new InnerClass ();
        System.out.println ("==========静态内部类调用==========");
        //获取静态内部类的静态属性
        String sex = OutClass.InnerStaticClass.sex;
        //获取静态内部类的非静态属性
        OutClass.InnerStaticClass inner = new OutClass.InnerStaticClass ();
        System.out.println (inner.flag);

    }
}