window.onload = function() {
	populateUser();
}

async function populateUser() { 

	try {
		let [response, plist,uname] = await Promise.all([fetch('http://localhost:8082/EmployeeManagement/session'),
			fetch('http://localhost:8082/EmployeeManagement/empundman'),
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
			//document.getElementById("firstname").innerText = "Welcome "+name.firstName+"!";
			let table = document.getElementById("tab"); 
			list.forEach(element => {
				let tr = document.createElement("tr");  
				let name = element.firstName+' '+element.lastName;
				//console.log(element.firstName);
				let date = element.rtable.s_date.monthValue+'/'+element.rtable.s_date.dayOfMonth+'/'+element.rtable.s_date.year;
				let accept = 'http://localhost:8082/EmployeeManagement/accept?reimbursement_id='+element.rtable.reimbursement_id;
				let reject = 'http://localhost:8082/EmployeeManagement/reject?reimbursement_id='+element.rtable.reimbursement_id;
				//http://localhost:8082/EmployeeManagement/specificemplist?employee_id=1000
				let eurl = 'http://localhost:8082/EmployeeManagement/specificemplist?employee_id='+element.employee_id;
				//console.log(eurl)
				//console.log(accept);
				let sta = element.rtable.status;

				if(sta === 'Pending'){
					tr.innerHTML = `<th scope="row">${i}</th>
					<td><a href="${eurl}" target="_blank">${name}</a></td>
					<td>${element.rtable.details}</td>
					<td>${element.rtable.balance}</td>
					<td>${element.rtable.status}</td>
					<td>${date}</td>
					
					<td><button onclick="window.location.href = '${accept}';">Accept</button> <button onclick="window.location.href = '${reject}';">Reject</button></td>`;
				} else {
					tr.innerHTML = `<th scope="row">${i}</th>
					<td><a href="${eurl}" target="_blank">${name}</a></td>
					<td>${element.rtable.details}</td>
					<td>${element.rtable.balance}</td>
					<td>${element.rtable.status}</td>
					<td>${date}</td>
					<td>Done</td>`;
				}

				
				table.appendChild(tr);
				i++;
			});
			//document.getElementById("lastname").innerText = "lastname: "+user.lastName;
		}
	} catch(error) {
		console.log(error);
	} 
}    