package com.love2shop.ecommerce.config;

import com.love2shop.ecommerce.entity.Product;
import com.love2shop.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class ReadOnlyRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] disabledMethods = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
        disableHttpMethods(config, disabledMethods, Product.class);
        disableHttpMethods(config, disabledMethods, ProductCategory.class);
    }

    private void disableHttpMethods(RepositoryRestConfiguration config, HttpMethod[] httpMethods, Class<?> type) {
        config.getExposureConfiguration()
                .forDomainType(type)
                .withItemExposure((metadata, methods) -> methods.disable(httpMethods))
                .withCollectionExposure((metadata, methods) -> methods.disable(httpMethods));
    }
}
