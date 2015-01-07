<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#contactForm').submit(
		function(event) {
			var name = $('#name').val();
			var email = $('#email').val();				
			var data = 'name='
					+ encodeURIComponent(name)
					+ '&amp;email='
					+ encodeURIComponent(email);
			$.ajax({
				url : $("#contactForm").attr("action"),
				data : data,
				type : "GET",
 
				success : function(response) {
					alert( response );
				},
				error : function(xhr, status, error) {
					alert(xhr.responseText);
				}
			});
			return false;
		});
	});
</script>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body>
	<div align="center">
		<h1>New/Edit Contact</h1>
		<form:form id="contactForm" action="saveContact" method="post"
			modelAttribute="contact" commandName="contact">
			<table>

				<form:hidden path="id" />
				<tr>
					<td>Name:</td>
					<form:errors path="name" cssClass="error" />
					<td><form:input path="name" /></td>
					<td align="left"><form:errors path="name" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
					<td align="left"><form:errors path="email" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Address:</td>
					<form:errors path="address" cssClass="error" />
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td>Telephone:</td>
					<form:errors path="telephone" cssClass="error" />
					<td><form:input path="telephone" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>