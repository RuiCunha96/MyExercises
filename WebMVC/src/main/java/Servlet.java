import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Create request dispatcher wrappers around the views
        RequestDispatcher page1Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");


// include the page1 processing by calling the appropriate jsp page code


        User user = new User();
        user.setName("Catarina Campino");
        user.setEmail("catarina.campino@academiadecodigo.org");

// Use global Servlet context to pass user object
        getServletContext().setAttribute("user", user);
// Use session context to pass the user object
        req.getSession().setAttribute("user", user);
// Use request  context to pass the user object
        req.setAttribute("user", user);


        page1Dispatcher.include(req, resp);


    }


}
