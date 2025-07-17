import { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

// Updated Navbar with horizontal navigation links
const Navbar = () => (
  <nav>
    <ul style={{ display: "flex", gap: "1rem", listStyle: "none" }}>
      <li><Link to="/login">Login</Link></li>
      <li><Link to="/register">Register</Link></li>
    </ul>
  </nav>
);

const Signup = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [userName, setUserName] = useState("");
  const [roles, setRoles] = useState([]);

  const handleRoleChange = (e) => {
    const { value, checked } = e.target;
    if (checked) {
      setRoles((prev) => [...prev, value]);
    } else {
      setRoles((prev) => prev.filter((role) => role !== value));
    }
  };

  const addNewEmployee = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "https://springboot-project-0j6s.onrender.com/api/auth/register",
        {
          name,
          email,
          password,
          userName,
          userRole: roles.map((r) => `ROLE_${r.toUpperCase()}`),
        }
      );
      alert(response.data || "Signup successful");
    } catch (error) {
      console.error(error);
      alert("Error during Sign Up");
    }
  };

  return (
    <>
      <Navbar />
      <section style={{ padding: "2rem" }}>
        <h2>Sign Up</h2>
        <div>
          <form onSubmit={addNewEmployee}>
            <label htmlFor="name">Name</label>
            <input
              type="text"
              id="name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
            <br /><br />

            <label htmlFor="email">Email</label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
            <br /><br />

            <label htmlFor="password">Password</label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <br /><br />

            <label htmlFor="userName">User Name</label>
            <input
              type="text"
              id="userName"
              value={userName}
              onChange={(e) => setUserName(e.target.value)}
            />
            <br /><br />

            <label>User Roles:</label><br />
            <label>
              <input
                type="checkbox"
                value="user"
                onChange={handleRoleChange}
              />
              User
            </label>
            <br />
            <label>
              <input
                type="checkbox"
                value="admin"
                onChange={handleRoleChange}
              />
              Admin
            </label>
            <br /><br />

            <button type="submit">Sign Up</button>
          </form>
        </div>
      </section>
    </>
  );
};

export default Signup;
