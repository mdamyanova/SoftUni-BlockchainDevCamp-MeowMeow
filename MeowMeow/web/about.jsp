<%--
  Created by IntelliJ IDEA.
  User: MirelaDamyanova
  Date: 12-Jul-18
  Time: 02:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MeowMeow</title>
    <link rel="stylesheet" href="gadgets/normalize/normalize.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="gadgets/aos/dist/aos.css" />
    <link rel="stylesheet" href="assets/styles/style.css">
    <link rel="stylesheet" href="assets/styles/about-me.css">
    <link rel="stylesheet" href="gadgets/scrolling-nav/css/scrolling-nav.css">
</head>
<body>
<nav class="navbar fixed-top navbar-toggleable-md navbar-light bg-faded" id="nav-bar-ella">

    <!--collapse the nav-bar for small screens-->
    <div class="navbar-header">
        <a class="navbar-brand" href="home">MeowMeow<span class="hearts">*</span></a>
        <button class="navbar-toggler navbar-toggler-right"
                type="button"
                data-toggle="collapse"
                data-target="#nav-bar-items"
                aria-controls="nav-bar-items"
                aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>

        </button>
    </div>

    <!--the actual nav-bar-->
    <div class="collapse navbar-collapse justify-content-end" id="nav-bar-items">
        <ul class="nav navbar-nav navbar-small">
            <li class="nav-item"><a class="nav-link" href="home">home</a></li>
            <li class="nav-item"><a class="nav-link" target="_blank" href="http://github.com/mdamyanova">github</a></li>
        </ul>
    </div>
</nav>
<main>
    <div class="animated fadeIn" id="section-one">
        <a id="home" class="smooth"></a>
        <div class="image-feature-about-me">
        </div>
        <div class="container-fluid">
            <h2 class="title-intro text-center">MeowMeow</h2>
            <div class="row">
                <div class="col-sm-6">
                    <h4 class="keywords text-center">dApp....</h4>
                </div>
                    <p class="paragraph">
                        MeowMeow... todo todo
                    </p>
            </div>
        </div>
    </div>
</main>
<footer>
    <p class="container-fluid"><b>MeowMeow</b> by Mirela &copy;</p>
</footer>
</body>
</html>
<script src="assets/scripts/app.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
        integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ScrollMagic/2.0.5/ScrollMagic.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ScrollMagic/2.0.5/plugins/debug.addIndicators.min.js"></script>
<script src="gadgets/aos/dist/aos.js"></script>
<script src="gadgets/scrolling-nav/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="gadgets/scrolling-nav/js/scrolling-nav.js"></script>