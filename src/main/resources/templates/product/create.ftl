<#import "/spring.ftl" as spring/>

<head>
 <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<h1>${page}</h1>
	
	<form action="<@spring.url '/products/create'/>" method="POST">
		Name:<br>
		<input type="text" name="name" value="">
		<br>
		Price:<br>
		<input type="number" name="price" value="">
		<br><br>
		
		<input type="submit" value="Submit">
	</form>
</body>