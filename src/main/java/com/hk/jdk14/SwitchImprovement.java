package com.hk.jdk14;


/**
 * Switch 改进
 * 在 JDK 12 与 JDK 13中为预览特性，在 JDK 14中正式确立
 */
public class SwitchImprovement {

    public static void main(String[] args) {
        jdk11();
        jdk12();
        jdk13();
    }

    /**
     * JDK 13 示例
     * 添加了 yield 关键字，yield 与 return 关键字一样，是将 switch 分支的值返回 给 switch 接收的变量
     */
    private static void jdk13() {
        Week week = Week.MONDAY;
        int result = switch (week) {
            case MONDAY -> 1;
            case TUESDAY, WEDNESDAY -> 2;
            case THURSDAY -> 4;
            case FRIDAY -> 5;
            case SATURDAY, SUNDAY -> {
                System.out.println("");
                yield 6;
            }
            default -> throw new RuntimeException();
        };
        System.out.println(result);


        // 也可以全部使用 yield 将结果返回给接受的值
        int result2 = switch (week) {
            case MONDAY:
                yield 1;
            case TUESDAY, WEDNESDAY:
                yield 2;
            case THURSDAY:
                yield 4;
            case FRIDAY:
                yield 5;
            case SATURDAY, SUNDAY: {
                System.out.println("周末到了");
                yield 6;
            }
            default:
                throw new RuntimeException();
        };
        System.out.println(result2);
    }

    /**
     * JDK 12 示例
     */
    private static void jdk12() {
        Week week = Week.MONDAY;
        int result;
        switch (week) {
            case MONDAY -> result = 1;
            case TUESDAY, WEDNESDAY -> result = 2;
            case THURSDAY -> result = 4;
            case FRIDAY -> result = 5;
            case SATURDAY, SUNDAY -> {
                System.out.println("周末");
                result = 6;
            }
            default -> throw new RuntimeException();
        }
        System.out.println(result);
        // 也可以直接返回 一个值
        int result2 = switch (week) {
            case MONDAY -> 1;
            case TUESDAY, WEDNESDAY -> 2;
            case THURSDAY -> 4;
            case FRIDAY -> 5;
            case SATURDAY, SUNDAY -> 6;
            default -> throw new RuntimeException();
        };
        System.out.println(result2);

    }

    /**
     * JDK 11 示例
     */
    private static void jdk11() {
        Week week = Week.MONDAY;
        int result;
        switch (week) {
            case MONDAY:
                result = 1;
                break;
            case TUESDAY:
                result = 2;
                break;
            case WEDNESDAY:
                result = 3;
                break;
            case THURSDAY:
                result = 4;
                break;
            case FRIDAY:
                result = 5;
                break;
            case SATURDAY:
                result = 6;
                break;
            case SUNDAY:
                result = 7;
                break;
            default:
                throw new RuntimeException();
        }
        System.out.println(result);

    }

    public enum Week {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }
}
