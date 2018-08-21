package cn.hl.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 提供用于获取SQLSessionFactory对象的方法
 * 单例模式实现
 * @author Terry
 *
 */
public class FactoryBuilder {
	//存储配置文件的信息
	private static String res = "conf.xml";
	//1、静态SqlSessionFactory对象
	private static SqlSessionFactory fac = null;
	
	/**
	 * 构建SqlSessionFactory对象
	 * @return
	 * @throws IOException
	 */
	public static SqlSessionFactory build() throws IOException{
		if(fac== null){
			synchronized(FactoryBuilder.class){
				Reader reader = Resources.getResourceAsReader(res);
				fac = new SqlSessionFactoryBuilder().build(reader);
			}
		}
		
		return fac;
	}
	
}
