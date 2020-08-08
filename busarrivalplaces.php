<?php
include "connection.php";
$sql = "SELECT * FROM `bus`";
$result = mysqli_query($con,$sql);
$data = "";
while($row = mysqli_fetch_assoc($result)){
    $data = $row['bus_from'].",".$data;
}
echo $data;
?>