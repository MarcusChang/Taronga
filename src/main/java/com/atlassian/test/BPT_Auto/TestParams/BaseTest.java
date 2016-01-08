package com.atlassian.test.BPT_Auto.TestParams;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Marcus_Chang on 2016/1/8.
 */
public class BaseTest {

    protected static ApplicationContext appContext;

    @BeforeClass
    public static void setUp() throws Exception {
        try {
            long start = System.currentTimeMillis();
            System.out.println("正在加载配置文件...");

            appContext = new ClassPathXmlApplicationContext("spring/spring-config.xml");//初始化spring 容器});
            System.out.println("配置文件加载完毕,耗时：" + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
