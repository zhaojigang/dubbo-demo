package test;

/**
 * Error
 */
public class TestError {
    public static void main(String[] args) {
        testStackOverFlow();
//        testOOM1();
//        testOOM2();
    }

    /**
     * java.lang.StackOverflowError
     * 栈深度满了
     */
    private static void testStackOverFlow() {
        testStackOverFlow();
    }

    /**
     * java.lang.OutOfMemoryError: Java heap space
     * 堆满了
     */
    private static void testOOM1() {
        // 前提：-Xms10m -Xmx10m
        // 创建一个 80m 的对象
        byte[] bytes = new byte[20 * 1024 * 1024];
    }

    /**
     *
     */
    private static void testOOM2() {
    }
}
