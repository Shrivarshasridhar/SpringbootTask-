
import { useState } from "react";

const Signup = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [userName, setUserName] = useState("");
  const[role,setRole]=useState("");

//   const Signup = (e) => {
//     e.preventDefault();
//     console.log({ name, email, password, userName });
//     alert("Signup details submitted (add backend API call here)");
//   };
async function addNewEmployee(e) {
    e.preventDefault();
    const roleArray=roleNames.split(',').map(role=>role.trim());
    console.log(roleArray);
    const req=axios.post("https://springboot-project-0j6s.onrender.com/api/auth/register",{name,email,password,userName,userRole:["ROLE_USER","ROLE_ADMIN"]})
    if(req.data){
        alert(req.data)
    }
    else{
        alert("Error duting Sign Up")
    }
    
}

  return (
    <section>
      <h2>Sign Up</h2>
      <div>
        <form onSubmit={addNewEmployee}>
          <label htmlFor="name">Name</label>
          <input
            type="text"
            id="name"
            onChange={(e) => setName(e.target.value)}
          />
          <br />
          <br/>
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            onChange={(e) => setEmail(e.target.value)}
          />
          <br />
          <br/>
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            onChange={(e) => setPassword(e.target.value)}
          />
          <br />
          <br/>
          <label htmlFor="userName">User Name</label>
          <input
            type="text"
            id="userName"
            onChange={(e) => setUserName(e.target.value)}
          />
          <br />
           <br />
          <label htmlFor="userRole">User Role</label>
          <input
            type="text"
            id="userRole"
            onChange={(e) => setUserRole(e.target.value)}
          />
          <br />
          <br />
          <button type="submit">Sign Up</button>
        </form>
      </div>
    </section>
  );
};

export default Signup;
