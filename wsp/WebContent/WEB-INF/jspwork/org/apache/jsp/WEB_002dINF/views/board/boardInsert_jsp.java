/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-01-08 03:42:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class boardInsert_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
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
      out.write("<title>게시판</title>\r\n");
      out.write("<style>\r\n");
      out.write("    .insert-label {\r\n");
      out.write("      display: inline-block;\r\n");
      out.write("      width: 80px;\r\n");
      out.write("      line-height: 40px\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .boardImg{\r\n");
      out.write("    \tcursor : pointer;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"container my-5\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<h3>게시글 등록</h3>\r\n");
      out.write("\t\t\t<hr>\r\n");
      out.write("\t\t\t<!-- 파일 업로드를 위한 라이브러리 cos.jar 라이브러리 다운로드(http://www.servlets.com/) -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- \r\n");
      out.write("\t\t\t\t- enctype : form 태그 데이터가 서버로 제출 될 때 인코딩 되는 방법을 지정. (POST 방식일 때만 사용 가능)\r\n");
      out.write("\t\t\t\t- application/x-www-form-urlencoded : 모든 문자를 서버로 전송하기 전에 인코딩 (form태그 기본값)\r\n");
      out.write("\t\t\t\t- multipart/form-data : 모든 문자를 인코딩 하지 않음.(원본 데이터가 유지되어 이미지, 파일등을 서버로 전송 할 수 있음.) \r\n");
      out.write("\t\t\t-->\r\n");
      out.write("\t\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/insert.do\" method=\"post\" \r\n");
      out.write("\t\t\t\t  enctype=\"multipart/form-data\" role=\"form\" onsubmit=\"return boardValidate();\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"mb-2\">\r\n");
      out.write("\t\t\t\t\t<label class=\"input-group-addon mr-3 insert-label\">카테고리</label> \r\n");
      out.write("\t\t\t\t\t<select\tclass=\"custom-select\" id=\"categoryCode\" name=\"categoryCode\" style=\"width: 150px;\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"10\">운동</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"20\">영화</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"30\">음악</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"40\">요리</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"50\">게임</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"60\">기타</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-inline mb-2\">\r\n");
      out.write("\t\t\t\t\t<label class=\"input-group-addon mr-3 insert-label\">제목</label> \r\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"boardTitle\" name=\"boardTitle\" size=\"70\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"form-inline mb-2\">\r\n");
      out.write("\t\t\t\t\t<label class=\"input-group-addon mr-3 insert-label\">작성자</label>\r\n");
      out.write("\t\t\t\t\t<h5 class=\"my-0\" id=\"writer\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h5>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"form-inline mb-2\">\r\n");
      out.write("\t\t\t\t\t<label class=\"input-group-addon mr-3 insert-label\">작성일</label>\r\n");
      out.write("\t\t\t\t\t<h5 class=\"my-0\" id=\"today\"></h5>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<hr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"form-inline mb-2\">\r\n");
      out.write("\t\t\t\t\t<label class=\"input-group-addon mr-3 insert-label\">썸네일</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"boardImg\" id=\"titleImgArea\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"titleImg\" width=\"200\" height=\"200\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"form-inline mb-2\">\r\n");
      out.write("\t\t\t\t\t<label class=\"input-group-addon mr-3 insert-label\">업로드<br>이미지</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"mr-2 boardImg\" id=\"contentImgArea1\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"contentImg1\" width=\"150\" height=\"150\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"mr-2 boardImg\" id=\"contentImgArea2\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"contentImg2\" width=\"150\" height=\"150\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"mr-2 boardImg\" id=\"contentImgArea3\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"contentImg3\" width=\"150\" height=\"150\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- 파일 업로드 하는 부분 -->\r\n");
      out.write("\t\t\t\t<div id=\"fileArea\">\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" id=\"img0\" name=\"img0\" onchange=\"LoadImg(this,0)\"> \r\n");
      out.write("\t\t\t\t\t<input type=\"file\" id=\"img1\" name=\"img1\" onchange=\"LoadImg(this,1)\"> \r\n");
      out.write("\t\t\t\t\t<input type=\"file\" id=\"img2\" name=\"img2\" onchange=\"LoadImg(this,2)\"> \r\n");
      out.write("\t\t\t\t\t<input type=\"file\" id=\"img3\" name=\"img3\" onchange=\"LoadImg(this,3)\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"content\">내용</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<textarea class=\"form-control\" id=\"boardContent\" name=\"boardContent\" rows=\"15\" style=\"resize: none;\"></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<hr class=\"mb-4\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"text-center\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">등록</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\">목록으로</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t(function printToday(){\r\n");
      out.write("\t\t\t// 오늘 날짜 출력 \r\n");
      out.write("\t \t\tvar today = new Date();\r\n");
      out.write("\t\t\tvar month = (today.getMonth()+1);\r\n");
      out.write("\t\t\tvar date = today.getDate();\r\n");
      out.write("\t\r\n");
      out.write("\t  \tvar str = today.getFullYear() + \"-\"\r\n");
      out.write("\t        \t\t+ (month < 10 ? \"0\"+month : month) + \"-\"\r\n");
      out.write("\t        \t\t+ (date < 10 ? \"0\"+date : date);\r\n");
      out.write("\t\t\t$(\"#today\").html(str);\r\n");
      out.write("\t\t})();\r\n");
      out.write("\r\n");
      out.write("\t\t// 유효성 검사 \r\n");
      out.write("\t\tfunction boardValidate() {\r\n");
      out.write("\t\t\tif ($(\"#boardTitle\").val().trim().length == 0) {\r\n");
      out.write("\t\t\t\talert(\"제목을 입력해 주세요.\");\r\n");
      out.write("\t\t\t\t$(\"#boardTitle\").focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tif ($(\"#content\").val().trim().length == 0) {\r\n");
      out.write("\t\t\t\talert(\"내용을 입력해 주세요.\");\r\n");
      out.write("\t\t\t\t$(\"#content\").focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 이미지 영역을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t$(\"#fileArea\").hide(); // #fileArea 요소를 숨김.\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\".boardImg\").on(\"click\", function(){ // 이미지 영역이 클릭 되었을 때\r\n");
      out.write("\t\t\t\t// 클릭한 이미지 영역 인덱스 얻어오기\r\n");
      out.write("\t\t\t\tvar index = $(\".boardImg\").index(this);\r\n");
      out.write("\t\t\t\t\t\t// -> 클릭된 요소가 .boardImg 중 몇번째 인덱스인지 반환\r\n");
      out.write("\t\t\t\t// console.log(index);\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t// 클릭된 영역 인덱스에 맞는 input file 태그 클릭\r\n");
      out.write("\t\t\t\t$(\"#img\"+index).click();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t \r\n");
      out.write("\t  // 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수\r\n");
      out.write("\t  function LoadImg(value, num) {\r\n");
      out.write("\t\t\t// value.files : 파일이 업로드되어 있으면 true\r\n");
      out.write("\t\t\t// && value.files[0] : 여러 파일 중 첫번째 파일이 업로드 되어 있으면 true\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(value.files && value.files[0]) { // 해당요소에 업로드된 파일이 있을 경우\r\n");
      out.write("\t\t\t\tvar reader = new FileReader();\r\n");
      out.write("\t\t\t\t// 자바스크립트 FileReader\r\n");
      out.write("\t      // 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 \r\n");
      out.write("\t      // 읽을 파일을 가리키는 File 혹은 Blob객체를 이용해 \r\n");
      out.write("\t      // 파일의 내용을 읽고 사용자의 컴퓨터에 저장하는 것을 가능하게 해주는 객체\r\n");
      out.write("\r\n");
      out.write("\t      reader.readAsDataURL(value.files[0]);\r\n");
      out.write("\t   \t\t// FileReader.readAsDataURL()\r\n");
      out.write("\t      // 지정된의 내용을 읽기 시작합니다.\r\n");
      out.write("\t      // Blob완료되면 result속성 data:에 파일 데이터를 나타내는 URL이 포함 됩니다.\r\n");
      out.write("\r\n");
      out.write("\t      reader.onload = function(e) {\r\n");
      out.write("\t\t   \t\t// FileReader.onload\r\n");
      out.write("\t\t\t\t\t// load 이벤트의 핸들러.\r\n");
      out.write("\t\t\t\t\t// 이 이벤트는 읽기 동작이 성공적으로 완료 되었을 때마다 발생합니다.\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t// 읽어들인 내용(이미지 파일)을 화면에 출력\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$(\".boardImg\").eq(num).children(\"img\").attr(\"src\", e.target.result);\r\n");
      out.write("\t\t   \t\t// e.target.result : 파일 읽기 동작을 성공한 요소가 읽어들인 파일 내용\r\n");
      out.write("\t      }\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
