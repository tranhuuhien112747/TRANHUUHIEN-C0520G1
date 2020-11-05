import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public API = 'http://localhost:3000/employee';
  public API_DIVISION = 'http://localhost:3000/employeeDivision';
  public API_EDUCATION = 'http://localhost:3000/employeeEducation';
  public API_POSITION = 'http://localhost:3000/employeePosition';

  constructor(
    public http: HttpClient
  ) {
  }

  getEducation(): Observable<any> {
    return this.http.get(this.API_EDUCATION);
  }

  getPosition(): Observable<any> {
    return this.http.get(this.API_POSITION);
  }

  getDivision(): Observable<any> {
    return this.http.get(this.API_DIVISION);
  }

  getAllEmployee(): Observable<any> {
    return this.http.get(this.API);
  }

  addNewEmployee(employee): Observable<any> {
    return this.http.post(this.API, employee);

  }

  getEmployeeById(employeeId): Observable<any> {
    return this.http.get(this.API + '/' + employeeId);
  }

  deleteByIdEmployee(employeeId): Observable<any> {
    return this.http.delete(this.API + '/' + employeeId);
  }

  editEmployeeById(employee, employeeId): Observable<any> {
    return this.http.put(this.API + '/' + employeeId, employee);
  }
}
