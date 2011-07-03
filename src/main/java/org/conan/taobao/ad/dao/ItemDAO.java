//Create by Conan. E-mail:bsspirit@gmail.com
package org.conan.taobao.ad.dao;

import java.util.List;
import java.util.Map;
import org.conan.taobao.base.dao.MybatisDAO;
import org.conan.taobao.base.dao.PageInObject;
import org.conan.taobao.base.dao.PageOutObject;

import org.conan.taobao.ad.model.ItemDTO;

/**
 * This is Item DAO interface
 * @author Conan Zhang
 * @date 2011-06-26
 */
public interface ItemDAO extends MybatisDAO {

    int insertItem(ItemDTO dto);
    int deleteItem(int id);
    int updateItem(ItemDTO dto);

    ItemDTO getItemById(int id);
    List<ItemDTO> getItems(Map<String,Object> paramMap);
    PageOutObject<ItemDTO> getItemsPaging(Map<String,Object> paramMap, PageInObject page);
    int getItemsCount(Map<String,Object> paramMap);
}

