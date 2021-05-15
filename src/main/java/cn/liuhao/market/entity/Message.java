package cn.liuhao.market.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class Message {

    /**
     * 成功返回的状态码
     */
    public static Integer SUCCESS=0;

    /**
     * 失败返回的状态码
     */
    public static Integer FAILURE=1;

    /**
     * 状态码
     */
    @Setter(value = AccessLevel.NONE)
    private Integer status;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 附带的信息
     */
    private Map<String,Object> data;

    public Message() {
        this.setStatus(Message.FAILURE);
        this.setData(new LinkedHashMap<>());
    }

    public void setStatus(Integer status) {
        this.status=status;
        this.setMsg(this.getStatus()==Message.SUCCESS?"success":"failure");
    }

    public void addDataItem(String key,Object value){
        this.getData().put(key,value);
    }

}
