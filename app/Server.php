<?php
  error_reporting(0);
  if(isset($_GET["param"])) {
    $param = $_GET["param"];
    echo '[{"name": "unoo", "surname": "'.$param.'"},{"name": "unodso", "surname": "dofados"}]';
  }
?>
