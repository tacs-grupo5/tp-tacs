package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Tacs web application</title>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/jquery-1.5.1.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/test.js\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\t$(document).ready(function(){\n");
      out.write("\t\tvar sites = eval('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sites}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("');\n");
      out.write("\t\tfor(var i in sites){\n");
      out.write("\t\t\t$(\"#sitesTable\").append('<tr><td>' + eval(sites[i]).id + \n");
      out.write("\t\t\t\t\t'</td><td>' + eval(sites[i]).name + \"</td></tr>\");\n");
      out.write("\t\t}\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<h1>Sites de Mercado Libre</h1>\n");
      out.write("\t<table id=\"sitesTable\" border=\"1px;\">\n");
      out.write("\t\t<tr style=\"background: blue;color:white;\">\n");
      out.write("\t\t\t<td>Id</td>\n");
      out.write("\t\t\t<td>Nombre</td>\t\t\n");
      out.write("\t\t</tr>\n");
      out.write("\t</table>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
