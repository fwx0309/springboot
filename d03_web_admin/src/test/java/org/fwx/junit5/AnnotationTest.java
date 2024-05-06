package org.fwx.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @ClassName AnnotationTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/5/6 9:32
 * @Version 1.0
 */
/**
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith(SpringExtension.class)
 */
//@SpringBootTest
public class AnnotationTest {

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    @Tag("JUnit5单元")
    @RepeatedTest(2)    // 重复执行
    @DisplayName("测试1")
    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Disabled
    @DisplayName("测试2")
    @Timeout(value = 2l, unit = TimeUnit.SECONDS)
    @Test
    public void test2() throws InterruptedException {
        System.out.println("test2");
        Thread.sleep(3000);
//        System.out.println("stringRedisTemplate = " + stringRedisTemplate);
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("每个方法执行之前");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("每个方法执行之后");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("所有方法执行之前");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("所有方法执行之后");
    }


    @Test
    public void simpleAsert(){
        Assertions.assertTrue(true);
        Assertions.assertFalse(false);
        Assertions.assertEquals(1,1);
        Assertions.assertNotEquals(1,2);
        Assertions.assertNull(null);
        Assertions.assertNotNull(1);
        Assertions.assertSame(1,1);
        Assertions.assertNotSame(1,2);
        Assertions.assertArrayEquals(new int[]{1,2},new int[]{1,2});
        Assertions.assertThrows(ArithmeticException.class, () -> {int i = 10/0;}, "10/0");
        Assertions.assertArrayEquals(new int[]{1, 2}, new int[]{1, 2}, "数组内容不相等");
        /**
         * 所有断言全部需要成功
         */
        Assertions.assertAll("test",
                () ->  Assertions.assertTrue(true && true, "结果不为true"),
                () ->  Assertions.assertEquals(1, 2, "结果不是1"));
    }

    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4,5})
    void testParameterized(int i){
        System.out.println(i);
    }


    @ParameterizedTest
    @DisplayName("参数化测试")
    @MethodSource("stringProvider")
    void testParameterized2(String i){
        System.out.println(i);
    }


    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana","atguigu");
    }
}
