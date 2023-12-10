package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ict.bean.*;
import java.util.*;

public final class booking_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navber.jsp", out, false);
      out.write("        \n");
      out.write("        ");
      java.util.ArrayList<ict.bean.Venue> venue = null;
      synchronized (request) {
        venue = (java.util.ArrayList<ict.bean.Venue>) _jspx_page_context.getAttribute("venue", PageContext.REQUEST_SCOPE);
        if (venue == null){
          try {
            venue = (java.util.ArrayList<ict.bean.Venue>) java.beans.Beans.instantiate(this.getClass().getClassLoader(), "java.util.ArrayList<ict.bean.Venue>");
          } catch (ClassNotFoundException exc) {
            throw new InstantiationException(exc.getMessage());
          } catch (Exception exc) {
            throw new ServletException("Cannot create bean of class " + "java.util.ArrayList<ict.bean.Venue>", exc);
          }
          _jspx_page_context.setAttribute("venue", venue, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        <div class=\"row row-cols-1 row-cols-md-3 g-4\">\n");
      out.write("            ");

                if (venue != null) {
                    for (int i = 0; i < venue.size(); i++) {
                        Venue v = venue.get(i);
            
      out.write("\n");
      out.write("            <form method=\"post\" action=\"bookingController\">\n");
      out.write("                <div class=\"col\">\n");
      out.write("                    <div class=\"card h-100\" style=\"width: 400px;\">\n");
      out.write("                        <img src=\"");
      out.print( v.getImage());
      out.write("\"  width=\"50\" height=\"180\" class=\"card-img-top\" alt=\"...\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h5 class=\"card-title\">");
      out.print( v.getName());
      out.write("</h5>\n");
      out.write("                            <p class=\"card-text\">\n");
      out.write("                                <i class=\"bi bi-building\"></i>Type : ");
      out.print( v.getType());
      out.write("   <br/>\n");
      out.write("                                <i class=\"bi bi-person\"></i>Capacity : ");
      out.print( v.getCapacity());
      out.write(" <br/>\n");
      out.write("                                <i class=\"bi bi-geo-alt\"></i>Location: ");
      out.print( v.getLocation());
      out.write("  <br/>\n");
      out.write("                                <i class=\"bi bi-coin\"></i>Fee(1/h): ");
      out.print( v.getFee());
      out.write("<br/>\n");
      out.write("                                <i class=\"bi bi-filter-square\"></i>Description :");
      out.print( v.getDescription());
      out.write("  <br/>\n");
      out.write("                                Venue : ");
      out.print( v.getStatus());
      out.write("\n");
      out.write("                                <input type=\"hidden\"  name=\"VenueId\" value=\"");
      out.print( v.getId());
      out.write("\">\n");
      out.write("                                <input type=\"hidden\"  name=\"fee\" value=\"");
      out.print( v.getFee());
      out.write("\">\n");
      out.write("\n");
      out.write("                            <div class=\"collapse\" id=\"collapseExample");
      out.print(i);
      out.write("\">\n");
      out.write("                                <div class=\"card card-body\">\n");
      out.write("                                    <span>\n");
      out.write("                                        <label for=\"dateInput\">日期:</label>\n");
      out.write("                                        <!--<input type=\"date\" value=\"\" id=\"selectdate\" name=\"selectdate\" min=\"\">-->                                \n");
      out.write("                                        <span id=\"datePicker");
      out.print( i);
      out.write("\" name=\"selectdate\" onchange=\"getdata(");
      out.print( i);
      out.write(")\" ></span>\n");
      out.write("                                        <input type=\"hidden\" id=\"dateInput");
      out.print( i);
      out.write("\" name=\"selectedDate\">\n");
      out.write("                                        <br>\n");
      out.write("                                        <label for=\"timeRange\">時間:</label>\n");
      out.write("                                        <input type=\"number\" style=\"width: 45px;\" name=\"StartTime\" min=\"9\" max=\"21\"> -\n");
      out.write("                                        <input type=\"number\" style=\"width: 45px;\" name=\"EndTrime\"  min=\"10\" max=\"21\">\n");
      out.write("                                    </span> \n");
      out.write("                                    input guest\n");
      out.write("                                    <input type=\"button\" value=\"+\" onclick=\"addInput(");
      out.print( i);
      out.write(")\"  style=\"width: 25px;\"/>\n");
      out.write("                                    <div id=\"input-gust");
      out.print(i);
      out.write("\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <input type=\"submit\" value=\"now booking\" class=\"btn btn-primary\"  name=\"nowBooking\">\n");
      out.write("                                <input type=\"submit\" value=\"Add rquest list\" class=\"btn btn-primary\" name=\"addBookingList\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card-footer\">\n");
      out.write("                            <small class=\"text-body-secondary\">\n");
      out.write("                                ");

                                    if (v.getStatus().equals("unavailable")) {
                                
      out.write("\n");
      out.write("                                <button disabled class=\"btn btn-primary\" data-bs-toggle=\"collapse\" href=\"#collapseExample");
      out.print(i);
      out.write("\" role=\"button\" aria-expanded=\"false\" aria-controls=\"collapseExample");
      out.print(i);
      out.write("\"  >\n");
      out.write("                                    booking\n");
      out.write("                                </buttona>\n");
      out.write("                                ");

                                } else {
                                
      out.write("  \n");
      out.write("                                <buttona  class=\"btn btn-primary\" data-bs-toggle=\"collapse\" href=\"#collapseExample");
      out.print(i);
      out.write("\" role=\"button\" aria-expanded=\"false\" aria-controls=\"collapseExample");
      out.print(i);
      out.write("\">\n");
      out.write("                                    booking\n");
      out.write("                                </buttona>\n");
      out.write("                                ");

                                    }
                                
      out.write("   \n");
      out.write("                            </small>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            ");

                    }
                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            let currentDate = new Date();\n");
      out.write("            let year = currentDate.getFullYear();\n");
      out.write("            let month = (\"0\" + (currentDate.getMonth() + 1)).slice(-2);\n");
      out.write("            let day = (\"0\" + currentDate.getDate()).slice(-2);\n");
      out.write("            let formattedDate = `");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${year}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('-');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${month}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('-');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${day}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("`;\n");
      out.write("\n");
      out.write("                document.getElementsByName(\"selectdate\").min = formattedDate;\n");
      out.write("                document.getElementsByName(\"selectdate\").value = formattedDate;\n");
      out.write("\n");
      out.write("                function addInput(id) {\n");
      out.write("\n");
      out.write("                    var containerName = document.getElementById(\"input-gust\" + id);\n");
      out.write("                    var newInputName = document.createElement(\"input\");\n");
      out.write("                    var containerEmail = document.getElementById(\"input-gust\" + id);\n");
      out.write("                    var newInputEmail = document.createElement(\"input\");\n");
      out.write("                    var nameDiv = document.createElement(\"div\");\n");
      out.write("\n");
      out.write("\n");
      out.write("                    newInputName.setAttribute(\"type\", \"text\");\n");
      out.write("                    newInputName.setAttribute(\"name\", \"guestName\");\n");
      out.write("                    containerName.appendChild(document.createTextNode(\"name: \"));\n");
      out.write("                    containerName.appendChild(newInputName);\n");
      out.write("\n");
      out.write("\n");
      out.write("                    newInputEmail.setAttribute(\"type\", \"text\");\n");
      out.write("                    newInputEmail.setAttribute(\"name\", \"guestEmail\");\n");
      out.write("                    containerEmail.appendChild(document.createTextNode(\"email: \"));\n");
      out.write("                    containerEmail.appendChild(newInputEmail);\n");
      out.write("\n");
      out.write("                    containerName.appendChild(nameDiv);\n");
      out.write("                }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                function generateDateOptions() {\n");
      out.write("                    // 取得今天的日期\n");
      out.write("                    var today = new Date();\n");
      out.write("            ");

                for (int i = 0; i < venue.size(); i++) {
            
      out.write("\n");
      out.write("                    // 產生下拉式選單的HTML\n");
      out.write("                    var selectHTML = '<select id=\"dateSelect");
      out.print( i);
      out.write("\">';\n");
      out.write("\n");
      out.write("                    // 產生七天內的日期選項\n");
      out.write("                    for (var i = 0; i < 7; i++) {\n");
      out.write("                        // 計算日期\n");
      out.write("                        var date = new Date();\n");
      out.write("                        date.setDate(today.getDate() + i);\n");
      out.write("\n");
      out.write("                        // 轉換日期為字串，格式為 YYYY-MM-DD\n");
      out.write("                        var dateString = date.toISOString().slice(0, 10);\n");
      out.write("\n");
      out.write("                        // 產生選項HTML\n");
      out.write("                        selectHTML += '<option value=\"' + dateString + '\">' + dateString + '</option>';\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    // 關閉下拉式選單的HTML標籤\n");
      out.write("                    selectHTML += '</select>';\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    // 將下拉式選單HTML寫入指定的元素中\n");
      out.write("                    document.getElementById('datePicker");
      out.print( i);
      out.write("').innerHTML = selectHTML;\n");
      out.write("\n");
      out.write("                    // 預設選擇今天的日期\n");
      out.write("                    document.getElementById('dateSelect");
      out.print( i);
      out.write("').value = today.toISOString().slice(0, 10);\n");
      out.write("                    var selectElement = document.getElementById('dateSelect");
      out.print( i);
      out.write("');\n");
      out.write("\n");
      out.write("                    // 獲取所選擇的日期的值\n");
      out.write("                    var selectdate = selectElement.options[selectElement.selectedIndex].value;\n");
      out.write("                    document.getElementById(\"dateInput");
      out.print( i);
      out.write("\").value = selectdate;\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                function getdata(a) {\n");
      out.write("                    var selectElement = document.getElementById('dateSelect' + a);\n");
      out.write("\n");
      out.write("                    // 獲取所選擇的日期的值\n");
      out.write("                    var selectdate = selectElement.options[selectElement.selectedIndex].value;\n");
      out.write("                    document.getElementById(\"dateInput\" + a).value = selectdate;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                function checkAvailability(a, id) {\n");
      out.write("                    // Get the selected time from the dropdown\n");
      out.write("                    var selectedTime = document.getElementById(\"dateInput\" + a).value;\n");
      out.write("\n");
      out.write("                    // Send a request to the server to check for availability\n");
      out.write("                    var xhr = new XMLHttpRequest();\n");
      out.write("                    xhr.onreadystatechange = function () {\n");
      out.write("                        if (xhr.readyState === 4 && xhr.status === 200) {\n");
      out.write("                            // Display the availability\n");
      out.write("                            document.getElementById(\"availability\").innerHTML = xhr.responseText;\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("                    xhr.open(\"GET\", \"bookingController?action=checktime&id=\" + id + \"&time=\" + encodeURIComponent(selectedTime), true);\n");
      out.write("                    xhr.send();\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                // 網頁載入時呼叫生成日期選單的函數\n");
      out.write("                generateDateOptions();\n");
      out.write("        </script>\n");
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
