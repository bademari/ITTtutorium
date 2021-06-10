function showDeliveryList() {


    var url = "produktauffuellungREST.php";
    var method = "action=GET";
    url += "?" + method;
    var request = new XMLHttpRequest();
    request.open("GET", url);
    request.onload = function () {
        if (request.status == 200) {
            
            //alert("GET funktioniert auf REST API");


            var deliverylist = request.responseText;
            //getTable header for data
            var url2 = "includes/deliverytable.json";
            var request2 = new XMLHttpRequest();
            request2.open("GET", url2);
            request2.onload = function () {
                if (request2.status === 200) {
                    var deliverytable = request2.responseText;
                    listDelivery(deliverylist, deliverytable);
                }
            };
            request2.send(null);
            
        }
    };
    request.send(null);
}










function listDelivery(deliverylist, getdeliverytable) {
    //alert(stationlist+getstationtable);
    var list = document.getElementById("deliverylist");
    list.innerHTML = "" // clear list
    var deliveries = JSON.parse(deliverylist);
    var deliverytable = JSON.parse(getdeliverytable);

    var table = document.createElement("table");
    table.setAttribute("id", "lieferung");

    //table head
    var tablehead = document.createElement("thead");
    var tableRow = document.createElement("tr");

    //wenn die tabllenid nicht angzeigt werden soll, muss h auf 1 gestetzt werden
    var tableattr = 1;
    for (var h = 0; h < tableattr; h++) {
        var json = deliverytable[0]; //in this case only one object exitsts
        var key = "td" + h;
        var tableval = json[key];
        if (tableval != undefined) {
            var tableCell = document.createElement("td");
            var cellContent = document.createTextNode(tableval);
            tableCell.appendChild(cellContent);
            tableRow.appendChild(tableCell);

            tableattr++;
        }
    }
    tableattr--;
    tablehead.appendChild(tableRow);

     //table body
    var tablebody = document.createElement("tbody");


    for (var j = 0; j < deliveries.length; j++) {
        var mycurrentRow = document.createElement("tr");

        for (var i = 0; i < tableattr; i++) {
            var json = deliverytable[0];
            var jsonval = deliveries[j];
            var key = "td" + i;
            var value = json[key];
            var tableval = jsonval[value];


            var mycurrentCell = document.createElement("td");
            if (tableval !== undefined) {
                var mycurrentText = document.createTextNode(tableval);
                mycurrentCell.setAttribute("name", jsonval.name + "_" + value); //value sind die Spalten der json
                mycurrentCell.setAttribute("id", jsonval.name + "_" + value); //jsonval.name ist der Wert von name in dieser Zeile
                mycurrentCell.setAttribute("value", tableval);
                mycurrentCell.appendChild(mycurrentText);
                mycurrentRow.appendChild(mycurrentCell);
                var hiddeninput = document.createElement("input");
                hiddeninput.setAttribute("name",jsonval.name + "_" + value);
                hiddeninput.setAttribute("value", tableval);
                hiddeninput.setAttribute("type", "hidden");
                mycurrentCell.appendChild(hiddeninput);
            }

            if (i === tableattr - 1) {
                var input = document.createElement("input");
                input.setAttribute("id", jsonval.stationID + "<->" + jsonval.productID);
                input.setAttribute("type", "checkbox");
                input.setAttribute("name", jsonval.stationID + "<->" + jsonval.productID);
                input.setAttribute("value", "done");
                mycurrentCell.appendChild(input);
                mycurrentRow.appendChild(mycurrentCell);
            }
        }
        tablebody.appendChild(mycurrentRow);
    }

    table.appendChild(tablehead);
    table.appendChild(tablebody);
    list.appendChild(table);
}
