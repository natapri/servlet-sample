package letscode;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import java.util.stream.Collectors;


@WebServlet(urlPatterns = "/file-servlet")
@MultipartConfig(location = "C:\\Users\\User\\IdeaProjects\\servletapp")
public class FileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       for(Part part : req.getParts()){
           if(part.getName().equals("file-name")){
               InputStream inputstream = part.getInputStream();
               InputStreamReader isr = new InputStreamReader(inputstream);
               String authorName = new BufferedReader(isr)
                       .lines().collect(Collectors.joining("\n"));
               log(authorName);
           }else {
               log(part.getName());
               part.write( UUID.randomUUID().toString() + part.getSubmittedFileName());
           }
       }
       resp.sendRedirect("/my-app/servlet");
    }
}
