package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "loginCheck.jsp", out, false);
      out.write('\n');
      out.write('\n');
      ict.bean.UserInfo userInfo = null;
      synchronized (session) {
        userInfo = (ict.bean.UserInfo) _jspx_page_context.getAttribute("userInfo", PageContext.SESSION_SCOPE);
        if (userInfo == null){
          userInfo = new ict.bean.UserInfo();
          _jspx_page_context.setAttribute("userInfo", userInfo, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("<!DOCTYPE HTML >\n");
      out.write("<html>\n");
      out.write("    <head><title>Welcome</title></head>\n");
      out.write("    <body>\n");
      out.write("        <b> Hello,\n");
      out.write("            ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ict.bean.UserInfo)_jspx_page_context.findAttribute("userInfo")).getUsername())));
      out.write("\n");
      out.write("        </b>\n");
      out.write("        <p>Wellcome to the ICT</p>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("        <form method=\"post\" action=\"main\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"logout\">\n");
      out.write("            <input type=\"submit\" value=\"Logout\" name=\"logoutButton\">\n");
      out.write("        </form>\n");
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
