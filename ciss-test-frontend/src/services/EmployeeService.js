import axios from 'axios';

const API_BASE_URL = "http://localhost:8080/api";


class EmployeeService {

    getEmployees(){
        return axios.get(API_BASE_URL+'/employees/all');
    }

    createEmployee(employee){
        return axios.post(API_BASE_URL+'/employees', employee);
    }

    getEmployeeById(employeeId){
        return axios.get(API_BASE_URL + '/employee/' + employeeId);
    }

    updateEmployee(employee, employeeId){
        return axios.put(API_BASE_URL + '/employees/' + employeeId, employee);
    }

    deleteEmployee(employeeId){
        return axios.delete(API_BASE_URL + '/employees/' + employeeId);
    }
}

export default new EmployeeService()