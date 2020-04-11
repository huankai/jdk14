package com.hk.jdk14;

/**
 * Record 增强:
 * Record 声明的类，可以减少属性的 get/set 方法，
 * 使用 Record 注意事项:
 * 1、record 声明的类不能使用 extends 继承某个父类，因为 record 声明的类默认 extends {@link Record} 了
 * 2、record 声明的类不能是 abstract(抽象类),因为 record 声明的类为 final类，final 与 abstract 水火不容.
 * 3、 record 声明的类中不能再定义其它非静态属性，因为 record 声明的类有个固定的构造函数，且该构造函数所有的参数对应的属性都是 final 类型.
 * 4、record 声明的类可以定义静态函数、非静态函数 静态属性。
 * 5、record 声明的类可以定义其它构造函数.
 * 6、record 声明的类重写了 toString 、hashCode 、equals 方法
 */
public class RecordsEnhance {

    /**
     * 定义 Record 对象
     */
    public record Student(String id, String name) {

        public Student() {
            this("1", DEFAULT_NAME);
        }

        //不允许声明非静态成员属性
//        private String age;

        private static final String DEFAULT_NAME = "defaultName";


        public static String getDefaultName() {
            return DEFAULT_NAME;
        }

        public String method1() {
            return "method1";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Student());
        System.out.println(new Student().hashCode());
        System.out.println(new Student().hashCode());
        System.out.println(new Student().equals(new Student()));
    }
}
