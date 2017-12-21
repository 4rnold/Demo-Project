# 配置ConversionService

```xml
    <mvc:annotation-driven conversion-service="conversionService"/>

   <!-- 用于覆盖<mvc:annotation-driven />中自带的ConversionService-->
    <bean id="conversionService"
          class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
        <property name="converters">
            <list>
                <bean class="com.arnold.databinder.ConversionService.converter.StringToUserConverter"/>
            </list>
        </property>
    </bean>

```

# 配置全局自定义编辑器
![](http://o8n1hrt12.bkt.clouddn.com/2017-12-08-22-58-57.png) 

#三种数据绑定优先级
1. @InitBinder
2. ConversionService
3. WebBindingInitializer

#Formatter
<mvc:annotation-driven/> 中自动注册的
FormattingConversionServiceFactoryBean中自动注册了
- NumberFormatAnnotationFormatterFactory   ->  @NumberFormat()
- JodaDateTimeFormatAnnotationFormatterFactory -> @DateTimeFormat()

