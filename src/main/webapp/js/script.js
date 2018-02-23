function validation(f) {
    if (f.mdp1.value == '' || f.mdp2.value == '') {
        alert('Tous les champs ne sont pas remplis');
        f.mdp1.focus();
        return false;
    }
    else if (f.mdp1.value != f.mdp2.value) {
        alert('Ce ne sont pas les mêmes mots de passe!');
        f.mdp1.focus();
        return false;
    }
    else if (f.mdp1.value == f.mdp2.value) {
        return true;
    }
    else {
        f.mdp1.focus();
        return false;
    }
}

function validation2(f) {
    if (f.mdpE1.value == '' || f.mdpE2.value == '') {
        alert('Tous les champs ne sont pas remplis');
        f.mdpE1.focus();
        return false;
    }
    else if (f.mdpE1.value != f.mdpE2.value) {
        alert('Ce ne sont pas les mêmes mots de passe d\'équipe!');
        f.mdpE1.focus();
        return false;
    }
    else if (f.mdpE1.value == f.mdpE2.value) {
        return true;
    }
    else {
        f.mdpE1.focus();
        return false;
    }
}

function myFunction() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}

// When the user clicks anywhere outside of the modal, close it
var modal = document.getElementById('ticketModal');
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
    showDivs(slideIndex += n);
}

function showDivs(n) {
    var i;
    var x = document.getElementsByClassName("mySlides");
    if (n > x.length) {slideIndex = 1}
    if (n < 1) {slideIndex = x.length}
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    x[slideIndex-1].style.display = "block";
}

