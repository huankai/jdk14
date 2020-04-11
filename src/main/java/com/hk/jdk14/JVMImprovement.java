package com.hk.jdk14;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM 改进
 * <p>
 * 1、弃用 ParallelScavenge 和 SerialOld GC 组合
 *      -XX:+UseParallelGC -XX:-UseParallelOldGC
 *      如果在 JDK 14中使用了 上面的参数，会给出一个警告信息.
 * 2、删除 CMS 垃圾回收器
 *      自从 G1(基于Regin) 分代横空出世后，CMS 在 JDK9 中就已经标记为过时了，
 *      CMS 垃圾回收器的弊端:
 *          -  会产生内存碎片，导致并发清除后，用户线程可用的空间不足；
 *          -  既然强调了并发，CMS 收集器对CPU资源非常敏感
 *          -  CMS 无法处理浮动垃圾
 *      上述的这些问题，尤其是碎片问题，给JVM实例就像是埋下一个定时炸弹，
 *      说不定在哪次义务高峰来一次FGC,当CMS 停止工作时，会把 Serial Old GC 作为备选方
 *      ，而 Serial Old GC 是JVM 中性能最差的垃圾回收方式，停顿几秒，几十秒都会有可能。
 *
 *  移除了 CMS 垃圾回收器后，如果在 JDK 14中使用了 -XX:+UseConcMarkSweepGC，JVM不会报错，只是给出一个警告信息.
 *
 * 3、ZGC 垃圾回收器(低延迟)
 *      在 JDK 11引入了 ZGC 垃圾回收器，Open JDK 12中引入了 Shenandoah 垃圾回收器，
 *      这两个主要特点是 低延迟 的垃圾回收器，但 Shenandoah 不是Oracle官网发布的，
 *      受到一定的排挤，所以以后也不会成为主流的垃圾回收器。
 *
 *     ZGC 与 Shenandoah 高度相似，都是在尽可能对吞吐量不大的前提下，实现在任意堆内存下都可以把垃圾回收集的停顿时间限制在10毫秒以内的低延迟。
 *
 *     虽然ZGC现在还处于实验阶段，但此时的性能已相当亮眼，将会是未来在服务端、大内存、低延迟应用的首选垃圾回收器.
 *
 *      要使用 ZGC ，需要先解锁实验的参数，如下:
 *          -XX:+UnlockExperimentalVMOptions -XX:+UseZGC
 */
public class JVMImprovement {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        while (true) {
            list.add(new byte[100]);
        }
    }
}
