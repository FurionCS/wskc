package org.apache.jsp.WEB_002dINF.jsp.basic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;

public final class AddBrand_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/share/_LayoutB.jsp");
    _jspx_dependants.add("/WEB-INF/Mytag.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fLayout_005foverwrite_0026_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fLayout_005foverwrite_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fLayout_005foverwrite_0026_005fname.release();
    _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_Layout_005foverwrite_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_Layout_005foverwrite_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  Layout:overwrite
      org.cs.basic.layout.OverwriteTag _jspx_th_Layout_005foverwrite_005f2 = (org.cs.basic.layout.OverwriteTag) _005fjspx_005ftagPool_005fLayout_005foverwrite_0026_005fname.get(org.cs.basic.layout.OverwriteTag.class);
      _jspx_th_Layout_005foverwrite_005f2.setPageContext(_jspx_page_context);
      _jspx_th_Layout_005foverwrite_005f2.setParent(null);
      // /WEB-INF/jsp/basic/AddBrand.jsp(76,0) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_Layout_005foverwrite_005f2.setName("MyScript");
      int _jspx_eval_Layout_005foverwrite_005f2 = _jspx_th_Layout_005foverwrite_005f2.doStartTag();
      if (_jspx_eval_Layout_005foverwrite_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_Layout_005foverwrite_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_Layout_005foverwrite_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_Layout_005foverwrite_005f2.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("<script src=\"");
          out.print(request.getContextPath() );
          out.write("/resources/global/plugins/bootstrap-suggest-plugin.js\"></script>\r\n");
          out.write("<script src=\"");
          out.print(request.getContextPath() );
          out.write("/resources/js/my/Brand.js\"></script>\r\n");
          int evalDoAfterBody = _jspx_th_Layout_005foverwrite_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_Layout_005foverwrite_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_Layout_005foverwrite_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fLayout_005foverwrite_0026_005fname.reuse(_jspx_th_Layout_005foverwrite_005f2);
        return;
      }
      _005fjspx_005ftagPool_005fLayout_005foverwrite_0026_005fname.reuse(_jspx_th_Layout_005foverwrite_005f2);
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_Layout_005fblock_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<!-- BEGIN HEAD -->\r\n");
      out.write("<head>\r\n");
      out.write("<title>");
      if (_jspx_meth_Layout_005fblock_005f1(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta content=\"\" name=\"description\"/>\r\n");
      out.write("<meta content=\"\" name=\"author\"/>\r\n");
      out.write("<!-- BEGIN GLOBAL MANDATORY STYLES -->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/simple-line-icons/simple-line-icons.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/uniform/css/uniform.default.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<!-- END GLOBAL MANDATORY STYLES -->\r\n");
      out.write("<!-- BEGIN PAGE LEVEL STYLES -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/select2/select2.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css\"/>\r\n");
      out.write("<!-- END PAGE LEVEL STYLES -->\r\n");
      out.write("<!-- BEGIN THEME STYLES -->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/css/components-rounded.css\" id=\"style_components\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/css/plugins.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/css/layout.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link id=\"style_color\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/css/themes/light.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/css/custom.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/css/themes/default.css\" ref=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<!-- END THEME STYLES -->\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/img/mouse.ico\"/>\r\n");
      if (_jspx_meth_Layout_005fblock_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<!-- END HEAD -->\r\n");
      out.write("<!-- BEGIN BODY -->\r\n");
      out.write("<body class=\"page-header-fixed page-sidebar-closed-hide-logo \">\r\n");
      out.write("<!-- BEGIN HEADER -->\r\n");
      out.write("<div class=\"page-header navbar navbar-fixed-top\">\r\n");
      out.write("\t<!-- BEGIN HEADER INNER -->\r\n");
      out.write("\t<div class=\"page-header-inner\">\r\n");
      out.write("\t\t<!-- BEGIN LOGO -->\r\n");
      out.write("\t\t<div class=\"page-logo hidden-xs\">\r\n");
      out.write("\t\t\t<a href=\"index.html\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/img/logo-light.png\" alt=\"logo\" class=\"logo-default\"/>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t<div class=\"menu-toggler sidebar-toggler\" style=\"float:left\">\r\n");
      out.write("\t\t\t\t<!-- DOC: Remove the above \"hide\" to enable the sidebar toggler button on header -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- END LOGO -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!-- BEGIN PAGE TOP -->\r\n");
      out.write("\t\t<div class=\"page-top\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<!-- BEGIN TOP NAVIGATION MENU -->\r\n");
      out.write("\t\t\t<div class=\"top-menu\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav pull-right\">\r\n");
      out.write("\t\t\t\t\t<li class=\"separator hide\">\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<!-- BEGIN NOTIFICATION DROPDOWN -->\r\n");
      out.write("\t\t\t\t\t<!-- DOC: Apply \"dropdown-dark\" class after below \"dropdown-extended\" to change the dropdown styte -->\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown dropdown-extended dropdown-notification dropdown-dark\" id=\"header_notification_bar\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" data-hover=\"dropdown\" data-close-others=\"true\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-bell\"></i>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"badge badge-success\">\r\n");
      out.write("\t\t\t\t\t\t7 </span>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"external\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h3><span class=\"bold\">12 pending</span> notifications</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"extra_profile.html\">view all</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu-list scroller\" style=\"height: 250px;\" data-handle-color=\"#637283\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">just now</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"details\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"label label-sm label-icon label-success\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-plus\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tNew user registered. </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">3 mins</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"details\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"label label-sm label-icon label-danger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-bolt\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tServer #12 overloaded. </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">10 mins</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"details\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"label label-sm label-icon label-warning\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-bell-o\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tServer #2 not responding. </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">14 hrs</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"details\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"label label-sm label-icon label-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-bullhorn\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tApplication error. </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">2 days</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"details\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"label label-sm label-icon label-danger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-bolt\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tDatabase overloaded 68%. </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">3 days</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"details\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"label label-sm label-icon label-danger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-bolt\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tA user IP blocked. </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">4 days</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"details\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"label label-sm label-icon label-warning\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-bell-o\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tStorage Server #4 not responding dfdfdfd. </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">5 days</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"details\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"label label-sm label-icon label-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-bullhorn\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tSystem Error. </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">9 days</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"details\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"label label-sm label-icon label-danger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-bolt\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tStorage server failed. </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<!-- END NOTIFICATION DROPDOWN -->\r\n");
      out.write("\t\t\t\t\t<li class=\"separator hide\">\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<!-- BEGIN INBOX DROPDOWN -->\r\n");
      out.write("\t\t\t\t\t<!-- DOC: Apply \"dropdown-dark\" class after below \"dropdown-extended\" to change the dropdown styte -->\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown dropdown-extended dropdown-inbox dropdown-dark\" id=\"header_inbox_bar\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" data-hover=\"dropdown\" data-close-others=\"true\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-envelope-open\"></i>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"badge badge-danger\">\r\n");
      out.write("\t\t\t\t\t\t4 </span>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"external\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h3>You have <span class=\"bold\">7 New</span> Messages</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"inbox.html\">view all</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu-list scroller\" style=\"height: 275px;\" data-handle-color=\"#637283\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"inbox.html?a=view\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"photo\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/img/avatar2.jpg\" class=\"img-circle\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"subject\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"from\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tLisa Wong </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">Just Now </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"message\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tVivamus sed auctor nibh congue nibh. auctor nibh auctor nibh... </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"inbox.html?a=view\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"photo\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/img/avatar3.jpg\" class=\"img-circle\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"subject\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"from\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tRichard Doe </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">16 mins </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"message\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tVivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"inbox.html?a=view\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"photo\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/img/avatar1.jpg\" class=\"img-circle\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"subject\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"from\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tBob Nilson </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">2 hrs </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"message\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tVivamus sed nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"inbox.html?a=view\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"photo\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/img/avatar2.jpg\" class=\"img-circle\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"subject\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"from\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tLisa Wong </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">40 mins </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"message\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tVivamus sed auctor 40% nibh congue nibh... </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"inbox.html?a=view\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"photo\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/img/avatar3.jpg\" class=\"img-circle\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"subject\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"from\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tRichard Doe </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"time\">46 mins </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"message\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tVivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<!-- END INBOX DROPDOWN -->\r\n");
      out.write("\t\t\t\t\t<li class=\"separator hide\">\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<!-- BEGIN TODO DROPDOWN -->\r\n");
      out.write("\t\t\t\t\t<!-- DOC: Apply \"dropdown-dark\" class after below \"dropdown-extended\" to change the dropdown styte -->\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown dropdown-extended dropdown-tasks dropdown-dark\" id=\"header_task_bar\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" data-hover=\"dropdown\" data-close-others=\"true\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-calendar\"></i>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"badge badge-primary\">\r\n");
      out.write("\t\t\t\t\t\t3 </span>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu extended tasks\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"external\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h3>You have <span class=\"bold\">12 pending</span> tasks</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"page_todo.html\">view all</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu-list scroller\" style=\"height: 275px;\" data-handle-color=\"#637283\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"task\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"desc\">New release v1.2 </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"percent\">30%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"progress\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span style=\"width: 40%;\" class=\"progress-bar progress-bar-success\" aria-valuenow=\"40\" aria-valuemin=\"0\" aria-valuemax=\"100\"><span class=\"sr-only\">40% Complete</span></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"task\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"desc\">Application deployment</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"percent\">65%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"progress\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span style=\"width: 65%;\" class=\"progress-bar progress-bar-danger\" aria-valuenow=\"65\" aria-valuemin=\"0\" aria-valuemax=\"100\"><span class=\"sr-only\">65% Complete</span></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"task\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"desc\">Mobile app release</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"percent\">98%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"progress\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span style=\"width: 98%;\" class=\"progress-bar progress-bar-success\" aria-valuenow=\"98\" aria-valuemin=\"0\" aria-valuemax=\"100\"><span class=\"sr-only\">98% Complete</span></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"task\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"desc\">Database migration</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"percent\">10%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"progress\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span style=\"width: 10%;\" class=\"progress-bar progress-bar-warning\" aria-valuenow=\"10\" aria-valuemin=\"0\" aria-valuemax=\"100\"><span class=\"sr-only\">10% Complete</span></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"task\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"desc\">Web server upgrade</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"percent\">58%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"progress\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span style=\"width: 58%;\" class=\"progress-bar progress-bar-info\" aria-valuenow=\"58\" aria-valuemin=\"0\" aria-valuemax=\"100\"><span class=\"sr-only\">58% Complete</span></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"task\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"desc\">Mobile development</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"percent\">85%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"progress\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span style=\"width: 85%;\" class=\"progress-bar progress-bar-success\" aria-valuenow=\"85\" aria-valuemin=\"0\" aria-valuemax=\"100\"><span class=\"sr-only\">85% Complete</span></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"task\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"desc\">New UI release</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"percent\">38%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"progress progress-striped\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span style=\"width: 38%;\" class=\"progress-bar progress-bar-important\" aria-valuenow=\"18\" aria-valuemin=\"0\" aria-valuemax=\"100\"><span class=\"sr-only\">38% Complete</span></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<!-- END TODO DROPDOWN -->\r\n");
      out.write("\t\t\t\t\t<!-- BEGIN USER LOGIN DROPDOWN -->\r\n");
      out.write("\t\t\t\t\t<!-- DOC: Apply \"dropdown-dark\" class after below \"dropdown-extended\" to change the dropdown styte -->\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown dropdown-user dropdown-dark\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" data-hover=\"dropdown\" data-close-others=\"true\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"username username-hide-on-mobile\">\r\n");
      out.write("\t\t\t\t\t\t<s:property value=\"#session.admin.username\"/> </span>\r\n");
      out.write("\t\t\t\t\t\t<!-- DOC: Do not remove below empty space(&nbsp;) as its purposely used -->\r\n");
      out.write("\t\t\t\t\t\t<img alt=\"\" class=\"img-circle\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/img/avatar9.jpg\"/>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-menu-default\">\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"extra_profile.html\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"icon-user\"></i> My Profile </a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"page_calendar.html\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"icon-calendar\"></i> My Calendar </a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"inbox.html\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"icon-envelope-open\"></i> My Inbox <span class=\"badge badge-danger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t3 </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"page_todo.html\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"icon-rocket\"></i> My Tasks <span class=\"badge badge-success\">\r\n");
      out.write("\t\t\t\t\t\t\t\t7 </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\">\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"../home/lock\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"icon-lock\"></i>锁屏</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"../home/logout\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"icon-key\"></i> 退出 </a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<!-- END USER LOGIN DROPDOWN -->\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- END TOP NAVIGATION MENU -->\r\n");
      out.write("\t\t\t\t<!-- BEGIN RESPONSIVE MENU TOGGLER -->\r\n");
      out.write("\t\t\t<a href=\"javascript:;\" class=\"menu-toggler responsive-toggler\" data-toggle=\"collapse\" data-target=\".navbar-collapse\" style=\"float: left;margin-left: 20px;\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t<!-- END RESPONSIVE MENU TOGGLER -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- END PAGE TOP -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- END HEADER INNER -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- END HEADER -->\r\n");
      out.write("<div class=\"clearfix\">\r\n");
      out.write("</div>\r\n");
      out.write("<!-- BEGIN CONTAINER -->\r\n");
      out.write("<div class=\"page-container\">\r\n");
      out.write("\t<!-- BEGIN SIDEBAR -->\r\n");
      out.write("\t<div class=\"page-sidebar-wrapper\">\r\n");
      out.write("\t\t<div class=\"page-sidebar navbar-collapse collapse\">\r\n");
      out.write("\t\t\t<ul class=\"page-sidebar-menu \" id=\"menuall\" data-keep-expanded=\"false\" data-auto-scroll=\"true\" data-slide-speed=\"200\">\r\n");
      out.write("\t\t\t\t<li class=\"start active\">\r\n");
      out.write("\t\t\t\t\t<a href=\"admin\">\r\n");
      out.write("\t\t\t\t\t<i class=\"icon-home\"></i>\r\n");
      out.write("\t\t\t\t\t<span  class=\"title selected\">首页</span>\r\n");
      out.write("\t\t\t\t\t <span class=\"arrow\"></span>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t <li id=\"menupage2\">\r\n");
      out.write("                    <a href=\"javascript:;\">\r\n");
      out.write("                        <i class=\"icon-diamond\"></i>\r\n");
      out.write("                        <span class=\"title\">基础档案</span>\r\n");
      out.write("                        <span class=\"arrow \"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                     <ul class=\"sub-menu\">\r\n");
      out.write("                     \t<li id=\"menupage2_1\">\r\n");
      out.write("                            <a href=\"../basic/industryList?menuids=2_1\"> <i class=\"fa fa-briefcase\"></i>所属行业</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li id=\"menupage2_2\">\r\n");
      out.write("                            <a href=\"../basic/brandList?menuids=2_2&industryId=0\"> <i class=\"fa fa-circle-o-notch\"></i>拥有品牌</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li id=\"menupage2_1\">\r\n");
      out.write("                            <a href=\"../Commodity/CommodityClassList.jsp?active=menupage2_1\"><i class=\"fa fa-turkish-lira\"></i>旗下产品</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li id=\"menupage3\">\r\n");
      out.write("                    <a href=\"javascript:;\">\r\n");
      out.write("                        <i class=\"fa fa-list-alt\"></i>\r\n");
      out.write("                        <span class=\"title\">采购管理</span>\r\n");
      out.write("                        <span class=\"arrow \"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                     <ul class=\"sub-menu\">\r\n");
      out.write("                        <li id=\"menupage3_0\">\r\n");
      out.write("                            <a href=\"../Order/OrderList.jsp?active=menupage3_0\"><i class=\"fa  fa-list-ul\"></i>采购<span class=\"badge badge-roundless badge-danger\">new</span></a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li id=\"menupage3_0\">\r\n");
      out.write("                            <a href=\"../Order/OrderList.jsp?active=menupage3_0\"><i class=\"fa   fa-align-justify\"></i>采购列表</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li id=\"menupage4\">\r\n");
      out.write("                    <a href=\"javascript:;\">\r\n");
      out.write("                        <i class=\"fa fa-table\"></i>\r\n");
      out.write("                        <span class=\"title\">销售管理</span>\r\n");
      out.write("                        <span class=\"arrow \"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                     <ul class=\"sub-menu\">\r\n");
      out.write("                        <li id=\"menupage4_0\">\r\n");
      out.write("                            <a href=\"../User/UserList.jsp?active=menupage4_0\"><i class=\"fa fa-th\"></i>销售</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li id=\"menupage4_1\">\r\n");
      out.write("                            <a href=\"../User/AddUser.jsp?active=menupage4_1\"><i class=\"fa fa-th\"></i>销售列表</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("\t\t\t\t <li id=\"menupage5\">\r\n");
      out.write("                    <a href=\"javascript:;\">\r\n");
      out.write("                        <i class=\"fa fa-eye\"></i>\r\n");
      out.write("                        <span class=\"title\">库存管理</span>\r\n");
      out.write("                        <span class=\"arrow \"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                     <ul class=\"sub-menu\">\r\n");
      out.write("                        <li id=\"menupage5_0\">\r\n");
      out.write("                            <a href=\"../test/test2.jsp?active=menupage5_0\"> <i class=\"fa  fa-circle-o\"></i>调拨单</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                         <li id=\"menupage5_0\">\r\n");
      out.write("                            <a href=\"../test/test2.jsp?active=menupage5_0\"><i class=\"fa fa-signal\"></i>其他入库单</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                         <li id=\"menupage5_0\">\r\n");
      out.write("                            <a href=\"../test/test2.jsp?active=menupage5_0\"><i class=\"fa fa-bar-chart-o\"></i>其他出库单</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li id=\"menupage5_1\">\r\n");
      out.write("                            <a href=\"../test/test2.jsp?active=menupage5_0\"><i class=\"fa fa-tachometer\"></i>库存量查询</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                         \r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li id=\"menupage6\">\r\n");
      out.write("                    <a href=\"javascript:;\">\r\n");
      out.write("                        <i class=\"fa fa-mortar-board\"></i>\r\n");
      out.write("                        <span class=\"title\">报表查询</span>\r\n");
      out.write("                        <span class=\"arrow \"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                     <ul class=\"sub-menu\">\r\n");
      out.write("                        <li id=\"menupage6_0\">\r\n");
      out.write("                            <a href=\"javascript:void(0)\"><i class=\"fa fa-male\"></i>采购报表<span class=\"arrow \"></span></a>\r\n");
      out.write("                            <ul class=\"sub-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li id=\"menupage6_0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"../admin/add?menuids=6_0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t采购统计表\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li id=\"menupage6_0_1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"../admin/list?menuids=6_0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t采购明细表\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li id=\"menupage6_1\">\r\n");
      out.write("                            <a href=\"javascript:void(0)\"><i class=\"fa fa-user\"></i>销售报表 <span class=\"arrow \"></span></a>\r\n");
      out.write("                            <ul class=\"sub-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li id=\"menupage6_1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"../role/add?menuids=6_1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t销售统计表\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li id=\"menupage6_1_1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"../role/roles?menuids=6_1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t销售毛利统计表\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li id=\"menupage6_2\">\r\n");
      out.write("                            <a href=\"javascript:void(0)\"><i class=\"fa fa-users\"></i>组别 <span class=\"arrow \"></a>\r\n");
      out.write("                            <ul class=\"sub-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li id=\"menupage6_2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"../group/add?menuids=6_2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t添加组别\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li id=\"menupage6_2_1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"../group/groups?menuids=6_2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t组别列表\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li id=\"menupage6_3\">\r\n");
      out.write("                            <a href=\"../resource/list?menuids=6_3\"><i class=\"fa  fa-graduation-cap\"></i>权限</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li id=\"menupage7\">\r\n");
      out.write("                    <a href=\"javascript:;\">\r\n");
      out.write("                        <i class=\"fa fa-eye\"></i>\r\n");
      out.write("                        <span class=\"title\">系统管理</span>\r\n");
      out.write("                        <span class=\"arrow \"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                     <ul class=\"sub-menu\">\r\n");
      out.write("                        <li id=\"menupage7_0\">\r\n");
      out.write("                            <a href=\"../test/test2.jsp?active=menupage7_0\"> <i class=\"fa  fa-circle-o\"></i>用户管理</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                         <li id=\"menupage7_0\">\r\n");
      out.write("                            <a href=\"../test/test2.jsp?active=menupage7_0\"><i class=\"fa fa-signal\"></i>用户日志</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                         <li id=\"menupage7_0\">\r\n");
      out.write("                            <a href=\"../test/test2.jsp?active=menupage7_0\"><i class=\"fa fa-bar-chart-o\"></i>系统配置<span class=\"arrow \"></a>\r\n");
      out.write("                             <ul class=\"sub-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li id=\"menupage6_2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"../group/add?menuids=6_2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t角色管理\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li id=\"menupage6_2_1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"../group/groups?menuids=6_2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t角色权限管理\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t\t<!-- END SIDEBAR MENU -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- END SIDEBAR -->\r\n");
      out.write("\t<!-- BEGIN CONTENT -->\r\n");
      out.write("\t<div class=\"page-content-wrapper\">\r\n");
      out.write("\t\t<div class=\"page-content\">\r\n");
      out.write("\t\t\t<!-- BEGIN PAGE HEADER-->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- END PAGE HEADER-->\r\n");
      out.write("\t\t\t<!-- BEGIN PAGE CONTENT-->\r\n");
      out.write("\t \t");
      if (_jspx_meth_Layout_005fblock_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- END CONTENT -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- END CONTAINER -->\r\n");
      out.write("<input id=\"menu\"  value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${menuids}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("' hidden/>\r\n");
      out.write("<!-- BEGIN FOOTER -->\r\n");
      out.write("<div class=\"page-footer hidden-xs\">\r\n");
      out.write("\t<div class=\"page-footer-inner\">\r\n");
      out.write("\t\t 2016 &copy; NetShop by cs. <a href=\"http://github.com/FurionCS\" title=\"程胜的github\" target=\"_blank\">github</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"scroll-to-top\">\r\n");
      out.write("\t\t<i class=\"icon-arrow-up\"></i>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- <div id=\"coverdiv\"> <div id=\"cover\"> </div> \t</div> -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/jquery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/jquery-migrate.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/jquery-ui/jquery-ui.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/bootstrap/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/jquery.blockui.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/jquery.cokie.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/uniform/jquery.uniform.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/wloften.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- END CORE PLUGINS -->\r\n");
      out.write("<!-- BEGIN PAGE LEVEL PLUGINS -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/select2/select2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/datatables/media/js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js\"></script>\r\n");
      out.write("<!-- END PAGE LEVEL PLUGINS -->\r\n");
      out.write("<!-- BEGIN PAGE LEVEL SCRIPTS -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/scripts/metronic.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/scripts/layout.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/scripts/demo.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/pages/scripts/table-managed.js\"></script>\r\n");
      out.write("<!-- beigin noty -->\r\n");
      out.write(" <script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/noty/jquery.noty.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/noty/packaged/jquery.noty.packaged.js\" type=\"text/javascript\"></script>\r\n");
      out.write("     <script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/noty/layouts/topCenter.js\" type=\"text/javascript\"></script>\r\n");
      out.write("     <script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/noty/themes/default.js\" type=\"text/javascript\"></script>\r\n");
      out.write(" <!-- end noty -->   \r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/core/jquery.basic.tool.js\" type=\"text/javascript\"></script>\r\n");
      if (_jspx_meth_Layout_005fblock_005f4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("jQuery(document).ready(function() {       \r\n");
      out.write("   Metronic.init(); // init metronic core components\r\n");
      out.write("   Layout.init(); // init current layout\r\n");
      out.write("   var menuid =\"menupage\"+$(\"#menu\").val();\r\n");
      out.write("   if (menuid == null || menuid == \"menupage\") {\r\n");
      out.write("       return;\r\n");
      out.write("   }\r\n");
      out.write("   else {\r\n");
      out.write("       $(\"#menuall\").children().removeClass(\"active\");\r\n");
      out.write("       $(\"#\" + menuid).addClass(\"active\");\r\n");
      out.write("       $(\"#\" + menuid).children(\"a\").children(\".arrow\").addClass(\"open\");\r\n");
      out.write("\t\t\r\n");
      out.write("       if (menuid.split(\"_\").length > 1) {\r\n");
      out.write("           $(\"#\" + menuid.split(\"_\")[0]).addClass(\"active\");\r\n");
      out.write("           $(\"#\" + menuid.split(\"_\")[0]).children(\"a\").children(\".arrow\").addClass(\"open\");\r\n");
      out.write("           $(\"#\" + menuid.split(\"_\")[0]).children(\"a\").append(\"<span class=\\\"selected\\\"></span>\");\r\n");
      out.write("       }\r\n");
      out.write("   }\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("<!-- END BODY -->\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_Layout_005foverwrite_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  Layout:overwrite
    org.cs.basic.layout.OverwriteTag _jspx_th_Layout_005foverwrite_005f0 = (org.cs.basic.layout.OverwriteTag) _005fjspx_005ftagPool_005fLayout_005foverwrite_0026_005fname.get(org.cs.basic.layout.OverwriteTag.class);
    _jspx_th_Layout_005foverwrite_005f0.setPageContext(_jspx_page_context);
    _jspx_th_Layout_005foverwrite_005f0.setParent(null);
    // /WEB-INF/jsp/basic/AddBrand.jsp(6,0) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_Layout_005foverwrite_005f0.setName("title");
    int _jspx_eval_Layout_005foverwrite_005f0 = _jspx_th_Layout_005foverwrite_005f0.doStartTag();
    if (_jspx_eval_Layout_005foverwrite_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_Layout_005foverwrite_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_Layout_005foverwrite_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_Layout_005foverwrite_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("添加品牌\r\n");
        int evalDoAfterBody = _jspx_th_Layout_005foverwrite_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_Layout_005foverwrite_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_Layout_005foverwrite_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fLayout_005foverwrite_0026_005fname.reuse(_jspx_th_Layout_005foverwrite_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fLayout_005foverwrite_0026_005fname.reuse(_jspx_th_Layout_005foverwrite_005f0);
    return false;
  }

  private boolean _jspx_meth_Layout_005foverwrite_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  Layout:overwrite
    org.cs.basic.layout.OverwriteTag _jspx_th_Layout_005foverwrite_005f1 = (org.cs.basic.layout.OverwriteTag) _005fjspx_005ftagPool_005fLayout_005foverwrite_0026_005fname.get(org.cs.basic.layout.OverwriteTag.class);
    _jspx_th_Layout_005foverwrite_005f1.setPageContext(_jspx_page_context);
    _jspx_th_Layout_005foverwrite_005f1.setParent(null);
    // /WEB-INF/jsp/basic/AddBrand.jsp(10,0) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_Layout_005foverwrite_005f1.setName("MyContent");
    int _jspx_eval_Layout_005foverwrite_005f1 = _jspx_th_Layout_005foverwrite_005f1.doStartTag();
    if (_jspx_eval_Layout_005foverwrite_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_Layout_005foverwrite_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_Layout_005foverwrite_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_Layout_005foverwrite_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("<div class=\"page-head\">\r\n");
        out.write("\t<!-- BEGIN PAGE TITLE -->\r\n");
        out.write("\t<div class=\"page-title hidden-xs\">\r\n");
        out.write("\t\t<h1>添加品牌</h1>\r\n");
        out.write("\t</div>\r\n");
        out.write("\t<!-- END PAGE TITLE -->\r\n");
        out.write("</div>\r\n");
        out.write("<ul class=\"page-breadcrumb breadcrumb\">\r\n");
        out.write("\t\t<li>\r\n");
        out.write("\t\t\t<a href=\"javascript:void(0)\">基础档案</a>\r\n");
        out.write("\t\t\t<i class=\"fa fa-circle\"></i>\r\n");
        out.write("\t\t</li>\r\n");
        out.write("\t\t<li>\r\n");
        out.write("\t\t\t<a href=\"javascript:void(0)\">品牌管理</a>\r\n");
        out.write("\t\t</li>\r\n");
        out.write("</ul>\r\n");
        out.write("<div class=\"row\">\r\n");
        out.write("\t<div class=\"col-md-8 col-xs-12 \">\r\n");
        out.write("\t\t\t\t\t<!-- BEGIN SAMPLE FORM PORTLET-->\r\n");
        out.write("\t\t\t\t\t<div class=\"portlet light\">\r\n");
        out.write("\t\t\t\t\t\t<div class=\"portlet-title\">\r\n");
        out.write("\t\t\t\t\t\t\t<div class=\"caption font-green\">\r\n");
        out.write("\t\t\t\t\t\t\t\t<i class=\"icon-pin font-green\"></i>\r\n");
        out.write("\t\t\t\t\t\t\t\t<span class=\"caption-subject bold uppercase\">添加品牌</span>\r\n");
        out.write("\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t<div class=\"portlet-body form\">\r\n");
        out.write("\t\t\t\t\t\t\t<form role=\"form\">\r\n");
        out.write("\t\t\t\t\t\t\t\t<div class=\"form-body\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\"> \r\n");
        out.write("\t\t\t\t\t\t\t\t\t<label for=\"taobao\">品牌</label>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t  <div class=\"input-group\">\r\n");
        out.write("\t\t\t\t\t                        <input type=\"text\" class=\"form-control\" id=\"brand\">\r\n");
        out.write("\t\t\t\t\t                        <div class=\"input-group-btn\">\r\n");
        out.write("\t\t\t\t\t                            <button type=\"button\" class=\"btn btn-default dropdown-toggle\" data-toggle=\"dropdown\" style=\"height: 34px;\">\r\n");
        out.write("\t\t\t\t\t                                <span class=\"caret\"></span>\r\n");
        out.write("\t\t\t\t\t                            </button>\r\n");
        out.write("\t\t\t\t\t                            <ul class=\"dropdown-menu dropdown-menu-right\" role=\"menu\">\r\n");
        out.write("\t\t\t\t\t                            </ul>\r\n");
        out.write("\t\t\t\t\t                        </div>\r\n");
        out.write("\t\t\t\t\t                        <!-- /btn-group -->\r\n");
        out.write("\t\t\t\t\t                    </div>\r\n");
        out.write("\t\t\t\t\t                  </div>\r\n");
        out.write("\t\t\t\t\t                <div class=\"form-group form-md-line-input has-success\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"code\" placeholder=\"授权码为8位,可不填\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"form_control_1\">授权码</label>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group form-md-line-input has-warning\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"remark\" placeholder=\"用于标记上家,可不填\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"form_control_1\">上家备注</label>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t\t\t<div class=\"form-actions noborder\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"btn btn-lg blue\" onclick=\"submitBrand()\">提交</a>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<a href=\"../basic/brandList?menuids=2_2&industryId=0\" class=\"btn btn-lg default\">返回</a>\r\n");
        out.write("\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t\t</form>\r\n");
        out.write("\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t<!-- END SAMPLE FORM PORTLET-->\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("</div>\r\n");
        out.write("<input type=\"hidden\" id=\"brandId\"/>\r\n");
        out.write("<input type=\"hidden\" id=\"brandName\"/>\r\n");
        int evalDoAfterBody = _jspx_th_Layout_005foverwrite_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_Layout_005foverwrite_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_Layout_005foverwrite_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fLayout_005foverwrite_0026_005fname.reuse(_jspx_th_Layout_005foverwrite_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fLayout_005foverwrite_0026_005fname.reuse(_jspx_th_Layout_005foverwrite_005f1);
    return false;
  }

  private boolean _jspx_meth_Layout_005fblock_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  Layout:block
    org.cs.basic.layout.BlockTag _jspx_th_Layout_005fblock_005f0 = (org.cs.basic.layout.BlockTag) _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.get(org.cs.basic.layout.BlockTag.class);
    _jspx_th_Layout_005fblock_005f0.setPageContext(_jspx_page_context);
    _jspx_th_Layout_005fblock_005f0.setParent(null);
    // /share/_LayoutB.jsp(6,0) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_Layout_005fblock_005f0.setName("import");
    int _jspx_eval_Layout_005fblock_005f0 = _jspx_th_Layout_005fblock_005f0.doStartTag();
    if (_jspx_th_Layout_005fblock_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.reuse(_jspx_th_Layout_005fblock_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.reuse(_jspx_th_Layout_005fblock_005f0);
    return false;
  }

  private boolean _jspx_meth_Layout_005fblock_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  Layout:block
    org.cs.basic.layout.BlockTag _jspx_th_Layout_005fblock_005f1 = (org.cs.basic.layout.BlockTag) _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.get(org.cs.basic.layout.BlockTag.class);
    _jspx_th_Layout_005fblock_005f1.setPageContext(_jspx_page_context);
    _jspx_th_Layout_005fblock_005f1.setParent(null);
    // /share/_LayoutB.jsp(15,7) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_Layout_005fblock_005f1.setName("title");
    int _jspx_eval_Layout_005fblock_005f1 = _jspx_th_Layout_005fblock_005f1.doStartTag();
    if (_jspx_th_Layout_005fblock_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.reuse(_jspx_th_Layout_005fblock_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.reuse(_jspx_th_Layout_005fblock_005f1);
    return false;
  }

  private boolean _jspx_meth_Layout_005fblock_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  Layout:block
    org.cs.basic.layout.BlockTag _jspx_th_Layout_005fblock_005f2 = (org.cs.basic.layout.BlockTag) _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.get(org.cs.basic.layout.BlockTag.class);
    _jspx_th_Layout_005fblock_005f2.setPageContext(_jspx_page_context);
    _jspx_th_Layout_005fblock_005f2.setParent(null);
    // /share/_LayoutB.jsp(40,0) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_Layout_005fblock_005f2.setName("Mycss");
    int _jspx_eval_Layout_005fblock_005f2 = _jspx_th_Layout_005fblock_005f2.doStartTag();
    if (_jspx_th_Layout_005fblock_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.reuse(_jspx_th_Layout_005fblock_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.reuse(_jspx_th_Layout_005fblock_005f2);
    return false;
  }

  private boolean _jspx_meth_Layout_005fblock_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  Layout:block
    org.cs.basic.layout.BlockTag _jspx_th_Layout_005fblock_005f3 = (org.cs.basic.layout.BlockTag) _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.get(org.cs.basic.layout.BlockTag.class);
    _jspx_th_Layout_005fblock_005f3.setPageContext(_jspx_page_context);
    _jspx_th_Layout_005fblock_005f3.setParent(null);
    // /share/_LayoutB.jsp(618,3) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_Layout_005fblock_005f3.setName("MyContent");
    int _jspx_eval_Layout_005fblock_005f3 = _jspx_th_Layout_005fblock_005f3.doStartTag();
    if (_jspx_th_Layout_005fblock_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.reuse(_jspx_th_Layout_005fblock_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.reuse(_jspx_th_Layout_005fblock_005f3);
    return false;
  }

  private boolean _jspx_meth_Layout_005fblock_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  Layout:block
    org.cs.basic.layout.BlockTag _jspx_th_Layout_005fblock_005f4 = (org.cs.basic.layout.BlockTag) _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.get(org.cs.basic.layout.BlockTag.class);
    _jspx_th_Layout_005fblock_005f4.setPageContext(_jspx_page_context);
    _jspx_th_Layout_005fblock_005f4.setParent(null);
    // /share/_LayoutB.jsp(666,0) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_Layout_005fblock_005f4.setName("MyScript");
    int _jspx_eval_Layout_005fblock_005f4 = _jspx_th_Layout_005fblock_005f4.doStartTag();
    if (_jspx_th_Layout_005fblock_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.reuse(_jspx_th_Layout_005fblock_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fLayout_005fblock_0026_005fname_005fnobody.reuse(_jspx_th_Layout_005fblock_005f4);
    return false;
  }
}