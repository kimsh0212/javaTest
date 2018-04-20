package com.ksh.apimanage.repository;

import com.ksh.apimanage.model.ApiData;
import com.ksh.config.DBRoute;
import com.ksh.config.RoutingBaseSqlSessionRepository;
import com.ksh.config.SqlSessionTemplateType;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@DBRoute(SqlSessionTemplateType.KSH)
@Repository
public class ApiManageRepository extends RoutingBaseSqlSessionRepository {
    @Override
    protected String getSqlMapperPrefix() {return "apiInfo.";}

    public int apiAddInsert(Map<String,Object> params) throws Exception{
        return insert("insertApiList",params);
    }

    public List<ApiData> selectAptList() throws Exception{
        return selectList("selectApiList");
    }
}
