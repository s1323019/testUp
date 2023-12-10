package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"mystyles.css\">\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            fieldset {\n");
      out.write("                padding: 1em;\n");
      out.write("                font:80%/1 sans-serif;\n");
      out.write("            }\n");
      out.write("            label {\n");
      out.write("                float:left;\n");
      out.write("                width:20%;\n");
      out.write("                margin-right:0.5em;\n");
      out.write("                padding-top:0.2em;\n");
      out.write("                text-align:right;\n");
      out.write("                font-weight:bold;\n");
      out.write("            } \n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"maincontainer\">\n");
      out.write("            <div id=\"topsection\"><div class=\"innertube\">\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "heading.jsp", out, false);
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"contentwrapper\">\n");
      out.write("                <div id=\"contentcolumn\">\n");
      out.write("                    <div class=\"innertube\">\n");
      out.write("                        <form>\n");
      out.write("                            <fieldset>\n");
      out.write("                                <legend>User Profile</legend>\n");
      out.write("                                <label for=\"name\">Username</label>\n");
      out.write("                                <input type=\"text\" name=\"name\" id=\"name\"/>\n");
      out.write("                                <br/>\n");
      out.write("                                <label for=\"mail\">E-mail:</label>\n");
      out.write("                                <input type=\"text\" name=\"mail\" id=\"mail\"/>\n");
      out.write("                                <br/>\n");
      out.write("                                <label for=\"address\">Address:</label>\n");
      out.write("                                <input type=\"text\" name=\"address\" id=\"address\" size=\"40\"/>\n");
      out.write("                            </fieldset>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\t    <div id=\"leftcolumn\">\n");
      out.write("                <div class=\"innertube\">\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"footer\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
