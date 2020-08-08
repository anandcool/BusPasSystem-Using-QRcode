<?php
include "connection.php";
$busname = $_REQUEST['busname'];
$busfrom = $_REQUEST['busfrom'];
$busto = $_REQUEST['busto'];
$bustiming = $_REQUEST['bustiming'];
$sql = "INSERT INTO `bus`(`bus_name`, `bus_from`, `bus_to`, `bus_timing`) VALUES ('$busname','$busfrom','$busto','$bustiming')";
$result = mysqli_query($con,$sql);
if($result){
    echo "Bus Add";
}


?>