package cn.liuhao.market.service.impl;

import cn.liuhao.market.entity.User;
import cn.liuhao.market.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Override
    public Object registerUser(User user) {
        return null;
    }
}
