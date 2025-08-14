<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Package Details</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4 text-center">Package Details</h2>

    <div class="card shadow-lg rounded-4">
        <div class="card-body p-4">
            <table class="table table-bordered table-striped table-hover">
                <thead class="table-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Artist</th>
                    <th scope="col">Genre</th>
                    <th scope="col">Release Date</th>
                    <th scope="col">Price</th>
                    <th scope="col">Rating</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${ref.albumId}</td>
                    <td>${ref.title}</td>
                    <td>${ref.artist}</td>
                    <td>${ref.genre}</td>
                    <td>${ref.releaseDate}</td>
                    <td>${ref.price}</td>
                    <td>${ref.rating}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<a href="returnToIndex">HOME</a>
<a href="redirectToTourism">Retrn Tourism Form</a>
<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
