package cn.liuhao.market.dao;

import cn.liuhao.market.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 查询所有的user信息
     * @return
     */
    public List<User> getAll();

    /**
     * 添加一个用户数据
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 根据用户的唯一账户查询出用户信息
     * @param account
     * @return
     */
    public User getUserByAccount(@Param("account") String account);
}
