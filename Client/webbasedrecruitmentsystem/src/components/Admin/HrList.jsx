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
        {hrList.map((hr) => (
          <div key={hr.id} className="card">
            <div className="card-body">
              <p>User Id:{hr.id}</p>
              <p>FirstName:{hr.firstName}</p>
              <p>LastName:{hr.lastName}</p>
              <p>Gender:{hr.gender}</p>
              <p>Email:{hr.email}</p>
              <p>PhoneNumber:{hr.phoneNumber}</p>
              <p>Qualification:{hr.qualification}</p>
            </div>
          </div>
        ))}
      </div>
    </>
  );
}
/*
 {
    "id": 0,
    "firstName": "string",
    "lastName": "string",
    "gender": "MALE",
    "email": "string",
    "phoneNumber": "string",
    "qualification": "string",
    "status": true
  }
*/
export default HrList;
