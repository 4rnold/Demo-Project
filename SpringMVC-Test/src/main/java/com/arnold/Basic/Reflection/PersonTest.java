package com.arnold.Basic.Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

import org.apache.commons.lang3.StringUtils;

/**
 * 反射测试
 * @author 菠萝大象
 */
public class PersonTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> c = Person.class;
		parseClass(c);
		//获取方法
		for(Method m : c.getDeclaredMethods()){
			System.out.printf("%4s"," ");
			parseMethod(m);
		}
		System.out.println("}");
	}
	
	static void parseClass(Class<?> c){
		//“public”
		System.out.print(Modifier.toString(c.getModifiers()));
		System.out.print(" class ");
		//类名“Persion”
		System.out.print(c.getSimpleName());
		//c.getTypeParameters()类型数组，<T,ke>
		parseTypeParameters(c.getTypeParameters(),"<",",",">",true);
		Type t = c.getGenericSuperclass();
		if(t != null){
			System.out.print(" extends ");
			parseTypeParameter(t, false);
		}
		parseTypeParameters(c.getGenericInterfaces()," implements ",",","",false);
		System.out.println(" {");
	}
	
	private static void parseTypeParameters(Type[] type, String pre, String sep, String suf, boolean isRec){
		if(type.length > 0) {
			// 对于没有显示定义上限的类型变量，不显示extends
			if(!(type.length == 1 && StringUtils.equals(type[0].toString(), "class java.lang.Object"))){
				System.out.print(pre);
			}
		}
		for (int i = 0; i < type.length; i++) {
			if (i > 0)
				System.out.print(sep);
			// System.out.print(type[i]); // 直接输出T和K
			parseTypeParameter(type[i], isRec);
		}
		if(type.length > 0) System.out.print(suf);
	}
	
	private static void parseTypeParameter(Type type, boolean isRec){
		if(type instanceof Class){
			Class<?> c = (Class<?>) type;
			// 如果没有显示定义上限，会由TypeVariable的getBounds()方法得到默认的上限java.lang.Object
			// 为了保证打印出的代码与原始的代码格式一致，所有Object都不打印出来
			// 此处与parseTypeParameters方法的41-43行代码对应
			// 如果不加这两个判断，所有没有显示定义的类型变量都将输出extends Object
			// 比如T extends Object，Comparable<? extends Object super T>等等
			if(!StringUtils.equals(c.getSimpleName(), "Object"))
				System.out.print(c.getSimpleName());
		} else if(type instanceof TypeVariable){
			TypeVariable<?> tv = (TypeVariable<?>)type;
			System.out.print(tv.getName());
			if(isRec) parseTypeParameters(tv.getBounds(), " extends ", " & ", "", false);
		} else if(type instanceof WildcardType){
			WildcardType wt = (WildcardType)type;
			System.out.print("?");
			parseTypeParameters(wt.getUpperBounds(), " extends ", " & ", "", false);
			parseTypeParameters(wt.getLowerBounds(), " super ", " & ", "", false);
		} else if(type instanceof ParameterizedType){
			ParameterizedType pt = (ParameterizedType)type;
			Type t = pt.getOwnerType();
			if(t != null) {
				parseTypeParameter(t, false);
				System.out.print(".");
			}
			parseTypeParameter(pt.getRawType(), false);
			parseTypeParameters(pt.getActualTypeArguments(), "<", " , ", ">", false);
		}
	}
	
	public static void parseMethod(Method m){
		System.out.print(Modifier.toString(m.getModifiers()));
		System.out.print(" ");
		parseTypeParameters(m.getTypeParameters(), "<", " , ", "> ", true);
		parseTypeParameter(m.getGenericReturnType(),false);
		System.out.print(" ");
		System.out.print(m.getName());
		System.out.print("(");
		parseTypeParameters(m.getGenericParameterTypes(), "", ",", "", false);
		System.out.println(")");
	}
}
