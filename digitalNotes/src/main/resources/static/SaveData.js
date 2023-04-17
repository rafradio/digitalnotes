function SaveToJson() {
    this.buttonJson = document.getElementById("json");
    this.returnButton = document.getElementById("return");
}

SaveToJson.prototype.initSettings = function() {
    
    this.buttonJson.addEventListener('click', () => {
        this.saveOnServer();
        this.saveOnClientSide();
    });
    
}

SaveToJson.prototype.saveOnServer = function() {
    let xhr = new XMLHttpRequest();
    xhr.onloadend = function(e) {
        document.getElementById("noteSavings").innerHTML = "Данные сохранены";
        setTimeout(() => {
            document.getElementById("noteSavings").innerHTML = "";
        }, 1200);
        console.log(this.responseText);
    }
    let uri = "http://localhost:8080/ajaxpost";
    let data = "jsonData=" + this.createJson();
    data += "&" + "id=" + document.getElementById("idMysql").value;
    xhr.open("POST", uri, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data);
}

SaveToJson.prototype.saveOnClientSide = function() {
    let dataString;
    let url = new URL("http://localhost:8080/fetchpost");
    url.searchParams.set('id', document.getElementById("idMysql").value);
    fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            }})
            .then(response => response.json())
            .then(data => {
                let d = new Date(data.date);
                data.date = d.toLocaleDateString();
                console.log("hello json ", data.date);
                dataString = JSON.stringify(data);
//                console.log(dataString);
                let tempLink = document.createElement("a");
                let taBlob = new Blob([dataString], {type: 'application/json'});
                tempLink.setAttribute('href', URL.createObjectURL(taBlob));
                tempLink.setAttribute('download', `data_json.json`);
                tempLink.click();
                URL.revokeObjectURL(tempLink.href);
            });    
}

SaveToJson.prototype.createJson = function() {
    let data = {
        id: document.getElementById("idMysql").value,
        title: document.getElementById("title").value,
        body: document.getElementById("bodyNote").value,
        date: document.getElementById("dateMysql").value,
        type: document.getElementById("typeMysql").value
    };
    
    return JSON.stringify(data);
}

SaveToJson.prototype.returnToMain = function() {
    this.returnButton.addEventListener('click', () => {
        location.href = "http://localhost:8080/index";
    });
}

const saveAction = new SaveToJson();

export {saveAction};