package org.conan.taobao.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.conan.taobao.TaoBao;

import com.taobao.api.ApiException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = -8567033450093619087L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("U=" + username + ",P=" + password);

        if (username != null && !username.equals("")) {
            HttpSession session = req.getSession();
            session.setAttribute("nick", username);
            
            try {
                session.setAttribute("user", TaoBao.getUser(username));
                session.setAttribute("shop", TaoBao.getShop(username));
            } catch (ApiException e) {
                e.printStackTrace();
            }
            res.sendRedirect("item");
        } else {
            doGet(req, res);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, res);
    }

}
