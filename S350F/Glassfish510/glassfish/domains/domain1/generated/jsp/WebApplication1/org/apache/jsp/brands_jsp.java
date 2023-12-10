package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ict.bean.*;
import java.util.*;

public final class brands_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      response.setHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      java.util.ArrayList<ict.bean.Brand> brands = null;
      synchronized (request) {
        brands = (java.util.ArrayList<ict.bean.Brand>) _jspx_page_context.getAttribute("brands", PageContext.REQUEST_SCOPE);
        if (brands == null){
          try {
            brands = (java.util.ArrayList<ict.bean.Brand>) java.beans.Beans.instantiate(this.getClass().getClassLoader(), "java.util.ArrayList<ict.bean.Brand>");
          } catch (ClassNotFoundException exc) {
            throw new InstantiationException(exc.getMessage());
          } catch (Exception exc) {
            throw new ServletException("Cannot create bean of class " + "java.util.ArrayList<ict.bean.Brand>", exc);
          }
          _jspx_page_context.setAttribute("brands", brands, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        \n");
      out.write("        ");

            for(int i=0;i<brands.size();i++){
                Brand b = brands.get(i);
                out.println( "<a href=\"getPhones?action=list&brand=" 
                + b.getName() + "\">" + b.getName() + "</a><br/>" );
            }
        
        
        
      out.write("\n");
      out.write("        \n");
      out.write("        <hr/>\n");
      out.write("        <a href=\"brandForm.jsp\"> Create Brand</a><br/>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
