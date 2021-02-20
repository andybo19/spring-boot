package com.example.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/20 11:10
 */
@Slf4j
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class CheckSQLInterceptor implements Interceptor {

    private static String SQL_WHERE = "where";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //获取方法的第0个参数，也就是MappedStatement。@Signature注解中的args中的顺序
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        //获取sql命令操作类型
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        final Object[] queryArgs = invocation.getArgs();
        final Object parameter = queryArgs[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        String sql = boundSql.getSql();
        if(SqlCommandType.DELETE.equals(sqlCommandType)){
            //格式化sql
            sql = sql.replace("\n", "");
            if(!sql.toLowerCase().contains(SQL_WHERE)){
                log.info("delete语句中没有where条件,sql:{}",sql);
                throw new Exception("删除语句中没有where条件");
            }
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
