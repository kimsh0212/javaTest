package com.ksh.config;

import com.ksh.config.factory.SqlSessionTemplateDatabaseFactory;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author becko
 * 
 */
public abstract class RoutingBaseSqlSessionRepository {
	@Autowired
	public SqlSessionTemplateDatabaseFactory sqlSessionTemplateDatabaseFactory;
	
	/**
	 * Gets the sql map id.
	 *
	 * @return the sql map id
	 */
	protected abstract String getSqlMapperPrefix();
	
	private SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplateDatabaseFactory.getSqlSessionTemplate(SqlSessionTemplateTypeContextHolder.getSqlSessionTemplateTypeId());
	}
	
	public <T> T selectOne(String statement) {
		return getSqlSessionTemplate().selectOne(getSqlMapperPrefix() + statement);
	}
	
	public <T> T selectOne(String statement, Object parameter) {
		return getSqlSessionTemplate().selectOne(getSqlMapperPrefix() + statement, parameter);
	}
	
	public <E> List<E> selectList(String statement) {
		return getSqlSessionTemplate().selectList(getSqlMapperPrefix() + statement);
	}
	
	public <E> List<E> selectList(String statement, Object parameter) {
		return getSqlSessionTemplate().selectList(getSqlMapperPrefix() + statement, parameter);
	}

	public int insert(String statement) throws Exception {
		return getSqlSessionTemplate().insert(getSqlMapperPrefix() + statement);
	}
	
	public int insert(String statement, Object parameter) throws Exception {
		return getSqlSessionTemplate().insert(getSqlMapperPrefix() + statement, parameter);
	}
	
	protected int delete(String statement) {
		return getSqlSessionTemplate().delete(getSqlMapperPrefix() + statement);
	}

	public int delete(String statement, Object parameter) throws Exception {
		return getSqlSessionTemplate().delete(getSqlMapperPrefix() + statement, parameter);
	}
	
	public int update(String statement) throws Exception {
		return getSqlSessionTemplate().update(getSqlMapperPrefix() + statement, null);
	}
	
	public int update(String statement, Object parameter) {
		return getSqlSessionTemplate().update(getSqlMapperPrefix() + statement, parameter);
	}
	
	/**
	 * Select map.
	 *
	 * @param <K> the key type
	 * @param <V> the value type
	 * @param statement the statement
	 * @param mapKey the map key
	 * @return the map
	 */
	protected <K, V> Map<K, V> selectMap(String statement, String mapKey) {
		return getSqlSessionTemplate().selectMap(getSqlMapperPrefix() + statement, mapKey);
	}

	/**
	 * Select map.
	 *
	 * @param <K> the key type
	 * @param <V> the value type
	 * @param statement the statement
	 * @param parameter the parameter
	 * @param mapKey the map key
	 * @return the map
	 */
	protected <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
		return getSqlSessionTemplate().selectMap(getSqlMapperPrefix() + statement, parameter, mapKey);
	}

	/**
	 * Select map.
	 *
	 * @param <K> the key type
	 * @param <V> the value type
	 * @param statement the statement
	 * @param parameter the parameter
	 * @param mapKey the map key
	 * @param rowBounds the row bounds
	 * @return the map
	 */
	protected <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
		return getSqlSessionTemplate().selectMap(getSqlMapperPrefix() + statement, parameter, mapKey, rowBounds);
	}
}