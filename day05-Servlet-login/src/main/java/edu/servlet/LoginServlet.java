package edu.servlet;

import edu.bean.User;
import edu.utils.JDBCUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        User usr = null;
        try {
            usr = queryRunner.query("Select * From 'user' where 'username'=? and 'password'=?", new BeanHandler<User>(User.class),
                    username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(usr == null){
            response.getWriter().write("login fail");
        }
        else{
            response.getWriter().write("login success");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
