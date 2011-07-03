//Create by Conan. E-mail:bsspirit@gmail.com
package org.conan.taobao.ad.model;

import java.sql.Timestamp;
import org.conan.taobao.base.BaseObject;

/**
 * This is Config Model DTO
 * @author Conan Zhang
 * @date 2011-07-02
 */
public class ConfigDTO extends BaseObject {

private static final long serialVersionUID = 13096111878752L;

public ConfigDTO(){}
public ConfigDTO(String nick, Integer width, Integer pic_size, Integer enter_show, Integer favor_show, Integer title_show, Integer shoptype, Timestamp create_date){
this.nick = nick;
this.width = width;
this.pic_size = pic_size;
this.enter_show = enter_show;
this.favor_show = favor_show;
this.title_show = title_show;
this.shoptype = shoptype;
this.create_date = create_date;
}


private int id;
private String nick;
private Integer width;
private Integer pic_size;
private Integer enter_show;
private Integer favor_show;
private Integer title_show;
private Integer shoptype;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getNick (){
return this.nick;
}
public Integer getWidth (){
return this.width;
}
public Integer getPic_size (){
return this.pic_size;
}
public Integer getEnter_show (){
return this.enter_show;
}
public Integer getFavor_show (){
return this.favor_show;
}
public Integer getTitle_show (){
return this.title_show;
}
public Integer getShoptype (){
return this.shoptype;
}
public Timestamp getCreate_date (){
return this.create_date;
}


public void setId(int id) {
this.id = id;
}

public void setNick(String nick) {
this.nick = nick;
}
public void setWidth(Integer width) {
this.width = width;
}
public void setPic_size(Integer pic_size) {
this.pic_size = pic_size;
}
public void setEnter_show(Integer enter_show) {
this.enter_show = enter_show;
}
public void setFavor_show(Integer favor_show) {
this.favor_show = favor_show;
}
public void setTitle_show(Integer title_show) {
this.title_show = title_show;
}
public void setShoptype(Integer shoptype) {
this.shoptype = shoptype;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
