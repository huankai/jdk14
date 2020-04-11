package com.hk.jdk14;

/**
 * instanceof 改进
 */
public class InstanceofImprovement {

    public static void main(String[] args) {
        instanceofJDk11(1);
        instanceofJDk11("Hello Jdk11");
        System.out.println("---------------");
        instanceofJDk14(1);
        instanceofJDk14("Hello ");
    }

    /**
     * JDK 11写法
     */
    private static void instanceofJDk11(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj; // 要强制转换一次
            System.out.println("obj 是字符串 :" + str);
        } else {
            System.out.println("obj 不是字符串");
        }
    }

    /**
     * JDK 14 写法
     */
    private static void instanceofJDk14(Object obj) {
        if (obj instanceof String str) {
            System.out.println("obj 是字符串 :" + str);
        } else {
            System.out.println("obj 不是字符串");
        }
        // instanceof 也可以在三元运算符中使用
        String result = obj instanceof String str && str.isEmpty() ? "empty" : "not Empty";

//        下面这种情况使用 || 是错误的语法
//        String result2 = obj instanceof String str || str.isEmpty() ? "empty" : "not Empty";

        System.out.println("result:" + result);
    }
}
