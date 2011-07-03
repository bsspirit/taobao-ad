package org.conan.taobao.web;

import java.io.IOException;
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
import org.conan.taobao.TaoBao;
import org.conan.taobao.ad.dao.ItemDAO;
import org.conan.taobao.ad.model.ItemDTO;
import org.conan.taobao.base.dao.MyBatisSession;
import org.conan.taobao.base.util.MyCast;
import org.conan.taobao.web.form.ItemForm;
import org.conan.taobao.web.util.PageOut;

import com.taobao.api.domain.Item;
import com.taobao.api.response.ItemsGetResponse;

@WebServlet(urlPatterns="/item")
public class ItemServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        save(req);
        delete(req);
        get(req, res);
    }

    private void save(HttpServletRequest req) {
        String itemid = req.getParameter("item");
        String nick = (String) req.getSession().getAttribute("nick");
        String op = req.getParameter("op");

        if (op != null && op.equals("save")) {
            if (itemid != null && !itemid.equals("")) {
                SqlSession session = MyBatisSession.getSession();
                ItemDAO itemDAO = session.getMapper(ItemDAO.class);
                try {
                    ItemDTO dto = new ItemDTO();
                    Item item = TaoBao.getItem(nick, Long.parseLong(itemid));
                    dto.setDesc_url(item.getDetailUrl());
                    dto.setPic_url(item.getPicUrl());
                    dto.setPrice(Float.parseFloat(item.getPrice()));
                    dto.setTitle(item.getTitle());
                    dto.setDtime(item.getDelistTime());
                    dto.setNick(nick);
                    dto.setItemid(item.getNumIid());
                    itemDAO.insertItem(dto);
                    MyBatisSession.commit(session);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void delete(HttpServletRequest req) {
        String id = req.getParameter("id");
        String op = req.getParameter("op");
        if (op != null && op.equals("del")) {
            SqlSession session = MyBatisSession.getSession();
            ItemDAO itemDAO = session.getMapper(ItemDAO.class);
            try {
                itemDAO.deleteItem(Integer.parseInt(id));
                MyBatisSession.commit(session);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void get(HttpServletRequest req, HttpServletResponse res) {
        String nick = (String) req.getSession().getAttribute("nick");
        try {
            int pageNum = MyCast.string2Int(req.getParameter("p"), 1);
            ItemsGetResponse itemRes = TaoBao.getItems(nick, pageNum, 10);

            SqlSession session = MyBatisSession.getSession();
            ItemDAO itemDAO = session.getMapper(ItemDAO.class);

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("nick", nick);
            List<ItemDTO> list = itemDAO.getItems(paramMap);

            List<ItemForm> flist = new ArrayList<ItemForm>();
            for (Item it : itemRes.getItems()) {
                ItemForm form = new ItemForm();
                form.setDesc_url(it.getDetailUrl());
                form.setItemid(it.getNumIid());
                form.setPic_url(it.getPicUrl());
                form.setPrice(Float.parseFloat(it.getPrice()));
                form.setTitle(it.getTitle());
                form.setNick(it.getNick());
                form.setDtime(it.getDelistTime());
                for (ItemDTO idto : list) {
                    if (it.getNumIid().equals(idto.getItemid())) {
                        form.setStatus(true);
                        form.setId(idto.getId());
                    }
                }
                flist.add(form);
            }
            MyBatisSession.commit(session);

            PageOut<ItemForm> pageOut = new PageOut<ItemForm>(itemRes.getTotalResults().intValue(), flist, pageNum);
            req.setAttribute("items", pageOut);
            req.getRequestDispatcher("item.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
