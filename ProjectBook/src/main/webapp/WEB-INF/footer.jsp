<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<footer class="bg-dark" id="tempaltemo_footer">
	<div class="container">
		<div class="row">

			<div class="col-md-4 pt-5">
				<h2 class="h2 text-success border-bottom pb-3 border-light logo">책방
					</h2>
				<ul class="list-unstyled text-light footer-link-list">
					<li><i class="fas fa-map-marker-alt fa-fw"></i>책방 강남점(본점) 서울특별시 서초구 강남대로 465</li>
					<li><i class="fa fa-phone fa-fw"></i> <a
						class="text-decoration-none" href="#">010-020-0340</a>
					</li>
					<li><i class="fa fa-envelope fa-fw"></i> <a
						class="text-decoration-none" href="#">book@naver.com</a>
					</li>
				</ul>
			</div>

			<div class="col-md-4 pt-5">
				<h2 class="h2 text-light border-bottom pb-3 border-light">장르별 도서</h2>
				<ul class="list-unstyled text-light footer-link-list">
					<li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=genre&key=로맨스">로맨스</a></li>
					<li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=genre&key=과학">과학</a></li>
					<li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=genre&key=판타지">판타지</a></li>
					<li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=genre&key=공포">공포</a></li>
					<li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=genre&key=추리">추리</a></li>
					<li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=genre&key=자기계발">자기계발</a></li>
					
				</ul>
			</div>

			<div class="col-md-4 pt-5">
				<h2 class="h2 text-light border-bottom pb-3 border-light">국가별 도서</h2>
				<ul class="list-unstyled text-light footer-link-list">
					<li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=country&key=독일">독일</a></li>
					<li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=country&key=한국">한국</a></li>
					<li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=country&key=일본">일본</a></li>
					<li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=country&key=미국">미국</a></li>
					<li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=country&key=중국">중국</a></li>
					<li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=country&key=프랑스">프랑스</a></li>
				</ul>
			</div>

		</div>

		<div class="row text-light mb-4">
			<div class="col-12 mb-3">
				<div class="w-100 my-3 border-top border-light"></div>
			</div>
			<div class="col-auto me-auto">
				<ul class="list-inline text-left footer-icons">
					<li
						class="list-inline-item border border-light rounded-circle text-center">
						<a class="text-light text-decoration-none" target="_blank"
						href="http://facebook.com/"><i
							class="fab fa-facebook-f fa-lg fa-fw"></i></a>
					</li>
					<li
						class="list-inline-item border border-light rounded-circle text-center">
						<a class="text-light text-decoration-none" target="_blank"
						href="https://www.instagram.com/"><i
							class="fab fa-instagram fa-lg fa-fw"></i></a>
					</li>
					<li
						class="list-inline-item border border-light rounded-circle text-center">
						<a class="text-light text-decoration-none" target="_blank"
						href="https://twitter.com/"><i
							class="fab fa-twitter fa-lg fa-fw"></i></a>
					</li>
					<li
						class="list-inline-item border border-light rounded-circle text-center">
						<a class="text-light text-decoration-none" target="_blank"
						href="https://www.linkedin.com/"><i
							class="fab fa-linkedin fa-lg fa-fw"></i></a>
					</li>
				</ul>
			</div>
			
		</div>
	</div>

	

</footer>
<!-- End Footer -->

<!-- Start Script -->
<script src="assets/js/jquery-1.11.0.min.js"></script>
<script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/templatemo.js"></script>
<script src="assets/js/custom.js"></script>
<!-- End Script -->

</body>
</html>