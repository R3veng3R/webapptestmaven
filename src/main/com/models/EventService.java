package main.com.models;

import main.com.mappers.EventMapper;
import main.com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Alex on 13.12.2015.
 */
public class EventService {

    public List<Event> getEventsByCallId(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

        try {
            EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
            return eventMapper.getEventsByCallId(id);

        } finally {
            sqlSession.close();
        }
    }

    public void insertEvent(Event event) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

        try {
            EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
            eventMapper.insertEvent(event);
            sqlSession.commit();
        } finally{
            sqlSession.close();
        }
    }
}
