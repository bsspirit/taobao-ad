//Create by Conan. E-mail:bsspirit@gmail.com
package org.conan.taobao.ad.dao;

import java.util.List;
import java.util.Map;
import org.conan.taobao.base.dao.MybatisDAO;
import org.conan.taobao.base.dao.PageInObject;
import org.conan.taobao.base.dao.PageOutObject;

import org.conan.taobao.ad.model.UserDTO;

/**
 * This is User DAO interface
 * @author Conan Zhang
 * @date 2011-06-25
 */
public interface UserDAO extends MybatisDAO {

    int insertUser(UserDTO dto);
    int deleteUser(int id);
    int updateUser(UserDTO dto);

    UserDTO getUserById(int id);
    List<UserDTO> getUsers(Map<String,Object> paramMap);
    PageOutObject<UserDTO> getUsersPaging(Map<String,Object> paramMap, PageInObject page);
    int getUsersCount(Map<String,Object> paramMap);
}

