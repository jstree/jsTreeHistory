<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="nasLoginRoot" value="http://nas.313.co.kr:5002/Design/template/products-WB0T41TX4/light-blue"></c:set>
<html>
<head>
    <title>Light Blue - Admin Template</title>
    <link href="${nasLoginRoot}/css/application.min.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/favicon.png">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta charset="utf-8">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="http://nas.313.co.kr:5002/Source/Script/jQuery/jQueryPlugIns/jnotify_v2.1/jquery/jNotify.jquery.js"></script>
	<script src="http://nas.313.co.kr:5002/Source/Script/ajax/ajax.js" type="text/javascript" charset="UTF-8"></script>	
<script>
$(document).ready(function() {
	
});
</script>
<body style="" class="background-dark">
<div class="single-widget-container">
    <section class="widget login-widget">
        <header class="text-align-center">
            <h4>Login to your account</h4>
        </header>
        <div class="body">
            <form class="no-margin" action="<c:url value='/login/process'/>" method="post">
                <fieldset>
                    <div class="form-group no-margin">
                        <label for="email">Email</label>

                        <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <i class="eicon-user"></i>
                                </span>
                            <input id="username"  name="username" class="form-control input-lg" placeholder="Your Email">
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="password">Password</label>

                        <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <i class="fa fa-lock"></i>
                                </span>
                            <input id="password" type="password" name="password" class="form-control input-lg" placeholder="Your Password">
                        </div>

                    </div>
                </fieldset>
                <div class="form-actions">
                    <button type="submit" id="submitBtn" class="btn btn-block btn-lg btn-danger">
                        <span class="small-circle"><i class="fa fa-caret-right"></i></span>
                        <small>Sign In</small>
                    </button>
                    <div class="forgot"><a class="forgot" href="#">Forgot Username or Password?</a></div>
                </div>
            </form>
        </div>
        <footer>
            <div class="facebook-login">
                <a href="index.html"><span><i class="fa fa-facebook-square fa-lg"></i> LogIn with Facebook</span></a>
            </div>
        </footer>
    </section>
</div>

</body>
</html>
