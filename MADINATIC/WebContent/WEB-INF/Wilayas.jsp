
<%@ page  contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<div class="wilayas">
	<jstl:forEach items="${ wilayas }" var="wilaya">
			<div class="wilaya" id="${wilaya.id_wilaya }" >
				<p class="name"><jstl:out value="${ empty wilaya ? wilaya.getClass() : wilaya.getName()}" /></p>
				<p class="nb">0</p>
			</div>
			<div class="towns" id="${wilaya.id_wilaya }" style="display:none">
				<jstl:forEach items="${wilaya.towns }" var="town">
					<div class="town">
						<p class="name"><jstl:out value="${ empty town ? town.getClass() : town.getName()}" /></p>
						<p class="nb">0</p>
					</div>
				</jstl:forEach>
			</div>
			
			
	</jstl:forEach>

</div>