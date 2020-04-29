package com.kingmao.dynamic.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * @author QX
 * @date 2020/4/28
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.master.apple")
    public DataSource masterAppleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.master.peach")
    public DataSource masterPeachDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave1.apple")
    public DataSource slave1AppleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave1.peach")
    public DataSource slave1PeachDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave2.apple")
    public DataSource slave2AppleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave2.peach")
    public DataSource slave2PeachDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSource myRoutingDataSource(@Qualifier("masterAppleDataSource") DataSource masterAppleDataSource,
                                          @Qualifier("masterPeachDataSource") DataSource masterPeachDataSource,
                                          @Qualifier("slave1AppleDataSource") DataSource slave1AppleDataSource,
                                          @Qualifier("slave1PeachDataSource") DataSource slave1PeachDataSource,
                                          @Qualifier("slave2AppleDataSource") DataSource slave2AppleDataSource,
                                          @Qualifier("slave2PeachDataSource") DataSource slave2PeachDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MASTER_APPLE, masterAppleDataSource);
        targetDataSources.put(DBTypeEnum.MASTER_PEACH, masterPeachDataSource);
        targetDataSources.put(DBTypeEnum.SLAVE1_APPLE, slave1AppleDataSource);
        targetDataSources.put(DBTypeEnum.SLAVE2_APPLE, slave2AppleDataSource);
        targetDataSources.put(DBTypeEnum.SLAVE1_PEACH, slave1PeachDataSource);
        targetDataSources.put(DBTypeEnum.SALVE2_PEACH, slave2PeachDataSource);
        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
        myRoutingDataSource.setDefaultTargetDataSource(masterAppleDataSource);
        myRoutingDataSource.setTargetDataSources(targetDataSources);
        return myRoutingDataSource;
    }
}
