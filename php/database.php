<?php
$servername = "localhost";
$username = "root";
$password = "12345678";
$dbname = "MyNewDataBase";

$id = $_POST["id"];
$name = $_POST["name"];
$score = $_POST["score"];
$level = $_POST["level"];

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO Player(PersonID, Name, Score, Level) values (" .$id. ",'" .$name. "'," .$score. "," .$level. ")";

if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>