window.onload = function() {
	populateUser();
}

async function populateUser() {

	try {
		let [response, plist] = await Promise.all([fetch('http://localhost:8082/EmployeeManagement/session'),
			fetch('http://localhost:8082/EmployeeManagement/empundman')]);
		//const response = await fetch('http://localhost:8082/EmployeeManagement/session');
		const list = await plist.json();
		const data = await response.json();
		let i = 1;
		if(data.session === null) {
			window.location = "http://localhost:8082/EmployeeManagement/login"
		} else {
			//define behavior for when a user is returned
			user = data;
			document.getElementById("firstname").innerText = "Welcome "+user.firstName+"!";
			let table = document.getElementById("tab");
			list.forEach(element => {
				let tr = document.createElement("tr");
				let name = element.firstName+' '+element.lastName;
				console.log(element.firstName);
				let date = element.rtable.s_date.monthValue+'/'+element.rtable.s_date.dayOfMonth+'/'+element.rtable.s_date.year;

				tr.innerHTML = `<th scope="row">${i}</th>
					<td>${name}</td>
					<td>${element.rtable.details}</td>
					<td>${element.rtable.balance}</td>
					<td>${element.rtable.status}</td>
					<td>${date}</td>
					<td><button onclick="window.location.href = 'https://w3docs.com';">Click Here</button> <button onclick="window.location.href = 'https://w3docs.com';">Click Here</button></td>`;
				table.appendChild(tr);
				i++;
			});
			//document.getElementById("lastname").innerText = "lastname: "+user.lastName;
		}
	} catch(error) {
		console.log(error);
	}
}