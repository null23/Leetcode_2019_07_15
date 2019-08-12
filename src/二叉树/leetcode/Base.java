package 二叉树.leetcode;

/**
 * 多态
 * 静态内部类
 * 向上转型 向下转型
 * 子类隐藏父类
 */
public class Base {
    private String baseName = "base";

    public Base() {
        callName();
    }

    public void callName() {
        System.out.println("father callName");
        System.out.println(baseName);
        System.out.println("---------------------");
    }

    static class Sub extends Base{
        private String baseName = "sub";

        public void callName() {
            System.out.println("child callName");
            System.out.println(baseName);
            System.out.println("---------------------");
        }
    }

    public static void main(String[] args) {
        Base b = new Sub();
        System.out.println(b.baseName);
        System.out.println("---------------------");

        Sub s = new Base.Sub();
        System.out.println(s.baseName);
    }
}
