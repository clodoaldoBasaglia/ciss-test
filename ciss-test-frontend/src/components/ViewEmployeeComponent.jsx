import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService'

class ViewEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            employee: {}
        }
    }

    componentDidMount(){
        EmployeeService.getEmployeeById(this.state.id).then( res => {
            this.setState({employee: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> Detalhes do funcionário</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Nome: </label>
                            <div> { this.state.employee.name }</div>
                        </div>
                        <div className = "row">
                            <label> Sobrenome: </label>
                            <div> { this.state.employee.lastName }</div>
                        </div>
                        <div className = "row">
                            <label> Email: </label>
                            <div> { this.state.employee.email }</div>
                        </div>
                        <div className = "row">
                            <label> Número PIS: </label>
                            <div> { this.state.employee.pisNumber }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewEmployeeComponent