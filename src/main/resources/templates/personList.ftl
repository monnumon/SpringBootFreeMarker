<#import "/spring.ftl" as spring/>

<html>
   <head>
      <title>Person List</title>
      <link rel="stylesheet"
           type="text/css"
           href="<@spring.url '/css/style.css'/>"/>      
   </head>   
   <body>
     <h3>Person List</h3>

     <br><br>
      <div>
         
         <table border="1">
            <tr>
               <th>First Name</th>
               <th>Last Name</th>
            </tr>
            <#list persons as person>
            <tr>
               <td>${person.firstName}</td>
               <td>${person.lastName}</td>
            </tr>
            </#list>
         </table>
            </br>

           <button style="color:blue;" onclick="document.location='addPerson'">Add Person</button>
      </div>
   </body>
</html>