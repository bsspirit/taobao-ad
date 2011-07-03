//Create by Conan. E-mail:bsspirit@gmail.com
package org.conan.taobao.ad.model;

import java.util.Date;
import java.sql.Timestamp;
import org.conan.taobao.base.BaseObject;

/**
 * This is Item Model DTO
 * @author Conan Zhang
 * @date 2011-06-26
 */
public class ItemDTO extends BaseObject {

private static final long serialVersionUID = 13090636607500L;

public ItemDTO(){}
public ItemDTO(Long itemid, String nick, String title, Float price, String pic_url, String desc_url, Date dtime, Timestamp create_date){
this.itemid = itemid;
this.nick = nick;
this.title = title;
this.price = price;
this.pic_url = pic_url;
this.desc_url = desc_url;
this.dtime = dtime;
this.create_date = create_date;
}


private int id;
private Long itemid;
private String nick;
private String title;
private Float price;
private String pic_url;
private String desc_url;
private Date dtime;
private Timestamp create_date;

public int getId() {
return this.id;
}

public Long getItemid (){
return this.itemid;
}
public String getNick (){
return this.nick;
}
public String getTitle (){
return this.title;
}
public Float getPrice (){
return this.price;
}
public String getPic_url (){
return this.pic_url;
}
public String getDesc_url (){
return this.desc_url;
}
public Date getDtime (){
return this.dtime;
}
public Timestamp getCreate_date (){
return this.create_date;
}


public void setId(int id) {
this.id = id;
}

public void setItemid(Long itemid) {
this.itemid = itemid;
}
public void setNick(String nick) {
this.nick = nick;
}
public void setTitle(String title) {
this.title = title;
}
public void setPrice(Float price) {
this.price = price;
}
public void setPic_url(String pic_url) {
this.pic_url = pic_url;
}
public void setDesc_url(String desc_url) {
this.desc_url = desc_url;
}
public void setDtime(Date dtime) {
this.dtime = dtime;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
