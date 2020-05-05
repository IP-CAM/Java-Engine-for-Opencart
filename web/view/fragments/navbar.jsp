<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<div class="container">
    <nav id="menu" class="navbar">
        <div class="navbar-header"><span id="category" class="visible-xs">Departamentos</span>
            <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fi-bars"></i></button>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <c:forEach var="categoryL1" items="${store.categoryList}">
                    <c:forEach var="categoryL2" items="${categoryL1.categoryList}">
                        <c:choose>                            
                            <c:when test="${categoryL2.top eq true}">
                                <c:choose>
                                    <c:when test="${empty categoryL2.categoryList}">
                                        <li><a href="/ZZZ_ag_908/ag?rsa=pgpvptl&findBy=Category&searchValue=${categoryL2.id}">${categoryL2.name}</a></li>
                                    </c:when>
                                    <c:otherwise>    
                                        <li class="dropdown">
                                            <a href="/ZZZ_ag_908/ag?rsa=pgpvptl&findBy=Category&searchValue=${categoryL2.id}" class="dropdown-toggle" data-toggle="dropdown">${categoryL2.name}</a>
                                            <div class="dropdown-menu">
                                                <div class="dropdown-inner">               
                                                    <ul class="list-unstyled">
                                                        <c:forEach var="categoryL3" items="${categoryL2.categoryList}">
                                                            <li><a href="/ZZZ_ag_908/ag?rsa=pgpvptl&findBy=Category&searchValue=${categoryL3.id}">${categoryL3.name}</a></li>
                                                        </c:forEach>                                                
                                                    </ul>
                                                </div>
                                                <a href="/ZZZ_ag_908/ag?rsa=pgpvptl&findBy=Category&searchValue=${categoryL2.id}" class="see-all">Todos em ${categoryL2.name}</a>
                                            </div>
                                        </li>                                                
                                    </c:otherwise>
                                </c:choose>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </c:forEach>
            </ul>
        </div>
    </nav>
</div>
