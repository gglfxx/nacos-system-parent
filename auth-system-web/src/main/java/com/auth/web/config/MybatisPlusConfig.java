package com.auth.web.config;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * mybatis-plus 配置分页
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.auth.web.dao")
public class MybatisPlusConfig {

	    /**
	     *   mybatis-plus分页插件
	     */
	@Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List<ISqlParser> sqlParserList = new ArrayList<>();
        // 攻击 SQL 阻断解析器、加入解析链 作用！阻止恶意的全表更新删除
        sqlParserList.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParserList);
        paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {
			@Override
			public boolean doFilter(MetaObject metaObject) {
				 BoundSql  boundSql = (BoundSql) metaObject.getValue("boundSql");
		         String sql = boundSql.getSql().replaceAll("\\s+", " ").toLowerCase();
		         //针对oracle获取下一个序列处理方式
		         return StringUtils.containsIgnoreCase(sql, "select")
		                    && StringUtils.containsIgnoreCase(sql, ".nextval");
			}
		});
        return paginationInterceptor;
    }
	
	@Bean
	public GlobalConfig globalConfig() {
		GlobalConfig conf = new GlobalConfig();
		conf.setMetaObjectHandler(new MetaHandler());
		conf.setDbConfig(new GlobalConfig.DbConfig().setKeyGenerator(new H2KeyGenerator()));
		return conf;
	}
	/**
     * SQL执行效率插件 设置 dev test 环境开启
     * mybatis-plus 3.2.0后被移除
     * <p>
     */
	/*@Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor() {
        final PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setFormat(true);
        performanceInterceptor.setMaxTime(3000);
        return new PerformanceInterceptor();
    }*/
    /**
     * 乐观锁
     * <p>
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
