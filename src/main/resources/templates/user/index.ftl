<#import "/spring.ftl" as spring/>
 
<!DOCTYPE HTML>
<html>
   <head>
     <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   </head>
    
   <body>
<#if page??>    
<h1> ${page} </h1>
</#if>
<a href="create">Create new</a>

<table class="table table-bordered table-hover">

<tr>

<th>Firstname</th>

<th>Lastname</th>

</tr>


<#list items as item>

<tr>

<td>${item.firstname}</td>

<td>${item.lastname}</td>

<td><a href="details/${item["id"]}">Show</a></td>

<td>

<form action="delete" method="POST">

<input type="hidden" name="id" value="${item["id"]}">

<input type="submit" value="delete"/>

</form>

</td>

</tr>

</#list>

</table>
       
   </body>
    
</html>