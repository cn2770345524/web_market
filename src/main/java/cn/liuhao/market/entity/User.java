package cn.liuhao.market.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * 唯一账户
     */
    private String account;

    /**
     * 加密后的密码
     */
    private String password;

    /**
     * 用于加密的salt
     */
    private String salt;

    /**
     * 注册的时间
     */
    private Date register_timestamp;
}
