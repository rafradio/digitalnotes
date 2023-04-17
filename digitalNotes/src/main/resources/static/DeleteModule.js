import {saveAction} from "http://localhost:8080/SaveData.js";

function DeleteNote() {
    this.form = document.getElementById("newNote");
    this.deleteButton = document.getElementById("delete");
    this.id = document.getElementById("idMysql");
    this.initSettings();
}

DeleteNote.prototype.initSettings = function() {

    this.deleteButton.addEventListener('click', (event) => {
        event.preventDefault();
        console.log("hello world from delete");
        let number = this.id.value;
        console.log("hello world from delete ", number);
        let url = "http://localhost:8080/" + number + "/delete";
        this.form.action = url;
        this.form.submit();
//        location.href = "http://localhost:8080/new";
    });
}

const deleteAction = new DeleteNote();
saveAction.initSettings();
saveAction.returnToMain();
