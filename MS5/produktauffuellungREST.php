<?php


// include necessary classes

include('produktauffuellung.php');

$delivery = new delivery();
$data = array_merge($_GET, $_POST);
$method = $data['action'];
$retlnk = '<br> <a href="produktauffuellung.html"> zur Produktauffüllung </a>';
// create SQL based on HTTP method
switch ($method) {
    case 'GET':
        $sql = $delivery->get_refilltable($data);
        header('Content-type: application/json; charset=utf-8');
        echo json_encode($sql);
        
        break;


    case 'POST':
       
        $sql = $delivery->addDelivery($data); 
        echo "Antwort: ".$sql.$retlnk ;
    
    break;
}
