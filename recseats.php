<?php
include "connection.php";
$sql = "SELECT * FROM `passenger`";
$result = mysqli_query($con,$sql);
$result1 = "";
while($row = mysqli_fetch_assoc($result))
{
    $result1 = $result1."".$row['seat_number'].",";
}
echo $result1;

?>