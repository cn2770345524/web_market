package cn.liuhao.market.dao;

import cn.liuhao.market.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    public List<User> getAll();
}
