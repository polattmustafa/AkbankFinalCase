function getForecast(city){
    fetch("/api/weather/"+ city ).then(function (data){
        data.json().then(function (res){
            var formattedData=formatForecast(res);
            document.getElementById("forecast").innerHTML=formattedData;
            document.getElementById('cityname').value="";
        })
    }).catch(function (er){
    console.log(er);
    })
    return false;
}

function formatForecast(data){
    var table="";
    for (var i = 0; i < data.list.length; i++) {
        table += "<tr>";
        table+="<td>"+new Date(data.list[i].dt*1000).toLocaleDateString()+"</td>"
        table += "<td><img src='http://openweathermap.org/img/w/" + data.list[i].weather[0].icon + ".png'/></td>";
        table += "<td>" + data.list[i].weather[0].main + "</td>";
        table += "<td>" + data.list[i].weather[0].description + "</td>";

        table += "<td>" + data.list[i].main.temp_min + "&deg;C</td>";
        table += "<td>" + data.list[i].main.temp_max + "&deg;C</td>";
        table += "<td>" + data.list[i].main.pressure + "hPa</td>";
        table += "<td>" + data.list[i].main.humidity + "%</td>";
        table += "<td>" + data.list[i].wind.speed + "m/s</td>";
        table += "</tr>";
    }
    return table;
}
