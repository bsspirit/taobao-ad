package org.conan.taobao.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.conan.taobao.ad.dao.ConfigDAO;
import org.conan.taobao.ad.model.ConfigDTO;
import org.conan.taobao.base.dao.MyBatisSession;

@WebServlet(urlPatterns = "/config")
public class ConfigServlet extends HttpServlet {

    private static final long serialVersionUID = -6581382295894600269L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nick = (String) req.getSession().getAttribute("nick");

        int pageWidth = Integer.parseInt(req.getParameter("width"));
        int picSize = Integer.parseInt(req.getParameter("pic_size"));
        int shopType = Integer.parseInt(req.getParameter("shop_type"));
        int itemTitle = Integer.parseInt(req.getParameter("item_title"));
        int enterShow = Integer.parseInt(req.getParameter("enter_show"));
        int favorShow = Integer.parseInt(req.getParameter("favor_show"));

        SqlSession session = MyBatisSession.getSession();

        ConfigDAO configDAO = session.getMapper(ConfigDAO.class);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("nick", nick);
        List<ConfigDTO> list = configDAO.getConfigs(paramMap);

        if (list.size() == 0) {
            // insert
            ConfigDTO dto = new ConfigDTO();
            dto.setNick(nick);
            dto.setWidth(pageWidth);
            dto.setPic_size(picSize);
            dto.setEnter_show(enterShow);
            dto.setFavor_show(favorShow);
            dto.setTitle_show(itemTitle);
            dto.setShoptype(shopType);
            configDAO.insertConfig(dto);
        } else {
            // update
            ConfigDTO dto = list.get(0);
            dto.setWidth(pageWidth);
            dto.setPic_size(picSize);
            dto.setEnter_show(enterShow);
            dto.setFavor_show(favorShow);
            dto.setTitle_show(itemTitle);
            dto.setShoptype(shopType);
            configDAO.updateConfig(dto);
        }

        MyBatisSession.commit(session);
        doGet(req, res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        SqlSession session = MyBatisSession.getSession();
        ConfigDAO configDAO = session.getMapper(ConfigDAO.class);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("nick", (String) req.getSession().getAttribute("nick"));
        List<ConfigDTO> list = configDAO.getConfigs(paramMap);
        if (list.size() > 0) {
            req.setAttribute("config", list.get(0));
        } else {
            req.setAttribute("config", defaultConfigDTO());
        }
        MyBatisSession.commit(session);
        req.getRequestDispatcher("config.jsp").forward(req, res);
    }

    private ConfigDTO defaultConfigDTO() {
        ConfigDTO dto = new ConfigDTO();
        dto.setEnter_show(1);
        dto.setFavor_show(1);
        dto.setPic_size(160);
        dto.setShoptype(0);
        dto.setTitle_show(1);
        dto.setWidth(750);
        return dto;
    }
}
