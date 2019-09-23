window.onload = function() {
    document.getElementById("button1").addEventListener("click", randomUserWithFetchAndAsync);
    }
function updateContent(myJson) {
    let randomuserul = document.getElementById("randomuser");
    //console.log(myJson.results[0]);
    //console.log(myJson.results[0].gender);
    //console.log(myJson.results[0].name.first);
    //console.log(myJson.results[0].name.last);
    //console.log(myJson.results[0].dob.age);
    //console.log(myJson.results[0].picture.thumbnail);
    let avg = 0;
    let h4 = document.createElement("h4");
    for (let index = 0; index < 25; index++) {
        //let div1 = document.createElement("div");
        let li = document.createElement("li");
        let name = document.createElement("p");
        let gender = document.createElement("p");
        let age = document.createElement("p");
        let img = document.createElement("img");
        let br = document.createElement("br");
        
        let fullName = myJson.results[index].name.first + " "+ myJson.results[index].name.last;
        img.setAttribute("src",myJson.results[index].picture.thumbnail);
        name.innerHTML = `<strong>${fullName}</strong>`;
        gender.innerHTML = myJson.results[index].gender;
        age.innerHTML = myJson.results[index].dob.age;
        avg = avg + myJson.results[index].dob.age;
        randomuserul.appendChild(li);
        randomuserul.appendChild(img);
        randomuserul.appendChild(name);
        randomuserul.appendChild(gender);
        randomuserul.appendChild(age);
        randomuserul.appendChild(br);
    }
    avg = avg/25;
    h4.innerHTML = `<strong>Average age: ${avg}</strong>`;
    randomuserul.appendChild(h4);}

async function randomUserWithFetchAndAsync() {

    try {
        const response = await fetch('https://randomuser.me/api/?results=25');
        const myJson = await response.json();
        updateContent(myJson);
    } catch(error) {
        console.log(error);
    }
}


function showPeople() {

    let randomuserul = document.getElementById("randomuser");
    
    for (let index = 0; index < 25; index++) {
        let div1 = document.createElement("div");
        let li = document.createElement("li");
        let name = document.createElement("p");
        let age = document.createElement("p");
        name.innerHTML = `<strong>Hello</strong>`;
        age.innerHTML = `<strong>11</strong>`;
        randomuserul.appendChild(name);
        randomuserul.appendChild(age);
    }
}
