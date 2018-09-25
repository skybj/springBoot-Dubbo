package cn.jsxwsl.dubbo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@NoArgsConstructor
@Data
@Accessors(chain = true)
public class User implements Serializable {


    private long id;
    private int sn;
    private String openid;
    private String account;
    private String password;
    private String nickname;
    private String headimgurl;
	public User(long id, int sn,String nickname ) {
		super();
		this.id = id;
		this.sn = sn;
		this.nickname=nickname;
	}
    

}
