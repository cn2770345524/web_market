package cn.liuhao.market.service;

import cn.liuhao.market.entity.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     * @return
     */
    public Object registerUser(User user);
}
