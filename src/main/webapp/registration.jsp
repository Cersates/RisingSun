<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page import="com.dataart.risingsun.app.Constants"%>
<%@ include file="/jspf/meta.jspf"%>
<title>Registration</title>
</head>

<body>
	<div id="wrapper">

		<!-- Header -->
		<div id="header">
			<%@ include file="/jspf/header.jspf"%>
		</div>

		<!-- menu bar -->
		<div id="menu_pane">
			<%@ include file="/jspf/menubar.jspf"%>
		</div>

		<!-- Content  -->
		<div id="content">

			<!-- Content box -->
			<div id="content-box">

				<!-- Content box left -->
				<div id="content-box-left">
					<div id="rss-box">
						<p>
							RSS <a href="#">Articles</a>/<a href="#">Comments</a>
						</p>
					</div>

					<div id="content-box-left-in">

						<!-- Content box with light blue background -->
						<div class="box">
							<div class="box-top">
								<div class="box-bottom">
									<div id="box-in">
										<div id="registration-box">
											<%@ include file="/jspf/registration-box.jspf" %>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Content box with light blue background end -->

						<div class="paging" title=""></div>

					</div>
				</div>
				<!-- Content box left end -->

				<!-- Content box right -->
				<div id="content-box-right">
					<%@ include file="/jspf/content-box-right.jspf"%>
				</div>
				<!-- Content box right end -->
				<div class="cleaner">&nbsp;</div>

			</div>
			<!-- Content box end -->

		</div>
		<!-- Content end -->

		<hr class="noscreen" />

		<!-- Footer -->
		<%@ include file="/jspf/footer.jspf"%>
		<!-- Footer end -->

	</div>
</body>
</html>