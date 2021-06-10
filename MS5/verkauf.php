<?php
//Einfache version ohne Framework, berücksichtigt das die meißten Browser kein PUT und DELETE unterstützen


class sale
{
   private $db;

   public function __construct()
   {
      //***TODO*** --> insert your database connection:
      $this->db = new mysqli("localhost","inttentwickler","ITT11pra!");

      if (mysqli_connect_errno())
      {
      	die("error while connection to database!:".mysqli_connect_error());
      }

      $this->db->select_db("Allgold");

      if($this->db->errno)
      {
      	die ($this->db->error);
      }
   }


   // Create

   public function addSale($data)
   {
   	   

    $gesamtbetrag = 0.00;                       //Variable um den Gesamtbetrag auszugeben

      if ($data['amount1']>0) {                 //prüft ob die angegebene Menge größer 1 ist

      /*Fügt den Datensatz der Tabelle sales hinzu*/
       $stmt = "INSERT INTO sales (             
       stationID,
       productID,
       amount,
       sellerID
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID1']."',
       '".$data['amount1']."',
       '".$data['sellerID']."'
       );";

       /*in statement 2 wird der derzeitige Bestand von dieser Station und diesem Produkt geholt*/

       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID1']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $diff = $result2['currentAmount'] - $data['amount1'];    //differenz des derzeitigen Bestands und der verkauften Menge des Produktes

       
       $stmt3 = "UPDATE inventory SET currentAmount = '".$diff."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID1']."' ;";   //Updated das Inventory auf den neuen Bestand


       $stmt4 = "SELECT price FROM products WHERE productID = '".$data['productID1']."' ;";         //holt den Einzelpreis des Produktes
       $result4 = $this->db->query($stmt4)->fetch_assoc();

       $gesamtbetrag += floatval($result4['price']) * $data['amount1'];               //wird zum Gesamtbetrag hinzugefügt

       //commit db request
       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

      //return var_dump($mengenpreis);
        
      }

       

        if ($data['amount2']>0) {

        $stmt = "INSERT INTO sales ( 
       stationID,
       productID,
       amount,
       sellerID
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID2']."',
       '".$data['amount2']."',
       '".$data['sellerID']."'
       );";

       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID2']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $diff = $result2['currentAmount'] - $data['amount2'];
       
       $stmt3 = "UPDATE inventory SET currentAmount = '".$diff."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID2']."' ;";

       $stmt4 = "SELECT price FROM products WHERE productID = '".$data['productID2']."' ;";
       $result4 = $this->db->query($stmt4)->fetch_assoc();

       $gesamtbetrag += floatval($result4['price']) * $data['amount2'];

