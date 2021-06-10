<?php

class delivery
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


    public function get_refilltable($data)
    {
        $refilllist = array();

        $refill_stmt = "SELECT s.stationID, s.location, p.name, i.toStoreAmount - i.currentAmount AS quantity FROM station s, products p, inventory i 
                        WHERE p.productID = i.productID AND s.stationID = i.stationID AND i.toStoreAmount - i.currentAmount > 'O' ORDER BY s.stationID, p.productID;"; 

       
        
        $refill_result = $this->db->query($refill_stmt);
        
        while ($row = $refill_result->fetch_assoc()) {
            $refilllist[] = $row;
        }


        return $refilllist;
    }




 public function addDelivery($data)
   {
       

        

      if ($data['amount1']>0) {                 //prüft ob die angegebene Menge größer 1 ist

   
       /*in statement 2 wird der derzeitige Bestand von dieser Station und diesem Produkt geholt*/

       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID1']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $sum = $result2['currentAmount'] + $data['amount1'];    //Summe des derzeitigen Bestands und der aufgefüllten Menge des Produktes

       
       $stmt3 = "UPDATE inventory SET currentAmount = '".$sum."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID1']."' ;";   //Updated das Inventory auf den neuen Bestand



       //commit db request

        /*Fügt den Datensatz der Tabelle refill hinzu*/
       $stmt = "INSERT INTO refill (             
       stationID,
       productID,
       amount
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID1']."',
       '".$data['amount1']."'
       );";



       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

      //return var_dump($mengenpreis);
        
      }

       

        if ($data['amount2']>0) {                 //prüft ob die angegebene Menge größer 1 ist

   
       /*in statement 2 wird der derzeitige Bestand von dieser Station und diesem Produkt geholt*/

       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID2']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $sum = $result2['currentAmount'] + $data['amount2'];    //Summe des derzeitigen Bestands und der aufgefüllten Menge des Produktes

       
       $stmt3 = "UPDATE inventory SET currentAmount = '".$sum."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID2']."' ;";   //Updated das Inventory auf den neuen Bestand



       //commit db request

        /*Fügt den Datensatz der Tabelle refill hinzu*/
       $stmt = "INSERT INTO refill (             
       stationID,
       productID,
       amount
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID2']."',
       '".$data['amount2']."'
       );";



       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

      //return var_dump($mengenpreis);
        
      }

       if ($data['amount3']>0) {                 //prüft ob die angegebene Menge größer 1 ist

   
       /*in statement 2 wird der derzeitige Bestand von dieser Station und diesem Produkt geholt*/

       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID3']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $sum = $result2['currentAmount'] + $data['amount3'];    //Summe des derzeitigen Bestands und der aufgefüllten Menge des Produktes

       
       $stmt3 = "UPDATE inventory SET currentAmount = '".$sum."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID3']."' ;";   //Updated das Inventory auf den neuen Bestand



       //commit db request

        /*Fügt den Datensatz der Tabelle refill hinzu*/
       $stmt = "INSERT INTO refill (             
       stationID,
       productID,
       amount
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID3']."',
       '".$data['amount3']."'
       );";



       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

      //return var_dump($mengenpreis);
        
      }

        if ($data['amount4']>0) {                 //prüft ob die angegebene Menge größer 1 ist

   
       /*in statement 2 wird der derzeitige Bestand von dieser Station und diesem Produkt geholt*/

       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID4']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $sum = $result2['currentAmount'] + $data['amount4'];    //Summe des derzeitigen Bestands und der aufgefüllten Menge des Produktes

       
       $stmt3 = "UPDATE inventory SET currentAmount = '".$sum."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID4']."' ;";   //Updated das Inventory auf den neuen Bestand



       //commit db request

        /*Fügt den Datensatz der Tabelle refill hinzu*/
       $stmt = "INSERT INTO refill (             
       stationID,
       productID,
       amount
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID4']."',
       '".$data['amount4']."'
       );";



       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

      //return var_dump($mengenpreis);
        
      }

       if ($data['amount5']>0) {                 //prüft ob die angegebene Menge größer 1 ist

   
       /*in statement 2 wird der derzeitige Bestand von dieser Station und diesem Produkt geholt*/

       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID5']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $sum = $result2['currentAmount'] + $data['amount5'];    //Summe des derzeitigen Bestands und der aufgefüllten Menge des Produktes

       
       $stmt3 = "UPDATE inventory SET currentAmount = '".$sum."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID5']."' ;";   //Updated das Inventory auf den neuen Bestand



       //commit db request

        /*Fügt den Datensatz der Tabelle refill hinzu*/
       $stmt = "INSERT INTO refill (             
       stationID,
       productID,
       amount
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID5']."',
       '".$data['amount5']."'
       );";



       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

      //return var_dump($mengenpreis);
        
      }

       if ($data['amount6']>0) {                 //prüft ob die angegebene Menge größer 1 ist

   
       /*in statement 2 wird der derzeitige Bestand von dieser Station und diesem Produkt geholt*/

       $stmt2 = "SELECT currentAmount FROM inventory WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID6']."' ;";
       $result2 = $this->db->query($stmt2)->fetch_assoc();

       $sum = $result2['currentAmount'] + $data['amount6'];    //Summe des derzeitigen Bestands und der aufgefüllten Menge des Produktes

       
       $stmt3 = "UPDATE inventory SET currentAmount = '".$sum."' WHERE stationID ='".$data['stationID']."' AND productID = '".$data['productID6']."' ;";   //Updated das Inventory auf den neuen Bestand



       //commit db request

        /*Fügt den Datensatz der Tabelle refill hinzu*/
       $stmt = "INSERT INTO refill (             
       stationID,
       productID,
       amount
       ) VALUES (
       '".$data['stationID']."',
       '".$data['productID6']."',
       '".$data['amount6']."'
       );";



       $result = $this->db->query($stmt);
       $result3 = $this->db->query($stmt3);

      //return var_dump($mengenpreis);
        
      }


      
      
      return "erfolgreich aufgefüllt";


    
   }






}