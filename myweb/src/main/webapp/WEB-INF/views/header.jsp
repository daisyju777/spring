
    <nav class="navbar navbar-inverse mynavbar">
        <div class="container-fluid mycontainer">
            <div class="navbar-header mynavheader">
                <a class="navbar-brand mynavbrand" href="<%=request.getContextPath()%>/">HealthCare</a>
            </div>
            <ul class="nav navbar-nav mynavbarul">
              <li class="dropdown mylist"><a class="dropdown-toggle" data-toggle="dropdown" href="#">HEALTH<span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Hot Topics</a></li>
                  <li><a href="#">Anti-aging</a></li>
                  <li><a href="#">Brain</a></li>
                  <li><a href="#">Detox</a></li>
                </ul>
              </li>
              <li class="dropdown mylist"><a class="dropdown-toggle" data-toggle="dropdown" href="#">REMEDIES<span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Supplements</a></li>
                  <li><a href="#">Herbs</a></li>
                </ul>
              </li>
              <li class="dropdown mylist"><a class="dropdown-toggle" data-toggle="dropdown" href="#">RECIPES<span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Main Dishes</a></li>
                  <li><a href="#">Desserts</a></li>
                  <li><a href="#">Beverages</a></li>
                </ul>
              </li>
              <li class="dropdown mylist"><a class="dropdown-toggle" data-toggle="dropdown" href="#">FITNESS<span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Yoga</a></li>
                  <li><a href="#">Meditation</a></li>
                  <li><a href="#">Fitness videos</a></li>
                </ul>
              </li>
              <li class="dropdown mylist"><a class="dropdown-toggle" data-toggle="dropdown" href="#">STORE<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Market</a></li>
                </ul>
              </li>
              <li class="dropdown mylist"><a class="dropdown-toggle" data-toggle="dropdown" href="#">COMMUNITY<span class="caret"></span></a>
                <ul class="dropdown-menu">
                 <li><a href="<%=request.getContextPath()%>/bbs/list">TalkTalk</a></li>
                </ul>
              </li>
            </ul>
           <form class="navbar-form navbar-left mynavbarform" action="#">
             <div class="input-group">
               <input type="text" class="form-control" placeholder="Search" name="search">
               <div class="input-group-btn">
                 <button class="btn btn-default" type="submit">
                   <i class="glyphicon glyphicon-search"></i>
                 </button>
               </div>
             </div>
           </form>
           <ul class="nav navbar-nav navbar-right mynavbarright">
             <li><a href="<%=request.getContextPath()%>/signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
             <li><a href="<%=request.getContextPath()%>/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
           </ul>
         </div>
      </nav>
