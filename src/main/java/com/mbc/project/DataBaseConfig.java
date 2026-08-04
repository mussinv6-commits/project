package com.mbc.project;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:/application.properties")
@MapperScan(basePackages = "com.mbc.project.dao")
public class DataBaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }
    
    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new HikariDataSource(hikariConfig());
        System.out.println("dataSource:" + dataSource);
        return dataSource;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        System.out.println("DatabaseConfig sqlSessionFactory 구동 시작");
        
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        
        // ⭕ 수정 코드: mapper 폴더 검색을 완전히 빼버리고, 무조건 성공하는 sqls 단일 타겟팅으로 통합
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] allResources = resolver.getResources("classpath:sqls/**/*.xml");
        
        sqlSessionFactoryBean.setMapperLocations(allResources);
        
        // 마이바티스 언더바 ➡️ 카멜케이스 전역 자동 맵핑 설정
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);
        
        return sqlSessionFactoryBean.getObject();        
    }

    
    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sf) {
        return new SqlSessionTemplate(sf);
    }    
}
