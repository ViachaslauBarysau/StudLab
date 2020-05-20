function ShowImage(img) {
    document.getElementById('picture').src = img;
}

let modal = document.getElementById('myModal');
let span = document.getElementsByClassName("close")[0];


document.addEventListener("DOMContentLoaded", ready);

function ready() {
    if (document.getElementById("message").getAttribute("about") != "") {
        modal.style.display = "block";
    }
}

span.onclick = function () {
    modal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
