package com.ksh.url.repository;

import com.ksh.config.DBRoute;
import com.ksh.config.RoutingBaseSqlSessionRepository;
import com.ksh.config.SqlSessionTemplateType;
import com.ksh.url.model.Url;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@DBRoute(SqlSessionTemplateType.KSH)
@Repository
public class UrlRepository  extends RoutingBaseSqlSessionRepository {
    @Override
    protected String getSqlMapperPrefix() {return "url.";}

    public List<Url> selectUserUrlList(Map<String, Object> params ){
        return selectList("selectUserUrlList",params);
    }
}
