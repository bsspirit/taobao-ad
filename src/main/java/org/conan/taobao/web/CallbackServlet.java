package org.conan.taobao.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.conan.taobao.MyConstant;
import org.conan.taobao.TaoBao;
import org.conan.taobao.TaoBaoAuth;

import com.taobao.api.ApiException;

@WebServlet(urlPatterns = "/callback")
public class CallbackServlet extends HttpServlet {

    private static final long serialVersionUID = -5192794091995383789L;

    /**
     * HELP: http://open.taobao.com/dev/index.php/%E6%B7%98%E5%AE%9D%E7%AE%B1%E7%94%A8%E6%88%B7%E7%99%BB%E9%99%86%E9%AA%8C%E8%AF%81
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // http://callback.com/callback?top_appkey=xxx&top_parameters=xxxxx&top_session=xxxxx&top_sign=xxxxx

        String appkey = req.getParameter("top_appkey");
        String parameters = req.getParameter("top_parameters");
        String sessionid = req.getParameter("top_session");
        String sign = req.getParameter("top_sign");

        String nick = TaoBaoAuth.parametersName(parameters);
        boolean vaild = TaoBaoAuth.validateSign(sign, appkey + parameters + sessionid, MyConstant.SECRET);

        if (vaild) {
            HttpSession session = req.getSession();
            session.setAttribute("nick", nick);
            try {
                session.setAttribute("user", TaoBao.getUser(nick));
                session.setAttribute("shop", TaoBao.getShop(nick));
            } catch (ApiException e) {
                e.printStackTrace();
            }

            res.sendRedirect("item");
        }

    }

}
