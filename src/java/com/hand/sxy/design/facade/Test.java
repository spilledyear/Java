package com.hand.sxy.design.facade;

/**
 * Created by spilledyear on 2017/9/6.
 *
 * 外观模式
 *
 * 我自己的理解：对细节的一种封装
 * 外观模式是为了解决类与类之家的依赖关系的，像spring一样，可以将类和类之间的关系配置到配置文件中，而外观模式就是将他们的关系放在一个Facade类中，
 * 降低了类类之间的耦合度，该模式中没有涉及到接口
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
