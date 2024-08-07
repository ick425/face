package com.github.face.utils;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.util.Map;

/**
 * 动态代理类
 *
 * @author wangcl
 */
public class DynamicBean {

    /**
     * 目标对象
     */
    private final Object target;

    /**
     * 属性集合
     */
    private final BeanMap beanMap;

    public DynamicBean(Class<?> superclass, Map<String, Class<?>> propertyMap) {
        this.target = generateBean(superclass, propertyMap);
        this.beanMap = BeanMap.create(this.target);
    }


    /**
     * bean 添加属性和值
     *
     * @param property 属性名
     * @param value    属性值
     */
    public void setValue(String property, Object value) {
        beanMap.put(property, value);
    }

    /**
     * 获取属性值
     *
     * @param property 属性名
     * @return 属性名对应的值
     */
    public Object getValue(String property) {
        return beanMap.get(property);
    }

    /**
     * 获取对象
     *
     * @return
     */
    public Object getTarget() {
        return this.target;
    }


    /**
     * 根据属性生成对象
     *
     * @param superclass  class类型
     * @param propertyMap 要生成的map对象
     * @return 生成的对象
     */
    private Object generateBean(Class<?> superclass, Map<String, Class<?>> propertyMap) {
        BeanGenerator generator = new BeanGenerator();

        if (null != superclass) {
            generator.setSuperclass(superclass);
        }
        BeanGenerator.addProperties(generator, propertyMap);
        return generator.create();
    }
}


