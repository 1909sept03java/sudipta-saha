let user = {};

window.onload = function() {
	populateUser();
}

async function populateUser() {

	try {
		let [response, plist] = await Promise.all([fetch('http://localhost:8082/EmployeeManagement/session'),
			fetch('http://localhost:8082/EmployeeManagement/uname')]);
		//const response = await fetch('http://localhost:8082/EmployeeManagement/session');
		const name = await plist.json();
		const data = await response.json();
		if(data.session === null) {
			window.location = "http://localhost:8082/EmployeeManagement/login"
		} else {
			//define behavior for when a user is returned
			user = data; 
			if(user.isAdmin != 1){
				let list = document.getElementById('list');
				let management = document.getElementById('management');
				list.remove();
				management.remove();
				//console.log(user.isAdmin); 
            } 
            console.log(name.firstName);
            document.getElementById("fname").innerText = "Firstname: "+ name.firstName;
            document.getElementById("lname").innerText = "Lastname: "+name.lastName;
		}  
	} catch(error) {
		console.log(error); 
	}   
} 

