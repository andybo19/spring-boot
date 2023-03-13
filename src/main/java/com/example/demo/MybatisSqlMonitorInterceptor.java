package com.example.demo;


import com.alibaba.druid.support.json.JSONUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.jdbc.PreparedStatementLogger;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author guoming
 * @date 2020/01/31
 */
@Component
@Intercepts({@Signature(type = StatementHandler.class, method = "query", args = {
    Statement.class, ResultHandler.class}),
    @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
    @Signature(type = StatementHandler.class, method = "batch", args = {Statement.class})})
public class MybatisSqlMonitorInterceptor implements Interceptor, Ordered {
    private static final Logger LOGGER = LoggerFactory.getLogger("sql_log");
    private Configuration configuration = null;



    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        long startTime = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {

 /*               long endTime = System.currentTimeMillis();
                long sqlCost = endTime - startTime;

                StatementHandler statementHandler = (StatementHandler)target;
                BoundSql boundSql = statementHandler.getBoundSql();

               *//* if (configuration == null) {
                    final DefaultParameterHandler parameterHandler = (DefaultParameterHandler)statementHandler
                        .getParameterHandler();
                    Field configurationField = ReflectionUtils.findField(parameterHandler.getClass(), "configuration");
                    ReflectionUtils.makeAccessible(configurationField);
                    this.configuration = (Configuration)configurationField.get(parameterHandler);
                }*//*
                MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                    SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
                MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
                String sqlId = mappedStatement.getId();
                //替换参数格式化Sql语句，去除换行符
                String sql = getSql(boundSql, mappedStatement.getConfiguration());
                LOGGER.info("traceId:{},Method:{},SQL:{},sqlCost:{}", "ceshi", sqlId, sql, sqlCost);
                System.out.println("sql:"+sql);
                System.out.println("++++++++++++++++++++++++++++++"+sql);*/
            Object proxy = invocation.getArgs()[0];
            Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
            h.setAccessible(true);
            PreparedStatementLogger preparedStatementLogger = (PreparedStatementLogger) h.get(proxy);

            String oriStr = preparedStatementLogger.getPreparedStatement().toString();
            String finalSql = oriStr.substring(oriStr.toString().indexOf(":") + 1);
            System.out.println("-------------------------------"+oriStr);
            System.out.println("sql:"+finalSql);
            System.out.println("++++++++++++++++++++++++++++++"+finalSql);


            /*PreparedStatementLogger preparedStatementLogger = (PreparedStatementLogger) invocation.getArgs()[0];
            PreparedStatement statement = preparedStatementLogger.getPreparedStatement();
            String oriStr = statement.toString();
            String sql = statement.toString().substring(statement.toString().indexOf(":") + 1);
            System.out.println("-------------------------------"+oriStr);
            System.out.println("sql:"+sql);
            System.out.println("++++++++++++++++++++++++++++++"+sql);*/

        }
    }


    /**
     * 获取完整的sql实体的信息
     *
     * @param boundSql
     * @return
     */
    private String getSql(BoundSql boundSql, Configuration configuration) {
        String sql = boundSql.getSql();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        Object parameterObject = boundSql.getParameterObject();
        // 输入sql字符串空判断
        if (StringUtils.isEmpty(sql) || configuration == null) {
            return "";
        }

        TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();

        // 格式化
        sql = sql.replaceAll("[\\s\n ]+", " ");
        /**
         * @see DefaultParameterHandler 参考Mybatis 参数处理
         */
        if (parameterMappings != null) {
            for (ParameterMapping parameterMapping : parameterMappings) {
                if (parameterMapping.getMode() != ParameterMode.OUT) {
                    Object value;
                    String propertyName = parameterMapping.getProperty();
                    if (boundSql.hasAdditionalParameter(propertyName)) {
                        value = boundSql.getAdditionalParameter(propertyName);
                    } else if (parameterObject == null) {
                        value = null;
                    } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                        value = parameterObject;
                    } else {
                        MetaObject metaObject = configuration.newMetaObject(parameterObject);
                        value = metaObject.getValue(propertyName);
                    }
                    String paramValueStr = "";
                    if (value instanceof String) {
                        paramValueStr = "'" + value + "'";
                    } else if (value instanceof Date) {
                        paramValueStr = value + "";
                    } else {
                        paramValueStr = value + "";
                    }
                    sql = sql.replaceFirst("\\?", paramValueStr);
                }
            }
        }
        return sql;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }


    public static void main(String[] args) {
/*        String str = "WITH summary AS (\\n        SELECT city_id,city_id as code,\\n         \\n        \\n        SUM(box_office) AS box_office,\\n        \\n        SUM(box_office_nsf) AS box_office_nsf,\\n        \\n        SUM(schedule) AS schedule_cnt,\\n        \\n        SUM(seat_cnt) AS seat_cnt,\\n        \\n        SUM(sold_seat_cnt) AS sold_seat_cnt,\\n        \\n        SUM(hall_cnt) as hall_cnt_online\\n     \\n        FROM gw_ads_cinema_boxoffice_day as boxoffice\\n         \\n         WHERE boxoffice.del_flag=1\\n            \\n                and (\\n                (boxoffice.show_date >= 20221214\\n                                and boxoffice.show_date <= 20221214))\\n            \\n            \\n        \\n            AND boxoffice.city_id IN\\n            (\\n                28\\n            ,\\n                28\\n            ,\\n                3\\n            ,\\n                1\\n            ,\\n                1\\n            ,\\n                1\\n            ,\\n                1\\n            ,\\n                28\\n            )\\n        \\n        \\n            AND boxoffice.city_level IN\\n            (\\n                -1\\n            )\\n        \\n        \\n    \\n            \\n            \\n        \\n        \\n        \\n    \\n            \\n                    \\n        \\n    \\n                \\n            \\n            \\n        AND (\\n        \\n                1 = 1\\n            \\n        AND\\n        \\n                1 = 1\\n            \\n        ) \\n     \\n        GROUP BY city_id\\n        )\\n\\n        SELECT\\n        summary.city_id as cityId,\\n         \\n         \\n                \\n                summary.box_office as cinemaBoxOffice,\\n             \\n        summary.code,\\n        summary.schedule_cnt as cinemaScheduleCnt,\\n        summary.seat_cnt as cinemaSeatCnt,\\n        summary.sold_seat_cnt as cinemaSoldSeatCnt\\n     \\n        FROM summary";
        String replace = str.replaceAll("( )+", " ");
        replace.replaceAll("(\\n)+", " ");
        System.out.println("+++++++++++"+replace);*/
      List<Integer> list = Lists.newArrayList(1,2,3,4);
        List<Integer> list1 = list.subList(1, list.size());
        System.out.println(JSONUtils.toJSONString(list1));
    }
}
