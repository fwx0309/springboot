package org.fwx;

/**
 * @ClassName ClassTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/25 7:44
 * @Version 1.0
 */
public class ClassTest {
    public static void main(String[] args) {
        Class<ClassTest> aClass = ClassTest.class;
        // 判断ClassTest类是否是ClassTest类的子类
        boolean assignableFrom = aClass.isAssignableFrom(ClassTest.class);
        System.out.println(assignableFrom);
    }
}
