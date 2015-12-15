package main.com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Alex on 12.12.2015.
 */
public class MyBatisUtil {

    private static SqlSessionFactory factory;

    private MyBatisUtil(){}

    static {
        Reader reader = null;

        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        factory = new SqlSessionFactoryBuilder().build(reader);

        try {
            if(reader != null) {
                reader.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }
}
