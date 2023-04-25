<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
    <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <a class="navbar-brand" href="/#">
            <asset:image src="LECOINCOIN.png" alt="Grails Logo"/>
        </a>
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
            <ul class="nav navbar-nav navbar-right">
                <g:pageProperty name="page.nav"/>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User <span class="caret"></span></a>
                    <ul class="dropdown-menu" style="background-color: darkgrey">
                        <li><a href="/user">Show</a></li>
                        <li><a href="/user/edit/1">Edit</a></li>
                        <li><a href="/user/create">Create</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Annonce <span class="caret"></span></a>
                    <ul class="dropdown-menu" style="background-color: darkgrey">
                        <li><a href="/annonce">Show</a></li>
                        <li><a href="/annonce/edit/1">Edit</a></li>
                        <li><a href="/annonce/create">Create</a></li>
                    </ul>
                </li>
                <li>
                    <sec:ifLoggedIn>
                        <g:link controller="logout" action="index">
                            Bonjour <sec:loggedInUserInfo field="username"/>
                            <button>Logout</button></g:link>
                    </sec:ifLoggedIn>
                    <sec:ifNotLoggedIn>
                        <g:link controller="login" action="index">Login</g:link>
                    </sec:ifNotLoggedIn>
                </li>
            </ul>
        </div>
    </div>
</div>

<g:layoutBody/>


<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
