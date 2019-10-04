window.onload = function() {
	if(!window.location.hash) {
        window.location = window.location + '#loaded';
        window.location.reload();
    }
	populateUser();

}

let count = 1;
async function populateUser() { 

	try {
		
        let [response,plist] = await Promise.all([fetch('http://localhost:8082/EmployeeManagement/session'),
            fetch('http://localhost:8082/EmployeeManagement/server')]);
		//const response = await fetch('http://localhost:8082/EmployeeManagement/session');
        const data = await response.json();
        const list = await plist.json();
		let i = 1;
		if(data.session === null) {
			window.location = "http://localhost:8082/EmployeeManagement/login"
		} else {
			//define behavior for when a user is returned
			user = data; 
			//console.log(user);
			//document.getElementById("firstname").innerText = "Welcome "+name.firstName+"!";
			let table = document.getElementById("tab"); 
			list.forEach(element => { 
				let tr = document.createElement("tr");   
				//let name = element.firstName+' '+element.lastName;
				//console.log(element.firstName);
				let date = element.s_date.monthValue+'/'+element.s_date.dayOfMonth+'/'+element.s_date.year;
				let accept = 'http://localhost:8082/EmployeeManagement/accept?reimbursement_id='+element.reimbursement_id;
				let reject = 'http://localhost:8082/EmployeeManagement/reject?reimbursement_id='+element.reimbursement_id;
				//http://localhost:8082/EmployeeManagement/specificemplist?employee_id=1000
				//let eurl = 'http://localhost:8082/EmployeeManagement/specificemplist?employee_id='+element.employee_id;
				//console.log(eurl) 
				//console.log(accept);
				let sta = element.status;

				if(sta === 'Pending'){ 
					tr.innerHTML = `<th scope="row">${i}</th>
					<td>${element.details}</td>
					<td>${element.balance}</td>
					<td>${element.status}</td>
					<td>${date}</td>
					
					<td><button onclick="window.location.href = '${accept}';">Accept</button> <button onclick="window.location.href = '${reject}';">Reject</button></td>`;
				} else {
					tr.innerHTML = `<th scope="row">${i}</th>
					<td>${element.details}</td>
					<td>${element.balance}</td>
					<td>${element.status}</td>
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
	/*for(i = 0; i<count; i++){
		count--;
		window.location.reload();
	}*/
	
}    