package letscode;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;




@WebServlet(urlPatterns = {"/servlet", "my-servlet/*"})
public class MainServlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Method init ))");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        resp.getWriter().write("Method service\n");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String uri = req.getRequestURI();
        String params = formatParams(req);

        resp.getWriter().write("Method doGet\nURI: " + uri + "\nParams:\n" + params + "\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String params = formatParams(req);

        resp.getWriter().write("Method doPost\nURI: " + uri + "\nParams:\n" + params + "\n");
    }

    private String formatParams(HttpServletRequest req){
        Map<String, String[]> parameterMap = req.getParameterMap();
        String paramstr="";
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            paramstr += entry.getKey() + "=" +  String.join(" and ", entry.getValue()) + "\n";
        }
        return paramstr;
    }




    @Override
    public void destroy() {
        super.destroy();
        log("Method destroy ))");
    }
}
