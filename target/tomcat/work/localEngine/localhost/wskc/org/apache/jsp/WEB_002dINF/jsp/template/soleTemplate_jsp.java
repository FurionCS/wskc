package org.apache.jsp.WEB_002dINF.jsp.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class soleTemplate_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("  \n");
      out.write("<script type=\"text/html\" id=\"soleTemplate\">\n");
      out.write("\t<div class=\"row\">\n");
      out.write("\t\t\t<div class=\"col-md-8 col-xs-12 \">\n");
      out.write("\t\t\t\t\t\t\t<!-- BEGIN SAMPLE FORM PORTLET-->\n");
      out.write("\t\t\t\t\t\t\t<div class=\"portlet light\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"caption font-green\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"caption-subject bold uppercase\">采购编码:<a href=\"../sole/showSole?menuids=4_1&id={{id}}\">{{soleNo}}</a></span>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t<hr style=\"padding:0;margin:5px 0 0 0;\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"portlet-body form\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-8 col-sm-12 col-xs-12\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"portlet-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row static-info\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-5 col-sm-5  col-xs-5 name\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 产品名称\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-7 col-sm-7 col-xs-7 value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t {{productName}} \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row static-info\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-5 col-sm-5  col-xs-5 name\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 品牌名称\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-7 col-sm-7 col-xs-7 value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t {{brandName}}\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row static-info\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-5 col-sm-5  col-xs-5 name\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 商品总价\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-7 col-sm-7 col-xs-7 value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{num}}*{{price}}=￥{{num*price | doubleFormat}} (数量*单价)\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row static-info\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-5 col-sm-5  col-xs-5 name\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t状态\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-7 col-sm-7 col-xs-7 value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"label label-success\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{status |statusFormat}}\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row static-info\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-5 col-sm-5  col-xs-5 name\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 创建时间\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-7 col-sm-7 col-xs-7 value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{createTime | dateFormat:'yyyy年 MM月 dd日 hh:mm:ss'}}\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<!-- END SAMPLE FORM PORTLET-->\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("</script>\n");
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
