<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.edu.imnu.itoffter.dao.CompanyDAO"%>
<%@ page import="cn.edu.imnu.itoffter.info.Company"%>
<%@ page import="cn.edu.imnu.itoffter.info.Job"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>

<jsp:useBean id="pagination"class="cn.edu.imnu.itoffer.pagebean.CompanyPageBean" scope="page"></jsp:useBean>
<jsp:setProperty property="pageSize" value="2" name="pagination"/>
<jsp:setProperty property="pageNo" param="pageNo" name="pagination"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/index.css" type="text/css" rel="stylesheet" />
<script src="js/a.js" type="text/javascript"></script>

</head>
<body>
      <iframe src="top.jsp" width="100%" height="100"  scrolling="no" frameborder="0" ></iframe>
      <div id="tn-content" >
      <%CompanyDAO dao =new CompanyDAO();
      List<Company> list = dao.getCompanyList();
      if (list != null) {
    	  for(Company company : list) {
      %>
      <div class="tn-box tn-widget tn-widget-content tn-corner-all it-home-box">
          <div class="tn-box-content tn-widget-content tn-corner-all">
            <div class="it-company-keyimg tn-border-bottom tn-border-gray"> 
            <a href="recruit/company.html" target="_blank"> <img src="images<%= company.getCompanyPic() %>" width="990"> 
            </a> 
            </div>
            <%
                 Set<Job> jobs = company.getJobs();
                 if(jobs != null) {
                 for (Job job : jobs) {
             %>
             <div class="it-home-present">
             
              <div class="it-present-btn"> <a class=" tn-button tn-button-home-apply" href="#"> 
              <span class="tn-button-text">我要申请</span> 
              </a> 
              </div>
               <div class="it-present-text" style="padding-left:185px;">
                <div class="it-line01 it-text-bom">
                  <p class="it-text-tit">职位</p>
                  <div class="it-present-text">
                  </div>
                <div class="it-line01 it-text-top">
                  <p class="it-text-tit">薪资</p>
                  <p class="it-line01 it-text-explain"> <span class="tn-icon it-home-arrow"></span>
                   <b><%= job.getJobSalary() %></b> </p>
                </div>
              </div>
                  <p class="it-line01 it-text-explain"> 
                  <span class="tn-icon it-home-arrow"></span>
                   <span class="tn-helper-right tn-action">
                    <a href="job.html" target="_blank" class="tn-button tn-corner-all tn-button-text-only tn-button-semidlong"> 
                     <span class="tn-button-text">更多职位</span>
                      </a> 
                      </span>
                      <a href="job.html" target="_blank"><%= job.getJobName () %></a>
                       </p>
                       </div>
                       <div class="it-present-text">
                <div class="it-line01 it-text-bom">
                  <p class="it-text-tit">到期时间</p>
                  <p class="it-line01 it-text-explain">
                   <span class="tn-icon it-home-arrow"></span>
                   <b><%= job.getJobEnddate() %></b>
                   </p>
                   <div class="it-line01 it-text-bom">
                  <p class="it-text-tit">工作地区</p>
                  <p class="it-line01 it-text-explain">
                   <span class="tn-icon it-home-arrow"></span>
                   <b><%= job.getJobArea() %></b>
                   </p>
                   </div>
              </div>
            </div>
            <%
                      }
                 }
            %>
            </div>
          </div>
        </div>
        <%
                      }
                 }
        %>
         <div class="tn-grid">
        <div class="tn-box tn-widget tn-widget-content tn-corner-all it-home-box">
          <div class="page01">
          </div>
        </div>
        </div>
        <iframe src="foot.jsp" width="100%" height="150"  scrolling="no" frameborder="0" ></iframe>     
</body>
</html>