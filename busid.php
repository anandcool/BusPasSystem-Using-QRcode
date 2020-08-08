<?php
include "connection.php";
$busfrom = $_REQUEST['busfrom'];
$busto = $_REQUEST['busto'];
$sql = "SELECT * FROM `bus` WHERE bus_from = '$busfrom' AND bus_to = '$busto'";
$result = mysqli_query($con,$sql);
$row = mysqli_num_rows($result);
if($row == 0){
    echo "No Bus Available";
}
else{
    $data = ""
    while($result1 = mysqli_fetch_assoc($result)){
        $data = $result1['bus_id'].",".$data;
    }
    echo $data;
}
?>