       //commit db request
       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

    
        
      }

        if ($data['amount3']>0) {

        $stmt = "INSERT INTO sales ( 
       stationID,
       productID,
       amount,
       sellerID
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID3']."',
       '".$data['amount3']."',
       '".$data['sellerID']."'
       );";

       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID3']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $diff = $result2['currentAmount'] - $data['amount3'];
       
       $stmt3 = "UPDATE inventory SET currentAmount = '".$diff."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID3']."' ;";

       $stmt4 = "SELECT price FROM products WHERE productID = '".$data['productID3']."' ;";
       $result4 = $this->db->query($stmt4)->fetch_assoc();

       $gesamtbetrag += floatval($result4['price']) * $data['amount3'];

       //commit db request
       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

       
        
      }

        if ($data['amount4']>0) {

        $stmt = "INSERT INTO sales ( 
       stationID,
       productID,
       amount,
       sellerID
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID4']."',
       '".$data['amount4']."',
       '".$data['sellerID']."'
       );";

       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID4']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $diff = $result2['currentAmount'] - $data['amount4'];
       
       $stmt3 = "UPDATE inventory SET currentAmount = '".$diff."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID4']."' ;";

       $stmt4 = "SELECT price FROM products WHERE productID = '".$data['productID4']."' ;";
       $result4 = $this->db->query($stmt4)->fetch_assoc();

       $gesamtbetrag += floatval($result4['price']) * $data['amount4'];

       //commit db request
       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

        
      }

        if ($data['amount5']>0) {

        $stmt = "INSERT INTO sales ( 
       stationID,
       productID,
       amount,
       sellerID
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID5']."',
       '".$data['amount5']."',
       '".$data['sellerID']."'
       );";

       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID5']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $diff = $result2['currentAmount'] - $data['amount5'];
       
       $stmt3 = "UPDATE inventory SET currentAmount = '".$diff."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID5']."' ;";

       $stmt4 = "SELECT price FROM products WHERE productID = '".$data['productID5']."' ;";
       $result4 = $this->db->query($stmt4)->fetch_assoc();

       $gesamtbetrag += floatval($result4['price']) * $data['amount5'];

       //commit db request
       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

       
        
      }

       if ($data['amount6']>0) {

        $stmt = "INSERT INTO sales ( 
       stationID,
       productID,
       amount,
       sellerID
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID6']."',
       '".$data['amount6']."',
       '".$data['sellerID']."'
       );";

       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID6']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $diff = $result2['currentAmount'] - $data['amount6'];
       
       $stmt3 = "UPDATE inventory SET currentAmount = '".$diff."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID6']."' ;";

       $stmt4 = "SELECT price FROM products WHERE productID = '".$data['productID6']."' ;";
       $result4 = $this->db->query($stmt4)->fetch_assoc();

       $gesamtbetrag += floatval($result4['price']) * $data['amount6'];

       //commit db request
       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

       
        
      }


      if ($gesamtbetrag >0) {
        return $gesamtbetrag;
      }
      
      return "Keine Menge angegeben";


    /*war nur ein TEST, kann gelöscht werden
    for ($i=1; $i < 7 ; $i++) { 
      if ($data['amount'+ i] > 0) {
        
         //create insert string
       $stmt = "INSERT INTO sales ( 
       stationID,
       productID,
       amount,
       sellerID
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID'.i]."',
       '".$data['amount'.i]."',
       '".$data['sellerID']."'
       );";



       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID'.i]."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $diff = $result2['currentAmount'] - $data['amount'.i];
       

       $stmt3 = "UPDATE inventory SET currentAmount = '".$diff."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID'.i]."' ;";

       //commit db request
       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);



      }
    }

    return "Sale maybe successfull";
    */

    /*
       //create insert string
   	   $stmt = "INSERT INTO sales ( 
   	   stationID,
       productID,
   	   amount,
       sellerID
   	   ) VALUES (
   	   '".$data['stationID']."',
       '".$data['productID']."',
   	   '".$data['amount']."',
       '".$data['sellerID']."'
   	   );";

     


       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $diff = $result2['currentAmount'] - $data['amount'];
       

       $stmt3 = "UPDATE inventory SET currentAmount = '".$diff."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID']."' ;";

       //commit db request
   	   $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

   	   if($result == 1)
   	   {
   	   	 return "Sale succesfully inserted.";
   	   }

   	   return "your statment: ".$stmt."<br /> received result:".$result;

       */
   }


  // R ead 

   public function getAllSales()
   {
      $allSales = array();
      $stmt = "SELECT * FROM sales;";
      $result = $this->db->query($stmt);

        if(empty($result))
        {
           return "your statement: ".$stmt."<br /> received result:".$result;
        }

      while ($row = $result->fetch_assoc()) 
      {
        $allSales[] = $row;
      }

      return  $allSales;
   }

   /*public function getCoordinates($stationID)
   {
   	  $allStations = array();
   	  $stmt = "SELECT * FROM station WHERE stationID = ".$stationID.";";
   	  $result = $this->db->query($stmt);

        if(empty($result))
        {
           return "your statement: ".$stmt."<br /> received result:".$result;
        }

      while ($row = $result->fetch_assoc()) 
      {
        $allStations[] = $row;
      }

      return $allStations;
   	  //return $row = $result->fetch_assoc(); 
   }


   public function findByLocation($location)
   {
   	  $allStations = array();
   	  $stmt = "SELECT * FROM station WHERE location = '".$location."';";
      $result = $this->db->query($stmt);

        if(empty($result))
        {
           return "your statement: ".$stmt."<br /> received result:".$result;
        }

      while ($row = $result->fetch_assoc()) 
      {
        $allStations[] = $row;
      }

      return $allStations;
   }
*/


// U pdate
    
  public function updateSale($data)
  {
    //create insert string
    $stmt = "UPDATE sales SET productID = '".$data['productID']."',
                              amount = '".$data['amount']."',
                              stationID = '".$data['stationID']."',
                              sellerID =  '".$data['sellerID']." ;
                            WHERE saleID = ".$data['saleID']." ;";

    //commit db request
    $result = $this->db->query($stmt);

    if($result == 1)
    {
      return "Sale updated succesfully";
    }

    return "your statement: ".$stmt."<br /> received result:".$result;
  }


// D elete

   public function removeSale($saleID)
   {
      $allSales = array();
      $stmt = "DELETE FROM sales WHERE saleID = ".$saleID.";";
      $result = $this->db->query($stmt);

       if($result == 1)
       {
         return "Sale succesfully deleted.";
       }

       return "your statment: ".$stmt."<br /> received result:".$result;
   }
}

