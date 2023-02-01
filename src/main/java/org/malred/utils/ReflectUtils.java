package org.malred.utils;

import org.malred.annotations.iAutowired;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 反射工具库
 *
 * @author malguy-wang sir
 * @create 2023-02-01-18:21
 */
public class ReflectUtils {
    /**
     * 缓存扫描到的类的全限定类名
     */
    public static List<String> classNames = new ArrayList<String>();

    /**
     * 扫描指定目录下的所有class文件,并保存其全类名
     * eg: scanPackage: org.malred.demo -> 磁盘上的文件夹(File)
     *
     * @param scanPackage 指定扫描目录
     */
    public static void doScan(String scanPackage) {
        try {
            // 如果在这里用,扫描到的是这里的目录,而不是调用方的目录
            String scanPackagePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + scanPackage.replaceAll("\\.", "/");
//            String scanPackagePath = basePath + scanPackage.replaceAll("\\.", "/");
            File pack = new File(scanPackagePath);
            File[] files = pack.listFiles();
            for (File file : files) {
                // 如果是包,要扫描包下的文件
                if (file.isDirectory()) {
                    // 递归
                    doScan(scanPackage + "." + file.getName()); // org.malred.demo.controller
                } else if (file.getName().endsWith(".class")) {
                    // 如果是java类,就获取全类名
                    String className =
                            scanPackage + "." + file.getName().replaceAll(".class", "");
                    classNames.add(className);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 传入类,配置文件对象,配置文件名称,加载配置文件
     *
     * @param clazz      调用该方法的类
     * @param properties 接收内容的对象
     * @param name       配置文件名称
     */
    public static void doLoadConfig(Class<?> clazz, Properties properties, String name) {
        // 加载资源流,从中读取配置文件
        InputStream resourceAsStream = clazz.getClassLoader().getResourceAsStream(name);
        try {
            properties.load(resourceAsStream);// 加载
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 依赖注入
     *
     * @param ioc dog容器,存放id和对应的类实例
     */
    public static void doAutowired(Map<String, Object> ioc) {
        if (ioc.isEmpty()) {
            return;
        }
        // 有对象再进行依赖注入
        // 遍历ioc中所有对象,如果有autowired注解,就注入
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            // 获取bean对象中的字段信息
            Field[] declaredFields = entry.getValue().getClass().getDeclaredFields();
            // 遍历
            for (int i = 0; i < declaredFields.length; i++) {
                Field declaredField = declaredFields[i];
                if (!declaredField.isAnnotationPresent(iAutowired.class)) {
                    continue;
                }
                // 有autowired注解
                iAutowired annotation = declaredField.getAnnotation(iAutowired.class);
                String beanName = annotation.value(); // 需要注入的bean的id
                if ("".equals(beanName.trim())) {
                    // 如果没有指定要注入的bean,就根据当前字段类型注入(接口注入)
                    beanName = declaredField.getType().getName();
                }
                // 赋值
                declaredField.setAccessible(true); // 强制访问
                try {
                    // set(当前字段或其所在类的全类名,值)
                    // ioc.get(beanName) beanName是要注入的bean的id
                    declaredField.set(entry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
