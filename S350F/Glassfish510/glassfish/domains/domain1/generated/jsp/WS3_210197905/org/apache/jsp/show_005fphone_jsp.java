package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Iterator;

public final class show_005fphone_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    private ArrayList getPhones(String brand) throws Exception {
	ArrayList<String> htc = new ArrayList<String>();
	htc.add("HTC One");
	htc.add("HTC OneX");

	ArrayList<String> iphone = new ArrayList<String>();
	iphone.add("iPhone 4");
	iphone.add("iPhone 4s");
	iphone.add("iPhone 5");

	ArrayList<String> samsung = new ArrayList<String>();

	samsung.add("galaxy express");
	samsung.add("Samsung S3");
	samsung.add("Samsung S4");

	if (brand.equals("htc")) {
	    return htc;
	} else if (brand.equals("iphone")) {
	    return iphone;
	} else if (brand.equals("samsung")) {
	    return samsung;
	} else {
	    throw new Exception("Incorrect brand");
	}
    }

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("<body>\n");
      out.write("\t");

	    String brand = request.getParameter("brand");

	    String output = "";
	    if (brand != null) {
		out.println(String.format("<h1>Brand %s</h1>", brand));
		ArrayList<String> phones = getPhones(brand);
		out.println("<ul>");
		Iterator iter = phones.iterator();
		while (iter.hasNext()) {
		    output = String.format("<li>%s</li>", iter.next());
		    out.println(output);
		}
		out.println("</ul>");

	    } else {
		out.println("No brand is selected <br><a href='phone.jsp'>Try again</a>");
	    }

	
      out.write("\n");
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
