package com.zto.sxy.jvm.gc;

/**
 * Created by brian on 17/3/2.
 * 引用计数算法缺陷
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    // -Xms20M -Xmx20 -Xmn4M -XX:NewRatio4 -XX:SurvivorRatio4 -XX:+UseSerialGC -XX:+PrintGC -XX:+PrintGCDetails -Xloggc:gc.log -Xss128k -XX:MaxGCPauseMills

    /**
     * 占点内存,以便  GC 日志观看
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        testGC();
    }

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}
