function RequestNewNote() {
    this.reqButton = document.querySelector('.new_note');
    this.initSettings();
}

RequestNewNote.prototype.initSettings = function() {
    console.log("hello world, ", window.location.pathname);
    this.reqButton.addEventListener('click', () => {
        location.href = "http://localhost:8080/new";
    });
}

const buttonNew = new RequestNewNote();