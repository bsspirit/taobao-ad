//Create by Conan. E-mail:bsspirit@gmail.com
package org.conan.taobao.ad.model;

import java.util.Date;
import org.conan.taobao.base.BaseObject;

/**
 * This is User Model DTO
 * @author Conan Zhang
 * @date 2011-06-25
 */
public class UserDTO extends BaseObject {

private static final long serialVersionUID = 13089791016711L;

public UserDTO(){}
public UserDTO(Long userid, String nick, String uid, Date create_date){
this.userid = userid;
this.nick = nick;
this.uid = uid;
this.create_date = create_date;
}


private int id;
private Long userid;
private String nick;
private String uid;
private Date create_date;

public int getId() {
return this.id;
}

public Long getUserid (){
return this.userid;
}
public String getNick (){
return this.nick;
}
public String getUid (){
return this.uid;
}
public Date getCreate_date (){
return this.create_date;
}


public void setId(int id) {
this.id = id;
}

public void setUserid(Long userid) {
this.userid = userid;
}
public void setNick(String nick) {
this.nick = nick;
}
public void setUid(String uid) {
this.uid = uid;
}
public void setCreate_date(Date create_date) {
this.create_date = create_date;
}


}
