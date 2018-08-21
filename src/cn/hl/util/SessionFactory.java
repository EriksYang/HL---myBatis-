package cn.hl.util;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

/**
 * 提供创建SqlSession的相关方法
 * @author Terry
 *
 */
public class SessionFactory {
	/**
	 * 返回SqlSession对象
	 * @return
	 * @throws IOException 
	 */
	public static SqlSession create() throws IOException{
		return FactoryBuilder.build().openSession(true);
	} 
	
	/**
	 * 返回SQLSession对象
	 * @param mode
	 * @return
	 * @throws IOException 
	 */
	public static SqlSession create(boolean mode) throws IOException{
		return FactoryBuilder.build().openSession(mode);
	}
}
