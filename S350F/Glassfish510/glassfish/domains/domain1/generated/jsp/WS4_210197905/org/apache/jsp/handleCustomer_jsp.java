package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ict.bean.CustomerBean;
import java.util.*;

public final class handleCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


ArrayList<CustomerBean> customers = new ArrayList<CustomerBean>();

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
      out.write('\n');
      out.write('\n');
      ict.bean.CustomerBean c = null;
      synchronized (_jspx_page_context) {
        c = (ict.bean.CustomerBean) _jspx_page_context.getAttribute("c", PageContext.PAGE_SCOPE);
        if (c == null){
          c = new ict.bean.CustomerBean();
          _jspx_page_context.setAttribute("c", c, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      ict.bean.CustomersBean cb = null;
      synchronized (request) {
        cb = (ict.bean.CustomersBean) _jspx_page_context.getAttribute("cb", PageContext.REQUEST_SCOPE);
        if (cb == null){
          cb = new ict.bean.CustomersBean();
          _jspx_page_context.setAttribute("cb", cb, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("c"), request);
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        The customer information are as follows:<br><br>\n");
      out.write("        Customer ID: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ict.bean.CustomerBean)_jspx_page_context.findAttribute("c")).getCustID())));
      out.write(" <br>\n");
      out.write("\tName: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ict.bean.CustomerBean)_jspx_page_context.findAttribute("c")).getName())));
      out.write(" <br>\n");
      out.write("\tTel: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ict.bean.CustomerBean)_jspx_page_context.findAttribute("c")).getTel())));
      out.write(" <br>\n");
      out.write("\tAge: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ict.bean.CustomerBean)_jspx_page_context.findAttribute("c")).getAge())));
      out.write(" <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t");


	    cb.addCustomer(c);


	    out.println("<table border='1'><tr><td>CustID</td><td>name</td><td>tel</td><td>age</td></tr>");


	    Iterator iterator = cb.getCustomers().iterator();
	    while (iterator.hasNext()) {
		CustomerBean cs = (CustomerBean) iterator.next();
		out.println(String.format(
			"<tr>"
			+ "<td>%s</td>"
			+ "<td>%s</td>"
			+ "<td>%s</td>"
			+ "<td>%s</td>"
			+ "</tr>",
			 cs.getCustID(), cs.getName(), cs.getTel(), cs.getAge()));
	    }

	    out.println("</table>");
	    
	    
	    out.println("<a href='editCustomer.jsp'>Try again</a>");

	
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
