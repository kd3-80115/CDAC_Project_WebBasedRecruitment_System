import { useEffect, useState } from "react";
import { getHrList } from "../../services/admin";

function HrList() {
  const [hrList, setHrList] = useState([]);

  useEffect(() => {
    // Use the getHrList function to fetch data when the component mounts
    getHrList()
      .then((response) => {
        // Update the hrList state with the data received from the backend
        setHrList(response);
      })
      .catch((error) => {
        console.error("Error fetching HR list:", error);
        // Handle errors if needed
      });
  }, []);
  return (
    <>
      <h1>HR List</h1>
      <hr />
      <div className="container-fluid">
        <table class="table table-striped table-hover">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">FirstName</th>
              <th scope="col">LastName</th>
              <th scope="col">Gender</th>
              <th scope="col">Email</th>
              <th scope="col">Contact</th>
              <th scope="col">Qualification</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            {hrList.map((hr) => (
              <tr key={hr.id}>
                <td>{hr.id}</td>
                <td>{hr.firstName}</td>
                <td>{hr.lastName}</td>
                <td>{hr.gender}</td>
                <td>{hr.email}</td>
                <td>{hr.phoneNumber}</td>
                <td>{hr.qualification}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default HrList;
