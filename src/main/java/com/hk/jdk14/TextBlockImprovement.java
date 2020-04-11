package com.hk.jdk14;


/**
 * 文本块 改进
 * <p>
 * 可以使用 三个 """ 定义文本块，可读性更强
 * 注意:
 * 1、每一行会多一个换行符 ,会导致文本块的长度增加，可以使用 \ 来过滤
 * 2、可以使用 \s 转义空格
 */
public class TextBlockImprovement {

    public static void main(String[] args) {
        String text = """
                Hello 
                world
                """;
        System.out.println(text.length());// 12
        String text2 = """
                Hello 
                world\
                """;
        System.out.println(text2.length()); //11
        // 使用 \s 转义为 空格如下:
        String sql = """
                SELECT * FROM\s\
                T_USER\s\
                WHERE ID = ?\
                """;
        System.out.println(sql); // SELECT * FROM T_USER WHERE ID = ?
    }
}
