<template>
  <div>
    <ul class="nav">
      <li class="nav-item active">
        <router-link to="/"><a class="nav-link">Home</a></router-link>
      </li>
      <li class="nav-item">
        <router-link to="/vue"><a class="nav-link">Vue.js</a></router-link>
      </li>
      <li class="nav-item">
        <router-link to="/home"><a class="nav-link">My Route</a></router-link>
      </li>
      <!--    <li class="nav-item" style="float: right;"><a class="nav-link" onclick="window.history.back();">返回</a></li>-->
    </ul>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "MyMainPage"
}
</script>

<style scoped>
body {
  /*chrome user agent stylesheet -> margin: 8;*/
  margin: 0;
}

.nav {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #34495e;
  position: fixed;
  top: 0;
  width: 100%;
}

.nav .nav-item {
  float: left;
}

.nav .nav-item .nav-link {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.nav .nav-item .nav-link:hover {
  background-color: #111;
}

.active {
  background-color: #41b883;
}

</style>
