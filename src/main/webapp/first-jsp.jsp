<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.List" %>
<%@ page import="letscode.User" %>

<!doctype html>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
  <h1>Hello JSP</h1>
  <br/>
  <%= request.getRequestURI() %>
  <br>
  <%= LocalDateTime.now() %>
  <hr/>
  <%
   List<User> users = (List) request.getAttribute("users");

   %>
   <table>
   <% for (User user : users) {%>
       <tr>
          <td><%= user.getName() %></td>
          <td>
              <% if (user.getCountry().equals("Vietnam")) { %>
                   <b><%= user.getCountry() %></b>
              <% } else { %>
                   <%= user.getCountry() %>
              <% } %>
          </td>
          <td><%= user.getAge() %></td>
       </tr>
   <% } %>
   </table>
</body>
</html>