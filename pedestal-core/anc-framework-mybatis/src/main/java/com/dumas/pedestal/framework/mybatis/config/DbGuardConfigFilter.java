package com.dumas.pedestal.framework.mybatis.config;

import com.alibaba.druid.filter.config.ConfigFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author dumas
 * @date 2021/12/06 3:04 PM
 */
@Component
public class DbGuardConfigFilter extends ConfigFilter {
    public DbGuardConfigFilter() {
    }

    @Override
    public void decrypt(DruidDataSource dataSource, Properties info) {
        try {
            String encryptedPassword = null;
            if (info != null) {
                encryptedPassword = info.getProperty("password");
            }

            if (encryptedPassword == null || encryptedPassword.length() == 0) {
                encryptedPassword = dataSource.getConnectProperties().getProperty("password");
            }

            if (encryptedPassword == null || encryptedPassword.length() == 0) {
                encryptedPassword = dataSource.getPassword();
            }

            //String passwordPlainText = DatasourcePropertiesFactory.decode(encryptedPassword);
            //if (info != null) {
            //    info.setProperty("password", passwordPlainText);
            //} else {
            //    dataSource.setPassword(passwordPlainText);
            //}

        } catch (Exception var5) {
            throw new IllegalArgumentException("Failed to decrypt.", var5);
        }
    }
}
