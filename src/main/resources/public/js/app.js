var api = (function () {

    function calculateStatistics (){
        var data=document.getElementById("data").value;
        console.log(data);
        putData(data);
        console.log(data)
        axios.post('http://localhost:4567/calcular',data)
            .then(res => {
                let json = JSON.parse(res.data);
                $("#media").text("Media : "+json.media);
                $("#std").text("Desviación estándar : "+json.std);

            }
        )
    }

    function putData(data){
        data=data.split(",")
        $("#TData > tbody").empty();
        $("#media").empty();
        $("#std").empty();
        for(i=0;i<data.length;i++){
            $("#TData > tbody").append(
                "<tr>" +
                " <td>" + (i+1) + "</td>" +
                "<td>" + data[i] + "</td> " +
                "</tr>"
            );
        }
    }




    return {
        calculateStatistics : calculateStatistics
    };
})();