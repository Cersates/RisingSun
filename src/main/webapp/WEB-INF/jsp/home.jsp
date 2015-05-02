<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page import="com.dataart.risingsun.app.Constants"%>
<%@ include file="/jspf/meta.jspf"%>
<title>Blog | Homepage</title>
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
										<div class="article">
											<div class="date">
												<p class="day">
													<span>18th</span>
												</p>
												<p>02/08</p>
											</div>
											<h3>
												<a href="#">My newest article about&hellip;</a>
											</h3>
											<div class="info">
												<div class="info-in">
													<p>
														In <a href="#">Category4</a> &nbsp;|&nbsp; Author <a
															href="#">Name</a> &nbsp;|&nbsp; <a href="#">23
															comments</a> &nbsp;|&nbsp; <a href="#">RSS comments</a>
													</p>
												</div>
											</div>
											
											<p>${msg}</p>
			<!-- 								<p>
												<img class="float" src="img/flower.jpg"
													alt="flower" width="128" height="96" /> Lorem ipsum dolor
												sit amet, consectetuer adipiscing elit. Nam vulputate turpis
												vel mauris. Aenean sapien mauris, ultrices sed, rhoncus at,
												pellentesque sed, lectus. In hac habitasse platea dictumst.
												Donec adipiscing, mauris eu varius consectetuer, nulla orci
												iaculis neque, ac rhoncus est lacus in augue. Maecenas ac
												dolor. Vestibulum semper eleifend arcu. Sed leo. Suspendisse
												vestibulum dolor sed eros ullamcorper tincidunt. Nulla at
												sapien vel mi fermentum adipiscing. Sed sit amet orci vel
												nisl mattis pretium. Nullam tristique mi eu magna. Duis odio
												ante, suscipit non, iaculis et, porta malesuada, neque.
												Suspendisse fringilla, purus dictum pretium nonummy, leo leo
												ullamcorper felis, id semper quam neque sit amet ante. Ut
												nec mi. Ut congue massa fermentum justo.
											</p> -->
											<p class="continue">
												[<a href="#">Continue&hellip;</a>]
											</p>
										</div>

										<div class="article">
											<div class="date">
												<p class="day">
													<span>17th</span>
												</p>
												<p>02/08</p>
											</div>
											<h3>
												<a href="#">My article about&hellip;</a>
											</h3>
											<div class="info">
												<div class="info-in">
													<p>
														In <a href="#">Category5</a> &nbsp;|&nbsp; Author <a
															href="#">Name</a> &nbsp;|&nbsp; <a href="#">64
															comments</a> &nbsp;|&nbsp; <a href="#">RSS comments</a>
													</p>
												</div>
											</div>
											<p>
												Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
												Nam vulputate turpis vel mauris. Aenean sapien mauris,
												ultrices sed, rhoncus at, pellentesque sed, lectus. In hac
												habitasse platea dictumst. Donec adipiscing, <a href="#">mauris
													eu varius</a> consectetuer, nulla orci iaculis neque, ac
												rhoncus est lacus in augue. Maecenas ac dolor. Vestibulum
												semper eleifend arcu. Sed leo. Suspendisse vestibulum dolor
												sed eros ullamcorper tincidunt. Nulla at sapien vel mi
												fermentum adipiscing. Sed sit amet orci vel nisl mattis
												pretium. Nullam tristique mi eu magna.
											</p>
											<p class="continue">
												[<a href="#">Continue&hellip;</a>]
											</p>
										</div>

										<div class="article">
											<div class="date">
												<p class="day">
													<span>16th</span>
												</p>
												<p>02/08</p>
											</div>
											<h3>
												<a href="#">My article about&hellip;</a>
											</h3>
											<div class="info">
												<div class="info-in">
													<p>
														In <a href="#">Category2</a> &nbsp;|&nbsp; Author <a
															href="#">Name</a> &nbsp;|&nbsp; <a href="#">12
															comments</a> &nbsp;|&nbsp; <a href="#">RSS comments</a>
													</p>
												</div>
											</div>
											<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
												elit. Nam vulputate turpis vel mauris. Aenean sapien mauris,
												ultrices sed, rhoncus at, pellentesque sed, lectus. In hac
												habitasse platea dictumst. Donec adipiscing, mauris eu
												varius consectetuer, nulla orci iaculis neque, ac rhoncus
												est lacus in augue. Maecenas ac dolor. Vestibulum semper
												eleifend arcu. Sed leo. Suspendisse vestibulum dolor sed
												eros ullamcorper tincidunt. Nulla at sapien vel mi fermentum
												adipiscing. Sed sit amet orci vel nisl mattis pretium.
												Nullam tristique mi eu magna. Duis odio ante, suscipit non,
												iaculis et, porta malesuada, neque. Suspendisse fringilla,
												purus dictum pretium nonummy, leo leo ullamcorper felis, id
												semper quam neque sit amet ante. Ut nec mi. Ut congue massa
												fermentum justo.</p>
											<p class="continue">
												[<a href="#">Continue&hellip;</a>]
											</p>
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