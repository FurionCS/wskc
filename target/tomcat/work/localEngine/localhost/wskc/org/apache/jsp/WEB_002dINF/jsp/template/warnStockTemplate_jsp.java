package org.apache.jsp.WEB_002dINF.jsp.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class warnStockTemplate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<script type=\"text/html\" id=\"warnStockTemplate\">\r\n");
      out.write("<a href=\"javascript:;\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" data-hover=\"dropdown\" data-close-others=\"true\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-bell\"></i>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"badge badge-danger\">\r\n");
      out.write("\t\t\t\t\t\t{{obj.length}} </span>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"external\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h3>您有<span class=\"bold\">{{obj.length}} 条</span>库存警告</h3>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu-list scroller\" style=\"height: 275px;\" data-handle-color=\"#637283\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{{each obj}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"photo\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t{{$value.brandName}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"subject\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"from\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{{$value.productName}}</span><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t库存：{{$value.num}},库存不足,警告值：{{$value.warnNum}}</span><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"\">{{$value.modifyTime | dateFormat:'yyyy年 MM月 dd日 hh:mm'}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{{/each}}\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t</script>");
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
