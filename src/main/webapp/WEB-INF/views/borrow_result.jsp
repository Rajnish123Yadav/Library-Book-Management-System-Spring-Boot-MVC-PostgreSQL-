<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Borrow Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f7fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .card {
            background: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            text-align: center;
        }
        h2 {
            color: #28a745;
            margin-bottom: 20px;
        }
        a {
            display: inline-block;
            padding: 10px 18px;
            text-decoration: none;
            background: #007bff;
            color: #fff;
            border-radius: 6px;
            font-weight: bold;
            transition: background 0.3s ease;
        }
        a:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <div class="card">
        <h2>${msg}</h2>
        <a href="borrow">Barrow Another</a>
        <a href="./">Back To Home</a>
		<a href="list">Go To Barrow Transaction</a>
    </div>
</body>
</html>
