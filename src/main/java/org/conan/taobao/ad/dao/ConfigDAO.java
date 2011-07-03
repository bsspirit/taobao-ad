//Create by Conan. E-mail:bsspirit@gmail.com
package org.conan.taobao.ad.dao;

import java.util.List;
import java.util.Map;
import org.conan.taobao.base.dao.MybatisDAO;
import org.conan.taobao.base.dao.PageInObject;
import org.conan.taobao.base.dao.PageOutObject;

import org.conan.taobao.ad.model.ConfigDTO;

/**
 * This is Config DAO interface
 * @author Conan Zhang
 * @date 2011-07-02
 */
public interface ConfigDAO extends MybatisDAO {

    int insertConfig(ConfigDTO dto);
    int deleteConfig(int id);
    int updateConfig(ConfigDTO dto);

    ConfigDTO getConfigById(int id);
    List<ConfigDTO> getConfigs(Map<String,Object> paramMap);
    PageOutObject<ConfigDTO> getConfigsPaging(Map<String,Object> paramMap, PageInObject page);
    int getConfigsCount(Map<String,Object> paramMap);
}

