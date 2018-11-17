<%@ page pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Dynamic Logging</title>

    <style>
      .hidden { 
        display: none;
      }

      td { 
        max-width: 650px;
        word-wrap: break-word;
      }
    </style>
  </head>

  <body>
    <h1>Welcome Loggers</h1>

    <table>
      <c:forEach items="${loggers}" var="logger">
        <tr id="${logger.getName()}">
          <td>${logger.getName()}</td>
          <td> 
            <select name="${logger.getName()}">
              <c:forEach items="${logLevels}" var="level">
                <option value="${level}" ${level == logger.getLevel() ? 'selected' : ''}>${level}</option>
              </c:forEach>
            </select>
          </td>
          <td>
            <span class="success hidden" style="color:green">&#x2713;</span>
            <span class="failure hidden" style="color:red">&#x2717;</span>
          </td>
          </tr>
      </c:forEach>
    </table>

    <script type="text/javascript">
      let flashRow = (name, className ) => {
        let row = document.querySelector( "tr[id='" + name + "']");
        row.querySelectorAll( "td:nth-child(3) > span" ).forEach( marker => {
          marker.classList.toggle( "hidden", !marker.classList.contains( className ));
        });
      };

      (function(){
        var dropdowns = document.querySelectorAll('select');

        Array.from(dropdowns).forEach(dropdown => {
          dropdown.addEventListener('change', (event) => {
            flashRow(event.target.name);

            fetch( "/change", {
              method: "POST",
              headers: {
                "Content-Type": "application/json; charset=utf-8",
              },
              body: JSON.stringify({
                name : event.target.name,
                level : event.target.value
              })
            }).then( response => {
              flashRow( event.target.name, 'success');
            }).catch( error => {
              flashRow( event.target.name, 'failure');
              console.log(error);
            });
          })
        });
      })();
    </script>
  </body>
</html>
