package gb.javaee.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LessonOneServlet", urlPatterns = "/get_products")
public class LessonOneServlet implements Servlet {

    private static Logger logger = LoggerFactory.getLogger(LessonOneServlet.class);
    private transient ServletConfig config;

    private Product[] products;
    private void initProducts(int cnt){
        products = new Product[cnt];
        for (int i = 0; i < cnt; i++) {
            products[i] = new Product(i + 1, String.format("Title %s", i + 1), 1.21 * i + 1);
        }
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public String getServletInfo() {
        return "Lesson One Servlet. Returns some products.";
    }

    @Override
    public void destroy() {
        logger.info("Servlet [{}] destroyed", getServletInfo());
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("Request to servlet");

        initProducts(10);

        if (products.length > 0){
            for (int i = 0; i < products.length; i++) {
                servletResponse.getWriter().println(String.format("<h1>Product %s: %s$</h1>", products[i].getTitle(), products[i].getCost()));
            }
        }
    }
}