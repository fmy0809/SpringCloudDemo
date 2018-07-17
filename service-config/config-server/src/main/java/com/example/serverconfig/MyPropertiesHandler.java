package com.example.serverconfig;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author ws47033
 * @date 2018/7/17 18:05
 */

@Component
public class MyPropertiesHandler implements PropertySourceLoader {
    @Override
    public String[] getFileExtensions() {
        return new String[]{"prop"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
            Properties properties = getProperties(resource);
            if (!properties.isEmpty()) {
                PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource(name, properties);
                List list = new ArrayList();
                list.add(propertiesPropertySource);
                return list;
            }
        return null;
    }

    private Properties getProperties(Resource resource){
        Properties properties= new Properties();
        try(InputStream inputStream = resource.getInputStream();){
            properties.load(new InputStreamReader(inputStream, "utf-8"));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
