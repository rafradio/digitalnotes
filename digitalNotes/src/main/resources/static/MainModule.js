function RequestNotes() {
    this.typeOfNotes = document.querySelectorAll('.new_note');
    this.idOfNotes = document.querySelectorAll('.typeid');
    this.initSettings();
}

RequestNotes.prototype.initSettings = function() {
    console.log("hello world, ", window.location.pathname, this.idOfNotes[0].innerHTML);
    this.typeOfNotes.forEach((item, index)=> {
        item.addEventListener('click', () => {
            let uri = "http://localhost:8080/notes/" + this.idOfNotes[index].innerHTML;
            location.href = uri;
        });
    });
 }

const requestNotes = new RequestNotes();

