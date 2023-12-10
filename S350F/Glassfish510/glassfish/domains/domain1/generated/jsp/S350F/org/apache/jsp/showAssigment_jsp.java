package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class showAssigment_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"assignment-box\">\n");
      out.write("            <h1>Course : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${as.courseID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </h1>\n");
      out.write("            <p class=\"assignment-text\">Assignment Title:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${as.assigmentTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("            <p class=\"assignment-status\">Status : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${as.status}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("            <p class=\"assignment-due-time\">Due Time : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${as.due_date}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("                <label for=\"formFile\" class=\"form-label\">Default file input example</label>\n");
      out.write("                <input class=\"form-control\" type=\"file\" id=\"formFile\">\n");
      out.write("            </div>\n");
      out.write("            <button type=\"submit\" class=\"submit-button\">Submit</button>\n");
      out.write("        </div>\n");
      out.write("    </body>    \n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("    .assignment-box {\n");
      out.write("        border: 1px solid #ccc;\n");
      out.write("        padding: 20px;\n");
      out.write("        max-width: 400px;\n");
      out.write("        margin: 0 auto;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .assignment-box h1 {\n");
      out.write("        font-size: 24px;\n");
      out.write("        margin-bottom: 10px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .assignment-text, .assignment-status, .assignment-due-time {\n");
      out.write("        font-size: 16px;\n");
      out.write("        margin-bottom: 5px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .assignment-file {\n");
      out.write("        margin-bottom: 10px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .submit-button {\n");
      out.write("        background-color: #4CAF50;\n");
      out.write("        color: white;\n");
      out.write("        padding: 10px 20px;\n");
      out.write("        border: none;\n");
      out.write("        cursor: pointer;\n");
      out.write("        font-size: 16px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .submit-button:hover {\n");
      out.write("        background-color: #45a049;\n");
      out.write("    }\n");
      out.write("</style>\n");
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
