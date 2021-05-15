package cn.liuhao.market.service.impl;

import cn.liuhao.market.dao.UserDao;
import cn.liuhao.market.entity.Message;
import cn.liuhao.market.entity.User;
import cn.liuhao.market.service.UserService;
import cn.liuhao.market.util.JwtUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Object registerUser(User user) {

        Message message=new Message();

        user.setSalt(JwtUtils.generateSalt());
        user.setRegister_timestamp(new Date(System.currentTimeMillis()));
        user.setPassword(new Md5Hash(user.getPassword(),user.getSalt(),1024).toHex());

        if(userDao.getUserByAccount(user.getAccount())==null)
        {
            if(userDao.addUser(user)>0){
                message.setStatus(Message.SUCCESS);
                message.addDataItem("info","用户名:["+user.getAccount()+"]注册成功");
            }
        }
        else {
            message.setStatus(Message.FAILURE);
            message.addDataItem("error","用户名:["+user.getAccount()+"]已经存在，请更换注册用户名");
        }
        return message;
    }
}
