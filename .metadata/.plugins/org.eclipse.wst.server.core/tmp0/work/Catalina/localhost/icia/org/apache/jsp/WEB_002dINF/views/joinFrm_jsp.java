/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2020-02-12 01:44:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class joinFrm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write(".subject {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\theight: 50px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form name=\"joinFrm\" action=\"memberjoin\" method=\"post\"\r\n");
      out.write("\t\tonsubmit=\"return check()\">\r\n");
      out.write("\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" class=\"subject\">회원가입</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"100\">ID</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" id=\"id\" name=\"m_id\"> <input\r\n");
      out.write("\t\t\t\t\ttype=\"button\" id=\"checkId\" value=\"중복검사\" />\r\n");
      out.write("\t\t\t\t\t<div id=\"result\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"100\">PWD</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"password\" name=\"m_pwd\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"100\">NAME</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"m_name\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"100\">BIRTH</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"m_birth\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"100\">ADDR</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"m_addr\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"100\">PHONE</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"m_phone\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" class=\"subject\"><input type=\"submit\"\r\n");
      out.write("\t\t\t\t\tvalue=\"회원가입\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$('#checkId').on(\r\n");
      out.write("\t\t\t\t'click',\r\n");
      out.write("\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\tif ($('#id').val() != '') {\r\n");
      out.write("\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\ttype : 'get',\r\n");
      out.write("\t\t\t\t\t\t\turl : 'user/userid',\r\n");
      out.write("\t\t\t\t\t\t\tdata : 'm_id=' + $('#id').val(),\r\n");
      out.write("\t\t\t\t\t\t\t//dataType : 'html',\r\n");
      out.write("\t\t\t\t\t\t\tsuccess : function(data, status, xhr) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$('#result').html(data).css('color', 'red');\r\n");
      out.write("\t\t\t\t\t\t\t\tconsole.log(\"data=\", data);\r\n");
      out.write("\t\t\t\t\t\t\t\tconsole.log(\"status=\", status);\r\n");
      out.write("\t\t\t\t\t\t\t\tconsole.log(\"xhr=\", xhr);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\terror : function(xhr, status) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$('#result').html(xhr.responseText).css(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t'color', 'red');\r\n");
      out.write("\t\t\t\t\t\t\t\tconsole.log(\"xhr=\", xhr);\r\n");
      out.write("\t\t\t\t\t\t\t\tconsole.log(\"status=\", status);\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tfunction check() {\r\n");
      out.write("\t\t\tvar frm = document.joinFrm;\r\n");
      out.write("\t\t\tvar length = frm.length - 1;\r\n");
      out.write("\t\t\tfor (var i = 0; i < length; i++) {\r\n");
      out.write("\t\t\t\tif (frm[i].value == \"\") {\r\n");
      out.write("\t\t\t\t\talert(frm[i].name + \"을 입력하세요!!!\");\r\n");
      out.write("\t\t\t\t\tfrm[i].focus();\r\n");
      out.write("\t\t\t\t\treturn false; //실패시\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn true; //성공시 서버로 전송\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
