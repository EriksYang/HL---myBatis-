package cn.hl.dao;

import java.util.List;

import cn.hl.util.BaseDao;
import cn.hl.vo.Recive;

public class ReciveDao  extends BaseDao{
	/**
	 * 执行批量添加
	 * @param recive
	 * @return
	 */
	public int add(List<Recive> recive){	
		return this.insert("cn.hl.vo.Recive.addReciver", recive);
	}
}
