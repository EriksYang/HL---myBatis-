package cn.hl.util;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.hl.vo.User;

/**
 * 公共的父类
 * @author Terry
 *
 */
public abstract class BaseDao {
	//声明SqlSession对象
	SqlSession session = null;
			
	/**
	 * 调用插入映射
	 * @param mapper ：映射名
	 * @return		   ：受影响行数
	 */
	protected <T> int insert(String mapper){
		return insert(mapper,null);
	}
	
	/**
	 * 调用插入映射
	 * @param mapper ：映射名
	 * @param t		   ：实体类对象
	 * @return		   ：受影响行数
	 */
	protected <T> int insert(String mapper,T t){
		try {
			//获取SqlSession对象
			session = SessionFactory.create();
			if(t == null)
				return session.insert(mapper);
			else
				return session.insert(mapper, t);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally{
			session.close();
		}
	}
	
	/**
	 * 调用修改映射
	 * @param mapper ：映射名
	 * @return		   ：受影响行数
	 */
	protected <T> int update(String mapper){
		return update(mapper,null);
	}
	
	/**
	 * 调用修改映射
	 * @param mapper ：映射名
	 * @param t		   ：实体类对象
	 * @return		   ：受影响行数
	 */
	protected <T> int update(String mapper,T t){
		try {
			//获取SqlSession对象
			session = SessionFactory.create();
			if(t == null)
				return session.update(mapper);
			else
				return session.update(mapper, t);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally{
			session.close();
		}
	}
	
	/**
	 * 调用插入映射
	 * @param mapper ：映射名
	 * @return		   ：受影响行数
	 */
	protected <T> int delete(String mapper){
		return update(mapper,null);
	}
	
	/**
	 * 调用插入映射
	 * @param mapper ：映射名
	 * @param t		   ：实体类对象
	 * @return		   ：受影响行数
	 */
	protected <T> int delete(String mapper,T t){
		try {
			//获取SqlSession对象
			session = SessionFactory.create();
			if(t == null)
				return session.update(mapper);
			else
				return session.update(mapper, t);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally{
			session.close();
		}
	}
	
	/**
	 * 查询一条数据
	 * @param mapper：映射名
	 * @return		：查询结果对象
	 */
	protected<T> T selectOne(String mapper){
		return selectOne(mapper,null);
	}
	
	/**
	 * 查询一条数据
	 * @param mapper：映射名
	 * @param t		：实体类对象
	 * @return		：查询结果对象
	 */
	protected<T> T selectOne(String mapper,T t){
		
		try {
			//获取SqlSession对象
			session = SessionFactory.create();
			
			//根据t执行查询
			if(t == null)
				return session.selectOne(mapper);
			else
				return session.selectOne(mapper, t);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally{
			session.close();
		}
	}
	
	/**
	 * 查询一条数据
	 * @param mapper：映射名
	 * @return		：查询结果对象
	 */
	protected<T> List<T> selectList(String mapper){
		return selectList(mapper,null);
	}
	
	/**
	 * 查询一条数据
	 * @param mapper：映射名
	 * @param t		：实体类对象
	 * @return		：查询结果对象
	 */
	protected<T> List<T> selectList(String mapper,T t){
		
		try {
			//获取SqlSession对象
			session = SessionFactory.create();
			
			//根据t执行查询
			if(t == null)
				return session.selectList(mapper);
			else
				return session.selectList(mapper, t);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally{
			session.close();
		}
	}
}
