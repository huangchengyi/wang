<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册 - 锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/register.css" type="text/css" rel="stylesheet" />
<meta content="大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职" name="keywords">
<meta content="锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。" name="description">
</head>

<body>
	<iframe src="top.jsp" width="100%" height="100" scrolling="no"
		frameborder="0"></iframe>
	<form action="ApplicantRegisterServlet" method="post">
		<div class="content">
			<div class="page_name">注册</div>
			<div class="login_content">
				<div class="login_l">
					<div class="span1">
						<label class="tn-form-label">邮箱：</label> <input class="tn-textbox"
							type="text" name="email">
					</div>
					<div class="span1">
						<label class="tn-form-label">密码：</label> <input class="tn-textbox"
							type="password" name="password">
					</div>
					<div class="span1">
						<label class="tn-form-label">验证码：</label> <input
							class="tn-textbox-long" type="text"> <span> <img
							src="images/CaptchaImage.jpg" title="点击换一换"> <a
							href="javascript:;">看不清？</a>
						</span>
					</div>
	</form>
				<div class="tn-form-row-button">
					<div class="span1">
						<input name="" type="submit" class="tn-button-text" value="立即注册">
						<p class="it-register-text">
							<input name="" id="" class="tn-checkbox" value="true"
								checked="checked" type="checkbox"> <label>
								同意本站服务条款</label> <a href="javascript:;">查看</a>
						</p>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="register_r">
				<p align="center">
					<b>还没有帐号？</b><a href="register.html">10秒钟快速注册</a>
				</p>

				<div>
					<img src="images/reg_pic.jpg">
				</div>

				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<iframe src="foot.jsp" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>