<#import "/spring.ftl"as spring/>

<head>
 <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<h1>${page}</h1>
	
	<form action ="<@spring.url '/user/create'/> method="POST">
		Firstname:<br>
		<input type="text" name="firstname" value="">
		<br>
		Lastname:<br>
		<input type="text" name="lastname" value="">
		<br><br>
		
		<input type="submit" value="submit">
	</form>
</body>