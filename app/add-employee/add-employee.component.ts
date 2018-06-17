import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../employee.service';
import {EmployeeModel} from '../EmployeeModel';
import {Router} from '@angular/router';
@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  employeemodel: EmployeeModel = new EmployeeModel();
  constructor(private employeeService: EmployeeService, private router:Router) {
  }

  myname: string;
  newCity: string;
  

  ngOnInit() {
    
  }
  addEmployee(): void{
    console.log('Initiated');
    console.log('Name is '+this.employeemodel.emplyeeName);
    console.log('Date of birth is '+this.employeemodel.dateOfBirth);
    
    this.employeeService.addEmployee(this.employeemodel).subscribe(data=>{alert("Employee Registered Successfully"); });
    console.log('done');
  }  
}