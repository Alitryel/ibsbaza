package ru.alitryel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.appline.logic.Abstract;

import ru.appline.logic.Model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/delete")
public class ServletDelete extends HttpServlet {

    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        PrintWriter pw = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));

        if (id > 0) {
            if (id > model.getFromList().size()) {
                Abstract Abstract = new Abstract();
                pw.print(gson.toJson(Abstract));
            } else {
                Abstract Abstract = new Abstract();
                pw.print(gson.toJson(Abstract));
                model.delete(id);
            }
        }
    }
}




