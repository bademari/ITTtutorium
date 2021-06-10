<?php
 
// include necessary classes 
include('verkauf.php');


$sale = new sale();
$data = array_merge($_GET, $_POST);
$method = $data['action'];
$retlnk = '<br> <a href="verkaufNEW.html"> zur&uuml;ck zur Verkaufsseite </a>';


 // create SQL based on HTTP method
switch ($method) 
{
  /* ############muss noch in HTML erstellt werden##################
  case 'GET':

    if(!empty($data['stationID']))
    {
    	$sql = $station->getCoordinates($data['stationID']);
        header('Content-type: application/json; charset=utf-8'); 
        echo json_encode($sql); 
        break;
    }

    if(!empty($data['location']))
    {
        $sql = $station->findByLocation($data['location']);
        header('Content-type: application/json; charset=utf-8');
        echo json_encode($sql);
        break;
    }

    else
    {
    	$sql = $station->getAllStations();
        header('Content-type: application/json; charset=utf-8'); 
        echo json_encode($sql);
        break;
    }

    break;

    */


  
  case 'POST':
    $sql = $sale->addSale($data); 
    echo "Gesamtbetrag in €: ".$sql.$retlnk ;
    
    break;


  case 'PUT':
    $sql = $sale->updateSale($data);
    if($sql == "OK")
    {
    	$send = $sale->getAllSales();
        header('Content-type: application/json; charset=utf-8'); 
        echo json_encode($send);    	
    } 
    else
    {
    	echo $sql;
    }
    break;

  case 'DELETE':
    $sql = $sale->removeSale($data['saleID']); 
    echo $sql.$retlnk;
    break;
}



?>

