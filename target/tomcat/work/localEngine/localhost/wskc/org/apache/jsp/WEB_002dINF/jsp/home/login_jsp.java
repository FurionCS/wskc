package org.apache.jsp.WEB_002dINF.jsp.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<!--<![endif]-->\r\n");
      out.write("<!-- BEGIN HEAD -->\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\"/>\r\n");
      out.write("<title>登录</title>\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no\">\r\n");
      out.write("<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<meta content=\"\" name=\"description\"/>\r\n");
      out.write("<meta content=\"\" name=\"author\"/>\r\n");
      out.write("<!-- BEGIN GLOBAL MANDATORY STYLES -->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/simple-line-icons/simple-line-icons.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/uniform/css/uniform.default.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<!-- END GLOBAL MANDATORY STYLES -->\r\n");
      out.write("<!-- BEGIN PAGE LEVEL STYLES -->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/select2/select2.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/pages/css/login-soft.css?v=1\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<!-- END PAGE LEVEL SCRIPTS -->\r\n");
      out.write("<!-- BEGIN THEME STYLES -->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/css/components-rounded.css\" id=\"style_components\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/css/plugins.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<!-- END THEME STYLES -->\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"favicon.ico\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<!-- END HEAD -->\r\n");
      out.write("<!-- BEGIN BODY -->\r\n");
      out.write("<body class=\"login\">\r\n");
      out.write("<!-- BEGIN LOGO -->\r\n");
      out.write("<div class=\"logo\">\r\n");
      out.write("\t<a href=\"index.html\">\r\n");
      out.write("\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/layout4/img/logo-big.png\" alt=\"\"/>\r\n");
      out.write("\t</a>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- END LOGO -->\r\n");
      out.write("<!-- BEGIN SIDEBAR TOGGLER BUTTON -->\r\n");
      out.write("<div class=\"menu-toggler sidebar-toggler\">\r\n");
      out.write("</div>\r\n");
      out.write("<!-- END SIDEBAR TOGGLER BUTTON -->\r\n");
      out.write("<!-- BEGIN LOGIN -->\r\n");
      out.write("<div class=\"content\">\r\n");
      out.write("\t<!-- BEGIN LOGIN FORM -->\r\n");
      out.write("\t<form class=\"login-form\" action=\"../home/checkLogin\" method=\"post\">\r\n");
      out.write("\t\t<h3 class=\"form-title\" style=\"text-align:center;\">库存系统</h3>\r\n");
      out.write("\t\t<div class=\"alert alert-danger display-hide\">\r\n");
      out.write("\t\t\t<button class=\"close\" data-close=\"alert\"></button>\r\n");
      out.write("\t\t\t<span>\r\n");
      out.write("\t\t\t输入正确的账号和密码. </span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->\r\n");
      out.write("\t\t\t<label class=\"control-label visible-ie8 visible-ie9\">用户名</label>\r\n");
      out.write("\t\t\t<div class=\"input-icon\">\r\n");
      out.write("\t\t\t\t<i class=\"fa fa-user\"></i>\r\n");
      out.write("\t\t\t\t<input class=\"form-control placeholder-no-fix\" type=\"text\" autocomplete=\"off\" placeholder=\"用户名\" name=\"userName\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label class=\"control-label visible-ie8 visible-ie9\">密码</label>\r\n");
      out.write("\t\t\t<div class=\"input-icon\">\r\n");
      out.write("\t\t\t\t<i class=\"fa fa-lock\"></i>\r\n");
      out.write("\t\t\t\t<input class=\"form-control placeholder-no-fix\" type=\"password\" autocomplete=\"off\" placeholder=\"密码\" name=\"userPassword\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-actions\">\r\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn blue col-md-12 col-xs-12\">\r\n");
      out.write("\t\t\t\t登录 \r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"forget-password\">\r\n");
      out.write("\t\t\t<a id=\"forget-password\"></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<!-- END LOGIN FORM -->\r\n");
      out.write("\t<!-- BEGIN FORGOT PASSWORD FORM -->\r\n");
      out.write("\t<form class=\"forget-form\" method=\"post\">\r\n");
      out.write("\t\t<h3>忘记密码 ?</h3>\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t\t\t 输入您的邮箱，获取密码？\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<div class=\"input-icon\">\r\n");
      out.write("\t\t\t\t<i class=\"fa fa-envelope\"></i>\r\n");
      out.write("\t\t\t\t<input class=\"form-control placeholder-no-fix\" type=\"text\" autocomplete=\"off\" placeholder=\"Email\" name=\"email\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-actions\">\r\n");
      out.write("\t\t\t<button type=\"button\" id=\"back-btn\" class=\"btn\">\r\n");
      out.write("\t\t\t<i class=\"m-icon-swapleft\"></i> 返回 </button>\r\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn blue pull-right\">\r\n");
      out.write("\t\t\t提交 <i class=\"m-icon-swapright m-icon-white\"></i>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<!-- END FORGOT PASSWORD FORM -->\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("<!-- END LOGIN -->\r\n");
      out.write("<input type=\"hidden\" id=\"error\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("<!-- BEGIN COPYRIGHT -->\r\n");
      out.write("<div class=\"copyright\">\r\n");
      out.write("\t 2016 &copy; cs.\r\n");
      out.write("</div>\r\n");
      out.write("<!-- END COPYRIGHT -->\r\n");
      out.write("<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->\r\n");
      out.write("<!-- BEGIN CORE PLUGINS -->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/respond.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/excanvas.min.js\"></script> \r\n");
      out.write("<![endif]-->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/jquery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/jquery-migrate.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/bootstrap/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/jquery.blockui.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/uniform/jquery.uniform.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/jquery.cokie.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- END CORE PLUGINS -->\r\n");
      out.write("<!-- BEGIN PAGE LEVEL PLUGINS -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/jquery-validation/js/jquery.validate.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/backstretch/jquery.backstretch.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/plugins/select2/select2.min.js\"></script>\r\n");
      out.write("<!-- END PAGE LEVEL PLUGINS -->\r\n");
      out.write("<!-- BEGIN PAGE LEVEL SCRIPTS -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/global/scripts/metronic.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/admin/pages/scripts/login-soft.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- END PAGE LEVEL SCRIPTS -->\r\n");
      out.write("<script>\r\n");
      out.write("jQuery(document).ready(function() {     \r\n");
      out.write("  Metronic.init(); // init metronic core components\r\n");
      out.write("\r\n");
      out.write("  Login.init();\r\n");
      out.write("       // init background slide images\r\n");
      out.write("       $.backstretch([\r\n");
      out.write("        \"../resources/admin/pages/media/bg/1.jpg\",\r\n");
      out.write("        \"../resources/admin/pages/media/bg/2.jpg\",\r\n");
      out.write("        \"../resources/admin/pages/media/bg/3.jpg\",\r\n");
      out.write("        \"../resources/admin/pages/media/bg/4.jpg\"\r\n");
      out.write("        ], {\r\n");
      out.write("          fade: 1000,\r\n");
      out.write("          duration: 8000\r\n");
      out.write("    }\r\n");
      out.write("    );\r\n");
      out.write("    if($(\"#error\").val()==1){\r\n");
      out.write("    \t$('.alert-danger', $('.login-form')).show();\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<!-- END JAVASCRIPTS -->\r\n");
      out.write("</body>\r\n");
      out.write("<!-- END BODY -->\r\n");
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
