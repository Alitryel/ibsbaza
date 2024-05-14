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

@WebServlet (urlPatterns = "/get")

public class ServletList extends HttpServlet {
    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        int id = Integer.parseInt(request.getParameter("id"));

        PrintWriter pw = response.getWriter();

        if (id == 0) {
            pw.print(gson.toJson(model.getFromList()));
        } else if (id > 0) {
            if (id > model.getFromList().size()) {
                Abstract Abstract = new Abstract();
                Abstract.string = "Такого пользователя не существует";
                pw.print(gson.toJson(Abstract));
            } else {
                pw.print(gson.toJson(model.getFromList().get(id)));
            }
        }
    }


}
