package gb.javaee.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LessonOneServlet", urlPatterns = "/get_products")
public class LessonOneServlet implements Servlet {

    private static Logger logger = LoggerFactory.getLogger(LessonOneServlet.class);
    private transient ServletConfig config;

    private Product[] products;
    private void initProducts(int cnt){
        products = new Product[cnt];
        for (int i = 0; i < cnt; i++) {
            products[i] = new Product(i + 1, String.format("Title %s", i + 1), 1.21 * (i + 1));
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
        PrintWriter out = servletResponse.getWriter();
        if (products.length > 0){
            out.println("<h1>Products List</h1><hr>");
            for (Product product : products) {
                out.println(String.format("<h2>%s: %.3f $</h2>", product.getTitle(), product.getCost()));
            }
        }
        out.close();
    }
}