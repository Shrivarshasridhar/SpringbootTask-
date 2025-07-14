import { useState } from "react";
import axios from "axios";

const Login = () => {
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");

  async function handleLogin(event) {
    event.preventDefault();

    if (!userName || !password) {
      alert("Please enter both username and password");
      return;
    }

    try {
      const response = await axios.post("http://localhost:3001/api/auth/login", {
        userName,
        password,
      });

      const token = response.data.token;
      localStorage.setItem("token", token);
      alert("Login Successful");
    } catch (e) {
      alert("Invalid Credentials");
    }
  }

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <label htmlFor="userName">User Name</label>
        <input
          id="userName"
          name="userName"
          value={userName}
          type="text"
          onChange={(e) => setUserName(e.target.value)}
        />
        <br />
        <br />
        <label htmlFor="password">Password</label>
        <input
          id="password"
          name="password"
          value={password}
          type="password"
          onChange={(e) => setPassword(e.target.value)}
        />
        <br />
        <br />
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
