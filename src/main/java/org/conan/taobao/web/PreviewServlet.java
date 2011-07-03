package org.conan.taobao.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import org.conan.taobao.ad.dao.ItemDAO;
import org.conan.taobao.ad.model.ConfigDTO;
import org.conan.taobao.ad.model.ItemDTO;
import org.conan.taobao.base.dao.MyBatisSession;
import org.conan.taobao.web.form.ItemForm;

import com.taobao.api.ApiException;
import com.taobao.api.domain.Shop;
import com.taobao.api.domain.User;

@WebServlet(urlPatterns = "/preview")
public class PreviewServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String query = req.getParameter("query");
        query = "安吉白茶";

        String nick = (String) req.getSession().getAttribute("nick");

        try {
            req.setAttribute("shopAddr", getShopAddr(req));
            req.setAttribute("searchAddr", getShopSearchAddr(req, query));
            req.setAttribute("favoriteAddr", getFavoriteAddr(req));
            req.setAttribute("items", getItems(nick));
            req.setAttribute("config", getConfig(nick));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("preview.jsp").forward(req, res);
    }

    private List<ItemForm> getItems(String nick) {
        List<ItemForm> flist = null;
        try {
            SqlSession session = MyBatisSession.getSession();
            ItemDAO itemDAO = session.getMapper(ItemDAO.class);

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("nick", nick);
            List<ItemDTO> list = itemDAO.getItems(paramMap);
            
            flist = new ArrayList<ItemForm>();
            for (ItemDTO idto : list) {
                ItemForm form = new ItemForm();
                form.setStatus(true);
                form.setId(idto.getId());

                form.setDesc_url(idto.getDesc_url());
                form.setItemid(idto.getItemid());
                form.setPic_url(idto.getPic_url());
                form.setPrice(idto.getPrice());
                form.setTitle(idto.getTitle());
                form.setNick(idto.getNick());
                form.setDtime(idto.getDtime());
                flist.add(form);
            }
            
            MyBatisSession.commit(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flist;
    }

    private ConfigDTO getConfig(String nick) {
        ConfigDTO dto = null;
        try {
            SqlSession session = MyBatisSession.getSession();
            ConfigDAO configDAO = session.getMapper(ConfigDAO.class);

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("nick", nick);
            List<ConfigDTO> list = configDAO.getConfigs(paramMap);
            if (list.size() > 0) {
                dto = list.get(0);
            }
            MyBatisSession.commit(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    private String getShopAddr(HttpServletRequest req) throws ApiException {
        Shop shop = (Shop) req.getSession().getAttribute("shop");
        return "http://shop" + shop.getSid() + ".taobao.com/";
    }

    private String getShopSearchAddr(HttpServletRequest req, String query) throws Exception {
        return getShopAddr(req) + "?q=" + URLEncoder.encode(query, "GBK") + "&search=y";
    }

    private String getFavoriteAddr(HttpServletRequest req) throws ApiException {
        Shop shop = (Shop) req.getSession().getAttribute("shop");
        User user = (User) req.getSession().getAttribute("user");

        StringBuilder sb = new StringBuilder();
        sb.append("http://favorite.taobao.com/popup/add_collection.htm");
        sb.append("?itemid=" + shop.getSid());
        sb.append("&itemtype=0");
        sb.append("&ownerid=" + user.getUid());
        return sb.toString();
    }

}
