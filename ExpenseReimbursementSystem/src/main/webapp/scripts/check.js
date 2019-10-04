let user = {};

window.onload = function() {
	populateUser();
}

async function populateUser() {

	try {
		let [response, plist,uname] = await Promise.all([fetch('http://localhost:8082/EmployeeManagement/session'),
			fetch('http://localhost:8082/EmployeeManagement/personallist'),
			fetch('http://localhost:8082/EmployeeManagement/uname')]);
		//const response = await fetch('http://localhost:8082/EmployeeManagement/session');
		const list = await plist.json();
		const data = await response.json();
		const name = await uname.json();
		let i = 1;
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
			document.getElementById("firstname").innerText = "Welcome "+name.firstName+"!";
			let table = document.getElementById("tab");
			list.forEach(element => {
				let tr = document.createElement("tr");
				let date = element.s_date.monthValue+'/'+element.s_date.dayOfMonth+'/'+element.s_date.year;

				tr.innerHTML = `<th scope="row">${i}</th>
					<td>${element.details}</td>
					<td>${element.balance}</td>
					<td>${element.status}</td>
					<td>${date}</td>`;
				table.appendChild(tr);
				i++;
			});
			//document.getElementById("lastname").innerText = "lastname: "+user.lastName;
		}
	} catch(error) {
		console.log(error);
	}
}

