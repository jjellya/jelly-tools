<template>
  <div id="app">
    <router-view/>
  </div>
</template>
<script>
  import DevicePixelRatio from "./evicePixelRatio";
  export default {
    name: "App",
    created() {
      //new DevicePixelRatio().init();
    }
  };
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
  padding: 0px;
}
html,body{
  margin:0;
  padding:0;
}
</style>
