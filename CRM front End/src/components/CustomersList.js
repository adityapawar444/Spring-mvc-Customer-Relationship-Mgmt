import { useEffect, useState } from "react";

import CustomerService from "../service/CustomerService";
import ErrorMessage from "./ErrorMessage";

function CustomerList() {
  const [customerData, setCustomerData] = useState([]);
  const [err, setErr] = useState(false);
  useEffect(() => {
    CustomerService.getCustomers()
      .then((response) => {
        console.log(response);

        setCustomerData(response.data);
        setErr(false);
        console.log(customerData);
      })
      .catch((error) => {
        setErr(true);
        console.log(error);
      });
  }, []);

  return (
    <div>
      <br></br>
      {err && <ErrorMessage />}

      <h2 className="text-center">Customers List</h2>
      <div className="row">
        <button className="btn btn-primary">Add Customer</button>
      </div>
      <br></br>
      <div className="row" style={{ overflow: "scroll" }}>
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th> Name</th>
              <th> Email </th>
              <th> Contact</th>
              <th> Actions</th>
            </tr>
          </thead>
          <tbody>
            {customerData.map((customer) => {
              return (
                <tr key={customer.id}>
                  <td>{customer.name}</td>
                  <td>{customer.email}</td>
                  <td>{customer.contact}</td>
                  <td>
                    <button className="btn btn-info">Update</button>|
                    <button className="btn btn-danger">Delete</button>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default CustomerList;
