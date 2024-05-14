package ru.alitryel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Abstract;
import ru.appline.logic.Model;
import ru.appline.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/put")
public class ServletPut extends HttpServlet {

    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        StringBuffer sb = new StringBuffer();
        PrintWriter pw = response.getWriter();

        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            System.out.println("Ошибка");
        }

        JsonObject jObj = gson.fromJson(String.valueOf(sb), JsonObject.class);

        int id = jObj.get("id").getAsInt();

        String name = jObj.get("name").getAsString();

        String surname = jObj.get("surname").getAsString();

        double salary = jObj.get("salary").getAsDouble();

        if (id > 0) {
            if (id > model.getFromList().size()) {
                Abstract Abstract = new Abstract();
                Abstract.string = "Такой пользователь не создавался";
                pw.print(gson.toJson(Abstract));

            } else {
                model.delete(id);
                User user = new User(name, surname, salary);
                model.put(user, id);

                Abstract Abstract = new Abstract();
                Abstract.string = "Id пользователя изменен";
                pw.print(gson.toJson(Abstract));
            }
        }
    }
}
