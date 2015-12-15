package main.com.models;

import main.com.mappers.CallMapper;
import main.com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alex on 12.12.2015.
 */
public class CallService {
    private CallMapper callMapper;

    public void insertCall(Call call) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

        try {
            CallMapper callMapper = sqlSession.getMapper(CallMapper.class);
            callMapper.insertCall(call);
            sqlSession.commit();
        } finally{
            sqlSession.close();
        }
    }

    public List<Call> getAllCalls() {
        //SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

       // try {
           // CallMapper callMapper = sqlSession.getMapper(CallMapper.class);
            return this.callMapper.getAllCalls();

        //} finally {
           // sqlSession.close();
       // }
    }

    public CallMapper getCallMapper() {
        return callMapper;
    }

    public void setCallMapper(CallMapper callMapper) {
        this.callMapper = callMapper;
    }
}
