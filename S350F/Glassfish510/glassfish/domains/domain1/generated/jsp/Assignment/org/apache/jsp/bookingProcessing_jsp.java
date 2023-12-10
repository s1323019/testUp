package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ict.bean.*;
import java.util.*;

public final class bookingProcessing_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navber.jsp", out, false);
      out.write("   \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"tableSt.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table>\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>loaction</th>\n");
      out.write("                    <th>Select time</th>\n");
      out.write("                    <th>Booking Status</th>\n");
      out.write("                    <th>Fee</th>\n");
      out.write("                </tr>\n");
      out.write("            <thead>\n");
      out.write("            <tbody>                    \n");
      out.write("                ");

                    ArrayList<BookingRecord> bookingPayment = (ArrayList<BookingRecord>) request.getAttribute("bookingPayment");
                    for (int i = 0; i < bookingPayment.size(); i++) {
                        BookingRecord v = bookingPayment.get(i);
                
      out.write("         \n");
      out.write("                <tr>\n");
      out.write("                    \n");
      out.write("                    <td>");
      out.print( v.getVenueName());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( v.getVenueLocation());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( v.getApStime());
      out.write(" - ");
      out.print( v.getApEtime());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( v.getBookingStatus());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( v.getFee());
      out.write("</td>\n");
      out.write("                 \n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("        <table/>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("   \n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("    .popover-body {\n");
      out.write("        width: 1200px;\n");
      out.write("        height: 600px;\n");
      out.write("    }\n");
      out.write("</style>");
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
