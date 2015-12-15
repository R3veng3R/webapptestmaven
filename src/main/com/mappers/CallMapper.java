package main.com.mappers;

import main.com.models.Call;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by Alex on 12.12.2015.
 */
public interface CallMapper {
    public void insertCall(Call call);

    public List<Call> getAllCalls();

}
