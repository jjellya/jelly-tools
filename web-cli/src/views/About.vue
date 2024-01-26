<template>
  <div class="about">
    <TopBar>
      <h1>This is an about page</h1>
    </TopBar>

  </div>
</template>

<script>
  // @ is an alias to /src
  import TopBar from "../components/TopBar";

  export default {
    name: 'About',
    components: {
      TopBar
    }
  }
</script>
